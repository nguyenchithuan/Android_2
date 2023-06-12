package edu.poly.broadcastreceiverwifi;

import androidx.appcompat.app.AppCompatActivity;

import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.os.Bundle;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    // Dynamic Receiver để đăng ký
    private ExampleBroadcastReceiver exampleBroadcastReceiver;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        exampleBroadcastReceiver = new ExampleBroadcastReceiver();
    }

    @Override
    protected void onStart() {
        super.onStart();
        Toast.makeText(this, "OnStart()", Toast.LENGTH_SHORT).show();
        IntentFilter intentFilter = new IntentFilter(ConnectivityManager.CONNECTIVITY_ACTION);
        registerReceiver(exampleBroadcastReceiver, intentFilter);
    }

    @Override
    protected void onStop() {
        super.onStop();
        Toast.makeText(this, "OnStop()", Toast.LENGTH_SHORT).show();
        unregisterReceiver(exampleBroadcastReceiver);
    }

    // có thể điều khuyển vòng đời của broadcastReceiver theo activity
}