package com.example.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.kitri.dto.Product;

import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CustomListViewActivity extends AppCompatActivity {


    private ArrayList<Product> data = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_custom_list_view);

        final MyListView view = new MyListView(CustomListViewActivity.this);



        // 임의 data로 뿌리기
        //// data 생성해서 List에 add ////
//        final ArrayList<Product> data = new ArrayList<>();
//        Product p = new Product();
//        p.setProdNo("001");
//        p.setProdPrice(1500);
//        p.setProdName("아메리카노");
//        data.add(p);
//
//        p = new Product();
//        p.setProdNo("002");
//        p.setProdPrice(2000);
//        p.setProdName("아이스아메리카노");
//        data.add(p);
//
//        p = new Product();
//        p.setProdNo("003");
//        p.setProdPrice(1500);
//        p.setProdName("라테");
//        data.add(p);
//
//        p = new Product();
//        p.setProdNo("004");
//        p.setProdPrice(1500);
//        p.setProdName("카푸치노");
//        data.add(p);
//
//
//        MyAdapter adapter = new MyAdapter(this, data);
//        MyListView view = new MyListView(this);
//        view.setAdapter(adapter);
//
//        layout.addView(view);


        // 서버로부터 데이터 받아서 뿌리기

//        웹서버url : http://192.168.14.52/myeljstl/productlistjson

        new Thread() {
            public void run() {
                String urlStr = "http://192.168.14.61/myeljstl/productlistjson";
                InputStream is = null;
                ByteArrayOutputStream byteArrayOutputStream = null;

                try {
                    //GET 방식으로 요청
                    URL url = new URL(urlStr);  //요청
                    HttpURLConnection con = (HttpURLConnection) url.openConnection();//응답
                    con.setRequestMethod("GET");

                    is = con.getInputStream();   //응답결과 입력스트림
                    byte[] buf = new byte[1024];

                    byteArrayOutputStream = new ByteArrayOutputStream(buf.length);

                    int readLength = -1;
                    while ((readLength = is.read(buf)) != -1) {
                        byteArrayOutputStream.write(buf, 0, readLength);
                    }

                    byte[] byteData = null;
                    byteData = byteArrayOutputStream.toByteArray();

                    // 서버가 보내준 응답내용(문자열)
                    String str = new String(byteData, 0, byteData.length);
                    Log.i("CustomListViewActivity", "서버 응답내용 :" + str);

                    // JACKSON API : JSONObject와 DTO간의 매핑
                    ObjectMapper mapper = new ObjectMapper();
//                    List<Product> list = Arrays.asList(mapper.readValue(str, Product[].class)); // JSON 배열 형태의 문자열을 Product Class의 배열 타입으로 매핑
                    data = mapper.readValue( str, new TypeReference<ArrayList<Product>>() {
                    });

                    final MyAdapter adapter = new MyAdapter(CustomListViewActivity.this, data);

                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            view.setAdapter(adapter);

                        }
                    });



                } catch (MalformedURLException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                } finally {
                    if (is != null) {
                        try {
                            is.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                }
            } //run()
        }.start();


        LinearLayout layout = (LinearLayout) findViewById(R.id.list);

//        MyAdapter adapter = new MyAdapter(this, data);
//        MyListView view = new MyListView(this);
//        view.setAdapter(adapter);

        layout.addView(view);



        //상품목록을 길게 눌렀을 때, 상세정보를 보여주도록 이벤트 처리
        view.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int index, long l) {

//                Toast.makeText(CustomListViewActivity.this, data.get(index).getProdName(), Toast.LENGTH_LONG).show();
                Intent intent = new Intent(CustomListViewActivity.this, ProductInfoActivity.class);

                //직렬화 된 클래스의 기본형데이터인 경우에만 putExtra로 전달할 수 있음    >>  Product클래스에 implements Serializable 처리함
                intent.putExtra("productInfo", data.get(index));
                startActivity(intent);

                return false;
            }
        });
    }
}
