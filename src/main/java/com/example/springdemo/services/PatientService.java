package com.example.springdemo.services;

import com.example.springdemo.dto.PatientDTO;
import com.example.springdemo.dto.builders.PatientBuilder;
import com.example.springdemo.entities.Patient;
import com.example.springdemo.repositories.CaregiverRepository;
import com.example.springdemo.repositories.PatientRepository;
import com.example.springdemo.repositories.UserRepository;
import com.example.springdemo.utilities.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PatientService {
    private final PatientRepository patientRepository;
    private final UserRepository userRepository;
    private final CaregiverRepository caregiverRepository;

    @Autowired
    public PatientService(PatientRepository patientRepository, UserRepository userRepository, CaregiverRepository caregiverRepository)
    {
        this.patientRepository = patientRepository;
        this.caregiverRepository = caregiverRepository;
        this.userRepository = userRepository;
    }

    public List<PatientDTO> getAll()
    {
        ArrayList<PatientDTO> patientDTOS = new ArrayList<PatientDTO>();
        for (Patient p:patientRepository.getAll()){
            patientDTOS.add(PatientBuilder.generateDTOFromPatient(p));
        }
        return patientDTOS;
    }

    public PatientDTO findById(Integer id)
    {
        return PatientBuilder.generateDTOFromPatient(patientRepository.getPatientById(id));
    }

    public List<PatientDTO> findByCaregiverId(Integer caregiverId)
    {
        ArrayList<PatientDTO> patientDTOS = new ArrayList<PatientDTO>() ;
        for (Patient p : patientRepository.getAllByCaregiverId(caregiverRepository.getCaregiverById(caregiverId))){
            patientDTOS.add(PatientBuilder.generateDTOFromPatient(p));
        }
        return patientDTOS;
    }

    public Boolean deleteById(Integer id)
    {
        if (this.findById(id) == null){
            System.out.println("patient with the specified id does not exist");
            return false;
        }
        else {
            patientRepository.deletePatientById(id);
            return true;
        }
    }

    public Boolean update(PatientDTO patientDTO)
    {
        if(this.findById(Integer.parseInt(patientDTO.getPatient_id())) == null){
            System.out.println("patient with the specified id does not exist");
            return false;
        }
        else {
            patientRepository.updatePatient(
                    Integer.parseInt(patientDTO.getPatient_id()),
                    caregiverRepository.getCaregiverById(Integer.parseInt(patientDTO.getId_caregiver())),
                    userRepository.getUserByUser_id(Integer.parseInt(patientDTO.getId_user())),
                    patientDTO.getName(),
                    DateUtils.stringToDate(patientDTO.getBirthDate()),
                    patientDTO.getGender(),
                    patientDTO.getMedicalRecord());
            return true;
        }
    }

    public void create(PatientDTO patientDTO)
    {
        patientRepository.createPatient(
                caregiverRepository.getCaregiverById(Integer.parseInt(patientDTO.getId_caregiver())),
                userRepository.getUserByUser_id(Integer.parseInt(patientDTO.getId_user())),
                patientDTO.getName(),
                DateUtils.stringToDate(patientDTO.getBirthDate()),
                patientDTO.getGender(),
                patientDTO.getMedicalRecord());
    }

}
