package edu.poly.broadcastreceiver_5_nhandulieu;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

public class MyBroadcastReceiver extends BroadcastReceiver {
    public static final String MY_TEXT = "edu.poly.TEXT";

    @Override
    public void onReceive(Context context, Intent intent) {
        String myText = intent.getStringExtra(MY_TEXT);
        Toast.makeText(context, "MyBroadcast 2: " + myText, Toast.LENGTH_SHORT).show();
    }
}
