package com.example.springdemo.dto;

public class CaregiverDTO {

    private Integer caregiverId;
    private Integer idUser;
    private Integer idDoctor;
    private String name;
    private String birthDate;
    private String gender;
    private String address;

    public CaregiverDTO(Integer caregiverId, Integer idUser, Integer idDoctor, String name, String birthDate, String gender, String address) {
        this.caregiverId = caregiverId;
        this.idUser = idUser;
        this.idDoctor = idDoctor;
        this.name = name;
        this.birthDate = birthDate;
        this.gender = gender;
        this.address = address;
    }

    public Integer getCaregiverId() {
        return caregiverId;
    }

    public void setCaregiverId(Integer caregiverId) {
        this.caregiverId = caregiverId;
    }

    public Integer getIdUser() {
        return idUser;
    }

    public void setIdUser(Integer idUser) {
        this.idUser = idUser;
    }

    public Integer getIdDoctor() {
        return idDoctor;
    }

    public void setIdDoctor(Integer idDoctor) {
        this.idDoctor = idDoctor;
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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
