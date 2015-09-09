package com.stockcontrol.services;

import java.util.List;

import javax.ws.rs.Consumes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.stockcontrol.model.businessobjects.User;
import com.stockcontrol.model.dao.UserDao;

@RestController
public class UserController {
	
	@Autowired
	private UserDao userDao;
	
	@RequestMapping(value="/users/list", method = RequestMethod.GET, produces = "application/json",headers="Accept=application/json")
	@ResponseBody
    public List<User> getAllUsers() {
        return userDao.listAllUsers();
    }
	
	@RequestMapping(value="/users/list/{id}", method = RequestMethod.GET, produces = "application/json",headers="Accept=application/json")
	@ResponseBody
    public User getAllUsers(@PathVariable("id") int id) {
        return getAllUsers().get(id);
    }
	
	@RequestMapping(value="/users/create", method = RequestMethod.POST,headers="Accept=application/json")
	@Consumes("text/html")
	public void createUser(@RequestBody User user) {
		userDao.createUser(user);
	}
	
	@RequestMapping(value="/users/deleteByUsername", method = RequestMethod.POST,headers="Accept=application/json")
	public void deleteUserByUsername(@RequestParam("username") String username) {
		userDao.deleteUserByUsername(username);
	}
	
	@RequestMapping(value="/users/delete", method = RequestMethod.POST,headers="Accept=application/json")
	public void deleteUser(@PathVariable("user") User user) {
		userDao.deleteUser(user);
	}
	
//	@RequestMapping(value="/users/list{}", method = RequestMethod.GET, produces = "application/json")
//	@ResponseBody
//    public List<User> getAllUsers() {
//        return userDao.listAllUsers();
//    }
}
