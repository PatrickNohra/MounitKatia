package com.example.mounitkatia;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class addItem extends AppCompatActivity {
    TextView total, number, name;
    ImageView plus, minus;
    Button confirm;
    int count = 0;
    double price=0;
    int intentSource;
    String str="";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_item);

        total = findViewById(R.id.total);
        number = findViewById(R.id.numberofitems);
        name = findViewById(R.id.itemNameAdd);
        plus =  findViewById(R.id.plusItem);
        minus = findViewById(R.id.minusItem);
        confirm =  findViewById(R.id.confirm);

        Intent prev = getIntent();
        str = prev.getStringExtra("Name");
        name.setText("Number of "+str);
        String p  = prev.getStringExtra("Price");
        p = p.substring(0, p.length()-1);
        price =  Double.parseDouble(p);
        intentSource = prev.getIntExtra("Menu", 0);
    }

    public void removeItem(View view) {
        if (count >0){
            count--;
            number.setText(Integer.toString(count));
        }
        //Still have to round due to idk what error
        String tot = "" +(price*count);
        total.setText(tot+"$");
    }

    public void addItem(View view) {
        count++;
        number.setText(Integer.toString(count));
        String tot = ""+(price*count);
        total.setText(tot+"$");
    }

    public void confirm(View view) {
        if(intentSource==1){
        Intent intent = new Intent(getApplicationContext(), Menu_v3.class);
        intent.putExtra("count", count);
        intent.putExtra("name", str);
        startActivity(intent);
        }
    }
}