package com.example.springdemo.dto;

import com.example.springdemo.entities.Caregiver;
import com.example.springdemo.utilities.Gender;

import java.util.Date;

public class PatientDTO {
    private String patient_id;
    private String id_caregiver;
    private String id_user;
    private String name;
    private String birthDate;
    private String gender;
    private String medicalRecord;

    public PatientDTO(String patient_id, String id_caregiver,String id_user, String name, String birthDate, String gender, String medicalRecord) {
        this.patient_id = patient_id;
        this.id_caregiver = id_caregiver;
        this.id_user = id_user;
        this.name = name;
        this.birthDate = birthDate;
        this.gender = gender;
        this.medicalRecord = medicalRecord;
    }

    public String getId_user() {
        return id_user;
    }

    public void setId_user(String id_user) {
        this.id_user = id_user;
    }

    public String getPatient_id() {
        return patient_id;
    }

    public void setPatient_id(String patient_id) {
        this.patient_id = patient_id;
    }

    public String getId_caregiver() {
        return id_caregiver;
    }

    public void setId_caregiver(String id_caregiver) {
        this.id_caregiver = id_caregiver;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getMedicalRecord() {
        return medicalRecord;
    }

    public void setMedicalRecord(String medicalRecord) {
        this.medicalRecord = medicalRecord;
    }
}
