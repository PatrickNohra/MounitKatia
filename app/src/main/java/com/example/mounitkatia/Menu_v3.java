package com.example.mounitkatia;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class Menu_v3 extends AppCompatActivity {
    public int countBm, countSB, countMazaher;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_v3);
        countBm=0;
        countSB=0;
        countMazaher=0;
    }
    public void nextpage(View button){
        Intent send = new Intent(Menu_v3.this, Menu2.class);
        startActivity(send);
        overridePendingTransition(R.anim.slide_in_right,R.anim.slide_out_left);
    }
    public void addstrawberry(View Button){
        TextView nameView = (TextView)findViewById(R.id.sbJamName);
        String name = nameView.getText().toString();
        TextView priceView = (TextView)findViewById(R.id.sbJamPrice);
        String price = priceView.getText().toString();

        Intent intent = new Intent(getApplicationContext(), addItem.class);
        intent.putExtra("Name", name);
        intent.putExtra("Price", price);
        intent.putExtra("Menu", 1);
        startActivity(intent);
    }

    public void addmazaher(View view) {
        TextView nameView = (TextView)findViewById(R.id.mazaherName);
        String name = nameView.getText().toString();
        TextView priceView = (TextView)findViewById(R.id.mazaherPrice);
        String price = priceView.getText().toString();

        Intent intent = new Intent(getApplicationContext(), addItem.class);
        intent.putExtra("Name", name);
        intent.putExtra("Price", price);
        intent.putExtra("Menu", 1);

        startActivity(intent);
    }

    public void addmakdous(View view) {
        TextView nameView = (TextView)findViewById(R.id.mkadousBName);
        String name = nameView.getText().toString();
        TextView priceView = (TextView)findViewById(R.id.maksoudBPrice);
        String price = priceView.getText().toString();

        Intent intent = new Intent(getApplicationContext(), addItem.class);
        intent.putExtra("Name", name);
        intent.putExtra("Price", price);
        intent.putExtra("Menu", 1);

        startActivity(intent);
    }

    public void proceedCashOut(View view) {
    }
}