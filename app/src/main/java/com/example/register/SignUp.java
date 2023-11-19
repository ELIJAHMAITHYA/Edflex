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

public class SignUp extends AppCompatActivity {
    public FirebaseAuth auth;
    public EditText signUpEmail, signUpPassword, signUpConfirmPassword, signUpusername;
    public Button signUpButton; // Initialize signUpButton

    private TextView loginRedirecttext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        auth = FirebaseAuth.getInstance();
        signUpEmail = findViewById(R.id.signup_email);
        signUpusername = findViewById(R.id.signup_name);
        signUpPassword = findViewById(R.id.signup_password);
        signUpConfirmPassword = findViewById(R.id.signup_confirm_password);
        signUpButton = findViewById(R.id.signup_button); // Initialize signUpButton
        loginRedirecttext = findViewById(R.id.login_text);

        signUpButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email = signUpEmail.getText().toString().trim();
                String name = signUpusername.getText().toString().trim();
                String password = signUpPassword.getText().toString().trim();
                String confirmPassword = signUpConfirmPassword.getText().toString().trim();

                if (email.isEmpty() || name.isEmpty() || password.isEmpty() || confirmPassword.isEmpty()) {
                    // Add appropriate error handling for each field
                    Toast.makeText(SignUp.this, "All fields are required", Toast.LENGTH_LONG).show();
                } else {
                    if (!password.equals(confirmPassword)) {
                        // Handle the case where passwords do not match
                        Toast.makeText(SignUp.this, "Passwords do not match", Toast.LENGTH_LONG).show();
                    } else {
                        auth.createUserWithEmailAndPassword(email, password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                if (task.isSuccessful()) {
                                    Toast.makeText(SignUp.this, "Successfully Registered", Toast.LENGTH_LONG).show();
                                    startActivity(new Intent(SignUp.this,  login.class));
                                } else {
                                    Toast.makeText(SignUp.this, "Sign Up failed: " + task.getException().getMessage(), Toast.LENGTH_LONG).show();
                                }
                            }
                        });
                    }
                }
            }
        });

        loginRedirecttext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), login.class);
                startActivity(intent);
            }
        });
    }
}
