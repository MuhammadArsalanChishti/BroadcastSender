package com.mac.broadcast;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.os.Bundle;
import android.view.View;

import com.mac.broadcast.Constants.ConstantBroasdcast;
import com.mac.broadcast.broadcasts.MyBroasdcastReceiver;

public class MainActivity extends AppCompatActivity {

    MyBroasdcastReceiver myBroasdcastReceiver = new MyBroasdcastReceiver();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
/*        IntentFilter intentFilter = new IntentFilter(ConnectivityManager.CONNECTIVITY_ACTION);
        intentFilter.addAction(Intent.ACTION_TIME_TICK);
        registerReceiver(myBroasdcastReceiver,intentFilter);*/

        findViewById(R.id.senderBtn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent sendBroadCastIntent = new Intent(ConstantBroasdcast.APP_BROADCAST_ACTION);
                sendBroadCastIntent.putExtra(ConstantBroasdcast.APP_BROADCAST_ACTION_EXTRANS_DATA,"this data is send from sender broad cast application");
                sendBroadcast(sendBroadCastIntent);
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();

        IntentFilter intentFilter = new IntentFilter(ConstantBroasdcast.APP_BROADCAST_ACTION);
        registerReceiver(myBroasdcastReceiver,intentFilter);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        unregisterReceiver(myBroasdcastReceiver);
    }

    /*    @Override
    protected void onDestroy() {
        super.onDestroy();
        unregisterReceiver(myBroasdcastReceiver);
    }*/
}
