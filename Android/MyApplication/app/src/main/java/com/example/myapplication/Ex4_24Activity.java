package com.example.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class Ex4_24Activity extends AppCompatActivity  { //extends Activity 액션바를 포함하지 않음
    //액션바를 포함함
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ex4_24); // inflation : layout에 해당하는 xml을 찾아 xml요소들을 객체화하고 화면에 전개함

        CheckBox cb1 = (CheckBox) findViewById(R.id.cb1); //VM에 관리되는 객체중 id가 cb1인 View타입의 객체를 찾아서 CheckBox로 다운캐스팅
        CheckBox cb2 = (CheckBox) findViewById(R.id.cb2);
        CheckBox cb3 = (CheckBox) findViewById(R.id.cb3);

        RadioGroup rg = (RadioGroup) findViewById(R.id.rg);
        final RadioButton rdm = (RadioButton) findViewById(R.id.rdm);
        final RadioButton rdw = (RadioButton) findViewById(R.id.rdw);

        MyCheckedChangeListener myListener = new MyCheckedChangeListener();


        cb1.setOnCheckedChangeListener(myListener);
        cb2.setOnCheckedChangeListener(myListener);
        cb3.setOnCheckedChangeListener(myListener);

        rg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {    // i : 실제 발생한 라디오버튼의 id
                if(i == R.id.rdm) {
                    Log.i("Ex4_24Activity", rdm.getText().toString());
                } else {
                    Log.i("Ex4_24Activity", rdw.getText().toString());
                }
            }
        });

    }

    class MyCheckedChangeListener implements CompoundButton.OnCheckedChangeListener {
        @Override
        public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
            Log.i("Ex4_24Activity", "cb1 checked 속성값이 변경됨" + b + ", text는 " + compoundButton.getText());

        }
    }



}
