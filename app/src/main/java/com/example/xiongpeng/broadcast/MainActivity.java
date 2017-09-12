package com.example.xiongpeng.broadcast;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


//注册广播：
// 静态注册：在xml文件中配置接受者信息（action重点），在activity中直接显式或隐式启动广播（隐式：action，显式：XXX.class）
public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    public String TAG = this.getClass().getName();
    Button start = null;
    Button active = null;
    Button order = null;
    Intent intent = null;
    MyBroadCast myBroadCast = null;
    ActiveBroadCast activeBroadCast = null;
    IntentFilter intentFilter = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        start = (Button)findViewById(R.id.button);
        start.setOnClickListener(this);
        active = (Button)findViewById(R.id.buttonActive);
        active.setOnClickListener(this);
        order = (Button)findViewById(R.id.buttonOrder);
        order.setOnClickListener(this);

        activeBroadCast = new ActiveBroadCast();
    }

    @Override
    protected void onResume() {
        super.onResume();
        intentFilter = new IntentFilter("com.xiongpeng.ActiveBroadCast");
        registerReceiver(activeBroadCast, intentFilter);
    }

    @Override
    public void onClick(View view) {

        if(view.getId() == R.id.button) {
            //Intent intent = new Intent("com.xiongpeng.mybroadcast");//隐式发送
           intent = new Intent(this, MyBroadCast.class);//显式发送

        }else if(view.getId() == R.id.buttonActive){
            intent  = new Intent("com.xiongpeng.ActiveBroadCast");//只能隐式发送广播

        }else if(view.getId() == R.id.buttonOrder){
            intent  = new Intent("com.xiongpeng.preority");
           // intent  = new Intent(this, ReceiverA.class);
        }
        sendOrderedBroadcast(intent, null);
    }

    @Override
    protected void onDestroy() {
        unregisterReceiver(activeBroadCast);
    }
}
