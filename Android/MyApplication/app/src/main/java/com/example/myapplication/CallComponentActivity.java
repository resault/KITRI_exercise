package com.example.myapplication;

import android.content.ComponentName;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class CallComponentActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_call_component);
    }

    public void callComponent(View view) {
        Intent intent = new Intent();
        ComponentName componentName = new ComponentName("com.example.bapplication", "com.example.bapplication.BActivity");
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK); //새로운 테스크에서 화면을 관리한다
        intent.setComponent(componentName);
        intent.putExtra("msg", "bActivity에서 전달하는 데이터입니다.");
        startActivity(intent);

    }
}
