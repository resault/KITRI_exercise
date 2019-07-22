package com.example.myapplication;

import android.app.TabActivity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TabHost;

@SuppressWarnings("deprecation")
public class Ex6_17Activity extends TabActivity{//extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ex6_17);

        TabHost tabHost = this.getTabHost(); //탭호스트 얻기
        TabHost.TabSpec tabSpec = tabHost.newTabSpec("SONG"); //탭추가
        tabSpec.setIndicator("음악별");//탭 라벨설정
        tabSpec.setContent(R.id.song);//탭이 클릭되었을때 보여줄 위젯등록
        tabHost.addTab(tabSpec);//탭호스트에 탭설정

        TabHost.TabSpec tabSpec2 = tabHost.newTabSpec("SINGER"); //탭추가
        tabSpec2.setIndicator("가수별");//탭 라벨설정
        tabSpec2.setContent(R.id.singer);//탭이 클릭되었을때 보여줄 위젯등록
        tabHost.addTab(tabSpec2);//탭호스트에 탭설정

        TabHost.TabSpec tabSpec3 = tabHost.newTabSpec("ALBUM"); //탭추가
        tabSpec3.setIndicator("앨범별");//탭 라벨설정
        tabSpec3.setContent(R.id.album);//탭이 클릭되었을때 보여줄 위젯등록
        tabHost.addTab(tabSpec3);//탭호스트에 탭설정

    }
}
