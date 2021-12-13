package com.example.springdemo.repositories;

import com.example.springdemo.entities.Caregiver;
import com.example.springdemo.entities.Patient;
import com.example.springdemo.entities.User;
import com.example.springdemo.utilities.Gender;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;


public interface PatientRepository extends JpaRepository<Patient, Integer> {
    @Query(value = "select u from Patient u")
    List<Patient> getAll();

    @Query(value = "select u from Patient u where u.caregiver = ?1")
    List<Patient> getAllByCaregiverId(Caregiver caregiver);

    @Query(value = "select u from Patient u where u.patient_id = ?1")
    Patient getPatientById(Integer patientId);

    @Transactional
    @Modifying
    @Query(value = "delete from Patient u where u.patient_id = ?1")
    void deletePatientById(Integer patientId);

    @Transactional
    @Modifying
    @Query(value = "insert into Patient(patient_id, id_caregiver,id_user, name, birth_date, gender, medical_record)" +
            "values(null, :idCaregiver,:idUser, :name, :birthDate, :gender, :medicalRecord)",
             nativeQuery = true)
    void createPatient(@Param("idCaregiver") Caregiver idCaregiver,
                       @Param("idUser") User user,
                       @Param("name") String name,
                       @Param("birthDate") Date birthDate,
                       @Param("gender") String gender,
                       @Param("medicalRecord") String medicalRecord);

    @Transactional
    @Modifying
    @Query(value = "update Patient u set u.caregiver = ?2,u.user = ?3, u.name = ?4, u.birthDate = ?5, u.gender = ?6, u.medicalRecord = ?7 where u.patient_id=?1")
    void updatePatient(Integer patientId,
                       Caregiver caregiver,
                       User user,
                       String name,
                       Date birthDate,
                       String gender,
                       String medicalRecord);
}
