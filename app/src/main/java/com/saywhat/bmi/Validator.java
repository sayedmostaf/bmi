package com.saywhat.bmi;

import java.util.regex.Pattern;

public class Validator {
    //    private static final Pattern EMAIL_PATTERN = Pattern.compile("^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$");
//
//    private static final Pattern PASSWORD_PATTERN = Pattern.compile("^.{8,}$");
    private static final Pattern EMAIL_PATTERN =
            Pattern.compile("^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,6}$");

    private static final Pattern PASSWORD_PATTERN =
            Pattern.compile("^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@#$%^&+=!]).{8,}$");

    public boolean validEmail(String email) {
        if (email == null || email.isEmpty()) return false;
        return EMAIL_PATTERN.matcher(email).matches();
    }

    public boolean validPassword(String password) {
        if (password == null || password.isEmpty()) return false;
        return PASSWORD_PATTERN.matcher(password).matches();
    }
}
