package com.example.mounitkatia;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Menu_v3 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_v3);
    }
    public void nextpage(View button){
        Intent send = new Intent(Menu_v3.this, Menu2.class);
        startActivity(send);
        overridePendingTransition(R.anim.slide_in_right,R.anim.slide_out_left);
    }
}