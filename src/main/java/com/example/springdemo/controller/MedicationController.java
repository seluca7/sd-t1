package com.example.springdemo.controller;

import com.example.springdemo.dto.IdDTO;
import com.example.springdemo.dto.MedicationDTO;
import com.example.springdemo.services.MedicationService;
import org.jboss.logging.annotations.Pos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping(value = "/medication")
public class MedicationController {
    private final MedicationService medicationService;

    @Autowired
    public MedicationController(MedicationService medicationService){
        this.medicationService = medicationService;
    }

    @GetMapping(path = "/all")
    public List<MedicationDTO> getAll(){
        return medicationService.getAll();
    }

    @GetMapping(value = "/{id}")
    public MedicationDTO getById(@PathVariable Integer id){
        return medicationService.findById(id);
    }

    @PostMapping(path = "/plan")
    public List<MedicationDTO> getMedicationPlan(@RequestBody IdDTO idDTO){
        return medicationService.findByPatientId(idDTO.getId());
    }

    @PostMapping(path = "/create")
    public void createMedication(@RequestBody MedicationDTO medicationDTO){
        medicationService.create(medicationDTO);
    }

    @PostMapping(path = "/update")
    public Boolean updateMedication(@RequestBody MedicationDTO medicationDTO){
        return medicationService.update(medicationDTO);
    }

    @PostMapping(path = "/delete")
    public Boolean deleteMedication(@RequestBody IdDTO idDTO){
        return medicationService.deleteById(idDTO.getId());
    }
}
