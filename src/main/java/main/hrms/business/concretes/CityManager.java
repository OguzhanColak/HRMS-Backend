package main.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import main.hrms.business.abstracts.CityService;
import main.hrms.core.utilities.results.DataResult;
import main.hrms.core.utilities.results.Result;
import main.hrms.core.utilities.results.SuccessDataResult;
import main.hrms.core.utilities.results.SuccessResult;
import main.hrms.dataAccess.abstracts.CityDao;
import main.hrms.entities.concretes.City;

@Service
public class CityManager implements CityService{
	
	private CityDao cityDao;

	@Autowired
	public CityManager(CityDao cityDao) {
		super();
		this.cityDao = cityDao;
	}

	@Override
	public DataResult<List<City>> getAll() {
		return new SuccessDataResult<List<City>>(this.cityDao.findAll(),"cities listed");
	}

	@Override
	public DataResult<City> getById(int id) {
		return new SuccessDataResult<City>(this.cityDao.findById(id).get());
	}

	@Override
	public Result add(City city) {
		this.cityDao.save(city);
		return new SuccessResult("city added");
	}

	@Override
	public Result update(City city) {
		this.cityDao.save(city);
		return new SuccessResult("city updated");
	    
	}

	@Override
	public Result delete(int id) {
		this.cityDao.deleteById(id);
		return new SuccessResult("city deleted");
	}
	

}
