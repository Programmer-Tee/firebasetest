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

public class Signup extends AppCompatActivity {
    Button buttonLogin;
    EditText password;
    EditText email;
    Button buttonSignUp;
    FirebaseAuth auth;
    ProgressBar progressBar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_signup);

        auth = FirebaseAuth.getInstance();


        buttonLogin = (Button) findViewById(R.id.buttonLogin);
        password = (EditText) findViewById(R.id.editTextPassword);
        email = (EditText) findViewById(R.id.editTextEmail);
        buttonSignUp = (Button) findViewById(R.id.buttonSignUp);
        progressBar = findViewById(R.id.signUpprogressBar);


        //handle action when signup button is clicked
        buttonSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                //validate password - 6 password length
                if ((!TextUtils.isEmpty(password.getText())) && password.getText().toString().trim().length() == 6 && (!TextUtils.isEmpty(email.getText())) && Patterns.EMAIL_ADDRESS.matcher(email.getText()).matches()) {


                    progressBar.setVisibility(View.VISIBLE);
                    auth.createUserWithEmailAndPassword(email.getText().toString(),password.getText().toString()).addOnCompleteListener(Signup.this, new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {

                            progressBar.setVisibility(View.GONE);


                            if(task.isSuccessful()){


                        startActivity(new Intent(Signup.this,Login.class));
                         finish();

                            }else{

                                Toast.makeText(Signup.this, "Sign Up Failed!"+task.getException(), Toast.LENGTH_LONG).show();

                            }



                        }
                    });


                }

                else {
                    Toast.makeText(Signup.this, "YOUR PASSWORD MUST BE 6 CHARACTERS WITH A VALID EMAIL", Toast.LENGTH_LONG).show();

                }


            }

        });
    }


    @Override
    protected void onResume() {
        super.onResume();

        progressBar.setVisibility(View.GONE);
    }
}

