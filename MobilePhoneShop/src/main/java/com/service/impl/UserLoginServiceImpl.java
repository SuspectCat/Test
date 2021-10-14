package com.service.impl;

import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;

import com.dao.impl.UserDAOImpl;
import com.entity.User;
import com.service.UserLoginService;

public class UserLoginServiceImpl implements UserLoginService {
	private UserDAOImpl daoImpl = new UserDAOImpl();
	
	@Override
	public boolean loginSuccess(String userName, String password) throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException, SQLException {
		// TODO Auto-generated method stub
		User findUserByUserName = daoImpl.findUserByUserName(userName);
		
		if (null != findUserByUserName) if (password.equals(findUserByUserName.getPassword())) return true;
		return false;
	}

}
