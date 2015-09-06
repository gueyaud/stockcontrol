package com.stockcontrol.model.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.stockcontrol.model.businessobjects.User;
import com.stockcontrol.model.dao.UserDao;

@Repository
@Transactional
public class UserDaoImpl implements UserDao {

	@Autowired
	private SessionFactory sessionFactory;

	@SuppressWarnings("unchecked")
	public User findByUserName(String username) {

		List<User> users = new ArrayList<User>();

		users = sessionFactory.getCurrentSession().createQuery("from User u where u.username=:username").setParameter("username", username)
				.list();
		
		//users = sessionFactory.getCurrentSession().createQuery("from User")
		//		.list();

		if (users.size() > 0) {
			return users.get(0);
		} else {
			return null;
		}

	}

	public List<User> listAllUsers() {
		List<User> users = new ArrayList<User>();

		users = sessionFactory.getCurrentSession().createQuery("from User u order by u.username").list();
		for (User u : users) {
		    u.getUserRole().size();
		}
		return users;
	}
	
	public User getUserById(int i) {
		return listAllUsers().get(i);
	}
	
	public User createUser(User user){
	
		//Add new Employee object
	    User userPersistant = new User();
	    userPersistant.setUsername(user.getUsername());
	    userPersistant.setPassword(user.getPassword());
	    userPersistant.setEnabled(Boolean.TRUE);
	     
	    //Save the employee in database
	    sessionFactory.getCurrentSession().save(user);
	    
	    return user;
	}


}