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
	 * ���ݶ������
	 * 1.ʹ��ע�ⷽʽ:ʹ�ø÷���
	 * 2.parameterMap��ʽ���÷�������ɾ����������ʹ��
	 * @param username
	 * @param password
	 * @return
	 */
	User getUserByUsernameAndPassword(@Param("username")String username,@Param("password")String password);
	
	List<User> getAllUsers();	
	
	List<User> getUserByRealname(String realname);
}
