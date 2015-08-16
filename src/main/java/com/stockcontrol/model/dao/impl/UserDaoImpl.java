package com.stockcontrol.model.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.stockcontrol.model.businessobjects.User;
import com.stockcontrol.model.dao.UserDao;

@Repository
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

}