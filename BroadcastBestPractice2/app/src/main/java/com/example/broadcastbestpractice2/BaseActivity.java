package com.example.broadcastbestpractice2;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

public class BaseActivity extends AppCompatActivity {
    private ForceOfflineReceiver receiver;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityCollector.addActivity(this);
    }

    @Override
    protected void onResume() {
        super.onResume();
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("com.example.broadcastbestpractice.FORCE_OFFLINE");
        receiver = new ForceOfflineReceiver();
        registerReceiver(receiver,intentFilter);
    }

    @Override
    protected void onPause() {
        super.onPause();
        if(receiver!=null)
        {
            unregisterReceiver(receiver);
            receiver=null;
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        ActivityCollector.removeActivity(this);
    }
    class ForceOfflineReceiver extends BroadcastReceiver {
        @Override
        public void onReceive(final Context context, Intent intent) {
            AlertDialog.Builder builder = new AlertDialog.Builder(context); //构建一个对话框
            builder.setTitle("Warning");
            builder.setMessage("You are forced to be offline.Please try to login again");
            builder.setCancelable(false); //设对话框不可取消
            builder.setPositiveButton("OK", new DialogInterface.OnClickListener() { //setPositiveButton给对话框注册确定按钮，点击之后
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    ActivityCollector.finishALL();  //点击后调用这个销毁所有活动
                    Intent intent = new Intent(context,LoginActivity.class);//重新启动LoginActivity
                    context.startActivity(intent);
                }
            });
            builder.show();
        }
    }
}