package main.hrms.dataAccess.abstracts;

import main.hrms.entities.concretes.CvPrgSkills;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CvPrgSkillsDao extends JpaRepository<CvPrgSkills,Integer> {
    List<CvPrgSkills> findByCvId(int id);
}