package com.jojo.ark.android.leakcanary;

import android.os.Bundle;
import android.os.Handler;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.jojo.ark.R;

/**
 * @author JOJO
 * @date 2020/5/27
 * Handler内存泄露
 */
public class Leak2Activity extends AppCompatActivity {
    private Handler handler = new Handler();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_leak);
        findViewById(R.id.btn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startDelayFun();
            }
        });
    }

    private void startDelayFun() {
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                // do something
            }
        }, 1000000);
        finish();
    }
}
