package com.actvn.shopapp.views;

import androidx.activity.OnBackPressedCallback;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.actvn.shopapp.R;
import com.bumptech.glide.Glide;

public class ProptiesActivity extends AppCompatActivity {
    private  ImageView imageView;
    private  TextView tvName, tvMoney;
    private ImageButton btnBack;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_propties);
        init();
        Intent intent = getIntent();
      String money =  intent.getStringExtra("money");
      String name = intent.getStringExtra("name");
      String url = intent.getStringExtra("imgs");
      tvMoney.setText(money);
      tvName.setText(name);
      Glide.with(this).load(url).into(imageView);
      btnBack.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View v) {
              onBackPressed();
          }
      });

    }
    private  void init() {
        imageView = findViewById(R.id.image_product_id);
        tvName = findViewById(R.id.name_product_id);
        tvMoney = findViewById(R.id.tv_currency);
        btnBack = findViewById(R.id.back_to_parent);
    }
    @Override
    public void onBackPressed()
    {
        super.onBackPressed();
    }
}