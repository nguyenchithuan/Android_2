package edu.poly.foregroundservicetesttixoa;

import androidx.appcompat.app.AppCompatActivity;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import edu.poly.foregroundservicetesttixoa.Objects.Song;

public class MainActivity extends AppCompatActivity {
    private Button btnStartService;
    private Button btnStopService;

    private RelativeLayout layoutButtom;
    private ImageView imgSong, imgPlayOrPause, imgClear;
    private TextView tvTitleSong, tvMessageSong;
    private Song mSong;
    private Boolean isPlaying;

    private BroadcastReceiver broadcastReceiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            Bundle bundle = intent.getExtras();
            if(bundle == null) {
                return;
            }
            mSong = (Song) bundle.getSerializable("object_song");
            isPlaying = bundle.getBoolean("status_song");
            int action = bundle.getInt("action_music");

            handleLayoutMusic(action);

        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnStartService = findViewById(R.id.btn_start_service);
        btnStopService = findViewById(R.id.btn_stop_service);
        layoutButtom = findViewById(R.id.layout_bottom);
        imgSong = findViewById(R.id.img_song);
        imgPlayOrPause = findViewById(R.id.img_play_or_pause);
        imgClear = findViewById(R.id.img_clear);
        tvTitleSong = findViewById(R.id.tv_title_song);
        tvMessageSong = findViewById(R.id.tv_message_song);

        LocalBroadcastManager.getInstance(this).registerReceiver(broadcastReceiver, new IntentFilter("send_data_to_activity"));


        btnStartService.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startServiceOnclick();
            }
        });

        btnStopService.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                stopServiceOnclick();
            }
        });

        imgPlayOrPause.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(isPlaying) {
                    sendActionToService(MyService.ACTION_PAUSE);
                } else {
                    sendActionToService(MyService.ACTION_RESUME);
                }
            }
        });

        imgClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendActionToService(MyService.ACTION_CLEAR);
            }
        });
    }



    private void startServiceOnclick() {
        Song song = new Song("Big city boy", "Nguyễn chí thuận", R.drawable.avatar, R.raw.anh_khong_sao_ma);

        Intent intent = new Intent(this, MyService.class);
        Bundle bundle = new Bundle();
        bundle.putSerializable("object_song", song);
        intent.putExtras(bundle);
        startService(intent);
    }

    private void stopServiceOnclick() {
        Intent intent = new Intent(this, MyService.class);
        stopService(intent);
    }

    private void handleLayoutMusic(int action) {
        switch (action) {
            case MyService.ACTION_START:
                layoutButtom.setVisibility(View.VISIBLE);
                showInfoSong();
                setStateButtomPlayOrPause();
                break;

            case MyService.ACTION_PAUSE:
                setStateButtomPlayOrPause();
                break;

            case MyService.ACTION_RESUME:
                setStateButtomPlayOrPause();
                break;

            case MyService.ACTION_CLEAR:
                layoutButtom.setVisibility(View.GONE);
                break;
        }
    }

    private void setStateButtomPlayOrPause() {
        if(isPlaying) {
            imgPlayOrPause.setImageResource(R.drawable.ic_baseline_pause_circle_outline_24);
        } else {
            imgPlayOrPause.setImageResource(R.drawable.ic_baseline_play_circle_outline_24);
        }
    }

    private void showInfoSong() {
        if(mSong == null) {
            return;
        }
        tvTitleSong.setText(mSong.getTitle());
        tvMessageSong.setText(mSong.getSingle());
        imgSong.setImageResource(mSong.getImage());
    }

    private void sendActionToService(int action) {
        Intent intent = new Intent(this, MyService.class);
        intent.putExtra("action_music_service", action);
        startService(intent);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        // hủy broadcastReceier
        LocalBroadcastManager.getInstance(this).unregisterReceiver(broadcastReceiver);
    }
}