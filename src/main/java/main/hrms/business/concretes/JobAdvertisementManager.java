package main.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import main.hrms.business.abstracts.JobAdvertisementService;
import main.hrms.core.utilities.results.DataResult;
import main.hrms.core.utilities.results.Result;
import main.hrms.core.utilities.results.SuccessDataResult;
import main.hrms.core.utilities.results.SuccessResult;
import main.hrms.dataAccess.abstracts.JobAdvertisementDao;
import main.hrms.entities.concretes.JobAdvertisement;

@Service
public class JobAdvertisementManager implements JobAdvertisementService{

	private JobAdvertisementDao jobAdvertisementDao;
	@Autowired
	public JobAdvertisementManager(JobAdvertisementDao jobAdvertisementDao) {
		super();
		this.jobAdvertisementDao = jobAdvertisementDao;
	}

	@Override
	public DataResult<List<JobAdvertisement>> getAll() {
		return new SuccessDataResult<List<JobAdvertisement>>(this.jobAdvertisementDao.findAll(),"listed");
	}
	
	@Override
	public Result add(JobAdvertisement jobAdvertisement) {
		this.jobAdvertisementDao.save(jobAdvertisement);
		return new SuccessResult("added");
	}

	@Override
	public Result update(JobAdvertisement jobAdvertisement) {
		this.jobAdvertisementDao.save(jobAdvertisement);
		return new SuccessResult("updated");
	}

	@Override
	public Result delete(int id) {
		this.jobAdvertisementDao.deleteById(id);;
		return new SuccessResult("deleted");
	}

	@Override
	public DataResult<JobAdvertisement> getById(int id) {
		JobAdvertisement j=this.jobAdvertisementDao.findById(id).get();
		return new SuccessDataResult<JobAdvertisement>(this.jobAdvertisementDao.findById(id).get());
	}

	@Override
	public DataResult<List<JobAdvertisement>> getByActiveStatus() {
		return new SuccessDataResult<List<JobAdvertisement>>(this.jobAdvertisementDao.getByActiveStatus(),"Active job Ads List:");
		
	}

	@Override
	public DataResult<List<JobAdvertisement>> getAllSortedByDate() {
		// TODO Auto-generated method stub
		Sort sort=Sort.by(Sort.Direction.ASC,"release_date");
		return new SuccessDataResult<List<JobAdvertisement>>(this.jobAdvertisementDao.findAll(sort));
	}

	@Override
	public DataResult<List<JobAdvertisement>> getByEmployerId(int id) {
		return new SuccessDataResult<List<JobAdvertisement>>(this.jobAdvertisementDao.getByEmployer_Id(id));
	}

	@Override
	public Result makePassive(int id) {
		JobAdvertisement j=this.jobAdvertisementDao.findById(id).get();
		j.set_active(false);
		this.jobAdvertisementDao.save(j);
		return new SuccessResult("pasif yap??ld??");
	}

}
