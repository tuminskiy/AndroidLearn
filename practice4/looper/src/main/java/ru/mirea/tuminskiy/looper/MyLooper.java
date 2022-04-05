package ru.mirea.tuminskiy.looper;



import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.RestrictionEntry;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;

import java.util.concurrent.TimeUnit;


public class MyLooper extends Thread {
    Handler handler;

    @SuppressLint("HandlerLeak")
    @Override
    public void run() {
        Log.d("MyLooper", "run");
        Looper.prepare();

        handler = new Handler() {
            @Override
            public void handleMessage(Message msg) {
                try
                {
                    int age = msg.getData().getInt("AGE");
                    Log.d("MyLooper",   "Age:" + String.valueOf(age));
                    Log.d("MyLooper",   "Work:" + msg.getData().getString("DEV"));
                    TimeUnit.SECONDS.sleep(age);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };

        Looper.loop();
    }
}