package com.example.springdemo.dto;

public class DoctorDTO {
    private Integer doctorId;
    private Integer idUser;
    private String firstName;
    private String lastName;

    public DoctorDTO(Integer doctorId, Integer idUser, String firstName, String lastName) {
        this.doctorId = doctorId;
        this.idUser = idUser;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public Integer getDoctorId() {
        return doctorId;
    }

    public void setDoctorId(Integer doctorId) {
        this.doctorId = doctorId;
    }

    public Integer getIdUser() {
        return idUser;
    }

    public void setIdUser(Integer idUser) {
        this.idUser = idUser;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}
