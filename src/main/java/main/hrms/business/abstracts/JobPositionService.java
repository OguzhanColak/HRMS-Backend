package main.hrms.business.abstracts;

import java.util.List;

import main.hrms.core.utilities.results.DataResult;
import main.hrms.core.utilities.results.Result;
import main.hrms.entities.concretes.JobPosition;

public interface JobPositionService {
	
	Result add(JobPosition job);
	DataResult<List<JobPosition>> getAll();
}
