package edu.poly.foregroundservicetesttixoa;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

public class MyReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        int actionMusic = intent.getIntExtra("action_music", 0);
        // tham số thứ 2 nếu không nhận được intent này thì giá trị là 0


        // chuyển action về service để sử lý, đã có hàm sử lý bên MyService rồi
        Intent intentService = new Intent(context, MyService.class);
        intentService.putExtra("action_music_service", actionMusic);
        // chạy đến hàm onStartCommand()
        context.startService(intentService);
    }
}
