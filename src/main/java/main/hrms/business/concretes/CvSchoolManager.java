package main.hrms.business.concretes;

import main.hrms.dataAccess.abstracts.CvDao;
import main.hrms.dataAccess.abstracts.CvSchoolDao;
import main.hrms.entities.concretes.CvSchool;
import main.hrms.business.abstracts.CvSchoolService;
import main.hrms.core.utilities.results.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CvSchoolManager implements CvSchoolService {

    private CvSchoolDao cvSchoolDao;

    @Autowired
    public CvSchoolManager(CvSchoolDao cvSchoolDao) {
        this.cvSchoolDao = cvSchoolDao;
    }

    @Override
    public Result addSchool(CvSchool cvSchool) {

        cvSchoolDao.save(cvSchool);
        return new SuccessResult("Okul eklendi");
    }

    @Override
    public Result deleteSchool(int schoolId) {
        if(!this.cvSchoolDao.existsById(schoolId)){
            return new ErrorResult("Böyle bir okul yok");
        }
        this.cvSchoolDao.deleteById(schoolId);
        return new SuccessResult("Okul silindi");
    }

    @Override
    public DataResult<List<CvSchool>> getByCvId(int cvId) {
        if(this.cvSchoolDao.findByCvId(cvId)==null){
            return new ErrorDataResult<List<CvSchool>>("Böyle bir cv yok");
        }
        return new SuccessDataResult<List<CvSchool>>(this.cvSchoolDao.findByCvId(cvId),"Data listelendi");
    }
}
