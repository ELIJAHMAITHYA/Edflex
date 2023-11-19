package com.example.register;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Initialize Firebase here if needed

        // Find views by their IDs
        Button startButton = findViewById(R.id.startButton);

        // Set click listener for the "Start" button
        startButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Handle the button click, for example, navigate to another activity
                startActivity(new Intent(MainActivity.this, Home.class));
            }
        });
    }
}
