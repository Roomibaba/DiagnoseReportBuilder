package com.example.diagnosereportbuilder;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

public class Symptoms extends AppCompatActivity {
    Model model;
    CheckBox fever, headache, sourThorat, abdominalPain, fatigue;
    EditText other_symptoms;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_symptoms);
        fever = findViewById(R.id.fever);
        headache = findViewById(R.id.headache);
        sourThorat = findViewById(R.id.sourThirat);
        abdominalPain = findViewById(R.id.abdominalPain);
        fatigue = findViewById(R.id.fatigue);

        other_symptoms = findViewById(R.id.other_symptoms);

        model = (Model) getIntent().getSerializableExtra("data");

        if (getIntent().hasExtra("name")){
            model = (Model) getIntent().getSerializableExtra("name");
            if (model.getBasic_symptoms().contains("Fever" + "\n")) {
                fever.setChecked(true);
            }
            if (model.getBasic_symptoms().contains("Head Ache" + "\n")) {
                headache.setChecked(true);
            }
            if (model.getBasic_symptoms().contains("Sour Throat" + "\n")) {
                sourThorat.setChecked(true);
            }
            if (model.getBasic_symptoms().contains("Abdominal Pain" + "\n")) {
                abdominalPain.setChecked(true);
            }
            if (model.getBasic_symptoms().contains("Fatigue" + "\n")) {
                fatigue.setChecked(true);
            }
        }


        if (getIntent().hasExtra("symptoms")) {
            model = (Model) getIntent().getSerializableExtra("symptoms");
            other_symptoms.setText(model.getOther_symptoms());
            if (model.getBasic_symptoms().contains("Fever" + "\n")) {
                fever.setChecked(true);
            }
            if (model.getBasic_symptoms().contains("Head Ache" + "\n")) {
                headache.setChecked(true);
            }
            if (model.getBasic_symptoms().contains("Sour Throat" + "\n")) {
                sourThorat.setChecked(true);
            }
            if (model.getBasic_symptoms().contains("Abdominal Pain" + "\n")) {
                abdominalPain.setChecked(true);
            }
            if (model.getBasic_symptoms().contains("Fatigue" + "\n")) {
                fatigue.setChecked(true);
            }

        }


    }


    public void next(View view) {


        StringBuilder output = new StringBuilder();
        if (fever.isChecked()) {
            output.append("Fever" + "\n");
        }
        if (headache.isChecked()) {
            output.append("Head Ache" + "\n");
        }
        if (sourThorat.isChecked()) {
            output.append("Sour Throat" + "\n");
        }
        if (abdominalPain.isChecked()) {
            output.append("Abdominal Pain" + "\n");
        }
        if (fatigue.isChecked()) {
            output.append("Fatigue" + "\n");
        }

        model.setOther_symptoms(other_symptoms.getText().toString());
        model.setBasic_symptoms(String.valueOf(output));
        if (model.getBasic_symptoms().isEmpty()){
            Toast.makeText(Symptoms.this, "Please Select Any One", Toast.LENGTH_SHORT).show();
        }else if (model.getOther_symptoms().isEmpty()){
            Toast.makeText(Symptoms.this, "Please Enter Other Symptoms", Toast.LENGTH_SHORT).show();
        }else {

            if (getIntent().hasExtra("name")){
                Intent intent = new Intent(Symptoms.this, Vitals.class);
                intent.putExtra("data", model);
                intent.putExtra("vital", model);
                intent.putExtra("name",model);
                startActivity(intent);
            }

            else if (getIntent().hasExtra("symptoms")) {
                Intent intent = new Intent(Symptoms.this, Vitals.class);
                intent.putExtra("data", model);
                intent.putExtra("vital", model);
                startActivity(intent);
            } else {
                Intent intent = new Intent(Symptoms.this, Vitals.class);
                intent.putExtra("data", model);
                startActivity(intent);
            }

        }
    }

    public void previous(View view) {
        onBackPressed();
    }
}


//        if (fever.isChecked()){
//            p_fever=fever.getText().toString();
//            model.setP_fever(p_fever);
//        }if (headache.isChecked()){
//            p_headache=headache.getText().toString();
//            model.setP_head_ache(p_headache);
//        }if(sourThorat.isChecked()){
//
//            p_sourThorat=sourThorat.getText().toString();
//            model.setSour_throat(p_sourThorat);
//        }if (abdominalPain.isChecked()){
//            p_abdominalPain=abdominalPain.getText().toString();
//            model.setAbdominal_pain(p_abdominalPain);
//        }if (fatigue.isChecked()){
//            p_fatigue=fatigue.getText().toString();
//            model.setFatigue(p_fatigue);
//        }


//            switch (model.getBasic_symptoms()) {
//                case "Fever"+"\n":
//                    fever.setChecked(true);
//
//                    break;
//                case "Head Ache"+"\n":
//                    headache.setChecked(true);
//                    break;
//                case "Sour Throat"+"\n":
//                    sourThorat.setChecked(true);
//                    break;
//                case "Abdominal Pain"+"\n":
//                    abdominalPain.setChecked(true);
//                    break;
//                case "Fatigue"+"\n":
//                    fatigue.setChecked(true);
//                    break;
//            }