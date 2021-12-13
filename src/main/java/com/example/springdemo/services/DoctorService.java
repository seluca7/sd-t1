package com.example.springdemo.services;

import com.example.springdemo.dto.DoctorDTO;
import com.example.springdemo.dto.builders.DoctorBuilder;
import com.example.springdemo.entities.Doctor;
import com.example.springdemo.repositories.DoctorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DoctorService {
    private final DoctorRepository doctorRepository;

    @Autowired
    public DoctorService(DoctorRepository doctorRepository)
    {
        this.doctorRepository = doctorRepository;
    }

    public List<DoctorDTO> getAll()
    {
        ArrayList<DoctorDTO> doctorDTOS = new ArrayList<DoctorDTO>();
        for (Doctor d: doctorRepository.getAll()){
            doctorDTOS.add(DoctorBuilder.generateDTOFromDoctor(d));
        }
        return doctorDTOS;
    };

    public DoctorDTO findDoctorById(Integer id)
    {
        return DoctorBuilder.generateDTOFromDoctor(doctorRepository.getDoctorById(id));
    }

    public void createDoctor(DoctorDTO doctorDTO)
    {
        doctorRepository.createDoctor(doctorDTO.getFirstName(),
                doctorDTO.getLastName(),
                doctorDTO.getIdUser());
    }

    public Boolean deleteDoctorById(Integer id)
    {
        if (this.findDoctorById(id) == null){
            System.out.println("doctor with the specified id does not exist");
            return false;
        }
        else {
            doctorRepository.deleteDoctorById(id);
            return true;
        }
    }

    public Boolean editDoctor(DoctorDTO doctorDTO)
    {
        if (this.findDoctorById(doctorDTO.getDoctorId()) == null){
            System.out.println("doctor with the specified id does not exist");
            return false;
        }
        else {
            doctorRepository.updateDoctor(doctorDTO.getDoctorId(),
                    doctorDTO.getFirstName(),
                    doctorDTO.getLastName());
            return true;
        }
    }

}
