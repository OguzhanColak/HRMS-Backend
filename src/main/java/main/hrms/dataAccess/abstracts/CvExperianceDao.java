package main.hrms.dataAccess.abstracts;

import main.hrms.entities.concretes.CvExperiance;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CvExperianceDao extends JpaRepository<CvExperiance,Integer> {
    List<CvExperiance> findByCvId(int id);
}
