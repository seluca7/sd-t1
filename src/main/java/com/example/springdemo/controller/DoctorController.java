package com.example.springdemo.controller;

import com.example.springdemo.dto.DoctorDTO;
import com.example.springdemo.dto.IdDTO;
import com.example.springdemo.services.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping(value = "/doctor")
public class DoctorController {
    private final DoctorService doctorService;

    @Autowired
    public DoctorController(DoctorService doctorService)
    {
        this.doctorService = doctorService;
    }

    @GetMapping(path = "/all")
    public List<DoctorDTO> getAll(){
        return doctorService.getAll();
    }

    @GetMapping(value = "/{id}")
    public DoctorDTO getDoctorById(@PathVariable("id") Integer id){
        return doctorService.findDoctorById(id);
    }

    @PostMapping(path = "/create")
    public void createDoctor(@RequestBody DoctorDTO doctorDTO){
        doctorService.createDoctor(doctorDTO);
    }

    @PostMapping(path = "/update")
    public Boolean editDoctor(@RequestBody DoctorDTO doctorDTO){
        return doctorService.editDoctor(doctorDTO);
    }

    @PostMapping(path = "/delete")
    public Boolean deleteDoctor(@RequestBody IdDTO idDTO){
        return doctorService.deleteDoctorById(idDTO.getId());
    }
}
