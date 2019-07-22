package com.example.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class Ex10_2ResultActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ex10_2_result);

        Intent inIntent = getIntent();
        String title = inIntent.getStringExtra("title");
        Float score = inIntent.getFloatExtra("score", 0);

        ((TextView) findViewById(R.id.movieTitle)).setText(title);
        ((TextView) findViewById(R.id.selStar)).setText("별점은 " + score + "점 선택하셨습니다.");
    }

    public void close(View view){

        Intent outIntent = new Intent(Ex10_2ResultActivity.this, Ex10_2Activity.class);

        float num = (float) 4.5;
        outIntent.putExtra("score", num);
        setResult(RESULT_OK, outIntent);

        this.finish();

    }
}
