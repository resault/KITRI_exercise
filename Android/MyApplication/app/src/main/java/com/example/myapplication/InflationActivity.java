package com.example.myapplication;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

public class InflationActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inflation);

        final LinearLayout root = (LinearLayout) findViewById(R.id.root);
        Button btCb = (Button) findViewById(R.id.btCb);

        btCb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //부분 XML 전개
                LayoutInflater inflater = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);

                inflater.inflate(R.layout.activity_sub1, root, true);

            }
        });

        Button rmCb = (Button) findViewById(R.id.rmCb);
        rmCb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                //영역만 제거  >> 이렇게 사용하려면 이벤트 실행전에 미리 객체 생성 및 영역 잡아두는 방식 사용할 것!
//                findViewById(R.id.sub_1).setVisibility(View.GONE);

                //View 제거
                root.removeView(findViewById(R.id.sub_1));
            }
        });
    }
}
