package com.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.IGoodsDAO;
import com.dao.impl.GoodsDAOImpl;
import com.entity.Goods;

@WebServlet(urlPatterns = {
	"/DisplayProductsServlet"
})
public class DisplayProductsServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		super.service(arg0, arg1);
		req.setCharacterEncoding("utf-8");
		resp.setContentType("text/html;charset=utf-8");

		IGoodsDAO goodsDAO = new GoodsDAOImpl();

		List<Goods> findAllProducts = goodsDAO.findAllProducts();

		req.setAttribute("findAllProducts", findAllProducts);

		req.getRequestDispatcher("DisplayProduct.jsp").forward(req, resp);
	}

	public static void main(String[] args) {
		IGoodsDAO goodsDAO = new GoodsDAOImpl();

		List<Goods> findAllProducts = goodsDAO.findAllProducts();

		System.out.println(findAllProducts);
	}

}
