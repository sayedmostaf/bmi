package com.saywhat.bmi;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class HomeActivity extends AppCompatActivity {

    TextView header, tips, bmiDisplay, categoryDisplay;
    Intent intent;
    ImageView stateImageView;
    String height, weight, gender;
    RelativeLayout bgLayout;

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        intent = getIntent();

        categoryDisplay = findViewById(R.id.bmi_calc);
        bmiDisplay = findViewById(R.id.state);
        stateImageView = findViewById(R.id.bmi_image);
        tips = findViewById(R.id.tips);
        header = findViewById(R.id.header);

        height = intent.getStringExtra("height");
        weight = intent.getStringExtra("weight");
        gender = intent.getStringExtra("gender");
        boolean isMale = gender.equalsIgnoreCase("male");

        BmiData bmiData = new BmiData(Float.parseFloat(height), Float.parseFloat(weight), isMale);

        int[] maleImages = {
                R.drawable.servere_thinness,
                R.drawable.modrate,
                R.drawable.mild,
                R.drawable.normal,
                R.drawable.overweight,
                R.drawable.obesei,
                R.drawable.obseeii,
                R.drawable.obeseiii
        };
        int[] femaleImages = {
                R.drawable.male_servere,
                R.drawable.male_modrate,
                R.drawable.male_modrate,
                R.drawable.male_normal,
                R.drawable.male_overweight,
                R.drawable.male_obesei,
                R.drawable.male_obeseii,
                R.drawable.male_obeseii
        };

        int[] categoryColors = {
                getResources().getColor(R.color.severe_thinness),
                getResources().getColor(R.color.moderate_thinness),
                getResources().getColor(R.color.mild_thinness),
                getResources().getColor(R.color.normal),
                getResources().getColor(R.color.overweight),
                getResources().getColor(R.color.obese_class_1),
                getResources().getColor(R.color.obese_class_2),
                getResources().getColor(R.color.obese_class_3)
        };

        bmiDisplay.setText(String.format("%.1f", bmiData.getBmiResult()));
        categoryDisplay.setText(bmiData.getCategory());
        tips.setText(bmiData.getTips());

        stateImageView.setImageResource((!isMale) ? maleImages[bmiData.getImageIndex()] : femaleImages[bmiData.getImageIndex()]);
        int color = categoryColors[bmiData.getImageIndex()];
        categoryDisplay.setTextColor(color);
        tips.setTextColor(color);
        header.setTextColor(color);
    }
}