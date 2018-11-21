package com.olczyk.android.broadcastsender;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.Click;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.ViewById;

@EActivity(R.layout.activity_main)
public class MainActivity extends AppCompatActivity {

    @ViewById
    TextView message;

    @ViewById
    Button buttonMessage;

    @AfterViews
    public void aVoid(){
    }

    @Click
    public void buttonMessage(){
        Intent intent = new Intent("android.olczyk.com.broadcastproject.EXAMPLE_ACTION");
        intent.putExtra("android.olczyk.com.broadcastproject.EXTRA_TEXT",
                "Broadcast received");
        sendBroadcast(intent);
    }

    private BroadcastReceiver broadcastReceiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            String receivedText =
                    intent.getStringExtra("android.olczyk.com.broadcastproject.EXTRA_TEXT");
            message.setText(receivedText);
        }
    };

    @Override
    protected void onStart() {
        super.onStart();
        IntentFilter filter =
                new IntentFilter("android.olczyk.com.broadcastproject.EXAMPLE_ACTION");
        registerReceiver(broadcastReceiver, filter);
    }

    @Override
    protected void onStop() {
        super.onStop();
        unregisterReceiver(broadcastReceiver);
    }
}
