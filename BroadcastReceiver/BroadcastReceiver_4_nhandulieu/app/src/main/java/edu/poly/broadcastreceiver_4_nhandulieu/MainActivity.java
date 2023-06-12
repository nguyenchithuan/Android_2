package edu.poly.broadcastreceiver_4_nhandulieu;

import androidx.appcompat.app.AppCompatActivity;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.widget.TextView;

import com.google.gson.Gson;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private TextView tvReceiver;

    private static final String MY_ACTION = "intent.ACTION";
    private static final String MY_USER = "intent.USER";

//    private BroadcastReceiver mBroadcastReceiver = new BroadcastReceiver() {
//        @Override
//        public void onReceive(Context context, Intent intent) {
//            if(MY_ACTION.equals(intent.getAction())) {
//                String jsonUser = intent.getStringExtra(MY_USER);
//                Gson gson = new Gson();
//                User user = gson.fromJson(jsonUser, User.class);
//
//                tvReceiver.setText("User id: " + user.getId() + ", User name: " + user.getName());
//            }
//        }
//    };

    private BroadcastReceiver mBroadcastReceiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            if(MY_ACTION.equals(intent.getAction())) {
                String strJson = intent.getStringExtra(MY_USER);
                List<User> list = getListUser(strJson);

                String listUserName = "";
                for (int i = 0; i < list.size(); i++) {
                    listUserName = listUserName + list.get(i).getName() + "\n";
                }

                tvReceiver.setText(listUserName);
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
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        unregisterReceiver(mBroadcastReceiver);
    }

    private List<User> getListUser(String json) {
        List<User> list = new ArrayList<>();

        try {
            JSONArray jsonArray = new JSONArray(json);
            JSONObject jsonObject;
            User user;
            Gson gson = new Gson();
            for (int i = 0; i < jsonArray.length(); i++) {
                jsonObject = jsonArray.getJSONObject(i);
                user = gson.fromJson(jsonObject.toString(), User.class); // dùng gson để biến thành user
                list.add(user);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }

        return list;
    }
}