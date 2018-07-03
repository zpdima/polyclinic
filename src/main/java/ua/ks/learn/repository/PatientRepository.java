package ua.ks.learn.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ua.ks.learn.model.Doctor;
import ua.ks.learn.model.Patient;
import ua.ks.learn.model.Station;

@Repository("patientRepository")
public interface PatientRepository extends JpaRepository<Patient, Long> {

}
