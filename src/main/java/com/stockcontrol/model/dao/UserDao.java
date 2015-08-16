package com.stockcontrol.model.dao;

import com.stockcontrol.model.businessobjects.User;

public interface UserDao {

	User findByUserName(String username);

}