package main.hrms.business.concretes;

import java.util.List;

import org.springframework.stereotype.Service;

import main.hrms.business.abstracts.JobSeekerService;
import main.hrms.core.utilities.business.BusinessRules;
import main.hrms.core.utilities.results.DataResult;
import main.hrms.core.utilities.results.ErrorResult;
import main.hrms.core.utilities.results.Result;
import main.hrms.core.utilities.results.SuccessDataResult;
import main.hrms.core.utilities.results.SuccessResult;
import main.hrms.dataAccess.abstracts.JobSeekerDao;
import main.hrms.entities.concretes.Employer;
import main.hrms.entities.concretes.JobSeeker;

@Service
public class JobSeekerManager implements JobSeekerService{

	private JobSeekerDao jobSeekerDao;
	
	public JobSeekerManager(JobSeekerDao jobSeekerDao) {
		super();
		this.jobSeekerDao = jobSeekerDao;
	}

	@Override
	public Result add(JobSeeker jobSeeker) {
		
		Result result = BusinessRules.Run
				(
				);
		
		if (result != null)
        {
            return result;
        }
		
		jobSeekerDao.save(jobSeeker);
		return new SuccessResult("İş arayan başarıyla eklendi");
	}

	@Override
	public DataResult<List<JobSeeker>> getAll() {
		
		return new SuccessDataResult<List<JobSeeker>>(jobSeekerDao.findAll());
	}
	
	//İŞ KURALLARI --------------------------------------------------------
	
	private Result checkIfFieldsNull(JobSeeker jobSeeker) {
		
		return new SuccessResult();
	}

	private Result checkIfPassedByMernis(JobSeeker jobSeeker) {
		
		return new ErrorResult();
	}
	
	private Result checkIfAlreadyRegistered(JobSeeker jobSeeker) {
		//Email ve tcno kontrolü
		return new ErrorResult();
	}
	
	private Result checkIfEmailIsChecked(JobSeeker jobSeeker) {
		
		return new ErrorResult();
	}
	
}
