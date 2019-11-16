package com.example.uiwidgettest;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private EditText editText;
    private ImageView imageView;
    private ProgressBar progressBar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button button=(Button) findViewById(R.id.button);
        editText = (EditText) findViewById(R.id.edittext);
        imageView = (ImageView) findViewById(R.id.imageview);
        progressBar = (ProgressBar) findViewById(R.id.progress_bar);
        button.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.button:
//                imageView.setImageResource(R.drawable.b);   //动态变图

//                if(progressBar.getVisibility()==View.GONE){       //变化进度条可见和不可见
//                    progressBar.setVisibility(View.VISIBLE);
//                }
//                else {
//                    progressBar.setVisibility(View.GONE);
//                }

//                int progress = progressBar.getProgress();   //动态改变进度条长度
//                progress=progress+10;
//                progressBar.setProgress(progress);

//                AlertDialog.Builder dialog=new AlertDialog.Builder(MainActivity.this);   //创建一个dialog的实例
//                dialog.setTitle("This is Dialog"); //标题 内容 可否取消的属性
//                dialog.setMessage("Something important.");
//                dialog.setCancelable(false);
//                dialog.setPositiveButton("ok", new DialogInterface.OnClickListener() {  //setPositiveButton 方法对对话框设置确定按钮的点击事件
//                    @Override
//                    public void onClick(DialogInterface dialog, int which) {
//
//                    }
//                });
//                dialog.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {  //这个方法设置取消按钮的点击事件
//                    @Override
//                    public void onClick(DialogInterface dialog, int which) {
//
//                    }
//                });
//                dialog.show();  //显示对话框

                ProgressDialog progressDialog = new ProgressDialog(MainActivity.this);
                progressDialog.setTitle("This is ProgressDialog");
                progressDialog.setMessage("Loading...");
                progressDialog.setCancelable(true); //如是false  则不能用Back键取消 则必须在数据加载完调用progessdialog的diamiss方法
                progressDialog.show();
                break;
            default:
                break;
        }
    }
}
