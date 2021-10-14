package com.service;

import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;

public interface UserLoginService {
	boolean loginSuccess(String userName, String password) throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException, SQLException;
}
