package com.olczyk.android.broadcastsender;

import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.Click;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.ViewById;

import java.util.List;

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
//        intent.setClass(this, ExampleBroadcastReceiver2.class);
//        ComponentName cn = new ComponentName("android.olczyk.com.broadcastproject",
//                "android.olczyk.com.broadcastproject.ExampleBroadCastReceiver");
//        intent.setComponent(cn);
//        intent.setClassName("android.olczyk.com.broadcastproject",
//                "android.olczyk.com.broadcastproject.ExampleBroadCastReceiver");
//        intent.setPackage("android.olczyk.com.broadcastproject");
        PackageManager packageManager = getPackageManager();
        List<ResolveInfo> infos = packageManager.queryBroadcastReceivers(intent,0);
        for(ResolveInfo resolveInfo : infos){
            ComponentName cn = new ComponentName(resolveInfo.activityInfo.packageName,
                    resolveInfo.activityInfo.name);
            intent.setComponent(cn);
        }
        sendBroadcast(intent);
    }
}
