package com.example.springdemo.repositories;

import com.example.springdemo.entities.Medication;
import com.example.springdemo.entities.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

public interface MedicationRepository extends JpaRepository<Medication, Integer> {

    @Query(value = "select u from Medication u")
    List<Medication> getAll();

    @Query(value = "select u from Medication u where u.medication_id = ?1")
    Medication getMedicationById(Integer id);

    @Query(value = "select u from Medication u where u.patient = ?1")
    List<Medication> getMedicationByPatientId(Patient patient);

    @Transactional
    @Modifying
    @Query(value = "delete from Medication u where u.medication_id = ?1")
    void deleteMedicationById(Integer medicationId);

    @Transactional
    @Modifying
    @Query(value = "update Medication u set u.name = ?2, u.start = ?3, u.end = ?4, u.sideEffects=?5, u.dosage = ?6, u.patient = ?7 where u.medication_id = ?1")
    void updateMedication(Integer medication_id,
                          String name, Date start,
                          Date end, String sideEffects,
                          Integer dosage,
                          Patient patient);

    @Transactional
    @Modifying
    @Query(value = "insert into Medication(medication_id,name,start_date,end_date,side_effects,dosage,id_patient) " +
            "values (null, :name,:start,:end,:sideEffects,:dosage,:idPatient)", nativeQuery = true)
    void createMedication(@Param("name") String name,
                          @Param("start") Date start,
                          @Param("end") Date end,
                          @Param("sideEffects") String sideEffects,
                          @Param("dosage") Integer dosage,
                          @Param("idPatient") Patient patient);
}
