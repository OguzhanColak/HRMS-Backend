package main.hrms.business.concretes;

import main.hrms.dataAccess.abstracts.CvDao;
import main.hrms.dataAccess.abstracts.CvPrgSkillsDao;
import main.hrms.entities.concretes.CvPrgSkills;
import main.hrms.business.abstracts.CvPrgSkillsService;
import main.hrms.core.utilities.results.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CvPrgSkillsManager implements CvPrgSkillsService {

    private CvPrgSkillsDao cvPrgSkillsDao;
    private CvDao cvDao;

    @Autowired
    public CvPrgSkillsManager(CvPrgSkillsDao cvPrgSkillsDao, CvDao cvDao) {
        this.cvPrgSkillsDao = cvPrgSkillsDao;
        this.cvDao = cvDao;
    }

    @Override
    public Result addSkill(CvPrgSkills cvPrgSkills) {

        cvPrgSkillsDao.save(cvPrgSkills);
        return new SuccessResult("Kaydedildi");
    }

    @Override
    public Result removeSkill(int skillId) {
        if(!this.cvPrgSkillsDao.existsById(skillId)){
            return new ErrorResult("Belə bir Cv mövcud deyildir!");
        }
        this.cvPrgSkillsDao.deleteById(skillId);
        return new SuccessResult("Silindi");
    }

    @Override
    public DataResult<List<CvPrgSkills>> getByCvId(int cvId) {
        if(!this.cvDao.existsById(cvId)){
            return new ErrorDataResult<List<CvPrgSkills>>("Belə bir Cv mövcud deyildir!");
        }

        return new SuccessDataResult<List<CvPrgSkills>>(this.cvPrgSkillsDao.findByCvId(cvId),"Data listelendi");
    }
}
