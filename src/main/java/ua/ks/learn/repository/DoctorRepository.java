package ua.ks.learn.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ua.ks.learn.model.Doctor;


@Repository("doctorRepository")
public interface DoctorRepository extends JpaRepository<Doctor, Long> {

}
