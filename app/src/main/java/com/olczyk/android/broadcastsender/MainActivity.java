package com.olczyk.android.broadcastsender;

import android.content.Intent;
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

        intent.setPackage("android.olczyk.com.broadcastproject");

        Bundle extras = new Bundle();
        extras.putString("stringExtra", "Start");

        sendOrderedBroadcast(intent,null, new SenderReceiver (),
                null, 0, "start", extras);
    }
}
