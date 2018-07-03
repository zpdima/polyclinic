package ua.ks.learn.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ua.ks.learn.model.Doctor;
import ua.ks.learn.model.Reception;


@Repository("receptionRepository")
public interface ReceptionRepository extends JpaRepository<Reception, Long> {
	
	List<Reception> findByDoctor(Doctor doctor);

}
