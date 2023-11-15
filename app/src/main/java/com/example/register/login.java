package com.example.register;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class login extends AppCompatActivity {
    public FirebaseAuth auth;
    public EditText LoginEmail, LoginPassword,LoginUsername;
    public Button LoginButton;

    private TextView SignUpRedirecttext;
    //private TextView LoginadminRedirecttext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        auth = FirebaseAuth.getInstance();
        LoginEmail = findViewById(R.id.login_email);
        LoginUsername = findViewById(R.id.login_name);
        LoginPassword = findViewById(R.id.login_password);
        LoginButton = findViewById(R.id.login_button); // Initialize signUpButton
        SignUpRedirecttext = findViewById(R.id.signup_text);
     // LoginadminRedirecttext = findViewById(R.id.admin);
        LoginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email = LoginEmail.getText().toString().trim();
                String name = LoginUsername.getText().toString().trim();
                String password = LoginPassword.getText().toString().trim();

                if (email.isEmpty() || name.isEmpty() || password.isEmpty()) {
                    // Add appropriate error handling for each field
                    Toast.makeText(login.this, "All fields are required", Toast.LENGTH_LONG).show();
                } else {
                        auth.createUserWithEmailAndPassword(email, password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                if (task.isSuccessful()) {
                                    Toast.makeText(login.this, "Log In Successful", Toast.LENGTH_LONG).show();
                                    startActivity(new Intent(login.this,  login.class));
                                } else {
                                    Toast.makeText(login.this, "Log In failed: " + task.getException().getMessage(), Toast.LENGTH_LONG).show();
                                }
                            }
                        });
                    }
                }
            });

        SignUpRedirecttext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplication(), SignUp.class);
                startActivity(intent);
            }
        });
    }
}
