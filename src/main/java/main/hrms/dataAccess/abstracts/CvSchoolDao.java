package main.hrms.dataAccess.abstracts;

import main.hrms.entities.concretes.CvSchool;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CvSchoolDao extends JpaRepository<CvSchool,Integer> {
    List<CvSchool> findByCvId(int id);
}