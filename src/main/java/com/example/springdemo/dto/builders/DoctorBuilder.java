package com.example.springdemo.dto.builders;

import com.example.springdemo.dto.DoctorDTO;
import com.example.springdemo.entities.Doctor;

public class DoctorBuilder {
    public static DoctorDTO generateDTOFromDoctor(Doctor doctor){
        return new DoctorDTO(doctor.getDoctor_id(),
                doctor.getUser().getUser_id(),
                doctor.getFirstName(),
                doctor.getLastName());
    }

    /*public static Doctor generateDoctorFromDTO(DoctorDTO doctorDTO){
        return new Doctor(doctorDTO.getDoctor_id(),
                doctorDTO.getId_user(),
                doctorDTO.getFirstName(),
                doctorDTO.getLastName());
    }*/
}
