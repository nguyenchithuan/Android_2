package edu.poly.foregroundservicemusic;

import android.app.Notification;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.widget.RemoteViews;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.core.app.NotificationCompat;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;

import edu.poly.foregroundservicemusic.Objects.Song;

public class MyService extends Service {
    private static final int NOTIFICATION_ID = 1;
    private MediaPlayer mediaPlayer;
    public static final int ACTION_PAUSE = 1;
    public static final int ACTION_RESUME = 2;
    public static final int ACTION_CLEAR = 3;
    public static final int ACTION_START = 4;
    private boolean isPlaying;// mặc định giá trị ban đầu là giá trị false
    private Song mSong;

    @Override
    public void onCreate() {
        super.onCreate();
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Bundle bundle = intent.getExtras();
        if(bundle != null) {
            Song song = (Song) bundle.getSerializable("object_song");
            if(song != null) {
                startMusic(song);
                sendNotification(song);
                mSong = song;
            }
        }

        int actionMusic = intent.getIntExtra("action_music_service", 0);
        handleActionMusic(actionMusic);

        return START_NOT_STICKY;
    }

    private void startMusic(Song song) {
        if(mediaPlayer == null) {
            mediaPlayer = MediaPlayer.create(this, song.getResourse());
        }
        mediaPlayer.start();
        // khi music chạy thì gán biến bằng true
        isPlaying = true;
        sendActionToActivity(ACTION_START);
    }

    // xử lý hành động music khi pause, resume, clear music
    private void handleActionMusic(int action) {
        switch (action) {
            case ACTION_PAUSE:
                pauseMusic();
                break;

            case ACTION_RESUME:
                resumeMusic();
                break;

            case ACTION_CLEAR:
                stopSelf();
                sendActionToActivity(ACTION_CLEAR);
                break;
        }
    }

    private void pauseMusic() {
        if(mediaPlayer != null && isPlaying) {
            mediaPlayer.pause();
            isPlaying = false;

            // update lại view notification
            sendNotification(mSong);
            sendActionToActivity(ACTION_PAUSE);
        }
    }

    private void resumeMusic() {
        if(mediaPlayer != null && !isPlaying) {
            mediaPlayer.start();
            isPlaying = true;
            // update lại view notification
            sendNotification(mSong);
            sendActionToActivity(ACTION_RESUME);
        }
    }

    private void sendNotification(Song song) {
        // pendingIntent
        Intent intent = new Intent(this, MainActivity.class);
        PendingIntent pendingIntent = PendingIntent.getActivity(this, 0, intent, PendingIntent.FLAG_UPDATE_CURRENT);

        // custom layout
        RemoteViews remoteViews = new RemoteViews(getPackageName(), R.layout.layout_custom_notification);
        remoteViews.setTextViewText(R.id.tv_title_song, song.getTitle());
        remoteViews.setTextViewText(R.id.tv_message_song, song.getSingle());
        remoteViews.setImageViewResource(R.id.img_song, song.getImage());
        remoteViews.setImageViewResource(R.id.img_play_or_pause, R.drawable.ic_baseline_pause_circle_outline_24);


        // bắt sự kiện khi click vào cái nào đó
        if(isPlaying) {
            remoteViews.setOnClickPendingIntent(R.id.img_play_or_pause, getPendingIntent(this, ACTION_PAUSE));
            remoteViews.setImageViewResource(R.id.img_play_or_pause, R.drawable.ic_baseline_pause_circle_outline_24);
            Toast.makeText(this, "Player", Toast.LENGTH_SHORT).show();
        } else {
            remoteViews.setOnClickPendingIntent(R.id.img_play_or_pause, getPendingIntent(this, ACTION_RESUME));
            remoteViews.setImageViewResource(R.id.img_play_or_pause, R.drawable.ic_baseline_play_circle_outline_24);
            Toast.makeText(this, "Pause", Toast.LENGTH_SHORT).show();
        }

        remoteViews.setOnClickPendingIntent(R.id.img_clear, getPendingIntent(this, ACTION_CLEAR));

        Notification notification = new NotificationCompat.Builder(this, MyApplication.CHANNEL_ID)
                .setSmallIcon(R.drawable.ic_baseline_notifications_24)
                .setColor(getColor(R.color.purple_200))
                .setCustomContentView(remoteViews)
                .setContentIntent(pendingIntent)
                .build();

        startForeground(NOTIFICATION_ID, notification);
    }

    private PendingIntent getPendingIntent(Context context, int action) {
        // BroadcastReceiver để nhận từ cái intent
        Intent intent = new Intent(this, MyReceiver.class);
        intent.putExtra("action_music", action);
        // sử dụng BroadcastReceiver thì dùng get Broadcast
        return PendingIntent.getBroadcast(context.getApplicationContext(), action, intent, PendingIntent.FLAG_UPDATE_CURRENT);
        // dùng action để phân biệt muốn làm hành động gì
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        if(mediaPlayer != null) {
            mediaPlayer.release();
            mediaPlayer = null;
        }
        sendActionToActivity(ACTION_CLEAR);
    }

    private void sendActionToActivity(int action) {
        // muốn gửi một data gì đó đi thì ta đóng gói intent
        Intent intent = new Intent("send_data_to_activity");
        Bundle bundle = new Bundle();
        bundle.putSerializable("object_song", mSong);
        bundle.putInt("action_music", action);
        bundle.putBoolean("status_player", isPlaying);

        intent.putExtras(bundle);

        // gửi dữ liệu thông qua broadcastManager cụ thể là LocalBroadcastManager
        // Dùng local thì tránh rò rỉ dữ liệu sang bên ngoài, các ứng dụng khác không hứng được dữ liệu
        // chỉ mình ứng dụng mới hứng được thôi
        LocalBroadcastManager.getInstance(this).sendBroadcast(intent);
    }
}
