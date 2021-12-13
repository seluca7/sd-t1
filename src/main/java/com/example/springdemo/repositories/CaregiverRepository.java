package com.example.springdemo.repositories;

import com.example.springdemo.entities.Caregiver;
import com.example.springdemo.entities.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

public interface CaregiverRepository extends JpaRepository<Caregiver, Integer> {
    @Query(value = "select u from Caregiver u")
    List<Caregiver> getAll();

    @Query(value = "select u from Caregiver u where u.caregiver_id = ?1")
    Caregiver getCaregiverById(Integer id);

    @Query(value = "select u from Caregiver u where u.doctor = ?1")
    List<Caregiver> getCaregiversByIdDoctor(Integer idDoctor);

    @Transactional
    @Modifying
    @Query(value = "insert into Caregiver(caregiver_id, address, birth_date, gender, name, id_doctor, id_user)" +
            " values(null, :address, :birthDate, :gender, :name, :idDoctor, :idUser)",
            nativeQuery = true)
    void createCaregiver(@Param("address") String address,
                      @Param("birthDate") Date birthDate,
                      @Param("gender") String gender,
                      @Param("name")String name,
                      @Param("idDoctor")Integer idDoctor,
                      @Param("idUser")Integer idUser);

    @Transactional
    @Modifying
    @Query(value = "delete from Caregiver u where u.caregiver_id = ?1")
    void deleteCaregiverById(Integer id);

    @Transactional
    @Modifying
    @Query(value = "update Caregiver u SET u.address=?2, u.birthDate = ?3 , u.gender = ?4 , u.name = ?5, u.doctor = ?6 where u.caregiver_id = ?1")
    void updateCaregiver(Integer caregiverId, String address, Date birthDate, String gender, String name, Doctor doctor);
}
