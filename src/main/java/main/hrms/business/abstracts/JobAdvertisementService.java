package main.hrms.business.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import main.hrms.core.utilities.results.DataResult;
import main.hrms.core.utilities.results.Result;
import main.hrms.entities.concretes.JobAdvertisement;


public interface JobAdvertisementService {
	
	DataResult<List<JobAdvertisement>> getAll();
	DataResult<JobAdvertisement> getById(int id);
	Result add(JobAdvertisement jobAdvertisement);
	Result update(JobAdvertisement jobAdvertisement);
	Result delete(int id);
	Result makePassive(int id);
	DataResult<List<JobAdvertisement>> getByActiveStatus();
	DataResult<List<JobAdvertisement>> getAllSortedByDate();
	DataResult<List<JobAdvertisement>> getByEmployerId(int id);
}