package edu.poly.broadcastreceiver_5;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ComponentName;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    private Button btnSendBroadcast;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // explicit broadcastReceiver : gửi cho một thằng broadcast cụ thể
        btnSendBroadcast = findViewById(R.id.btn_send_broadcast);

        btnSendBroadcast.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clickSendBroadcast();
            }
        });
    }

    private void clickSendBroadcast() {
        // truyền broadcast cho một thằng cụ thể nào đó
        Intent intent = new Intent();

        // gửi thông qua componentName
        // gửi thông qua backageName và đường dẫn đến broadcast đó
        ComponentName componentName = new ComponentName("edu.poly.broadcastreceiver_5_nhandulieu", "edu.poly.broadcastreceiver_5_nhandulieu.MyBroadcastReceiver");
        intent.setComponent(componentName);

        intent.putExtra(MyBroadcastReceiver.MY_TEXT, "This is Tincoder channel");

        // sendBroadcast hoặc lắng nghe sự kiên từ android thì broadcast sẽ chạy
        sendBroadcast(intent);
    }
}