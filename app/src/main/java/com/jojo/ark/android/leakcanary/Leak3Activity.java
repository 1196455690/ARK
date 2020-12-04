package com.jojo.ark.android.leakcanary;

import android.os.AsyncTask;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.jojo.ark.R;

/**
 * @author JOJO
 * @date 2020/5/27
 * 匿名类/非静态内部类
 */
public class Leak3Activity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_leak);
        findViewById(R.id.btn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startAsyncTask();
            }
        });
    }

    private void startAsyncTask() {
        new AsyncTask<Void, Void, Void>() {
            @Override
            protected Void doInBackground(Void... voids) {
                // 耗时操作，使内部类生命周期比外部类长，
                // 因为内部类持有外部类的引用，从而导致外部类无法被回收
                SystemClock.sleep(10000);
                return null;
            }
        }.execute();
        finish();
    }
}
