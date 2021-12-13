package com.example.springdemo.controller;

import com.example.springdemo.dto.IdDTO;
import com.example.springdemo.dto.PatientDTO;
import com.example.springdemo.services.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping(value = "/patient")
public class PatientController {
    private PatientService patientService;

    @Autowired
    public PatientController(PatientService patientService){
        this.patientService = patientService;
    }

    @GetMapping(path = "/all")
    public List<PatientDTO> getAll(){
        return patientService.getAll();
    }

    @PostMapping(path = "/byCaregiver")
    public List<PatientDTO> getAllByCaregiverId(@RequestBody IdDTO idDTO){
        return patientService.findByCaregiverId(idDTO.getId());
    }

    @GetMapping(value = "/{id}")
    public PatientDTO getById(@PathVariable Integer id){
        return patientService.findById(id);
    }

    @PostMapping(value = "/update")
    public boolean update(@RequestBody PatientDTO patientDTO){
        return patientService.update(patientDTO);
    }

    @PostMapping(value = "/create")
    public void create(@RequestBody PatientDTO patientDTO){
        patientService.create(patientDTO);
    }

    @PostMapping(value = "/delete")
    public Boolean delete(@RequestBody IdDTO idDTO){
        return patientService.deleteById(idDTO.getId());
    }
}
