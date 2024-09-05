package com.saywhat.bmi;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class LoginActivity extends AppCompatActivity {
    private EditText email, password;
    private Button signInButton;
    private TextView textSignUp;
    SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        email = findViewById(R.id.email_input);
        password = findViewById(R.id.password_input);
        signInButton = findViewById(R.id.login_button);
        textSignUp = findViewById(R.id.text_signup);

        sharedPreferences = getSharedPreferences("login", MODE_PRIVATE);

        textSignUp.setOnClickListener(v -> {
            Intent intent = new Intent(LoginActivity.this, SignUpActivity.class);
            startActivity(intent);
        });

        signInButton.setOnClickListener(v -> {
            if (validateLogin()) {
                Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                startActivity(intent);
            } else {
                Toast.makeText(LoginActivity.this, "Invalid email or password", Toast.LENGTH_SHORT).show();
            }
        });

    }

    private boolean validateLogin() {
        String emailInput = email.getText().toString().trim();
        String passwordInput = password.getText().toString().trim();

        String storedEmail = sharedPreferences.getString("email", "");
        String storedPassword = sharedPreferences.getString("password", "");

        return emailInput.equals(storedEmail) && passwordInput.equals(storedPassword);
    }
}