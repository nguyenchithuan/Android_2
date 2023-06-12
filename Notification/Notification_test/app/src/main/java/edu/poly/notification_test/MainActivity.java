package edu.poly.notification_test;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;

import android.app.Notification;
import android.app.NotificationManager;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import edu.poly.notification_test.channels.MyApplication;

public class MainActivity extends AppCompatActivity {
    private static final int NOTIFICATION_ID = 1;
    private Button btn_notificaton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn_notificaton = findViewById(R.id.btn_notification);
        btn_notificaton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendNotication();
            }
        });
    }

    private void sendNotication() {
        Notification notification = new NotificationCompat.Builder(this, MyApplication.CHANNEL_ID)
                .setContentTitle("Title push notification")
                .setContentText("Message push notification")
                .setSmallIcon(R.drawable.ic_baseline_location_on_24)
                .setColor(getResources().getColor(R.color.blue))
                .build();

        NotificationManager notificationManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        notificationManager.notify(NOTIFICATION_ID, notification);
    }
}