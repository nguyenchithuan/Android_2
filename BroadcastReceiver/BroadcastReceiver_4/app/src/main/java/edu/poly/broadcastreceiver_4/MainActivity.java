package edu.poly.broadcastreceiver_4;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.gson.Gson;
import com.google.gson.JsonArray;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private Button btnSendBroadcast;

    private static final String MY_ACTION = "intent.ACTION";
    private static final String MY_USER = "intent.USER";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnSendBroadcast = findViewById(R.id.btn_send_broadcast);

        btnSendBroadcast.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clickSendBroadcast();
            }
        });
    }

    private void clickSendBroadcast() {
        // gson để biến object thành một string
        // sau đó mình biến ngược lại một cái string thành một object


        // gửi 1 object
//        Intent intent = new Intent(MY_ACTION);
//        User user = new User(1, "Tincoder");
//        Gson gson = new Gson();
//        String jsonUser = gson.toJson(user); // biến thành string json
//        intent.putExtra(MY_USER, jsonUser);
//        sendBroadcast(intent);
//        Toast.makeText(this, "Send broadcast thành công", Toast.LENGTH_SHORT).show();


        // gửi list object
        Intent intent = new Intent(MY_ACTION);
        User user1 = new User(1, "Tincoder");
        User user2 = new User(2, "Tin");
        List<User> list = new ArrayList<>();
        list.add(user1);
        list.add(user2);

        Gson gson = new Gson();
        JsonArray jsonArray = gson.toJsonTree(list).getAsJsonArray();
        String strJson = jsonArray.toString();
        intent.putExtra(MY_USER, strJson);
        sendBroadcast(intent);
        Toast.makeText(this, "Send broadcast thành công", Toast.LENGTH_SHORT).show();
    }
}