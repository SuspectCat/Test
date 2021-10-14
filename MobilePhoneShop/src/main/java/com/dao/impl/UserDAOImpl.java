package com.dao.impl;

import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;

import com.dao.IUserDAO;
import com.entity.User;
import com.utils.DatabaseConnecter;

public class UserDAOImpl implements IUserDAO {
	private DatabaseConnecter connecter = new DatabaseConnecter();
	
	@Override
	public User findUserByUserName(String userName) throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException, SQLException {
		// TODO Auto-generated method stub
		String sqlString = "select user.password from user where username = ?;";
		
		User selectOne = connecter.selectOne(sqlString, User.class, userName);
		
		return selectOne;
	}

}
