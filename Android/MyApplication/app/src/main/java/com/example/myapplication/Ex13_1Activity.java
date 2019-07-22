package com.example.myapplication;

import android.Manifest;
import android.app.Activity;
import android.media.MediaPlayer;
import android.os.Environment;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;

import java.io.File;
import java.io.IOException;
import java.sql.Time;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class Ex13_1Activity extends AppCompatActivity {

    ProgressBar pb;
    private MediaPlayer mediaPlayer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ex13_1);
        pb = findViewById(R.id.pb);

        // SD 카드경로 접근 퍼미션 허용
        ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE}, MODE_PRIVATE);

        // SD 카드 기본경로
        final String mp3Path = Environment.getExternalStorageDirectory().getPath() + "/";
        Log.i("Ex13_1Activity", "mp3path=" + mp3Path);

        // 확장자가 mp3인 파일 찾기
        File dir = new File(mp3Path);
        File[] files = dir.listFiles();
        final List<String> fileNames = new ArrayList<>();
        for(File file : files) {
            String fileName = file.getName();
            if(fileName.endsWith(".mp3")) {
                fileNames.add(fileName);
            }
        }

        //ListView에 파일목록 보여주기
        ListView lvMp3 = (ListView) findViewById(R.id.lvMp3);
        ArrayAdapter<String> adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_single_choice, fileNames);
        lvMp3.setAdapter(adapter);
        lvMp3.setChoiceMode(ListView.CHOICE_MODE_SINGLE);   // 아이템 선택 가능하도록 설정

        // mp3파일용 MediaPlayer 생성
        lvMp3.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int index, long l) { // index >> 파일이름이 됨
                try {
                    String seleecteedFileName = fileNames.get(index);
                    mediaPlayer = new MediaPlayer();
                    mediaPlayer.setDataSource(mp3Path + seleecteedFileName);
                    mediaPlayer.prepare();  // 리소스 준비
                    TextView tvResult = (TextView) findViewById(R.id.tvResult);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
    }


    public void play(View view) {
        mediaPlayer.start();
//        mediaPlayer.isPlaying();
//        mediaPlayer.getDuration();
//        mediaPlayer.getCurrentPosition()

        pb.setMax(mediaPlayer.getDuration());
        new Thread(){
            public void run() {

                while (mediaPlayer.isPlaying()) { // 플레이 중


                    // 미디어플레이어 현재 위치값
//                    Log.i("Ex13_1Activity", "getCurrentPosition() = " + mediaPlayer.getCurrentPosition() + " getDuration() = " + mediaPlayer.getDuration());
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            int crrentPosition = mediaPlayer.getCurrentPosition();
                            SimpleDateFormat sdf = new SimpleDateFormat("mm:ss");
                            String progressTime = sdf.format(crrentPosition);
                            TextView tvResult = (TextView) findViewById(R.id.tvResult);
                            tvResult.setText(progressTime);
                            pb.setProgress(crrentPosition); // 사용자정의 스레드 안에서 위젯 사용하려면 runOnUiThread 사용해야 함

                        }
                    });
                }
            }
        }.start();
        pb.setVisibility(View.VISIBLE);
    }

    public void pause(View view) {
        Button currentBt = (Button) view;
        String btStr = currentBt.getText().toString();

        if("일시정지".equals(btStr)) {
            mediaPlayer.pause();
            currentBt.setText("이어듣기");  // 일시정지 클릭된 경우 "이어듣기"로 바뀐다
            pb.setVisibility(View.INVISIBLE);
        } else {
            mediaPlayer.start();
            currentBt.setText("일시정지");  // 이어듣기 클릭된 경우 "일시정지"로 바뀐다
            pb.setVisibility(View.VISIBLE);
        }

    }

    public void stop(View view) {
        mediaPlayer.stop();
    }

}
