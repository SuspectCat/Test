package com.dao;

import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;

import com.entity.User;

public interface IUserDAO {
	User findUserByUserName(String userName) throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException, SQLException;
}
