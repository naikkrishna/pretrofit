package com.richcgim.mp1_mad314_pa2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    EditText etId, etPassword;
    Button btnSubmit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etId = findViewById(R.id.et_id);
        etPassword = findViewById(R.id.et_password);
        btnSubmit = findViewById(R.id.btn_submit);

        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String inputId = etId.getText().toString();
                String inputPassword = etPassword.getText().toString();

                List<Student> students = StudentDataSource.getInstance().students;

                // find a student that fits the login
                for (int i = 0; i < students.size(); i++) {
                    Student student = students.get(i);
                    if (student.id == Integer.valueOf(inputId) && student.password.equals(inputPassword)) {
                        Intent intent = new Intent(MainActivity.this, SecondActivity.class);
                        startActivity(intent);
                    }
                }
            }
        });
    }
}
