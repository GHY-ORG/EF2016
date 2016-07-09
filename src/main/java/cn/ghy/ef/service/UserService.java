package cn.ghy.ef.service;

import java.sql.SQLException;
import java.util.List;

import cn.ghy.ef.dao.UserDao;
import cn.ghy.ef.model.user;

public class UserService {

	// 获得status=0或1的用户
	public List<user> getAll() throws SQLException {
		return UserDao.getAll();
	}
}
