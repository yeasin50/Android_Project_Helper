package com.example.parceble;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import javax.xml.transform.Templates;

public class Main2Activity extends AppCompatActivity {

    ImageView imageView;
    Button button;
    TextView textView, textViews;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        imageView = findViewById(R.id.imageView2);
        textView = findViewById(R.id.textView3);
        textViews= findViewById(R.id.textView4);
        button = findViewById(R.id.button);


        Intent intent = getIntent();
        Model model = intent.getParcelableExtra("ITEM");

        imageView.setImageResource(model.getImage());
        textView.setText(model.getText1());
        textViews.setText(model.getText2());
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),MainActivity.class));
            }
        });


    }
}
