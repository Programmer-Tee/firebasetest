package com.example.tobeisun.foodapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Signup extends AppCompatActivity {
Button btn ; EditText password; EditText email ; Button btn2 ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);


        btn = (Button) findViewById(R.id.buttonLogin) ;
        password=(EditText) findViewById(R.id.editTextPassword) ;
        email =(EditText) findViewById(R.id.editTextEmail) ;
        btn2=(Button) findViewById(R.id.buttonSignUp) ;






        if(password.length()==6)
        {
            btn.setOnClickListener(new View.OnClickListener() {
                @Override


                public void onClick(View view) {
                    startActivity(new Intent(Signup.this, Login.class));
                }

            });}


            else
        {
            Toast.makeText(Signup.this, "PASSWORD MUST BE 6 CHARACTERS",Toast.LENGTH_LONG) ;
        }

            }

    }

