package com.example.intents;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        final Intent _intent = getIntent();

        TextView mesaage1 =findViewById(R.id.msg1);
        TextView mesaage2 =findViewById(R.id.msg2);


       String sum= _intent.getStringExtra("addtion");
       String multiply=_intent.getStringExtra("multiplication");
        mesaage1.setText("sum of three numbers is:"+sum);
         mesaage2.setText("product of three numbers is:"+multiply);


    }
}
