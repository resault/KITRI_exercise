package com.example.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Ex52Activity extends AppCompatActivity {

    String num1 = "";
    String num2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ex52);


    }

    public void num(View view){

        EditText viewNum = (EditText) findViewById(R.id.view);
        // 버튼의 숫자 받아오기
        num1 += ((Button) view).getText().toString();

        // view에 뿌리기
        viewNum.setText(num1);

    }
}
