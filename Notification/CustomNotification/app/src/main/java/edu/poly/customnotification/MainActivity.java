package edu.poly.customnotification;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

import android.app.Application;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RemoteViews;

import java.text.SimpleDateFormat;
import java.util.Date;

public class MainActivity extends AppCompatActivity {
    private static final int NOTIFICAITON_ID = 1;
    private Button btn_custom;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn_custom = findViewById(R.id.btn_custom_notification);

        btn_custom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                customNotification();
            }
        });
    }

    private void customNotification() {
        // pendingIntent
        Intent intent = new Intent(this, MainActivity.class);
        PendingIntent pendingIntent = PendingIntent.getActivity(this, 0, intent, PendingIntent.FLAG_UPDATE_CURRENT);

        // collapsed
        RemoteViews remoteViews = new RemoteViews(getPackageName(), R.layout.layout_custom_notification);
        remoteViews.setTextViewText(R.id.tv_title_custom_notification, "Title custom notification");
        remoteViews.setTextViewText(R.id.tv_message_custom_notification, "Message custom notification");

        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
        String strDate = sdf.format(new Date());
        remoteViews.setTextViewText(R.id.tv_time_custom_notification, strDate);

        // expanded
        RemoteViews remoteViews_1 = new RemoteViews(getPackageName(), R.layout.layout_custom_notification_expanded);
        remoteViews_1.setTextViewText(R.id.tv_title_custom_notification_expanded, "Title custom notification expanded");
        remoteViews_1.setTextViewText(R.id.tv_message_custom_notification_expanded, "Message custom notification expanded");
        remoteViews_1.setImageViewResource(R.id.img_custom_notification_expanded, R.mipmap.ic_launcher);

        Notification notification = new NotificationCompat.Builder(this, MyApplication.CHANNEL_ID)
                .setSmallIcon(R.drawable.ic_baseline_notifications_24)
                .setColor(getColor(R.color.blue))
                .setCustomContentView(remoteViews)
                .setCustomBigContentView(remoteViews_1)
                .setContentIntent(pendingIntent)
                .build();

        // gửi thông báo
        NotificationManagerCompat notificationManagerCompat = NotificationManagerCompat.from(this);
        notificationManagerCompat.notify(NOTIFICAITON_ID, notification);


    }
}