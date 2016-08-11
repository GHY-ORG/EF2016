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

	// select * from user where status = 0 or 1
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

	// select * from user where status = ?
	public static List<user> getAllByStatus(int status) throws SQLException {
		try {
			userExample example = new userExample();
			example.or().andStatusEqualTo(status);

			return mapper.selectByExample(example);

		} finally {
			sqlSession.close();
		}
	}

	// select * from user where id = ? and status = ?
	public static List<user> getOneById(int id, int status) throws SQLException {
		try {
			userExample example = new userExample();
			example.or().andStatusEqualTo(id);

			return mapper.selectByExample(example);

		} finally {
			sqlSession.close();
		}
	}

	// if(nickname == "")select * from user where username = ?
	// if(username == "")select * from user where nickname = ?
	// select * from user where username = ? and nickname = ?
	public static List<user> getUserList(String username, String nickname) throws SQLException {
		try {
			userExample example = new userExample();

			if (username != "" && nickname != "") {
				example.or().andUsernameEqualTo(username).andNicknameEqualTo(nickname);
			} else if (username != "") {
				example.or().andNicknameEqualTo(username);
			} else {
				example.or().andNicknameEqualTo(nickname);
			}

			return mapper.selectByExample(example);
		} finally {
			sqlSession.close();
		}
	}

	// insert into
	// user(nickname,username,password,sex,phone,email,stunumber,registertime,status)
	// values (?,?,?,?,?,?,?,?,?)
	public static boolean add(user record) throws SQLException {

		try {

			if (mapper.insert(record) > 0) {
				return true;
			} else {
				return false;
			}

		} finally {
			sqlSession.close();
		}
	}

	// update user
	// set nickname = ?,username = ?,password = ?,sex = ?,phone = ?,email =
	// ?,stunumber = ?,status = ?
	// where userid = ?
	public static boolean updateById(user record) throws SQLException {
		try {

			if (mapper.updateByPrimaryKeySelective(record) > 0) {
				return true;
			} else {
				return false;
			}

		} finally {
			sqlSession.close();
		}
	}
}
