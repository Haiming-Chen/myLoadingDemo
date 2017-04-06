package com.chm.android;

import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.RotateAnimation;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    Handler mHandler = new Handler() {
        public void handleMessage(Message msg) {
            switch (msg.what) {
                case REFRESH_PROGRESS:
                        mProgress += 5;
                        mHandler.sendEmptyMessageDelayed(REFRESH_PROGRESS,
                                new Random().nextInt(300));
                        loading.setProgress(mProgress);
                    break;
                default:
                    break;
            }
        }

        ;
    };
    Loading loading;
    private View mFanView;
    private static final int REFRESH_PROGRESS = 0x10;
    private int mProgress = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        loading = new Loading(this);
        mFanView = findViewById(R.id.fan_pic);
        RotateAnimation rotateAnimation = AnimationUtils.initRotateAnimation(false, 1500, true,
                Animation.INFINITE);
        mFanView.startAnimation(rotateAnimation);
        mHandler.sendEmptyMessageDelayed(REFRESH_PROGRESS, 1000);
    }
}
