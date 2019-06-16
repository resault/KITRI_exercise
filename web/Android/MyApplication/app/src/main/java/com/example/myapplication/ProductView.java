package com.example.myapplication;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.view.LayoutInflater;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.kitri.dto.Product;

public class ProductView extends LinearLayout {
    public ProductView(Context context) {
        super(context);
    }
    public ProductView(Context context, Product product) {
        super(context);
        // Layout Inflation
        LayoutInflater inflater =
                (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        inflater.inflate(R.layout.listitem, this, true);

        ImageView ivProd_img;
        TextView tvProd_no;
        TextView tvProd_name;
        TextView tvProd_price;
        //------------
        ivProd_img = (ImageView) findViewById(R.id.prod_img); //이미지뷰
        //String imgFileName = "d001";//product.getProd_img();//이미지파일명
        //int imgResource = -1;

        int imgResource = R.drawable.d001;

//        if(imgFileName.equals("americano")){
//            imgResource = R.drawable.americano;
//        }else{
//            imgResource = R.drawable.icelatte;
//        }
        //String imageFileName = product.getProductCategory().getCate_no()+product.getProd_no();

        //Uri imagePath = Uri.parse("android.resource://com.example.myapplication/drawable/"+imageFileName);
        Resources res = getResources();
        Drawable img = res.getDrawable(imgResource);

        ivProd_img.setImageDrawable(img);
        //---------------
        tvProd_no = (TextView)findViewById(R.id.prod_no);
        tvProd_no.setText(product.getProd_no());

        tvProd_name = (TextView)findViewById(R.id.prod_name);
        tvProd_name.setText(product.getProd_name());

        tvProd_price = (TextView)findViewById(R.id.prod_price);
        tvProd_price.setText("" + product.getProd_price());
        //-------------------
		/* NumberPicker numberPicker = (NumberPicker) findViewById(R.id.numberPicker1);
        numberPicker.setMaxValue(20);
        numberPicker.setMinValue(0);     */
        // numberPicker.setWrapSelectorWheel(true);
    }
}

