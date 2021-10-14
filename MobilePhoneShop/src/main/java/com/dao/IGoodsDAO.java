package com.dao;

import java.util.List;

import com.entity.Goods;

public interface IGoodsDAO {
	List<Goods> findAllProducts();
}
