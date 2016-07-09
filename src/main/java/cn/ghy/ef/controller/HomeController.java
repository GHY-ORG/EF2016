package cn.ghy.ef.controller;

import java.sql.SQLException;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.ghy.ef.model.user;
import cn.ghy.ef.service.UserService;


@Controller
public class HomeController {

	private UserService userService;
	private List<user> userList;

	@RequestMapping(value = "/", method = RequestMethod.GET)
	@ResponseBody
	public List<user> index() {
		// show user list
		userService = new UserService();
		try {
			userList = userService.getAll();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return userList;
	}
	
	@RequestMapping(value="/error", method = RequestMethod.GET)
	public void error(){
		
	}

}
