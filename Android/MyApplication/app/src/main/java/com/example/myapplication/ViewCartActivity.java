package com.example.myapplication;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.NumberPicker;
import android.widget.TextView;
import android.widget.Toast;

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

public class ViewCartActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_cart);

        final SharedPreferences pref = getApplicationContext().getSharedPreferences( "sessionCookie", Context.MODE_PRIVATE); //xml파일이름
        final SharedPreferences.Editor edit = pref.edit();

        //Thread 생성 및 run()오버라이딩
        new Thread() {
            public void run() {

                // url설정
                String urlStr = "http://192.168.14.61/myeljstl/viewcart";
                InputStream is = null;

                try {
                    // ## 요청정보 설정
                    //서버로 요청
                    URL url = new URL(urlStr);
                    HttpURLConnection con = (HttpURLConnection) url.openConnection();
                    con.setRequestMethod("GET");

                    //요청헤더에 쿠키 추가
                    String jsession_cookie = pref.getString("JSESSIONID", null);
                    if (jsession_cookie != null) {
                        Log.i("ViewCartActivity", "쿠키 :"+ jsession_cookie);
                        con.setRequestProperty("Cookie", jsession_cookie);
                    }


                    // ## 요청정보 설정 끝

                    // 응답얻기     //응답 메소드 호출시 서버로 요청정보가 전달되고, 응답이 돌아옴. 요청 및 응답 코딩 순서만 지키면 됨
                    int responseCode = con.getResponseCode();
                    if (responseCode == HttpURLConnection.HTTP_OK) { //정상응답 (200번과 같은 상수값)
                        //응답헤더중 cookie값 얻기
                        List<String> cookies = con.getHeaderFields().get("Set-cookie");
                        if (cookies != null) {  //최초 요청이 아닌경우 (최초 요청시에는 cookie가 없음)
                            Log.i("LoginActivity" , cookies.toString());
                            for (String cookie : cookies) {
                                //JSESSIONID=4B9E346D35F9D49E6DA0E8452E82F729; Path=/myeljstl; HttpOnly
                                String cookieNameValue = cookie.split(";\\s*")[0]; //JSESSIONID=4B9E346D35F9D49E6DA0E8452E82F729
                                String cookieName = cookieNameValue.split("=")[0];
                                edit.putString(cookieName, cookieNameValue);    //SharedPreference객체에 쓰기 (cookie이름과 값으로 저장)
                                edit.apply(); //xml파일에 쓰기작업을 비동기화
                            }
                        }

                        is = con.getInputStream();

                        StringBuffer sb = new StringBuffer();
                        int readValue = -1;
                        while( (readValue = is.read()) != -1){
                            sb.append((char)readValue);
                        }
                        Log.i("ViewCartActivity", "응답결과 :" + sb.toString());

//                        Map sharedDatas = pref.getAll();
//                        for(Object key : sharedDatas.keySet()){
//                            Log.i("ProductInfoActivity", "SharedPreferences: " + key + "=" + sharedDatas.get(key));
//
//                        }



//                        finish();


//
                    }
                } catch (MalformedURLException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }finally{


                }
            }
        }.start();
    }


}
