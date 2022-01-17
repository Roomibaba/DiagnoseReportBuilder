package com.example.diagnosereportbuilder;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.diagnosereportbuilder.Adpters.Adpter_patient;

import java.util.ArrayList;
import java.util.List;

public class Show_Patient_List extends AppCompatActivity {
    RecyclerView recyclerView;
    Adpter_patient adpterPatient;
    Patient_Db patientDb;
    List<Model> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_patient_list);
        recyclerView=findViewById(R.id.review);
        patientDb = Patient_Db.getInstance(this);
        list = patientDb.patient_dao().getAllData();

        adpterPatient = new Adpter_patient( list, this);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adpterPatient);
        adpterPatient.notifyDataSetChanged();




    }
}