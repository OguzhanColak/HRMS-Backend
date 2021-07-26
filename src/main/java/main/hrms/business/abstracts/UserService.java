package main.hrms.business.abstracts;

import java.util.List;

import main.hrms.core.utilities.results.DataResult;
import main.hrms.core.utilities.results.Result;
import main.hrms.entities.concretes.User;

public interface UserService {

	DataResult<List<User>> getAll();
	DataResult<User> getById();
	Result add(User user);
	Result update(User user);
	Result delete(int id);
	  
}
