package com.example.xiongpeng.broadcast;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

/**
 * Created by xiongpeng on 2017/9/12.
 */

public class MyBroadCast extends BroadcastReceiver {
    public String TAG = this.getClass().getName();
    @Override
    public void onReceive(Context context, Intent intent) {
        Log.d(TAG,"MyBroacast");
    }
}
