package com.example.mad_314_1896930_a2;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    //private RecyclerView MyAdapter mAdapter;
    private RecyclerView.LayoutManager layoutManager;

    RecyclerView rvls;
    private MyAdapter  mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        recyclerView = findViewById(R.id.rvls);
        layoutManager = new LinearLayoutManager(this);
        rvls.setLayoutManager(layoutManager);

        mAdapter = new MyAdapter(getApplicationContext());
        rvls.setAdapter(mAdapter);

        final Listrepository repository = Listrepository.getInstance();

        final Intent nextintent = getIntent();
        String uname =nextintent.getStringExtra("a");
        String upassword=nextintent.getStringExtra("b");
        String uid=nextintent.getStringExtra("c");


        Listrepository items = new Listrepository();

        items.uname = uname;
        items.upassword =upassword;
        items.uid=uid;

        // add
        repository.addstudents(items);

        mAdapter.update();

        // clear the fields
        uname.getText().clear();
        upassword.getText().clear();
        uid.getText().clear();
    }
}