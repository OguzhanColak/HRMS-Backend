package main.hrms.business.abstracts;

import java.util.List;

import main.hrms.core.utilities.results.DataResult;
import main.hrms.core.utilities.results.Result;
import main.hrms.entities.concretes.JobSeeker;

public interface JobSeekerService {
	
	Result add(JobSeeker jobSeeker);
	DataResult<List<JobSeeker>> getAll();
}