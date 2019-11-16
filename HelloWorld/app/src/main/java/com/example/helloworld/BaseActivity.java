package com.example.helloworld;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;

public class BaseActivity extends AppCompatActivity {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d("BaseActivity",getClass().getSimpleName());//获取当前实例的类名，并打印
    }
}
