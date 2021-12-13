package com.example.springdemo.controller;

import com.example.springdemo.dto.CaregiverDTO;
import com.example.springdemo.dto.IdDTO;
import com.example.springdemo.entities.Caregiver;
import com.example.springdemo.services.CaregiverService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping(value = "/caregiver")
public class CaregiverController {
    CaregiverService caregiverService;

    @Autowired
    public CaregiverController(CaregiverService caregiverService){
        this.caregiverService = caregiverService;
    }

    @GetMapping(path = "/all")
    public List<CaregiverDTO> getAll(){
        return caregiverService.getAll();
    }

    @GetMapping(value = "/{id}")
    public CaregiverDTO getCaregiverById(@PathVariable("id") Integer id){
        return caregiverService.findCaregiverById(id);
    }

    @PostMapping(path = "/getByDoctor")
    public List<CaregiverDTO> getAllByDoctorId(@RequestBody Integer doctorId){
        return caregiverService.findCaregiversByDoctor(doctorId);
    }

    @PostMapping(path = "/create")
    public void createCaregiver(@RequestBody CaregiverDTO caregiverDTO){
        caregiverService.createCaregiver(caregiverDTO);
    }

    @PostMapping(path = "/update")
    public Boolean updateCaregiver(@RequestBody CaregiverDTO caregiverDTO){
        return caregiverService.editCaregiver(caregiverDTO);
    }

    @PostMapping(path = "/delete")
    public Boolean deleteCaregiver(@RequestBody IdDTO idDTO){
        return caregiverService.deleteCaregiverById(idDTO.getId());
    }


}
