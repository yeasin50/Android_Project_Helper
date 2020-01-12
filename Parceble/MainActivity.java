package com.example.parceble;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    Adapter adapter;

    List<Model> models = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recy);

        models.add(new Model(R.drawable.icon,"Title1","descript 1"));
        models.add(new Model(R.drawable.audio,"Title2","descript 1"));
        models.add(new Model(R.drawable.br,"Title1","descript 1"));

        adapter = new Adapter(models);
        recyclerView.setAdapter(adapter);


    }
}
