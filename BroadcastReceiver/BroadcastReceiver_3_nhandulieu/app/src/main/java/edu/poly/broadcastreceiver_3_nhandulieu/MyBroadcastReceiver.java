package edu.poly.broadcastreceiver_3_nhandulieu;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

public class MyBroadcastReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        if(MainActivity.MY_ACTION.equals(intent.getAction())) {
            String data = intent.getStringExtra(MainActivity.MY_TEXT);
            Toast.makeText(context, data + " 1", Toast.LENGTH_SHORT).show();
        }
    }
}
