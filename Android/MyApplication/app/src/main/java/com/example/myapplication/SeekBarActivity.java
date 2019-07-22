package com.example.myapplication;

import android.os.SystemClock;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.SeekBar;
import android.widget.TextView;

public class SeekBarActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_seek_bar);
    }

    public void progress(View view) {
        final SeekBar sb = (SeekBar) findViewById(R.id.sb);
        final TextView tvResult = (TextView) findViewById(R.id.tvResult);
        int start = sb.getProgress();
//        for(int i=0; i<100; i++) {
//            sb.setProgress(i);
//            SystemClock.sleep(100);    //thread의 sleep()과 동일 but, 진행률의 위젯이 thread처리 되어있지 않기 때문에 중간 결과값이 나오지 않고 멈춰있다가 바로 100이 됨
//        }

       //진행률을 보여주는 부분만 사용자정의 thread로 구성
       new Thread() {
            public void run() {
                int start = sb.getProgress();
                for (int i = 0; i < 100; i++) {
                    sb.setProgress(i+1);  //예외적으로 사용자 정의 thread에서 접근 가능한 UI객체임

//                    tvResult.setText("진행률 : " + i + "%"); //안드로이드 API 버전이 낮은 경우 에러 발생함 (25버전 정도로 내려가면 에러 남)

                    //runOnUiThread()
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            tvResult.setText("진행률 : " + sb.getProgress() + "%");
                        }
                    });
                    SystemClock.sleep(100);
                }
            }
        }.start();
    }

    public void init(View view) {
        SeekBar sb = (SeekBar) findViewById(R.id.sb);
        sb.setProgress(0);
    }

}
