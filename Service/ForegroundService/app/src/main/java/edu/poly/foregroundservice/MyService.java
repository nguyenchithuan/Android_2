package edu.poly.foregroundservice;

import android.app.Notification;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;

import androidx.annotation.Nullable;
import androidx.core.app.NotificationCompat;

public class MyService extends Service {
    private static final int NOTIFICATION_ID = 1;
    // Tạo ra service thì phải khai báo trong android manifests

    @Override
    public void onCreate() {
        super.onCreate();
        Log.e("thuan", "MyService onCreate");
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) { // sử dụng khi ràng buộc service
        return null;
    }

    // dùng đến hàm onStartCommand là bời vì ta dùng foreground service
    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        String strDataIntent = intent.getStringExtra("data_intent");

        sendNotification(strDataIntent);

        return START_NOT_STICKY;
    }

    private void sendNotification(String data) {

        Intent intent = new Intent(this, MainActivity.class);
        PendingIntent pendingIntent = PendingIntent.getActivity(this, 0, intent, PendingIntent.FLAG_UPDATE_CURRENT);

        Notification notification = new NotificationCompat.Builder(this, MyApplication.CHANNEL_ID)
                .setContentTitle("Title Notification")
                .setContentText(data)
                .setSmallIcon(R.drawable.ic_baseline_notifications_24)
                .setColor(getColor(R.color.blue))
                .setContentIntent(pendingIntent)
                .build();

        // gửi notification liên quan foreground service
        startForeground(NOTIFICATION_ID, notification);

    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.e("thuan", "MyService onDestroy");
    }
}
