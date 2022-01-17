package com.example.diagnosereportbuilder;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class Initial_Diagnose extends AppCompatActivity {

    TextView patient_name, patient_no, patient_gender, basic, patient_age, vitals,patient_allergies, other_symptoms;
    ImageView submitted;
    Model model;
    Patient_Db patient_db;
    int id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_initial_diagnose);
        submitted = findViewById(R.id.submitted);
        patient_name = findViewById(R.id.patient_name);
        patient_no = findViewById(R.id.patient_no);
        patient_gender = findViewById(R.id.patient_gender);
        patient_age = findViewById(R.id.patient_age);

        basic = findViewById(R.id.basic);


        vitals = findViewById(R.id.vitals);
        patient_allergies=findViewById(R.id.patient_allergies);

        other_symptoms = findViewById(R.id.other);
        patient_db = Patient_Db.getInstance(this);


        model = (Model) getIntent().getSerializableExtra("data");

        if (getIntent().hasExtra("name")) {
            model = (Model) getIntent().getSerializableExtra("name");
            id = model.getId();
        }

        patient_name.setText(model.getP_name());
        patient_no.setText(model.getPhone());
        patient_gender.setText(model.getP_gender());
        patient_age.setText(model.getAge());

        basic.append(model.getBasic_symptoms());

        other_symptoms.setText(model.getOther_symptoms());

        vitals.append(model.getVital());
        patient_allergies.setText(model.getAllergies());
        submitted.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                save();
                submitted.setVisibility(View.GONE);
            }
        });

    }

    public void save() {

        String Pname = patient_name.getText().toString();
        String Pphone = patient_no.getText().toString();
        String Pgender = patient_gender.getText().toString();
        String Page = patient_age.getText().toString();
        String Pbasic = basic.getText().toString();
        String Pother = other_symptoms.getText().toString();
        String Pvital = vitals.getText().toString();
        String Palargi = patient_allergies.getText().toString();

        model = new Model(Pname, Pphone, Pgender, Page, Pbasic, Pother, Pvital, Palargi);

        if (getIntent().hasExtra("name")) {
            model.setId(id);
            patient_db.patient_dao().Update(model);
        } else {
            patient_db.patient_dao().insertdata(model);
        }
//        SharedPreferences Start

//        SharedPreferences sharedPreferences=getSharedPreferences("Patient",MODE_PRIVATE);
//        SharedPreferences.Editor editor=sharedPreferences.edit();
//        editor.putString("name",model.getP_name());
//        editor.putString("Phone",model.getPhone());
//        editor.putString("Gender",model.getP_gender());
//        editor.putString("Age",model.getAge());
//        editor.putString("Basic Symptoms",model.getBasic_symptoms());
//        editor.putString("Other Symptoms",model.getOther_symptoms());
//        editor.putString("Vitals",model.getVital());
//        editor.apply();

//        SharedPreferences End

        Toast.makeText(Initial_Diagnose.this, "Patient Record Save", Toast.LENGTH_SHORT).show();


    }

    public void Edit(View view) {


        Intent intent = new Intent(Initial_Diagnose.this, MainActivity.class);
        intent.putExtra("FirstData", model);
        startActivity(intent);

    }


    public void new_record(View view) {
        Intent intent = new Intent(Initial_Diagnose.this, MainActivity.class);
        startActivity(intent);
        finish();
    }
}