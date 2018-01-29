package service;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Service;
/**
 * 注入模板的基础service类
 * @author wsz
 * @date 2018年1月29日
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
