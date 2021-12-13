package com.example.springdemo.dto;

import com.example.springdemo.entities.Patient;

import java.util.Date;

public class MedicationDTO {
    private String medication_id;
    private String name;
    private String start;
    private String end;
    private String sideEffects;
    private String dosage;
    private String id_patient;

    public MedicationDTO(String medication_id, String name, String start, String end, String sideEffects, String dosage, String id_patient) {
        this.medication_id = medication_id;
        this.name = name;
        this.start = start;
        this.end = end;
        this.sideEffects = sideEffects;
        this.dosage = dosage;
        this.id_patient = id_patient;
    }

    public String getMedication_id() {
        return medication_id;
    }

    public void setMedication_id(String medication_id) {
        this.medication_id = medication_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStart() {
        return start;
    }

    public void setStart(String start) {
        this.start = start;
    }

    public String getEnd() {
        return end;
    }

    public void setEnd(String end) {
        this.end = end;
    }

    public String getSideEffects() {
        return sideEffects;
    }

    public void setSideEffects(String sideEffects) {
        this.sideEffects = sideEffects;
    }

    public String getDosage() {
        return dosage;
    }

    public void setDosage(String dosage) {
        this.dosage = dosage;
    }

    public String getId_patient() {
        return id_patient;
    }

    public void setId_patient(String id_patient) {
        this.id_patient = id_patient;
    }
}
