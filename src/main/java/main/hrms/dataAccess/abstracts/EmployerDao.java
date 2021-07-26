package main.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import main.hrms.entities.concretes.Employer;

public interface EmployerDao extends JpaRepository<Employer, Integer>{

}
