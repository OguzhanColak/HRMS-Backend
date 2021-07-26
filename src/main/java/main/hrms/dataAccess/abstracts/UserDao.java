package main.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import main.hrms.entities.concretes.User;

public interface UserDao extends JpaRepository<User,Integer>{

	
}
