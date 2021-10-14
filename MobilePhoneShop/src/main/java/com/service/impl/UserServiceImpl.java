package com.service.impl;

import java.util.List;

import com.dao.IGoodsDAO;
import com.dao.impl.GoodsDAOImpl;
import com.entity.Goods;
import com.service.UserService;

public class UserServiceImpl implements UserService {

	@Override
	public List<Goods> findAllProducts() {
		// TODO Auto-generated method stub
		IGoodsDAO goodsDAO = new GoodsDAOImpl();
		
		return goodsDAO.findAllProducts();
	}

}
