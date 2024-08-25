package com.saywhat.bmi;

public class BmiData {
    private float height, weight, bmiResult;
    private String category, tips;
    private int imageIndex;
    private int[] categoryColors;

    public BmiData(float height, float weight) {
        this.height = height / 100;
        this.weight = weight;
        calculateBmi();
        determineCategory();
    }

    private void calculateBmi() {
        this.bmiResult = weight / (height * height);
    }

    private void determineCategory() {
        if (bmiResult < 16) {
            imageIndex = 0;
            category = "Severe Thinness";
            tips = "You have severe thinness. Please consult a healthcare provider.";
        } else if (bmiResult < 17) {
            imageIndex = 1;
            category = "Moderate Thinness";
            tips = "You have moderate thinness. Consider improving your diet.";
        } else if (bmiResult < 18.5) {
            imageIndex = 2;
            category = "Mild Thinness";
            tips = "You have mild thinness. A balanced diet can help.";
        } else if (bmiResult < 25) {
            imageIndex = 3;
            category = "Normal";
            tips = "You have a normal body weight. Good job!";
        } else if (bmiResult < 30) {
            imageIndex = 4;
            category = "Overweight";
            tips = "You are overweight. Regular exercise can help.";
        } else if (bmiResult < 35) {
            imageIndex = 5;
            category = "Obese Class I";
            tips = "Obese Class I. A weight loss plan is recommended.";
        } else if (bmiResult < 40) {
            imageIndex = 6;
            category = "Obese Class II";
            tips = "Obese Class II. Medical advice is necessary.";
        } else {
            imageIndex = 7;
            category = "Obese Class III";
            tips = "Obese Class III. Immediate medical intervention is needed.";
        }
    }

    public float getBmiResult() {
        return bmiResult;
    }

    public String getCategory() {
        return category;
    }

    public int getImageIndex() {
        return imageIndex;
    }

    public String getTips() {
        return tips;
    }
}
