package main.hrms.dataAccess.abstracts;

import main.hrms.entities.concretes.Cv;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CvDao extends JpaRepository<Cv,Integer> {
    Cv findByJobSeekerId(int id);
}
