package com.example.mounitkatia;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {
    private Button login, register;
    private TextView username, password;
    FirebaseAuth fAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        login = (Button) findViewById(R.id.login);
        register = (Button) findViewById(R.id.registerButton2);
        username = (TextView)findViewById(R.id.username2);
        password = (TextView)findViewById(R.id.username2);
        fAuth =FirebaseAuth.getInstance();
    }
    public void instagram(View view){
        ImageView insta = findViewById(R.id.insta);
        Intent send = new Intent(MainActivity.this, InstagramPage.class);
        startActivity(send);
        
    }
    public void login(View button){
        String name = username.getText().toString().trim();
        String pass = password.getText().toString().trim();

        if (name.isEmpty()||pass.isEmpty()){
            Toast.makeText(getApplicationContext(), "Fill all the fields!", Toast.LENGTH_SHORT).show();
        }else {
            fAuth.signInWithEmailAndPassword(name, pass).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {
                    if(task.isSuccessful()){
                        Toast.makeText(getApplicationContext(), "Log in Successful!", Toast.LENGTH_SHORT).show();

                        Intent send = new Intent(MainActivity.this, Menu_v3.class);
                        startActivity(send);
                    }else Toast.makeText(getApplicationContext(), "Wrong email or password!", Toast.LENGTH_SHORT).show();

                }
            });
        }Intent send = new Intent(MainActivity.this, Menu_v3.class);
        startActivity(send);


    }

    public void goToRegisterPage(View view) {
        Intent send = new Intent(MainActivity.this, RegisterUser.class);
        startActivity(send);
    }

}