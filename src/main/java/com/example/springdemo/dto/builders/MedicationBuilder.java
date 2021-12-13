package com.example.springdemo.dto.builders;

import com.example.springdemo.dto.MedicationDTO;
import com.example.springdemo.entities.Medication;
import com.example.springdemo.utilities.DateUtils;

public class MedicationBuilder {
    /*public static Medication generateMedicationFromDTO(MedicationDTO medicationDTO){
        return new Medication(medicationDTO.getMedication_id(),
                medicationDTO.getName(),
                medicationDTO.getStart(),
                medicationDTO.getEnd(),
                medicationDTO.getSideEffects(),
                medicationDTO.getDosage(),
                medicationDTO.getId_patient());
    }*/

    public static MedicationDTO generateDTOFromMedication(Medication medication){
        return new MedicationDTO(medication.getMedication_id().toString(),
                medication.getName(),
                DateUtils.dateToString(medication.getStart()),
                DateUtils.dateToString(medication.getEnd()),
                medication.getSideEffects(),
                medication.getDosage().toString(),
                medication.getPatient().getPatient_id().toString());
    }
}
