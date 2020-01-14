package com.example.broadcasttest;

import androidx.appcompat.app.AppCompatActivity;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;

import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private IntentFilter intentFilter;
    //private NetworkChangeReceiver networkChangeReceiver;
    private LocalReceiver localReceiver;
    private LocalBroadcastManager localBroadcastManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        localBroadcastManager = LocalBroadcastManager.getInstance(this);
        Button button = (Button)findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Intent intent = new Intent("com,example.broadcasttest.MY_BROADCAST");
//                intent.setComponent(new ComponentName("com.example.broadcasttest"
//                        ,"com.example.broadcasttest.MyBroadcastReceiver"));
//                sendBroadcast(intent);
//                intent.setComponent(new ComponentName("com.example.broadcasttest2"
//                        ,"com.example.broadcasttest2.AnotherBroadcastReceiver"));
//                sendBroadcast(intent);
                  Intent intent = new Intent("com.example.broadcasttest.LOCAL_BROADCAST");
                  localBroadcastManager.sendBroadcast(intent);
            }
        });
        intentFilter = new IntentFilter();
        intentFilter.addAction("com.example.broadcasttest.LOCAL_BROADCAST");
        localReceiver = new LocalReceiver();
        localBroadcastManager.registerReceiver(localReceiver,intentFilter);
//        intentFilter = new IntentFilter();
//        intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
//        networkChangeReceiver = new NetworkChangeReceiver();
//        registerReceiver(networkChangeReceiver,intentFilter);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        localBroadcastManager.unregisterReceiver(localReceiver);//动态注册的广播接收器一定都要取消注册
    }
    class LocalReceiver extends BroadcastReceiver{
        @Override
        public void onReceive(Context context, Intent intent) {
            Toast.makeText(context,"received local broadcast",Toast.LENGTH_SHORT).show();
        }
    }
//    class NetworkChangeReceiver extends BroadcastReceiver{
//        @Override
//        public void onReceive(Context context, Intent intent) {
//            ConnectivityManager connectionManager = (ConnectivityManager)getSystemService(Context.CONNECTIVITY_SERVICE);
//            NetworkInfo networkInfo=connectionManager.getActiveNetworkInfo();
//            if(networkInfo !=null&&networkInfo.isAvailable()){
//                Toast.makeText(context,"network is available",Toast.LENGTH_SHORT).show();
//            }
//            else{
//                Toast.makeText(context,"network is unavailable",Toast.LENGTH_SHORT).show();
//            }
//        }
//    }
}
