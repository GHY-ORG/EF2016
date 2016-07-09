package cn.ghy.ef.util;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import cn.ghy.ef.mapper.userMapper;

public class GetSqlSession {
	public static SqlSession getSqlSession(){
		InputStream inputStream = null;
		try {
			inputStream = Resources.getResourceAsStream("MapperConfig.xml");
		} catch (IOException e) {
			e.printStackTrace();
		}
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		return sqlSessionFactory.openSession();
	}
}