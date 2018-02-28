package com.example.tobeisun.foodapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Login extends AppCompatActivity {


     Button btn , btn2; EditText email, Password ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);


        btn = (Button) findViewById(R.id. buttonSignUp) ;
        btn2 =(Button) findViewById(R.id.buttonLogin) ;
        email=(EditText) findViewById(R.id.editTextEmail) ;
        Password=(EditText) findViewById(R.id.editTextPassword)  ;


        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Login.this,Signup.class));
            }
        });
    }
}
