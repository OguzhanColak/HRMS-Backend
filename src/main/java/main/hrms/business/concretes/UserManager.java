package main.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import main.hrms.business.abstracts.UserService;
import main.hrms.core.utilities.results.DataResult;
import main.hrms.core.utilities.results.Result;
import main.hrms.core.utilities.results.SuccessDataResult;
import main.hrms.core.utilities.results.SuccessResult;
import main.hrms.dataAccess.abstracts.UserDao;
import main.hrms.entities.concretes.User;

@Service
public class UserManager implements UserService{

	private UserDao userDao;
	@Autowired
	public UserManager(UserDao userDao) {
		super();
		this.userDao = userDao;
	}

	@Override
	public DataResult<List<User>> getAll() {
		return new SuccessDataResult<List<User>>(this.userDao.findAll(),"user listed");
		
	}

	@Override
	public DataResult<User> getById() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Result add(User user) {
		return new SuccessResult("user added");
	}

	@Override
	public Result update(User user) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Result delete(int id) {
		// TODO Auto-generated method stub
		return null;
	}

}