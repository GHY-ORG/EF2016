package cn.ghy.ef.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import cn.ghy.ef.model.user;
import cn.ghy.ef.model.userExample;
import cn.ghy.ef.mapper.userMapper;
import cn.ghy.ef.util.GetSqlSession;

public class UserDao {

	// DB Connect
	private static SqlSession sqlSession = GetSqlSession.getSqlSession();
	// Mapper
	private static userMapper mapper = sqlSession.getMapper(userMapper.class);

	// select * from ef_user where status = 0 or 1
	public static List<user> getAll() throws SQLException {
		try {
			userExample example = new userExample();
			List<Integer> values = new ArrayList<Integer>();
			values.add(0);
			values.add(1);
			example.or().andStatusIn(values);

			return mapper.selectByExample(example);

		} finally {
			sqlSession.close();
		}
	}
}
