package com.example.springdemo.entities;


import javax.persistence.*;

import static javax.persistence.GenerationType.IDENTITY;

@Entity
@Table(name = "doctor")
public class Doctor {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "doctor_id", unique = true, nullable = false)
    private Integer doctor_id;

    @ManyToOne
    @JoinColumn(name = "id_user")
    private User user;

    @Column(name = "firstName", length = 100)
    private String firstName;

    @Column(name = "lastName", length = 100)
    private String lastName;

    public Doctor()
    {

    }

    public Doctor(Integer doctor_id,User user, String firstName, String lastName)
    {
        this.doctor_id = doctor_id;
        this.user = user;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public Integer getDoctor_id() {
        return doctor_id;
    }

    public void setDoctor_id(Integer doctor_id) {
        this.doctor_id = doctor_id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
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
