package main.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import main.hrms.entities.concretes.JobPosition;


public interface JobPositionDao extends JpaRepository<JobPosition, Integer>{
	
}
