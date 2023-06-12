package edu.poly.broadcastreceiver_3_nhandulieu;

import androidx.appcompat.app.AppCompatActivity;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    public static final String MY_ACTION = "edu.poly.ACTION";
    public static final String MY_TEXT = "edu.poly.TEXT";

    TextView tvReceiver;

    private MyBroadcastReceiver myBroadcastReceiver = new MyBroadcastReceiver();

    private BroadcastReceiver mBroadcastReceiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            if(MY_ACTION.equals(intent.getAction())) {
                String text = intent.getStringExtra(MY_TEXT);
                tvReceiver.setText(text);
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tvReceiver = findViewById(R.id.tv_receiver);
    }

    @Override
    protected void onStart() {
        super.onStart();
        IntentFilter intentFilter = new IntentFilter(MY_ACTION);
        registerReceiver(mBroadcastReceiver, intentFilter);
        registerReceiver(myBroadcastReceiver, intentFilter);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        unregisterReceiver(mBroadcastReceiver);
    }
}