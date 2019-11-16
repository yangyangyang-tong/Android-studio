package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button button1 = (Button) findViewById(R.id.button1);  //findViewById方法获取布局文件中定义的元素  得到按钮的实例
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Toast.makeText(MainActivity.this,"You clicked button1",Toast.LENGTH_SHORT).show();  //maketext方法创建一个toast对象
//                Intent intent = new Intent(MainActivity.this,SecondActivity.class);
//                startActivity(intent);

//                Intent intent = new Intent("com.example.activitytest.ACTION_START");
//                intent.addCategory("com.example.activitytest.MY_CATEGORY");
//                startActivity(intent);
                Intent intent= new Intent(Intent.ACTION_VIEW);  //Intent.ACTION_VIEW
                intent.setData(Uri.parse("https://www.baidu.com/"));//将一个网址字符串解析成一个Uri对象 带调用setData方法把这个对象传进去
                startActivity(intent);
            }
        });    //setOnClickListener方法 为按钮设置一个监听器 点击按钮就执行监听器中的方法
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId())
        {
            case R.id.add_item:
                Toast.makeText(this,"you clicked add",Toast.LENGTH_SHORT).show();
                break;
            case R.id.remove_item:
                Toast.makeText(this,"you clicked remove",Toast.LENGTH_SHORT).show();
                break;
            default:
        }
        return  true;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main,menu);  //getMenuInflater方法得到MenuInflater对象 再调用inflate方法 创建才当 第一个参数指定资源文件夹 第二个制定菜单项添加到哪个Menu对象中
        return true;//允许菜单显示
    }
}
