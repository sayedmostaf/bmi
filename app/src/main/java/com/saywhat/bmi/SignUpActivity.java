    package com.saywhat.bmi;

    import android.content.Intent;
    import android.content.SharedPreferences;
    import android.os.Bundle;
    import android.widget.Button;
    import android.widget.EditText;
    import android.widget.TextView;
    import android.widget.Toast;

    import androidx.appcompat.app.AppCompatActivity;

    public class SignUpActivity extends AppCompatActivity {
        EditText username, email, password, confirmPassword;
        Button signUpButton;
        TextView textSignIn;
        SharedPreferences sharedPreferences;
        Validator validator;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_sign_up);

            username = findViewById(R.id.username_input);
            email = findViewById(R.id.email_input);
            password = findViewById(R.id.password_input);
            confirmPassword = findViewById(R.id.confirm_password_input);
            signUpButton = findViewById(R.id.signup_button);
            textSignIn = findViewById(R.id.text_sign_in);

            validator = new Validator();
            sharedPreferences = getSharedPreferences("login", MODE_PRIVATE);

            textSignIn.setOnClickListener(v -> {
                Intent intent = new Intent(SignUpActivity.this, LoginActivity.class);
                startActivity(intent);
            });

            signUpButton.setOnClickListener(v -> {
                if (validateInputs()) {
                    String emailVal = email.getText().toString().trim();
                    String passwordVal = password.getText().toString().trim();

                    SharedPreferences.Editor editor = sharedPreferences.edit();
                    editor.putString("email", emailVal);
                    editor.putString("password", passwordVal);
                    editor.apply();

                    Intent intent = new Intent(SignUpActivity.this, LoginActivity.class);
                    startActivity(intent);
                }
            });
        }

        private boolean validateInputs() {
            String usernameInput = username.getText().toString().trim();
            String emailInput = email.getText().toString().trim();
            String passwordInput = password.getText().toString().trim();
            String confirmPasswordInput = confirmPassword.getText().toString().trim();

            boolean isValid = true;

            if (usernameInput.length() < 4) {
                username.setError("Username must be at least 4 characters");
                isValid = false;
            }

            if (!validator.validEmail(emailInput)) {
                email.setError("Invalid email");
                isValid = false;
            }

            if (!validator.validPassword(passwordInput)) {
                password.setError("Password must be at least 8 characters, include an uppercase letter, a lowercase letter, a digit, and a special character");
                isValid = false;
            }

            if (!passwordInput.equals(confirmPasswordInput)) {
                confirmPassword.setError("Passwords do not match");
                isValid = false;
            }

            return isValid;
        }
    }