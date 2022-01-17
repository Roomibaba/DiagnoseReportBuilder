package com.example.diagnosereportbuilder;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

public class Vitals extends AppCompatActivity {
    CheckBox blood_P, diabetes;
    EditText allergies;
    Model model;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vitals);
        blood_P = findViewById(R.id.blood_P);
        diabetes = findViewById(R.id.diabetes);
        allergies = findViewById(R.id.allergies);

        model = (Model) getIntent().getSerializableExtra("data");
        if (getIntent().hasExtra("name")) {
            model = (Model) getIntent().getSerializableExtra("name");
            allergies.setText(model.getAllergies());
            if (model.getVital().contains("High Blood Pressure" + "\n")) {
                blood_P.setChecked(true);
            }
            if (model.getVital().contains("Diabetes" + "\n")) {
                diabetes.setChecked(true);
            }

        }

        if (getIntent().hasExtra("vital")) {
            model = (Model) getIntent().getSerializableExtra("vital");
            allergies.setText(model.getAllergies());

            if (model.getVital().contains("High Blood Pressure" + "\n")) {
                blood_P.setChecked(true);
            }
            if (model.getVital().contains("Diabetes" + "\n")) {
                diabetes.setChecked(true);
            }

        }
    }

    public void submit(View view) {
        StringBuilder vital = new StringBuilder();
        if (blood_P.isChecked()) {
            vital.append("High Blood Pressure" + "\n");

        }
        if (diabetes.isChecked()) {
            vital.append("Diabetes" + "\n");
        }
        model.setVital(String.valueOf(vital));

        model.setAllergies(allergies.getText().toString());

        if (model.getVital().isEmpty()) {
            Toast.makeText(Vitals.this, "Select Any Box ", Toast.LENGTH_SHORT).show();
        } else if (model.getAllergies().isEmpty()) {
            Toast.makeText(Vitals.this, "Fill Allergies Filed ", Toast.LENGTH_SHORT).show();
        } else {
            if (getIntent().hasExtra("name")) {
                Intent intent = (new Intent(Vitals.this, Initial_Diagnose.class));
                intent.putExtra("data", model);
                intent.putExtra("name", model);
                startActivity(intent);
            } else {

                Intent intent = (new Intent(Vitals.this, Initial_Diagnose.class));
                intent.putExtra("data", model);
                startActivity(intent);
            }
        }
    }

    public void symptomps(View view) {
        onBackPressed();
    }
}