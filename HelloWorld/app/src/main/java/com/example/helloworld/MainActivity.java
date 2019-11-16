package com.example.helloworld;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity extends BaseActivity {
    public static final String TAG = "MainActivity";
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d(TAG, "onCreate");
        setContentView(R.layout.activity_main);
        if(savedInstanceState!=null)   //取出数据
        {
            String tempData=savedInstanceState.getString("data_key");
            Log.d(TAG,tempData);
        }

        Button button1 = (Button) findViewById(R.id.button1);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final Intent intent = new Intent(Intent.ACTION_DIAL);
                intent.setData(Uri.parse("tel:10086"));
            }
        });
        Button startnormalactivity = (Button) findViewById(R.id.start_normalactivity);
        Button startdialogactivity = (Button) findViewById(R.id.start_dialogactivity);
        startnormalactivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1 = new Intent(MainActivity.this, normal_activity.class);
                startActivity(intent1);
            }
        });
        startdialogactivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent2 = new Intent(MainActivity.this, dialog_activity.class);
                startActivity(intent2);
            }
        });
    }
    @Override
    protected void onStart(){
        super.onStart();
        Log.d(TAG,"onStart");
    }
    @Override
    protected void onResume(){
        super.onResume();
        Log.d(TAG,"onResume");
    }
    @Override
    protected void onPause(){
        super.onPause();
        Log.d(TAG,"onPause");
    }
    @Override
    protected void onDestroy(){
        super.onDestroy();
        Log.d(TAG,"onDestory");
    }
    @Override
    protected void onRestart(){
        super.onRestart();
        Log.d(TAG,"onRestart");
    }
    @Override
    protected void onSaveInstanceState(Bundle outState){   //保存临时数据
        super.onSaveInstanceState(outState);
        String tempData="Something you just typed";
        outState.putString("data_key",tempData);
    }
}
