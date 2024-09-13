package com.saywhat.bmi;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ExpandableListView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class Overweight_causes extends AppCompatActivity {

    private ExpandableListView expandableListView;
    private ExpandableListAdapter adapter;
    TextView results;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_overweight_causes);

        expandableListView = findViewById(R.id.expandableListView_over);

        // Create data for the ExpandableListView
        String[] groupHeaders = {"Diabetes", "Cortisone", "Antihistamine", "Antidepressants", "Hormonal contraceptives", "Medications to treat convulsions"};
        String[][] childItems = {
                {"Insulin"},
                {"Betamethasone", "Prednisone", "Prednisolone"},
                {"Cetirizine","Fexofenadine", "Desloratadine"},
                {"Paroxetine", "Mirtazapine", "Amitriptyline"},
                {"Loestrin", "Tri-mili", "Jasmiel", "Safyral"},
                {"Gabapentin", "Carbamazepine", "Valproate"}
        };

        // Create the adapter
        adapter = new ExpandableListAdapter(this, groupHeaders, childItems);
        expandableListView.setAdapter(adapter);

        // Set the listener for the ExpandableListView
        expandableListView.setOnGroupExpandListener(new ExpandableListView.OnGroupExpandListener() {
            @Override
            public void onGroupExpand(int groupPosition) {
                // Handle group expansion
            }
        });

        expandableListView.setOnGroupCollapseListener(new ExpandableListView.OnGroupCollapseListener() {
            @Override
            public void onGroupCollapse(int groupPosition) {
                // Handle group collapse
            }
        });

        results = findViewById(R.id.overweight_lead_to);
        results.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Overweight_causes.this , Underweight_causes.class);
                startActivity(intent);
            }
        });

    }
}