package com.example.xiongpeng.broadcast;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

/**
 * Created by xiongpeng on 2017/9/12.
 */

public class ReceiverA extends BroadcastReceiver {
    String TAG = getClass().getName();
    Bundle bundle = null;
    @Override
    public void onReceive(Context context, Intent intent) {
        Log.d(TAG, "This is A");
        bundle = getResultExtras(true);
        Log.d(TAG, bundle.getString("ReceiverB"));

    }
}
