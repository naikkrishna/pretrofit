package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final EditText number1 = findViewById(R.id.num1);
        final EditText number2 = findViewById(R.id.num2);
        final EditText number3 = findViewById(R.id.num3);
        final Button login = findViewById(R.id.button);
        final Intent _myintent = new Intent(MainActivity.this, SecondActivity.class);

        String a = number1.getText().toString();
        final int n1 = Integer.parseInt(a);
        String b = number2.getText().toString();
        final int n2 = Integer.parseInt(b);
        String c = number3.getText().toString();
        final int n3 = Integer.parseInt(c);


        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                int sum = n1 + n2 + n3;
                int mul = n1 * n2 * n3;
                String M = Integer.toString(mul);
                String S = Integer.toString(sum);
                _myintent.putExtra("id1", S);
                _myintent.putExtra("id2", M);
                startActivity(_myintent);

            }

        });
    }
}
