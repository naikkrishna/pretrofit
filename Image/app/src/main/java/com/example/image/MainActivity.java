package com.example.image;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

public class MainActivity extends AppCompatActivity {
ImageView img_demo;
String url="https://image.shutterstock.com/image-photo/popular-photographers-attraction-braies-lake-600w-705417145.jpg";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        img_demo=findViewById(R.id.imv_demo);

        Picasso.get().load(url).into(img_demo);

    }
}
