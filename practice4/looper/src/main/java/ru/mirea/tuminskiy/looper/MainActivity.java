package ru.mirea.tuminskiy.looper;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Message;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    MyLooper myLooper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        myLooper = new MyLooper();
        myLooper.start();
    }

    public void onClick(View v) {
        Message msg = new Message();
        Bundle bundle = new Bundle();

        bundle.putInt("AGE", 22);
        bundle.putString("DEV", "Junior dotnet");
        msg.setData(bundle);

        if (myLooper != null) {
            myLooper.handler.sendMessage(msg);
        }
    }
}