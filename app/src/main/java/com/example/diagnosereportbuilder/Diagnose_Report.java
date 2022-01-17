package com.example.diagnosereportbuilder;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class Diagnose_Report extends AppCompatActivity {

    TextView report_name, report_phone, report_gender, report_basic, report_age, report_vitals, report_other;
    Model model;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.diagnose_report);

        report_name = findViewById(R.id.report_name);
        report_phone = findViewById(R.id.report_phone);
        report_gender = findViewById(R.id.report_gender);
        report_age = findViewById(R.id.report_age);

        report_basic = findViewById(R.id.report_basic);

        report_vitals = findViewById(R.id.report_vitals);
        report_other = findViewById(R.id.report_other);


        SharedPreferences preferences = getSharedPreferences("Patient",MODE_PRIVATE);
        String Pname=preferences.getString("name","");
        String Pno=preferences.getString("Phone","");
        String Pgender=preferences.getString("Gender","");
        String Page=preferences.getString("Age","");
        String PBasicSym=preferences.getString("Basic Symptoms","");
        String POtherSym=preferences.getString("Other Symptoms","");
        String Pvital=preferences.getString("Vitals","");

        report_name.setText(Pname);
        report_phone.setText(Pno);
        report_gender.setText(Pgender);
        report_age.setText(Page);
        report_basic.setText(PBasicSym);
        report_other.setText(POtherSym);
        report_vitals.setText(Pvital);


    }

    public void new_patient(View view) {
        Intent intent = new Intent(Diagnose_Report.this, MainActivity.class);
        startActivity(intent);
        finish();
    }
}