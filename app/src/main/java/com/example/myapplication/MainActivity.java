package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final Button uye_ekle=findViewById(R.id.button2);
        final Button uye_listele=findViewById(R.id.button3);
        final Button etkinlik_ekle=findViewById(R.id.button4);
        final Button etkinlik_listele=findViewById(R.id.button5);

        uye_ekle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this,uye_ekle.class);
                startActivity(intent);
            }
        });
        uye_listele.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this,uye_listele.class);
                startActivity(intent);
            }
        });
        etkinlik_ekle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this,etkinlik_ekle.class);
                startActivity(intent);
            }
        });
        etkinlik_listele.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this,etkinlik_listele.class);
                startActivity(intent);
            }
        });

    }
}
