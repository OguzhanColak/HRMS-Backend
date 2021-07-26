package main.hrms.business.concretes;

import java.util.List;

import main.hrms.business.abstracts.CvExperianceService;
import main.hrms.core.utilities.results.DataResult;
import main.hrms.core.utilities.results.Result;
import main.hrms.core.utilities.results.SuccessDataResult;
import main.hrms.core.utilities.results.SuccessResult;
import main.hrms.dataAccess.abstracts.CvExperianceDao;
import main.hrms.entities.concretes.CvExperiance;

public class CvExperianceManager implements CvExperianceService{

    private CvExperianceDao cvExperianceDao;

	public CvExperianceManager(CvExperianceDao cvExperianceDao) {
		super();
		this.cvExperianceDao = cvExperianceDao;
	}

	@Override
	public Result add(CvExperiance cvExperiance) {

		cvExperianceDao.save(cvExperiance);
		return new SuccessResult("İş deneyimi başarıyla kaydedildi");
	}

	@Override
	public Result delete(int experianceId) {

		cvExperianceDao.deleteById(experianceId);
        return new SuccessResult("İş deneyimi başarıyla silindi");
	}

	@Override
	public DataResult<List<CvExperiance>> getByCvId(int id) {

		return new SuccessDataResult<List<CvExperiance>>(this.cvExperianceDao.findByCvId(id),"Data listelendi");
	}

}
