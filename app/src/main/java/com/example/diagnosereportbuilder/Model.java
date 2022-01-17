package com.example.diagnosereportbuilder;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

import java.io.Serializable;

@Entity(tableName = "Patient_Detail")
public class Model implements Serializable {

    @PrimaryKey(autoGenerate = true)
    int id;

    @ColumnInfo(name = "p_name")
    String p_name;
    @ColumnInfo(name = "phone")
    String phone;
    @ColumnInfo(name = "p_gender")
    String p_gender;
    @ColumnInfo(name = "age")
    String age;
    @ColumnInfo(name = "basic_symptoms")
    String basic_symptoms;
    @ColumnInfo(name = "other_symptoms")
    String other_symptoms;
    @ColumnInfo(name = "vital")
    String vital;
    @ColumnInfo(name = "allergies")
    String allergies;

    public Model(String p_name, String phone, String p_gender, String age, String basic_symptoms, String other_symptoms, String vital, String allergies) {
        this.p_name = p_name;
        this.phone = phone;
        this.p_gender = p_gender;
        this.age = age;
        this.basic_symptoms = basic_symptoms;
        this.other_symptoms = other_symptoms;
        this.vital = vital;
        this.allergies = allergies;
    }


    public Model() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getP_name() {
        return p_name;
    }

    public void setP_name(String p_name) {
        this.p_name = p_name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getP_gender() {
        return p_gender;
    }

    public void setP_gender(String p_gender) {
        this.p_gender = p_gender;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getBasic_symptoms() {
        return basic_symptoms;
    }

    public void setBasic_symptoms(String basic_symptoms) {
        this.basic_symptoms = basic_symptoms;
    }

    public String getOther_symptoms() {
        return other_symptoms;
    }

    public void setOther_symptoms(String other_symptoms) {
        this.other_symptoms = other_symptoms;
    }

    public String getVital() {
        return vital;
    }

    public void setVital(String vital) {
        this.vital = vital;
    }

    public String getAllergies() {
        return allergies;
    }

    public void setAllergies(String allergies) {
        this.allergies = allergies;
    }
}
