package service;

import java.util.List;

import org.apache.ibatis.session.RowBounds;
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
			return new Result(false,"账号错误");
		}
		return new Result(true,"登录成功");
	}
	
	/**
	 * 使用RowBounds模拟分页
	 * @return
	 */
	public Result getPage() {
		List<User> list = userDao.getUserByRealname("1", new RowBounds(2, 4));
		return new Result(true,"",list);
	}
	
}
