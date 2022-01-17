package com.example.diagnosereportbuilder;

import android.content.Intent;
import android.os.Bundle;
import android.view.Display;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.diagnosereportbuilder.Adpters.Adpter_patient;

import java.util.List;

public class Patient_Detail extends AppCompatActivity {
    TextView detail_name, detail_contact, detail_gender, detail_age,
            detail_basic_symptoms, detail_other_symptoms, detail_vitals, detail_allergies;
    ImageView edit_btn, delete_btn;
    Model model;
    Patient_Db patientdb;
    int position;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_patient_detail);

        detail_name = findViewById(R.id.detail_name);
        detail_contact = findViewById(R.id.detail_phone);
        detail_gender = findViewById(R.id.detail_gender);
        detail_age = findViewById(R.id.detail_age);
        detail_basic_symptoms = findViewById(R.id.detail_basic);
        detail_other_symptoms = findViewById(R.id.detail_other);
        detail_vitals = findViewById(R.id.detail_vitals);
        edit_btn = findViewById(R.id.detail_edit);
        delete_btn = findViewById(R.id.detail_delet);
        detail_vitals = findViewById(R.id.detail_vitals);
        detail_allergies = findViewById(R.id.detail_allergies);
        patientdb=Patient_Db.getInstance(this);


        model = (Model) getIntent().getSerializableExtra("patient_detail");
        if (getIntent().hasExtra("patient_detail")) {
            detail_name.setText(model.getP_name());
            detail_contact.setText(model.getPhone());
            detail_gender.setText(model.getP_gender());
            detail_age.setText(model.getAge());
            detail_basic_symptoms.setText(model.getBasic_symptoms());
            detail_other_symptoms.setText(model.getOther_symptoms());
            detail_vitals.setText(model.getVital());
            detail_allergies.setText(model.getAllergies());
            position = model.getId();
            Toast.makeText(Patient_Detail.this, ""+position, Toast.LENGTH_SHORT).show();

        }
        edit_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Patient_Detail.this, MainActivity.class);

                intent.putExtra("name", model);
//                intent.putExtra("phone", models.get(position).getPhone());
//                intent.putExtra("id", models.get(position).getId());
                startActivity(intent);

            }
        });
        delete_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                model.setId(model.getId());
                patientdb.patient_dao().deleteData(model);



                Toast.makeText(Patient_Detail.this, "Record Delete", Toast.LENGTH_SHORT).show();

            }
        });

    }
}
