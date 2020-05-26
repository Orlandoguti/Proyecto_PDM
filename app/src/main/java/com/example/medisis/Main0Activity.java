package com.example.medisis;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;


public class Main0Activity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main0);
        Button Pantalla2=findViewById(R.id.bt_mostrar);
        Pantalla2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Main0Activity.this,Main2Activity.class));
            }
        });

        Button Pantalla1=findViewById(R.id.button5);
        Pantalla1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Main0Activity.this,MainActivity.class));
            }
        });
    }
}
