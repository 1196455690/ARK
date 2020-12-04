package com.jojo.ark.android.leakcanary;

import android.os.Bundle;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.jojo.ark.R;

/**
 * @author JOJO
 * @date 2020/5/27
 * 普通GC
 */
public class Leak0Activity extends AppCompatActivity {
    private Object obj;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_leak);
        findViewById(R.id.btn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                createClass();
            }
        });
    }

    private void createClass() {
        obj = new MyClass();
        finish();
    }

    private class MyClass{
        // 非静态内部类(MyClass)会持有外部类(Leak0Activity)的引用
    }
}
