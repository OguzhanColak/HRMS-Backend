package main.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import main.hrms.business.abstracts.JobPositionService;
import main.hrms.core.utilities.results.DataResult;
import main.hrms.core.utilities.results.Result;
import main.hrms.core.utilities.results.SuccessDataResult;
import main.hrms.core.utilities.results.SuccessResult;
import main.hrms.dataAccess.abstracts.JobPositionDao;
import main.hrms.entities.concretes.Employer;
import main.hrms.entities.concretes.JobPosition;

@Service
public class JobPositionManager implements JobPositionService {
	
	JobPositionDao jobPositionDao;
	
	@Autowired
	public JobPositionManager(JobPositionDao jobPositionDao) {
		this.jobPositionDao = jobPositionDao;
	}

	@Override
	public DataResult<List<JobPosition>> getAll() {

		return new SuccessDataResult<List<JobPosition>>(jobPositionDao.findAll());
	}
	
	@Override
	public Result add(JobPosition job) {
		
		jobPositionDao.save(job);
		return new SuccessResult("job added");
	}
}