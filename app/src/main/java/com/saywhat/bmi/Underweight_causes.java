package com.saywhat.bmi.History;

import android.os.Bundle;
import android.widget.ExpandableListView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.saywhat.bmi.R;

public class Underweight_causes extends AppCompatActivity {

    private ExpandableListView expandabledescripView;
    private ExpandableDescriptionAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_underweight_causes);

        expandabledescripView = findViewById(R.id.expandableListView_under);

        // Create data for the ExpandableListView
        String[] groupHeaders = {"Anxiety", "Coeliac disease", "Irritable bowel syndrome", "Overactive thyroid", "Type 2 diabetes"};
        String[][] childItems = {
                {"• Feeling restless or on edge\n"+
                        "• Being irritable\n"+
                        "• Getting tired easily\n"+
                        "• Having difficulty concentrating\n"+
                        "• Having trouble getting to sleep or staying asleep\n"+
                        "• Having tense muscles"},
                {"• Bloating and flatulence\n"+
                        "• Diarrhoea or constipation\n"+
                        "• Fatigue, weakness & lethargy\n"+
                        "• Nausea & vomiting\n"+
                        "• Stomach cramps"},
                {"• Abdominal pain and cramping\n"+
                        "• Diarrhoea, constipation or both\n"+
                        "• Swelling of your stomach\n"+
                        "• Flatulence"},
                {"• Nervousness and irritability\n"+
                        "• Mood swings\n"+
                        "• Difficulty sleeping\n"+
                        "• Persistent tiredness & weakness\n"+
                        "• Sensitivity to heat\n"+
                        "• Swelling in your neck and/or palpitations"},
                {"• Weeing a lot, especially at night\n"+
                        "• Being really thirsty\n"+
                        "• Feeling more tired than usual\n"+
                        "• Genital itching or thrush\n"+
                        "• Cuts & wounds taking longer to heal\n"+
                        "• Blurred eyesight"}
        };

        // Create the adapter
        adapter = new ExpandableDescriptionAdapter(this, groupHeaders, childItems);
        expandabledescripView.setAdapter(adapter);

        // Set the listener for the ExpandableListView
        expandabledescripView.setOnGroupExpandListener(new ExpandableListView.OnGroupExpandListener() {
            @Override
            public void onGroupExpand(int groupPosition) {
                // Handle group expansion
            }
        });

        expandabledescripView.setOnGroupCollapseListener(new ExpandableListView.OnGroupCollapseListener() {
            @Override
            public void onGroupCollapse(int groupPosition) {
                // Handle group collapse
            }
        });
    }
}