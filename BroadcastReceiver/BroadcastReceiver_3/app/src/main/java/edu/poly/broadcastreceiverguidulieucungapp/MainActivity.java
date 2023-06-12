package edu.poly.broadcastreceiverguidulieucungapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    public static final String MY_ACTION = "edu.poly.ACTION";
    public static final String MY_TEXT = "edu.poly.TEXT";
    Button btnSendBroadcast;
    TextView tvReceiver;

    MyBroadcastReceiver myBroadcastReceiver = new MyBroadcastReceiver();

    BroadcastReceiver broadcastReceiver = new BroadcastReceiver() {
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

        btnSendBroadcast = findViewById(R.id.btn_send_broadcast);
        tvReceiver = findViewById(R.id.tv_receiver);

        btnSendBroadcast.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clickSendBroadcast();
            }
        });
    }

    private void clickSendBroadcast() {
        Intent intent = new Intent(MY_ACTION);
        intent.putExtra(MY_TEXT, "This is Tincoder channel");
        sendBroadcast(intent);
    }

    @Override
    protected void onStart() {
        super.onStart();

        IntentFilter intentFilter = new IntentFilter(MY_ACTION);
        registerReceiver(broadcastReceiver, intentFilter);

        registerReceiver(myBroadcastReceiver, intentFilter);
    }

    @Override
    protected void onStop() {
        super.onStop();
        unregisterReceiver(broadcastReceiver);
    }
}