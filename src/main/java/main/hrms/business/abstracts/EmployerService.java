package main.hrms.business.abstracts;

import java.util.List;

import main.hrms.core.utilities.results.DataResult;
import main.hrms.core.utilities.results.Result;
import main.hrms.entities.concretes.Employer;


public interface EmployerService {
	
	DataResult<List<Employer>> getAll();
	Result add(Employer employer);
}
