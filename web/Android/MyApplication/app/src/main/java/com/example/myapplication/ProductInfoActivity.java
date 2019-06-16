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

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.util.List;
import java.util.Map;

public class ProductInfoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_info);
        TextView tvProdu_no = (TextView) findViewById(R.id.tvProd_no);
        TextView tvProdu_name = (TextView) findViewById(R.id.tvProd_name);
        TextView tvProdu_price = (TextView) findViewById(R.id.tvProd_price);

        Intent intent = getIntent();
        Product product = (Product) (intent.getExtras().get("productInfo"));

        tvProdu_no.setText(tvProdu_no.getText() + product.getProd_no());
        tvProdu_name.setText(tvProdu_name.getText() + product.getProd_name());
        tvProdu_price.setText(tvProdu_price.getText() + String.valueOf(product.getProd_price()));

        NumberPicker numberPicker =
                (NumberPicker) findViewById(R.id.npQuantity);
        numberPicker.setMinValue(1);
        numberPicker.setMaxValue(10);
        numberPicker.setWrapSelectorWheel(true);

    }

    public void addCart(View view) {
        TextView tvProdu_no = (TextView) findViewById(R.id.tvProd_no);
        final String prod_no = tvProdu_no.getText().toString();//상품번호
        NumberPicker numberPicker = (NumberPicker) findViewById(R.id.npQuantity);
        final int quantity = numberPicker.getValue();//수량

        final SharedPreferences pref =
                getApplicationContext().getSharedPreferences(
                        "sessionCookie"  //xml파일이름
                        , Context.MODE_PRIVATE);

        final SharedPreferences.Editor edit = pref.edit();

        new Thread() {
            public void run() {
                String urlStr = "http://192.168.14.52/myeljstl/addcart";
                InputStream is = null;
                try {
                    urlStr += "?no=" + prod_no + "&quantity=" + quantity;
                    URL url = new URL(urlStr);
                    HttpURLConnection con = (HttpURLConnection) url.openConnection();
                    con.setRequestMethod("GET");

                    //요청헤더에 쿠키추가
                    String jsession_cookie = pref.getString("JSESSIONID", null);
                    if (jsession_cookie != null) {
                        con.setRequestProperty("Cookie", jsession_cookie);
                    }

                    //응답얻기
                    int responseCode = con.getResponseCode();
                    if (responseCode == HttpURLConnection.HTTP_OK) {
                        List<String> cookies =
                                con.getHeaderFields().get("Set-cookie");

                        //JSESSIONID쿠키없이 요청했을경우
                        // 서버가 응답하는 응답헤더에는 쿠키가 있다

                        //JSESSIONID쿠키가  요청헤더에 추가됐을경우
                        // 서버가 응답하는 응답헤더에는 쿠키가 없다
                        if (cookies != null) {
                            Log.i("ProductInfoActivity" , "응답쿠키내용:" + cookies.toString());
                            for (String cookie : cookies) {
                                String cookieNameValue = cookie.split(";\\s*")[0];
                                String cookieName = cookieNameValue.split("=")[0];
                                edit.putString(cookieName, cookieNameValue);
                                edit.apply();
                            }
                        }
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                Toast.makeText(ProductInfoActivity.this,
                                        "장바구니 넣기 성공",
                                        Toast.LENGTH_SHORT).show();
                            }
                        });

//                        Map sharedDatas = pref.getAll();
//                        for(Object key : sharedDatas.keySet()){
//                            Log.i("ProductInfoActivity", "SharedPreferences: " + key + "=" + sharedDatas.get(key));
//
//                        }
                        finish();
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                } finally {

                }
            }
        }.start();
    }
}