package com.example.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.w3c.dom.Text;

public class Ex43Activity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ex43);
    }

    public void calc(View view){
        int num1 = Integer.parseInt(((TextView)findViewById(R.id.num1)).getText().toString());
        int num2 = Integer.parseInt(((TextView)findViewById(R.id.num2)).getText().toString());
        String resultStr = "결과 : ";
        int result = 0;
        TextView textView = findViewById(R.id.textView);

        int viewId = view.getId();
        if(viewId == R.id.plus) {
            result = num1 + num2;
            textView.setText(resultStr + result);
        } else if(viewId == R.id.minus) {
            result = num1 - num2;

        } else if(viewId == R.id.multiply) {
            result = num1 * num2;

        } else if(viewId == R.id.divide) {
            result = num1 / num2;

        } else if(viewId == R.id.remain) {
            result = num1 % num2;

        }


    }
}
