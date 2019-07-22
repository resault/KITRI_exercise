package com.example.myapplication;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.NumberPicker;
import android.widget.TextView;
import android.widget.Toast;

import com.kitri.dto.Product;

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.Map;

public class ProductInfoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_info);

        TextView tvProd_no = (TextView) findViewById(R.id.tvProd_no);
        TextView tvProd_name = (TextView) findViewById(R.id.tvProd_name);
        TextView tvProd_price = (TextView) findViewById(R.id.tvProd_price);

        Intent intent = getIntent();
        Product product = (Product)intent.getExtras().get("productInfo");

        tvProd_no.setText(tvProd_no.getText() + product.getProdNo());
        tvProd_name.setText(tvProd_name.getText() + product.getProdName());
        tvProd_price.setText(tvProd_price.getText() + String.valueOf(product.getProdPrice()));


        NumberPicker numberPicker = (NumberPicker) findViewById(R.id.npQuantity);
        numberPicker.setMinValue(1);
        numberPicker.setMaxValue(10);
        numberPicker.setWrapSelectorWheel(true);
    }


    public void addCart(View view) {
        TextView tvProd_no = (TextView) findViewById(R.id.tvProd_no);
        final String prod_no = tvProd_no.getText().toString();
        NumberPicker numberPicker = (NumberPicker) findViewById(R.id.npQuantity);
        final int quantity = numberPicker.getValue();

        final SharedPreferences pref = getApplicationContext().getSharedPreferences( "sessionCookie", Context.MODE_PRIVATE); //xml파일이름
        final SharedPreferences.Editor edit = pref.edit();


        //Thread 생성 및 run()오버라이딩
        new Thread() {
            public void run() {

                // url설정
                String urlStr = "http://192.168.14.61/myeljstl/addcart";
                InputStream is = null;

                try {
                    // ## 요청정보 설정
                    //서버로 요청
                    urlStr += "?no=" + prod_no + "&quantity=" + quantity;
                    URL url = new URL(urlStr);
                    HttpURLConnection con = (HttpURLConnection) url.openConnection();
                    con.setRequestMethod("GET");

                    //요청헤더에 쿠키 추가
                    String jsession_cookie = pref.getString("JSESSIONID", null);
                    if (jsession_cookie != null) {
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

//                        is = con.getInputStream();
//
//                        StringBuffer sb = new StringBuffer();
//                        int readValue = -1;
//                        while( (readValue = is.read()) != -1){
//                            sb.append((char)readValue);
//                        }

//                        Map sharedDatas = pref.getAll();
//                        for(Object key : sharedDatas.keySet()){
//                            Log.i("ProductInfoActivity", "SharedPreferences: " + key + "=" + sharedDatas.get(key));
//
//                        }

                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                Toast.makeText(ProductInfoActivity.this, "장바구니 넣기 성공", Toast.LENGTH_LONG).show();

                            }
                        });


                        finish();


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
