package com.example.springdemo.repositories;

import com.example.springdemo.entities.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import javax.print.Doc;
import java.util.List;

public interface DoctorRepository extends JpaRepository<Doctor, Integer> {

    @Query(value = "select u from Doctor u")
    List<Doctor> getAll();

    @Query(value = "select u from Doctor u where u.doctor_id = ?1")
    Doctor getDoctorById(Integer id);

    @Transactional
    @Modifying()
    @Query(value = "insert into Doctor(doctor_id, first_name, last_name, id_user) values(null, :firstName, :lastName, :userId)",
    nativeQuery = true)
    void createDoctor(@Param("firstName") String firstName,
                      @Param("lastName") String lastName,
                      @Param("userId") Integer userId);

    @Transactional
    @Modifying
    @Query(value = "delete from Doctor u where u.doctor_id = ?1")
    void deleteDoctorById(Integer id);

    @Transactional
    @Modifying
    @Query(value = "update Doctor u SET u.firstName=?2, u.lastName = ?3 where u.doctor_id = ?1")
    void updateDoctor(Integer doctorId, String firstName, String lastName);
}
