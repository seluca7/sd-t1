package com.example.springdemo.entities;

import javax.persistence.*;
import java.util.Date;

import static javax.persistence.GenerationType.IDENTITY;

@Entity
@Table(name = "medication")
public class Medication {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "medication_id", unique = true, nullable = false)
    private Integer medication_id;

    @Column(name = "name", length = 100)
    private String name;

    @Column(name = "start_date")
    private Date start;

    @Column(name = "end_date")
    private Date end;

    @Column(name = "side_effects")
    private String sideEffects;

    @Column(name = "dosage")
    private Integer dosage;

    @ManyToOne
    @JoinColumn(name = "id_patient")
    private Patient patient;

    public Medication()
    {

    }

    public Medication(Integer medication_id,String name, Date start, Date end, String sideEffects, Integer dosage, Patient patient) {
        this.medication_id = medication_id;
        this.name = name;
        this.start = start;
        this.end = end;
        this.sideEffects = sideEffects;
        this.dosage = dosage;
        this.patient = patient;
    }

    public Integer getMedication_id() {
        return medication_id;
    }

    public void setMedication_id(Integer medication_id) {
        this.medication_id = medication_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getStart() {
        return start;
    }

    public void setStart(Date start) {
        this.start = start;
    }

    public Date getEnd() {
        return end;
    }

    public void setEnd(Date end) {
        this.end = end;
    }

    public String getSideEffects() {
        return sideEffects;
    }

    public void setSideEffects(String sideEffects) {
        this.sideEffects = sideEffects;
    }

    public Integer getDosage() {
        return dosage;
    }

    public void setDosage(Integer dosage) {
        this.dosage = dosage;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }
}
