package com.example.mounitkatia;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private TextView login, register;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        login = (TextView)findViewById(R.id.login);
        register = (TextView)findViewById(R.id.registerButton2);


    }
    public void instagram(View view){
        ImageView insta = findViewById(R.id.insta);
        Intent send = new Intent(MainActivity.this, InstagramPage.class);
        startActivity(send);
        
    }
    public void login(View button){
        Intent send = new Intent(MainActivity.this, Menu_v3.class);
        startActivity(send);
    }

    public void goToRegisterPage(View view) {
        Intent send = new Intent(MainActivity.this, RegisterUser.class);
        startActivity(send);
    }

}