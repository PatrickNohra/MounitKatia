package com.example.mounitkatia;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }
    public void instagram(View view){
        ImageView insta = findViewById(R.id.insta);
        
    }
    public void login(View button){
        Intent send = new Intent(MainActivity.this, Menu_v3.class);
        startActivity(send);
    }
}