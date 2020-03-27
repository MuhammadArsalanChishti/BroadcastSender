package com.mac.broadcast.broadcasts;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.widget.Toast;

import com.mac.broadcast.Constants.ConstantBroasdcast;

public class MyBroasdcastReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        if(ConnectivityManager.CONNECTIVITY_ACTION.equals(intent.getAction())){
            boolean boleanExtra =
                    intent.getBooleanExtra(ConnectivityManager.EXTRA_NO_CONNECTIVITY,false);

            if(!boleanExtra){
                Toast.makeText(context, "Connected", Toast.LENGTH_SHORT).show();
            }
            else {
                Toast.makeText(context, "Disconnected ", Toast.LENGTH_SHORT).show();
            }

        }
        else if(Intent.ACTION_TIME_TICK.equals(intent.getAction())){
            Toast.makeText(context, "Time incremented ", Toast.LENGTH_SHORT).show();
        }

        else if (ConstantBroasdcast.APP_BROADCAST_ACTION.equals(intent.getAction())){
            Toast.makeText(context, "Broadcast receive in sender app locally", Toast.LENGTH_SHORT).show();
        }
    }
}
