package main.hrms.business.concretes;


import main.hrms.dataAccess.abstracts.CvDao;
import main.hrms.dataAccess.abstracts.CvImgDao;
import main.hrms.dataAccess.abstracts.JobSeekerDao;
import main.hrms.entities.concretes.Cv;
import main.hrms.entities.concretes.CvImg;
import main.hrms.entities.concretes.JobSeeker;
import main.hrms.business.abstracts.CvService;
import main.hrms.core.utilities.results.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CvManager implements CvService {

    private CvDao cvDao;
    private JobSeekerDao jobSeekerDao;
    private CvImgDao cvImgDao;

    @Autowired
    public CvManager(CvDao cvDao, JobSeekerDao jobSeekerDao, CvImgDao cvImgDao) {
        this.cvDao = cvDao;
        this.jobSeekerDao = jobSeekerDao;
        this.cvImgDao = cvImgDao;
    }

    @Override
    public Result add(int employeeId) {
        Cv cv=new Cv();
        cv.setJobSeeker(this.jobSeekerDao.getById(employeeId));

        this.cvDao.save(cv);
        CvImg cvImg =new CvImg();
        cvImg.setCv(cv);
        cvImg.setImageUrl("https://t4.ftcdn.net/jpg/00/64/67/63/360_F_64676383_LdbmhiNM6Ypzb3FM4PPuFP9rHe7ri8Ju.jpg");
        this.cvImgDao.save(cvImg);
        return new SuccessResult("Kaydedildi");
    }

    @Override
    public Result addCv(Cv cv) {
        cvDao.save(cv);
        return new SuccessResult("CV başarıyla sisteme kaydedildi");
    }


    @Override
    public DataResult<List<Cv>> getAll() {
        return new SuccessDataResult<List<Cv>>(this.cvDao.findAll(),"Data listelendi");
    }

    @Override
    public DataResult<Cv> getByCvId(int cvId) {
        if(!this.cvDao.existsById(cvId)){
            return new ErrorDataResult<Cv>("Böyle bir cv yok");
        }
        return new SuccessDataResult<Cv>(this.cvDao.getById(cvId),"Data listelendi");
    }

    @Override
    public DataResult<Cv> getByEmployeeId(int employeeId) {
        if(this.cvDao.findByJobSeekerId(employeeId) == null){
            return new ErrorDataResult<Cv>("Böyle bir candidate yok");
        }
        return new SuccessDataResult<Cv>(this.cvDao.findByJobSeekerId(employeeId),"Data listelendi");
    }

    @Override
    public Result updateGithub(String githublink, int cvId) {

        if(!this.cvDao.existsById(cvId)){
            return new ErrorResult("Böyle bir cv yok");
        }else if(!githublink.startsWith("https://github.com")){
            if(!githublink.startsWith("github.com")){
                return new ErrorResult("Geçerli bir github linki değil");
            }
        }

        Cv cv=this.cvDao.getById(cvId);
        cv.setGithub(githublink);
        this.cvDao.save(cv);
        return new SuccessResult("Kaydedildi");
    }

    @Override
    public Result deleteGithub(int cvId) {
        if(!this.cvDao.existsById(cvId)){
            return new ErrorResult("Böyle bir cv yok");
        }
        Cv cv=this.cvDao.getById(cvId);
        cv.setGithub(null);
        this.cvDao.save(cv);

        return new SuccessResult("Github adresi kaldırıldı");
    }

    @Override
    public Result updateLinkedin(String linkedinlink, int cvId) {
        if(!this.cvDao.existsById(cvId)){
            return new ErrorResult("Böyle bir cv yok");
        }else if(!linkedinlink.startsWith("https://www.linkedin.com") &&
                !linkedinlink.startsWith("www.linkedin.com") &&
                !linkedinlink.startsWith("https://linkedin.com") &&
                !linkedinlink.startsWith("linkedin.com")){
            return new ErrorResult("Geçerli bir linked in adresi değil");
        }
        Cv cv=this.cvDao.getById(cvId);
        cv.setLinkedin(linkedinlink);
        this.cvDao.save(cv);
        return new SuccessResult("Kaydedildi");
    }

    @Override
    public Result deleteLinkedin(int cvId) {
        if(!this.cvDao.existsById(cvId)){
            return new ErrorResult("Böyle bir cv yok");
        }
        Cv cv=this.cvDao.getById(cvId);
        cv.setLinkedin(null);
        this.cvDao.save(cv);
        return new SuccessResult("Linkedin adresi silindi");
    }

    @Override
    public Result updateBiography(String biography, int cvId) {
        if(!this.cvDao.existsById(cvId)){
            return new ErrorResult("Böyle bir cv yok");
        }else if(biography.length()<=2){
            return new ErrorResult("Biyografi 2 krakterden uzun olmalıdır");
        }
        Cv cv=this.cvDao.getById(cvId);
        cv.setBiography(biography);
        this.cvDao.save(cv);
        return new SuccessResult("Biyografi kaydedildi");
    }

    @Override
    public Result deleteBiography(int cvId) {
        if(!this.cvDao.existsById(cvId)){
            return new ErrorResult("Böyle bir cv yok");
        }
        Cv cv=this.cvDao.getById(cvId);
        cv.setBiography(null);
        this.cvDao.save(cv);
        return new SuccessResult("Biyografi silindi");
    }

}
