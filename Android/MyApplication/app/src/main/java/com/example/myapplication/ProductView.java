package com.example.myapplication;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.util.Log;
import android.view.LayoutInflater;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.kitri.dto.Product;

import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Arrays;
import java.util.List;

public class ProductView extends LinearLayout {
    private ImageView ivProd_img;
    private TextView tvProd_no;
    private TextView tvProd_name;
    private TextView tvProd_price;
    public ProductView(Context context, Product product) {
        super(context);
        // Layout Inflation
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        inflater.inflate(R.layout.listitem, this, true);    //부분 "xml"을 전개


        new Thread() {
            public void run() {
                //아래는 java코드임
                String urlStr = "http://192.168.14.61/androidweb/ProdList.jsp";
                InputStream is = null;
                ByteArrayOutputStream byteArrayOutputStream = null;

                try {
                    //GET 방식으로 요청
//                    urlStr += "?opt=add";
//                    URL url = new URL(urlStr);  //요청
//                    HttpURLConnection con = (HttpURLConnection) url.openConnection();//응답
//                    con.setRequestMethod("GET");


                    //POST 방식으로 요청
                    URL url = new URL(urlStr);  //요청
                    HttpURLConnection con = (HttpURLConnection) url.openConnection();//응답
                    con.setRequestMethod("POST");
                    con.setDoOutput(true);  //요청 전달데이터를 message body에 쓰기 허용
                    DataOutputStream dos = new DataOutputStream(con.getOutputStream());
                    dos.writeBytes("opt=add");  //message body에 쓰기

                    is = con.getInputStream();   //응답결과 입력스트림

                    byte[] buf = new byte[1024];
                    byteArrayOutputStream = new ByteArrayOutputStream(buf.length);

                    int readLength = -1;
                    while ((readLength = is.read(buf)) != -1) {
//                        String str = new String(buf, 0, readLength);
//                        JSONObject jsonObject = new JSONObject();
//                        Log.i("NewActivity", "서버가 보내준 응답결과" + str);
                        byteArrayOutputStream.write(buf, 0, readLength);
                    }
                    byte[] byteData = null;
                    byteData = byteArrayOutputStream.toByteArray();
                    String str = new String(byteData, 0, byteData.length);

//                    JSONObject jsonObject = new JSONObject(str);
//                    int status = jsonObject.getInt("status");
//                    String msg = jsonObject.getString("msg");
//                    String method = jsonObject.getString("method");
//                    String opt = jsonObject.getString("opt");
//                    Log.i("NetworkActivity", "서버가 보내준 [status]: " + status);
//                    Log.i("NetworkActivity", "서버가 보내준 [msg]: " + msg);
//                    Log.i("NetworkActivity", "서버가 보내준 [method]: " + method);
//                    Log.i("NetworkActivity", "서버가 보내준 [opt]: " + opt);

//                    JSONArray jsonArray = new JSONArray(str);
//                    for(JSONObject jsonObject : jsonArray) {
//                        String prod_no = jsonObject.getString("prod_no");
//                        String prod_name = jsonObject.getString("prod_name");
//                        Log.i("NetworkActivity", "서버가 보내준 [prod_name]: " + prod_name);
//                    }

//                    //jasonArray 받아서 반복문 처리
//                    int len = jsonArray.length();
//                    for(int i=0; i<len; i++) {
//                        JSONObject jsonObject = (JSONObject)jsonArray.get(i);
//                        String prod_no = jsonObject.getString("prod_no");
//                        String prod_name = jsonObject.getString("prod_name");
//                        int prod_price = jsonObject.getInt("prod_price");
//
//
//                        Log.i("NetworkActivity", "서버가 보내준 [prod_no]: " + prod_no);
//                        Log.i("NetworkActivity", "서버가 보내준 [prod_name]: " + prod_name);
//                        Log.i("NetworkActivity", "서버가 보내준 [prod_price]: " + prod_price);
//
//                    }


                    ObjectMapper mapper = new ObjectMapper();
                    List<Product> list = Arrays.asList(mapper.readValue(str, Product[].class));
                    Log.i("NetworkActivity", "서버가 보내준 상품종류: " + list.size());
                    int len = list.size();
                    for(int i=0; i<len; i++) {
                        Product p = list.get(i);
                        String prod_no = p.getProdNo();
                        String prod_name = p.getProdName();
                        int prod_num = p.getProdPrice();
                        Log.i("NetworkActivity", "서버가 보내준 상품정보 : 상품번호_" + prod_no + ", 상품명_" + prod_name + ", 상품가격_" + prod_num + "");
                    }




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

            }
        }.start();




        //------------
        ivProd_img = (ImageView) findViewById(R.id.prod_img); //이미지뷰
//        String imgFileName = ""//product.getProd_img();//이미지파일명
        int imgResource = R.drawable.a001;
//        if(imgFileName.equals("americano")){
//            imgResource = R.drawable.americano;
//        }else{
//            imgResource = R.drawable.icelatte;
//        }

        Resources res = getResources();
        Drawable img = res.getDrawable(imgResource);
        ivProd_img.setImageDrawable(img);
        //---------------
        tvProd_no = (TextView) findViewById(R.id.prod_no);
        tvProd_no.setText(product.getProdNo());

        tvProd_name = (TextView) findViewById(R.id.prod_name);
        tvProd_name.setText(product.getProdName());

        tvProd_price = (TextView) findViewById(R.id.prod_price);
        tvProd_price.setText("" + product.getProdPrice());
        //-------------------
		/* NumberPicker numberPicker = (NumberPicker) findViewById(R.id.numberPicker1);
        numberPicker.setMaxValue(20);
        numberPicker.setMinValue(0);     */
        // numberPicker.setWrapSelectorWheel(true);
    }
}
