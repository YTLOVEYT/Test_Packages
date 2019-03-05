package com.example.packages;

import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.umeng.analytics.MobclickAgent;

public class MainActivity extends AppCompatActivity
{
    private static final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        try
        {
            PackageManager manager = this.getPackageManager();
            if (manager != null)
            {
                ApplicationInfo info = manager.getApplicationInfo(getPackageName(), PackageManager.GET_META_DATA);
                if (info != null && info.metaData != null)
                {
                    String name = String.valueOf(info.metaData.get("UMENG_CHANNEL"));
                    TextView tv = findViewById(R.id.tv_channel);
                    tv.setText("name=" + name);
                }
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }


    }

    @Override
    protected void onResume()
    {
        super.onResume();
        MobclickAgent.onResume(this);
        Log.e(TAG, "onResume: ");
    }

    @Override
    protected void onPause()
    {
        super.onPause();
        MobclickAgent.onPause(this);
        Log.e(TAG, "onPause: ");

    }

    @Override
    protected void onStop()
    {
        super.onStop();

    }
}
