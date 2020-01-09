package com.example.uicustomviews;

import android.app.Activity;
import android.content.Context;
import android.text.Layout;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;

import java.util.jar.Attributes;

public class TitleLayout extends LinearLayout {
    public  TitleLayout(Context context, AttributeSet attrs){//重写了LinearLayout中带两个参数的构造函数，在布局中引入TitleLayout控件就会调用这个构造函数
        super(context,attrs);
        LayoutInflater.from(context).inflate(R.layout.title,this); //通过LayoutInflater的from方法可以构建出一个LayoutInflater对象，然后调用inflate（）方法就可以动态加载一个布局文件
        //第 一个参数是要加载的布局文件的id,这里我们传入R.layout.title,第二个参数是给加载好的布局 再添加一个父布局，这里我们想要指定为TitleLayout,于是直接传入this
        Button titleback=(Button) findViewById(R.id.title_back); //通过findViewById方法获得按钮的实例，
        Button titleedit=(Button) findViewById(R.id.title_edit);
        titleback.setOnClickListener(new OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                ((Activity) getContext()).finish();
            }
        });
        titleedit.setOnClickListener(new OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Toast.makeText(getContext(), "You clicked edit button", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
