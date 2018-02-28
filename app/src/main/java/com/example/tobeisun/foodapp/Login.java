package com.example.tobeisun.foodapp;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class Login extends AppCompatActivity {


     Button btn , btn2; EditText email, Password ; FirebaseAuth auth; ProgressBar bar ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);


        btn = (Button) findViewById(R.id. buttonSignupp) ;
        btn2 =(Button) findViewById(R.id.buttonLoginn) ;
        email=(EditText) findViewById(R.id.editTextEmail) ;
        Password=(EditText) findViewById(R.id.editTextPassword)  ;
   auth=FirebaseAuth.getInstance();
   bar =(ProgressBar) findViewById(R.id.progressBarLogin) ;

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Login.this,Signup.class));
            }
        });

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if ((!TextUtils.isEmpty(Password.getText())) && Password.getText().toString().trim().length() == 6 && (!TextUtils.isEmpty(email.getText())) && Patterns.EMAIL_ADDRESS.matcher(email.getText()).matches()) {


                    bar.setVisibility(View.VISIBLE);


                        auth.signInWithEmailAndPassword(email.getText().toString(), Password.getText().toString()).addOnCompleteListener(Login.this, new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {

                                bar.setVisibility(View.GONE);
                                if(task.isSuccessful())
                                {
                                    startActivity(new Intent(Login.this, User.class));
                                }
                                else
                                {
                                    Toast.makeText(Login.this , "Try Again",Toast.LENGTH_LONG).show();
                                }
                            }
                        });

                    }
            else {
                             Toast.makeText(Login.this , "Check Email and password again",Toast.LENGTH_LONG).show();}
            }



        });
}
    @Override

        protected void onResume() {
            super.onResume();

            bar.setVisibility(View.GONE);
    }
}
