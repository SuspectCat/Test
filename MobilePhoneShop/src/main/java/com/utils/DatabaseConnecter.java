package com.utils;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;
import java.util.Properties;

public class DatabaseConnecter {
	private static Properties databaseProperties = new Properties();
	
	static {
		ClassLoader contextClassLoader = Thread.currentThread().getContextClassLoader();
		InputStream resourceAsStream = contextClassLoader.getResourceAsStream("databaseConnect.properties");
		
		try {
			databaseProperties.load(resourceAsStream);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			Class.forName(databaseProperties.getProperty("databaseDriverPath"));
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public Connection getConnection() {
		try {
			return DriverManager.getConnection(databaseProperties.getProperty("databaseUrl"), databaseProperties.getProperty("databaseUsername"), databaseProperties.getProperty("databaseUserPassword"));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}
	
	/**
	 * 通过sql修改数据
	 * @param sqlString sql语句
	 * @param objects	sql语句的参数
	 * @return			被修改的列号
	 * @throws SQLException
	 */
	public int updateData(String sqlString, Object...objects) throws SQLException {
		Connection connection = getConnection();
		PreparedStatement prepareStatement = connection.prepareStatement(sqlString);
		
		if (null != objects) {
			for (int i = 0; i < objects.length; i++) {
				prepareStatement.setObject(i + 1, objects[i]);
			}
		}
		
		return prepareStatement.executeUpdate();
	}
	
	/**
	 * 查找一个数据
	 * @param <T>
	 * @param sqlString
	 * @param type
	 * @param objects
	 * @return
	 * @throws SQLException 
	 * @throws IllegalAccessException 
	 * @throws InstantiationException 
	 * @throws InvocationTargetException 
	 * @throws IllegalArgumentException 
	 * @throws SecurityException 
	 * @throws NoSuchMethodException 
	 */
	public <T> T selectOne(String sqlString, Class<T> type, Object...objects) throws SQLException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException {
		Connection databaseConnection = getConnection();
		PreparedStatement prepareStatement = databaseConnection.prepareStatement(sqlString);
		
		if (null != objects) {
			for (int i = 0; i < objects.length; i++) {
				prepareStatement.setObject(i + 1, objects[i]);
			}
		}
		
		ResultSet executeQuery = prepareStatement.executeQuery();
		
//		T newInstance = type.newInstance();
		Constructor<T> constructor = type.getConstructor();
		T newInstance = constructor.newInstance();
		
		if (null != executeQuery) {
			if (executeQuery.next()) {
				// 获取数据结果集
				ResultSetMetaData metaData = executeQuery.getMetaData();
				// 获取列数
				int columnCount = metaData.getColumnCount();
				
				for (int i = 0; i < columnCount; i++) {
					// 获取第i列的列名
					String columnName = metaData.getColumnName(i + 1);
					
					// 获取type的所有方法
					Method[] declaredMethods = type.getDeclaredMethods();
					
					for (Method method : declaredMethods) {
						if (method.getName().equalsIgnoreCase("set" + columnName)) method.invoke(newInstance, executeQuery.getObject(columnName));
					}
				}
			}
		}
		
		return newInstance;
	}
	
	/**
	 * 查询所有的内容
	 * @param <T>
	 * @param sqlString
	 * @param type
	 * @param objects
	 * @return
	 * @throws SQLException
	 * @throws InstantiationException
	 * @throws IllegalAccessException
	 * @throws IllegalArgumentException
	 * @throws InvocationTargetException
	 * @throws NoSuchMethodException
	 * @throws SecurityException
	 */
	public <T> List<T> selectAllMessages(String sqlString, Class<T> type, Object...objects) throws SQLException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException {
		Connection databaseConnection = getConnection();
		PreparedStatement prepareStatement = databaseConnection.prepareStatement(sqlString);
		
		if (null != objects) {
			for (int i = 0; i < objects.length; i++) {
				prepareStatement.setObject(i + 1, objects[i]);
			}
		}
		
		ResultSet executeQuery = prepareStatement.executeQuery();
		List<T> userList = new LinkedList<T>();
		
		if (null != executeQuery) while (executeQuery.next()) {
			ResultSetMetaData metaData = executeQuery.getMetaData();
			int columnCount = metaData.getColumnCount();
			
			Constructor<T> constructor = type.getConstructor();
			T newInstance = constructor.newInstance();
			
			for (int index = 0; index < columnCount; index++) {
				String columnName = metaData.getColumnName(index + 1);
				
				Method[] declaredMethods = type.getDeclaredMethods();
				
				for (Method method : declaredMethods) {
					if (method.getName().equalsIgnoreCase("set" + columnName)) method.invoke(newInstance, executeQuery.getObject(columnName));
				}
			}
			
			userList.add(newInstance);
		}
		
		return userList;
	}
}
