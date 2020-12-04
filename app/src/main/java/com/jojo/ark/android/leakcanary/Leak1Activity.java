package com.jojo.ark.android.leakcanary;

import android.os.Bundle;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.jojo.ark.R;

/**
 * @author JOJO
 * @date 2020/5/27
 * 非静态内部类的静态实例导致的内存泄露
 */
public class Leak1Activity extends AppCompatActivity {
    private static Object sObj;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_leak);
        findViewById(R.id.btn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                createInternalClass();
            }
        });
    }

    private void createInternalClass() {
        // 非静态内部类的实例为静态时，会长期持有外部类的引用(强引用)，从而阻止外部类被系统回收
        sObj = new MyClass();
        finish();
    }

    private class MyClass {
        // 非静态内部类(MyClass)会持有外部类(Leak1Activity)的引用
    }
}
