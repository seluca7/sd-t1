package com.example.springdemo.services;

import com.example.springdemo.dto.CaregiverDTO;
import com.example.springdemo.dto.builders.CaregiverBuilder;
import com.example.springdemo.entities.Caregiver;
import com.example.springdemo.repositories.CaregiverRepository;
import com.example.springdemo.repositories.DoctorRepository;
import com.example.springdemo.utilities.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CaregiverService {
    private final CaregiverRepository caregiverRepository;
    private final DoctorRepository doctorRepository;

    @Autowired
    public CaregiverService(CaregiverRepository caregiverRepository, DoctorRepository doctorRepository)
    {
        this.caregiverRepository = caregiverRepository;
        this.doctorRepository = doctorRepository;
    }

    public List<CaregiverDTO> getAll()
    {
        ArrayList<CaregiverDTO> caregiverDTOS = new ArrayList<CaregiverDTO>();
        for (Caregiver c: caregiverRepository.getAll()){
            caregiverDTOS.add(CaregiverBuilder.generateDTOFromCaregiver(c));
        }
        return caregiverDTOS;
    };

    public CaregiverDTO findCaregiverById(Integer id)
    {
        return CaregiverBuilder.generateDTOFromCaregiver(caregiverRepository.getCaregiverById(id));
    }

    public List<CaregiverDTO> findCaregiversByDoctor(Integer doctorId)
    {
        ArrayList<CaregiverDTO> caregiverDTOS = new ArrayList<CaregiverDTO>();
        for (Caregiver c : caregiverRepository.getCaregiversByIdDoctor(doctorId))
        {
            caregiverDTOS.add(CaregiverBuilder.generateDTOFromCaregiver(c));
        }
        return caregiverDTOS;
    }

    public void createCaregiver(CaregiverDTO caregiverDTO)
    {
        caregiverRepository.createCaregiver(caregiverDTO.getAddress(),
                DateUtils.stringToDate(caregiverDTO.getBirthDate()),
                caregiverDTO.getGender(),
                caregiverDTO.getName(),
                caregiverDTO.getIdDoctor(),
                caregiverDTO.getIdUser());
    }

    public Boolean deleteCaregiverById(Integer id)
    {
        if (this.findCaregiverById(id) == null){
            System.out.println("Caregiver with the specified id does not exist");
            return false;
        }
        else {
            caregiverRepository.deleteCaregiverById(id);
            return true;
        }
    }

    public Boolean editCaregiver(CaregiverDTO caregiverDTO)
    {
        if (this.findCaregiverById(caregiverDTO.getCaregiverId()) == null){
            System.out.println("Caregiver with the specified id does not exist");
            return false;
        }
        else {
            caregiverRepository.updateCaregiver(caregiverDTO.getCaregiverId(),
                    caregiverDTO.getAddress(),
                    DateUtils.stringToDate(caregiverDTO.getBirthDate()),
                    caregiverDTO.getGender(),
                    caregiverDTO.getName(),
                    doctorRepository.getDoctorById(caregiverDTO.getIdDoctor())
            );
            return true;
        }
    }

}
