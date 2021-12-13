package com.example.springdemo.entities;

import com.example.springdemo.utilities.Gender;
import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
import java.util.Date;

import static javax.persistence.GenerationType.IDENTITY;

@Entity
@Table(name = "caregiver")
public class Caregiver {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "caregiver_id", unique = true, nullable = false)
    private Integer caregiver_id;

    @ManyToOne
    @JoinColumn(name = "id_user")
    private User user;

    @ManyToOne
    @JoinColumn(name = "id_doctor")
    private Doctor doctor;

    @Column(name = "name", length = 100)
    private String name;

    @Column(name = "birthDate")
    @JsonFormat(shape= JsonFormat.Shape.STRING, pattern="dd-MM-yyyy")
    private Date birthDate;

    @Column(name = "gender")
    private String gender;

    @Column(name = "address", length = 200)
    private String address;

    public Caregiver(){

    }

    public Caregiver(Integer caregiver_id,User user, Doctor doctor, String name, Date birthDate, String gender, String address) {
        this.caregiver_id = caregiver_id;
        this.user = user;
        this.doctor = doctor;
        this.name = name;
        this.birthDate = birthDate;
        this.gender = gender;
        this.address = address;
    }

    public Integer getCaregiver_id() {
        return caregiver_id;
    }

    public void setCaregiver_id(Integer caregiver_id) {
        this.caregiver_id = caregiver_id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Doctor getDoctor() {
        return doctor;
    }

    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
