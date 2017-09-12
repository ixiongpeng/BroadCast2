package com.example.xiongpeng.broadcast;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

/**
 * Created by xiongpeng on 2017/9/12.
 */

public class ReceiverB extends BroadcastReceiver {
    String TAG = getClass().getName();
    Bundle bundle = new Bundle();
    @Override
    public void onReceive(Context context, Intent intent) {
        Log.d(TAG, "This is B");
        bundle.putString("ReceiverB", "send to A");
        setResultExtras(bundle);
    }
}
