package com.example.diagnosereportbuilder;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Spinner age_list;

    EditText p_name, phone;
    RadioGroup sex;
    RadioButton maleRB, femaleRB;

    Model model = new Model();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        sex = findViewById(R.id.p_gender);
        p_name = findViewById(R.id.name);
        phone = findViewById(R.id.contact);
        maleRB = findViewById(R.id.male);
        femaleRB = findViewById(R.id.female);


        age_list = findViewById(R.id.age_list);

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.agelist,
                android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);
        age_list.setAdapter(adapter);

        if (getIntent().hasExtra("name")) {
            model = (Model) getIntent().getSerializableExtra("name");
            p_name.setText(model.getP_name());
            phone.setText(model.getPhone());
            if (model.getP_gender().equals("Male")) {
                maleRB.setChecked(true);
            } else if (model.getP_gender().equals("Female")) {
                femaleRB.setChecked(true);
            }
            String compareValue = model.getAge();
            int spinnerPosition = adapter.getPosition(compareValue);
            age_list.setSelection(spinnerPosition);

        }

//       Get Data Before Save

        if (getIntent().hasExtra("FirstData")) {
            model = (Model) getIntent().getSerializableExtra("FirstData");

            p_name.setText(model.getP_name());
            phone.setText(model.getPhone());

            if (model.getP_gender().equals("Male")) {
                maleRB.setChecked(true);
            } else if (model.getP_gender().equals("Female")) {
                femaleRB.setChecked(true);
            }
            String compareValue = model.getAge();
            int spinnerPosition = adapter.getPosition(compareValue);
            age_list.setSelection(spinnerPosition);


        }
//       Get Data Before Save

    }

    public void next(View view) {

        send();
    }


    private void send() {
        StringBuilder output = new StringBuilder();

        int sex_id = sex.getCheckedRadioButtonId();
        if (sex_id == R.id.male) {
            output.append("Male");
        } else if (sex_id == R.id.female) {
            output.append("Female");
        }


        model.setAge(age_list.getSelectedItem().toString());
        model.setPhone((phone.getText().toString()));
        model.setP_name(p_name.getText().toString());
        model.setP_gender(String.valueOf(output));

        if (model.getP_name().isEmpty()) {
            Toast.makeText(MainActivity.this, "Enter Patient Name", Toast.LENGTH_SHORT).show();
            p_name.setError("Enter Patient Name");
        } else if (model.getPhone().isEmpty()) {
            Toast.makeText(MainActivity.this, "Enter Contact No", Toast.LENGTH_SHORT).show();
        } else if (model.getP_gender().isEmpty()) {
            Toast.makeText(MainActivity.this, "Select Gender", Toast.LENGTH_SHORT).show();
        } else {

            if (getIntent().hasExtra("name")) {
                Intent intent = new Intent(MainActivity.this, Symptoms.class);
                intent.putExtra("data", model);
                intent.putExtra("symptoms", model);
                intent.putExtra("name", model);
                startActivity(intent);
            } else if (getIntent().hasExtra("FirstData")) {
                Intent intent = new Intent(MainActivity.this, Symptoms.class);
                intent.putExtra("data", model);
                intent.putExtra("symptoms", model);
                startActivity(intent);
            } else {
                Intent intent = new Intent(MainActivity.this, Symptoms.class);
                intent.putExtra("data", model);
                startActivity(intent);
            }
        }

    }


    public void View(View view) {
        startActivity(new Intent(MainActivity.this, Show_Patient_List.class));
    }
}
