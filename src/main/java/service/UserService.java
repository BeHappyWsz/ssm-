package service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import common.Result;
import common.Utils;
import dao.UserDao;
import domain.User;

@Service
public class UserService extends BaseService{

	@Autowired
	private UserDao userDao;
	
	public Result login(String username,String pasword) {
		User u = userDao.getUserByUsernameAndPassword(username,pasword);
		if(Utils.nullOrEmpty(u)) {
			return new Result(false,"ÕËºÅ´íÎó");
		}
		return new Result(true,"µÇÂ¼³É¹¦");
	}
	
	
	
}
