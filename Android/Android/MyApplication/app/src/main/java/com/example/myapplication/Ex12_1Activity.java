package com.example.myapplication;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class Ex12_1Activity extends AppCompatActivity {
    class MySQLiteOpenHelper extends SQLiteOpenHelper{
        public MySQLiteOpenHelper( Context context, String name) {
            //DB생성
            super(context, name, null, 1);
        }

        @Override
        public void onCreate(SQLiteDatabase sqLiteDatabase) {
            //테이블생성
            String sql = "CREATE TABLE groups (name varchar2(20), cnt int);";
            sqLiteDatabase.execSQL(sql);
        }

        @Override
        public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
            //테이블삭제
            String sql = "DROP TABLE IF EXISTS groups";
            sqLiteDatabase.execSQL(sql);
        }
    }

    private MySQLiteOpenHelper myHelper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ex12_1);
        myHelper = new MySQLiteOpenHelper(this, "testDB");
    }

    public void init(View view){
        //초기화
        SQLiteDatabase sqLiteDatabase = myHelper.getWritableDatabase();
        int majorVersion = 1;
        int minorVersion = 0;
        myHelper.onUpgrade(sqLiteDatabase, majorVersion, minorVersion);//테이블제거
        myHelper.onCreate(sqLiteDatabase);//테이블생성
        sqLiteDatabase.close();
    }
    public void insert(View view){
        //입력
        String name  = ((EditText)findViewById(R.id.edName)).getText().toString(); //그룹이름
        String cnt = ((EditText)findViewById(R.id.edCnt)).getText().toString();
        SQLiteDatabase sqLiteDatabase = myHelper.getWritableDatabase();
        sqLiteDatabase.execSQL(
                "INSERT INTO groups VALUES ('"+ name +"'," + Integer.parseInt(cnt) + ")");
        sqLiteDatabase.close();

        select(findViewById(R.id.btSelect));
    }
    public void select(View view){
        SQLiteDatabase sqLiteDatabase = myHelper.getReadableDatabase();
        Cursor cursor =
                sqLiteDatabase.rawQuery("SELECT * FROM groups", null);
        //cursor.moveToFirst(); //첫행으로 이동
        //cursor.moveToLast(); //마지막행으로 이동
        StringBuffer sb = new StringBuffer();
        sb.append("그룹명-인원수\n");
        while(cursor.moveToNext()){ //다음행으로 이동
            String name = cursor.getString(0); //첫번째 컬럼 name
            int cnt = cursor.getInt(1); //두번째 컬럼 cnt
            sb.append(name + "-" + cnt +"\n");
        }
        TextView tvResult = findViewById(R.id.tvResult);
        tvResult.setText(sb.toString());
        sqLiteDatabase.close();
    }
}
