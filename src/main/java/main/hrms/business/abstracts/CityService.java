package main.hrms.business.abstracts;

import java.util.List;

import main.hrms.core.utilities.results.DataResult;
import main.hrms.core.utilities.results.Result;
import main.hrms.entities.concretes.City;

public interface CityService {
	
	DataResult<List<City>> getAll();
	DataResult<City> getById(int id);
	Result add(City city);
	Result update(City city);
	Result delete(int id);
}
