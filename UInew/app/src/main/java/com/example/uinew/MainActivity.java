package com.example.uinew;


import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;

import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;

import java.util.ArrayList;
import java.util.List;
public class MainActivity extends AppCompatActivity {

    private List<Msg> msgList = new ArrayList<>();
    private EditText inputText;
    private Button send;
    private RecyclerView msgRecycleView;
    private MsgAdapter adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initMsgs();
        inputText = (EditText)findViewById(R.id.input_text);
        send = (Button)findViewById(R.id.send);
        msgRecycleView = (RecyclerView)findViewById(R.id.msg_recycler_view);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        msgRecycleView.setLayoutManager(layoutManager);
        adapter = new  MsgAdapter(msgList);
        send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String content = inputText.getText().toString();
                if(!"".equals(content)){
                        Msg msg=new Msg(content,Msg.TYPE_SEND);
                        msgList.add(msg);
                        adapter.notifyItemInserted(msgList.size() - 1);
                        msgRecycleView.scrollToPosition(msgList.size()-1);
                        inputText.setText("");
                }
            }
        });
    }
    private void initMsgs(){
        Msg msg1=new Msg("Hello guy",Msg.TYPE_RECEIVED);
        msgList.add(msg1);
        Msg msg2=new Msg("Hello.who is that?",Msg.TYPE_SEND);
        msgList.add(msg2);
        Msg msg3=new Msg("This is Tom.Nice talking to you.",Msg.TYPE_RECEIVED);
        msgList.add(msg3);
    }
}

