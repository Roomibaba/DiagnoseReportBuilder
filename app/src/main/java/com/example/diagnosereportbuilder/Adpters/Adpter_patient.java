package com.example.diagnosereportbuilder.Adpters;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.diagnosereportbuilder.MainActivity;
import com.example.diagnosereportbuilder.Model;
import com.example.diagnosereportbuilder.Patient_Db;
import com.example.diagnosereportbuilder.Patient_Detail;
import com.example.diagnosereportbuilder.R;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Adpter_patient extends RecyclerView.Adapter<Adpter_patient.ViewHolder> {
    List<Model> models;
    Activity context;
    Patient_Db patient_db;

    public Adpter_patient(List<Model> models, Activity context) {
        this.models = models;
        this.context = context;
        patient_db = Patient_Db.getInstance(context);
    }

    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.patient_list_sample, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Adpter_patient.ViewHolder holder, @SuppressLint("RecyclerView") int position) {

        holder.P_name.setText(models.get(position).getP_name());
        holder.P_number.setText(models.get(position).getPhone());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, Patient_Detail.class);
                intent.putExtra("patient_detail", models.get(position));
                context.startActivity(intent);


            }
        });
//        holder.detail_name.setText(models.get(position).getP_name());
//        holder.detail_contact.setText(models.get(position).getPhone());
//        holder.detail_gender.setText(models.get(position).getP_gender());
//        holder.detail_age.setText(models.get(position).getAge());
//        holder.detail_basic_symptoms.setText(models.get(position).getBasic_symptoms());
//        holder.detail_other_symptoms.setText(models.get(position).getOther_symptoms());
//        holder.detail_vitals.setText(models.get(position).getVital());


//        holder.edit_btn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent = new Intent(context, MainActivity.class);
//
//                intent.putExtra("name", models.get(position));
////                intent.putExtra("phone", models.get(position).getPhone());
////                intent.putExtra("id", models.get(position).getId());
//                context.startActivity(intent);
//
//            }
//        });

//        holder.delete_btn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                model.setId(models.get(position).getId());
//                patient_db.patient_dao().deleteData(model);
//                models.remove(position);
//                notifyDataSetChanged();
//            }
//        });

    }

    @Override
    public int getItemCount() {
        return models.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        //        TextView detail_name, detail_contact, detail_gender, detail_age, detail_basic_symptoms, detail_other_symptoms, detail_vitals;
//        ImageView edit_btn, delete_btn;
        TextView P_name, P_number;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            P_name = itemView.findViewById(R.id.P_name);
            P_number = itemView.findViewById(R.id.number);

//            detail_name = itemView.findViewById(R.id.detail_name);
//            detail_contact = itemView.findViewById(R.id.detail_phone);
//            detail_gender = itemView.findViewById(R.id.detail_gender);
//            detail_age = itemView.findViewById(R.id.detail_age);
//            detail_basic_symptoms = itemView.findViewById(R.id.detail_basic);
//            detail_other_symptoms = itemView.findViewById(R.id.detail_other);
//            detail_vitals = itemView.findViewById(R.id.detail_vitals);
//            edit_btn = itemView.findViewById(R.id.detail_edit);
//            delete_btn = itemView.findViewById(R.id.detail_delet);

        }
    }

}
