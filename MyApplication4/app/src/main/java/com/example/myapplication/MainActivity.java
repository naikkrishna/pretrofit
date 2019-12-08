package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.material.snackbar.Snackbar;

public class MainActivity extends AppCompatActivity {
Button btn_toast;
//int i=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
     final  Toast toast= Toast.makeText(getApplicationContext(), "This is test", Toast.LENGTH_SHORT);
        btn_toast =findViewById(R.id.btn_toast);

        btn_toast.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
              //  toast.setText("this is Demo"+i);
             //  toast.show();
           //     i++;
               // Toast.makeText(getApplicationContext(),"This is Demo!",Toast.LENGTH_SHORT).show();
             //  Snackbar snb=Snackbar.make(findViewById(R.id.mainlayout),"Done!", Snackbar.LENGTH_LONG);
             //  snb.show();

                Snackbar snb=Snackbar.make(findViewById(R.id.mainlayout),"Done!",Snackbar.LENGTH_INDEFINITE).setAction("UNDO", new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Toast.makeText(getApplicationContext(), "Snackbar toast!", Toast.LENGTH_LONG).show();

                    }
                });
                snb.show();
            }
        });
    }
}
