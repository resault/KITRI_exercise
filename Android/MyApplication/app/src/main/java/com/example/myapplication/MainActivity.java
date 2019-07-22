package com.example.myapplication;

import android.content.Context;
import android.content.Intent;
import android.media.ExifInterface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        Button bt1 =  (Button)findViewById(R.id.bt1);
//        String btText = bt1.getText().toString();
//        //System.out.println("버튼 텍스트:" + btText);
//        String tag = "MainActivity";
//        String msg = btText;
//        //Log.d(tag, msg);
//        Log.e(tag, msg);
//
//        Context ctx = this;
//        String text = btText;
//        Toast.makeText(ctx, text, Toast.LENGTH_LONG).show();

        Log.i("MainActivity", "MainActivity_onCreate");
    }


    @Override
    protected void onStart() {
        super.onStart();
        Log.i("MainActivity", "MainActivity_onStart");

    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i("MainActivity", "MainActivity_onResume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.i("MainActivity", "MainActivity_onPause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.i("MainActivity", "MainActivity_onStop");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.i("MainActivity", "MainActivity_onRestart");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i("MainActivity", "MainActivity_onDestroy");
    }

    @Override
    protected void onNewIntent(Intent intent) {     //처음 메인이 뜰때는 호출 X, 로그인하고 메인으로 돌아가면 Intent.FLAG_ACTIVITY_SINGLE_TOP에 의해 호출됨
        super.onNewIntent(intent);
        String msg = intent.getStringExtra("msg");
        Toast.makeText(this, msg, Toast.LENGTH_LONG).show();
    }

    public void btClick(View view) {
        Intent intent = null;
        switch (view.getId()) {
            case R.id.btEx4_24 :
                intent = new Intent(this, Ex4_24Activity.class);
                startActivity(intent);    //새 화면 띄우기
                break;
             case R.id.btEx5_1 :
                intent = new Intent(this, Ex5_1Activity.class);
                startActivity(intent);    //새 화면 띄우기
                break;
             case R.id.btEx42 :
                intent = new Intent(this, Ex42Activity.class);
                startActivity(intent);    //새 화면 띄우기
                break;
             case R.id.btEx43 :
                intent = new Intent(this, Ex43Activity.class);
                startActivity(intent);    //새 화면 띄우기
                break;
             case R.id.btExinflation :
                intent = new Intent(this, InflationActivity.class);
                startActivity(intent);    //새 화면 띄우기
                break;

             case R.id.btNewActivity :
                intent = new Intent(this, NewActivity.class);
                startActivity(intent);    //새 화면 띄우기
                break;

             case R.id.btEx10_2 :
                intent = new Intent(this, Ex10_2Activity.class);
                startActivity(intent);    //새 화면 띄우기
                break;

             case R.id.btEx10_21 :
                intent = new Intent(this, Ex10_21Activity.class);
                startActivity(intent);    //새 화면 띄우기
                break;

             case R.id.btEx10_3 :
                intent = new Intent(this, Ex10_3Activity.class);
                startActivity(intent);    //새 화면 띄우기
                break;

             case R.id.btLogin :
                intent = new Intent(this, LoginActivity.class);
                startActivity(intent);    //새 화면 띄우기
                break;

             case R.id.bActivity :
                intent = new Intent(this, CallComponentActivity.class);
                startActivity(intent);    //새 화면 띄우기
                break;

             case R.id.btEx11_2:
                intent = new Intent(this, Ex11_2Activity.class);
                startActivity(intent);    //새 화면 띄우기
                break;

             case R.id.btCustom:
                intent = new Intent(this, CustomListViewActivity.class);
                startActivity(intent);    //새 화면 띄우기
                break;

             case R.id.sbTest:
                intent = new Intent(this, SeekBarActivity.class);
                startActivity(intent);    //새 화면 띄우기
                break;

            case R.id.btExchange:
                intent = new Intent(this, ExchangeRateActivity.class);
                startActivity(intent);    //새 화면 띄우기
                break;

            case R.id.btCart:
                intent = new Intent(this, ViewCartActivity.class);
                startActivity(intent);    //새 화면 띄우기
                break;

            case R.id.btEx13_1:
                intent = new Intent(this, Ex13_1Activity.class);
                startActivity(intent);    //새 화면 띄우기
                break;


        }
    }


}
