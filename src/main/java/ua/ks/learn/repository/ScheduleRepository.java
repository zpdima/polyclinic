package ua.ks.learn.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import ua.ks.learn.model.Schedule;


@Repository("scheduleRepository")
public interface ScheduleRepository extends JpaRepository<Schedule, Long> {

}
