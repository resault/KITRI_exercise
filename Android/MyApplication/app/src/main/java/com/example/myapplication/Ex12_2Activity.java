package com.example.myapplication;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Calendar;


public class Ex12_2Activity extends AppCompatActivity {


    class MySQLiteOpenHelper extends SQLiteOpenHelper{
        public MySQLiteOpenHelper( Context context, String name) {
            //DB생성
            super(context, name, null, 1);
        }

        @Override
        public void onCreate(SQLiteDatabase sqLiteDatabase) {
            //테이블생성
            String sql = "CREATE TABLE diary (diary_dt varchar2(10), diary_content varchar2(400))";
            sqLiteDatabase.execSQL(sql);
        }

        @Override
        public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
            //테이블삭제
            String sql = "DROP TABLE IF EXISTS diary";
            sqLiteDatabase.execSQL(sql);
        }
    }

    DatePicker dp;
    EditText edtDiary;
    Button btnWrite;
    Button btnInit;
    String diary_dt;
    String diary_content;


    private MySQLiteOpenHelper myHelper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ex12_2);
        myHelper = new MySQLiteOpenHelper(this, "testDB");

        dp = (DatePicker) findViewById(R.id.datePicker1);
        edtDiary = (EditText) findViewById(R.id.edtDiary);
        btnWrite = (Button) findViewById(R.id.btnWrite);
        btnInit = (Button) findViewById(R.id.btnInit);

        Calendar cal = Calendar.getInstance();
        int cYear = cal.get(Calendar.YEAR);
        int cMonth = cal.get(Calendar.MONTH);
        int cDay = cal.get(Calendar.DAY_OF_MONTH);



        dp.init(cYear, cMonth, cDay, new DatePicker.OnDateChangedListener() {
            public void onDateChanged(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                diary_dt = Integer.toString(year) + "/" + Integer.toString(monthOfYear + 1) + "/" + Integer.toString(dayOfMonth);
                select(diary_dt);
                btnWrite.setEnabled(true);
            }
        });

        btnWrite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                diary_content = edtDiary.getText().toString();
                String btnStr = btnWrite.getText().toString();
                if(btnStr == "새로 저장") {
                    insert(diary_dt, diary_content);
                    btnWrite.setText("수정 하기");
                } else {
                    update(diary_dt, diary_content);
                }
            }
        });

        btnInit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                init();
            }
        });

    }

    public void init() {
        //초기화
        SQLiteDatabase sqLiteDatabase = myHelper.getWritableDatabase();
        int majorVersion = 1;
        int minorVersion = 0;
        myHelper.onUpgrade(sqLiteDatabase, majorVersion, minorVersion);//테이블제거
        myHelper.onCreate(sqLiteDatabase);//테이블생성
        Toast.makeText(getApplicationContext(), "초기화 완료", Toast.LENGTH_SHORT).show();
        sqLiteDatabase.close();
    }

    public void insert(String diary_dt, String diary_content) {
        //입력
        SQLiteDatabase sqLiteDatabase = myHelper.getWritableDatabase();
        sqLiteDatabase.execSQL( "INSERT INTO diary VALUES ('"+ diary_dt + "', '" + diary_content + "')");
        Toast.makeText(getApplicationContext(), "저장완료", Toast.LENGTH_SHORT).show();
        sqLiteDatabase.close();
    }

    public void select(String diary_dt) {
        SQLiteDatabase sqLiteDatabase = myHelper.getReadableDatabase();
        Cursor cursor = sqLiteDatabase.rawQuery("SELECT diary_content FROM diary WHERE diary_dt='" + diary_dt +"'", null);

        if (cursor.moveToNext()) {
            diary_content = cursor.getString(0);
            btnWrite.setText("수정 하기");
            edtDiary.setText(diary_content);
        } else {
            edtDiary.setText(null);
            edtDiary.setHint("일기 없음");
            btnWrite.setText("새로 저장");
        }
        sqLiteDatabase.close();
    }

    public void update(String diary_dt, String diary_content) {
        SQLiteDatabase sqLiteDatabase = myHelper.getWritableDatabase();
        sqLiteDatabase.execSQL( "UPDATE diary SET diary_content = '"+ diary_content + "' WHERE diary_dt = '" + diary_dt + "'");
        Toast.makeText(getApplicationContext(), "수정완료", Toast.LENGTH_SHORT).show();
        sqLiteDatabase.close();
    }

}
