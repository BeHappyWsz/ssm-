package dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import domain.User;

@Repository
public interface UserDao {

	User getUserById(int id);
	
	User getUserByUsername(String username);
	
	/**
	 * 传递多个参数
	 * 1.使用注解方式:使用该方法
	 * 2.parameterMap方式：该方法即将删除，不建议使用
	 * @param username
	 * @param password
	 * @return
	 */
	User getUserByUsernameAndPassword(@Param("username")String username,@Param("password")String password);
	
	List<User> getAllUsers();	
	
	List<User> getUserByRealname(String realname);
}
