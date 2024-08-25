package com.saywhat.bmi;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import java.util.Objects;

public class MainActivity extends AppCompatActivity {
    TextView maleCurrentHeight, maleCurrentWeight, maleCurrentAge;
    ImageView maleIncrementAge, maleDecrementAge, maleIncrementWeight, maleDecrementWeight;
    Button maleCalculateBmi;
    SeekBar heightSeekBar;
    RelativeLayout maleLayout, femaleLayout;

    int baseWeight = 55, baseAge = 20, currentProgress;
    String minProgress = "170", type = "0", weight2 = "55", age2 = "22";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        maleCurrentAge = findViewById(R.id.current_age);
        maleCurrentWeight = findViewById(R.id.current_weight);
        maleCurrentHeight = findViewById(R.id.current_height);
        maleIncrementAge = findViewById(R.id.increment_age);
        maleDecrementAge = findViewById(R.id.decrement_age);
        maleIncrementWeight = findViewById(R.id.increment_weight);
        maleDecrementWeight = findViewById(R.id.decrement_weight);
        maleCalculateBmi = findViewById(R.id.calc_button);
        heightSeekBar = findViewById(R.id.seekbar_height);
        maleLayout = findViewById(R.id.male);
        femaleLayout = findViewById(R.id.female);

        maleLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                maleLayout.setBackground(ContextCompat.getDrawable(getApplicationContext(), R.drawable.male_focus));
                femaleLayout.setBackground(ContextCompat.getDrawable(getApplicationContext(), R.drawable.bg_card_small));
                type = "Male";

            }
        });
        femaleLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                femaleLayout.setBackground(ContextCompat.getDrawable(getApplicationContext(), R.drawable.male_focus));
                maleLayout.setBackground(ContextCompat.getDrawable(getApplicationContext(), R.drawable.bg_card_small));
                type = "Female";

            }
        });
        heightSeekBar.setMax(300);
        heightSeekBar.setProgress(170);
        heightSeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                currentProgress = progress;
                minProgress = String.valueOf(currentProgress);
                maleCurrentHeight.setText(minProgress);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });


        maleIncrementWeight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                baseWeight++;
                weight2 = String.valueOf(baseWeight);
                maleCurrentWeight.setText(weight2);
            }
        });

        maleIncrementAge.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                baseAge++;
                age2 = String.valueOf(baseAge);
                maleCurrentAge.setText(age2);
            }
        });
        maleDecrementWeight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                baseWeight--;
                weight2 = String.valueOf(baseWeight);
                maleCurrentWeight.setText(weight2);
            }
        });

        maleDecrementAge.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                baseAge--;
                age2 = String.valueOf(baseAge);
                maleCurrentAge.setText(age2);
            }
        });
        maleCalculateBmi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (type.equals("0")) {
                    Toast.makeText(getApplicationContext(), "Select gender first", Toast.LENGTH_SHORT).show();
                } else if (minProgress.equals("0")) {
                    Toast.makeText(getApplicationContext(), "Select height first", Toast.LENGTH_SHORT).show();
                } else if (baseAge <= 0) {
                    Toast.makeText(getApplicationContext(), "Invalid age", Toast.LENGTH_SHORT).show();
                } else if (baseWeight <= 0) {
                    Toast.makeText(getApplicationContext(), "Invalid weight", Toast.LENGTH_SHORT).show();
                } else {
                    Intent intent = new Intent(MainActivity.this, HomeActivity.class);
                    intent.putExtra("gender", type);
                    intent.putExtra("height", minProgress);
                    intent.putExtra("weight", weight2);
                    intent.putExtra("age", age2);
                    startActivity(intent);
                }
            }
        });
    }
}