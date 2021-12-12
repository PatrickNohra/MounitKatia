package com.example.mounitkatia;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.FirebaseDatabase;

import java.util.regex.Pattern;

public class RegisterUser extends AppCompatActivity {
    private FirebaseAuth mauth;
    private TextView username, password, email;
    private Button register;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_user);

        mauth = FirebaseAuth.getInstance();

        username = findViewById(R.id.username2);
        password = findViewById(R.id.password2);
        email = findViewById(R.id.email2);
        register = findViewById(R.id.registerButton2);



    }

    public void instagram2(View view) {
        Intent send = new Intent(RegisterUser.this, InstagramPage.class);
        startActivity(send);
    }

    public void gotomenu(View view) {

        String name = username.getText().toString().trim();
        String pass = password.getText().toString().trim();
        String mail = email.getText().toString().trim();
        if (name.isEmpty()||pass.isEmpty()||mail.isEmpty()){
            Toast.makeText(getApplicationContext(), "Fill all the fields!", Toast.LENGTH_LONG).show();
        }else if(!Patterns.EMAIL_ADDRESS.matcher(mail).matches()){
            Toast.makeText(getApplicationContext(), "Enter a valid email address!", Toast.LENGTH_LONG).show();
        }else{
            mauth.createUserWithEmailAndPassword(mail,pass).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {
                    if(task.isSuccessful()){
                        userAccount user = new userAccount(name,mail,pass);
                        FirebaseDatabase.getInstance().getReference("Users").child(FirebaseAuth.getInstance().getCurrentUser().getUid()).setValue(user).addOnCompleteListener(new OnCompleteListener<Void>() {
                            @Override
                            public void onComplete(@NonNull Task<Void> task) {
                                if(task.isSuccessful()){
                                    Toast.makeText(getApplicationContext(), "User has been Registered!", Toast.LENGTH_SHORT).show();
                                    Intent send = new Intent(RegisterUser.this, Menu_v3.class);
                                    startActivity(send);
                                }else Toast.makeText(getApplicationContext(), "could not register at this time!", Toast.LENGTH_SHORT).show();

                            }
                        });
                    }else Toast.makeText(getApplicationContext(), "could not register at this time 2!", Toast.LENGTH_SHORT).show();

                }
            });
        }

    }
}