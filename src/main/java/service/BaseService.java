package service;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Service;
/**
 * ע��ģ��Ļ���service��
 * @author wsz
 * @date 2018��1��29��
 */
@Service
public class BaseService{

	private SqlSessionTemplate sqlSessionTemplate = null;

	public SqlSessionTemplate getSqlSessionTemplate() {
		return sqlSessionTemplate;
	}

	public void setSqlSessionTemplate(SqlSessionTemplate sqlSessionTemplate) {
		this.sqlSessionTemplate = sqlSessionTemplate;
	}

}
