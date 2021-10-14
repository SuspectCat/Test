package com.dao.impl;

import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

import com.dao.IGoodsDAO;
import com.entity.Goods;
import com.utils.DatabaseConnecter;

public class GoodsDAOImpl implements IGoodsDAO {
	private DatabaseConnecter databaseConnecter = new DatabaseConnecter();
	
	@Override
	public List<Goods> findAllProducts() {
		// TODO Auto-generated method stub
		List<Goods> goods = new LinkedList<Goods>();
		String sqlString = "select * from goods;";
		
		try {
			goods = databaseConnecter.selectAllMessages(sqlString, Goods.class);
			
			return goods;
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoSuchMethodException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}

}
