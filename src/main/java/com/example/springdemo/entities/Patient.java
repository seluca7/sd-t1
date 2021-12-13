package com.example.springdemo.entities;

import javax.persistence.*;
import java.util.Date;

import static javax.persistence.GenerationType.IDENTITY;

@Entity
@Table(name = "patient")
public class Patient {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "patient_id", unique = true, nullable = false)
    private Integer patient_id;

    @ManyToOne
    @JoinColumn(name = "id_caregiver")
    private Caregiver caregiver;

    @ManyToOne
    @JoinColumn(name = "id_user")
    private User user;

    @Column(name = "name", length = 200)
    private String name;

    @Column(name = "birthDate")
    private Date birthDate;

    @Column(name = "gender")
    private String gender;

    @Column(name = "medicalRecord")
    private String medicalRecord;

    public Patient()
    {

    }

    public Patient(Integer patient_id,Caregiver caregiver,User user, String name, Date birthDate, String gender, String medicalRecord)
    {
        this.patient_id = patient_id;
        this.caregiver = caregiver;
        this.user = user;
        this.name = name;
        this.birthDate = birthDate;
        this.gender = gender;
        this.medicalRecord = medicalRecord;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Integer getPatient_id() {
        return patient_id;
    }

    public void setPatient_id(Integer patient_id) {
        this.patient_id = patient_id;
    }

    public Caregiver getCaregiver() {
        return caregiver;
    }

    public void setCaregiver(Caregiver caregiver) {
        this.caregiver = caregiver;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
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
