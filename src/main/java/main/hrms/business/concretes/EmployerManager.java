package main.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import main.hrms.business.abstracts.EmployerService;
import main.hrms.core.utilities.business.BusinessRules;
import main.hrms.core.utilities.results.DataResult;
import main.hrms.core.utilities.results.ErrorResult;
import main.hrms.core.utilities.results.Result;
import main.hrms.core.utilities.results.SuccessDataResult;
import main.hrms.core.utilities.results.SuccessResult;
import main.hrms.dataAccess.abstracts.EmployerDao;
import main.hrms.entities.concretes.Employer;
import main.hrms.entities.concretes.JobSeeker;

@Service
public class EmployerManager implements EmployerService{

	private EmployerDao employerDao;

	@Autowired
	public EmployerManager(EmployerDao employerDao) {
		super();
		this.employerDao = employerDao;
	}

	@Override
	public DataResult<List<Employer>> getAll() {

		return new SuccessDataResult<List<Employer>>(employerDao.findAll());
	}

	@Override
	public Result add(Employer employer) {
		
		Result result = BusinessRules.Run
				(
				);
		
		if (result != null)
        {
            return result;
        }
		
		employerDao.save(employer);
		return new SuccessResult("İş veren başarıyla eklendi");
	}
	
	//İŞ KURALLARI --------------------------------------------------------
	
	private Result checkIfFieldsNull(JobSeeker jobSeeker) {
		
		return new SuccessResult();
	}

	private Result checkIfCorpIsReal(Employer employer) {
		
		return new SuccessResult();
	}
	
	private Result checkIfEmailIsCheckedOrHRMSPersonelIsApproved(JobSeeker jobSeeker) {
		
		return new ErrorResult();
	}
		
	private Result checkIfAlreadyRegistered(JobSeeker jobSeeker) {
		
		return new ErrorResult();
	}
	
}
