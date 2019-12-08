package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        final Intent nextintent = getIntent();
        TextView t1 =findViewById(R.id.textView);
        TextView t2 =findViewById(R.id.textView2);

        String sum =nextintent.getStringExtra("id1");
        String multiply=nextintent.getStringExtra("id2");
        t1.setText("sum of three numbers is:"+sum);
        t2.setText("product of three numbers is:"+multiply);
    }
}
