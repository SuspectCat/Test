<%@page import="org.apache.jasper.tagplugins.jstl.core.ForEach"%>
<%@page import="com.entity.Goods"%>
<%@page import="java.util.LinkedList"%>
<%@page import="com.controller.DisplayProductsServlet"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>

<style>
.productFrame {
	width: 1060px;
	height: auto;
	margin: 0 auto;
}

.messageFrame {
	float: left;
	width: 200px;
	height: 350px;
	border: 1px solid grey;
	margin: 10px 0px 0px 10px;
}

.messageFrame img {
	width: 200px;
	height: 200px;
}

.priceeFrame {
	font-size: 18px;
	color: red;
	font-weight: bold;
	text-align: center;
}

.titleFrame {
	font-size: 12px;
	color: black;
}
</style>

<body>
	<div class="productFrame">
		<%-- <c:forEach items="${findAllProducts }" var="goods">
			<div class="messageFrame">
				<img alt="mobile phone"
					src="http:localhost:8080/img/${goods.goodsPhoto }">

				<div class="describeFrame">
					<div class="priceeFrame">￥${goods.goodsPrice }</div>
					<div class="titleFrame">${goods.goodsContent }</div>
				</div>
			</div>
		</c:forEach> --%>

		<%
		if (null != request.getAttribute("findAllProducts")) {
			LinkedList<Goods> gooLinkedList = (LinkedList<Goods>) request.getAttribute("findAllProducts");

			for (Goods goods : gooLinkedList) {
		%>
		<div class="messageFrame">
			<img alt="mobile phone"
				src="http://localhost:8080/img/<%=goods.getGoodsPhoto()%>">

			<div class="describeFrame">
				<div class="priceeFrame">
					￥<%=goods.getGoodsPrice()%>>
				</div>
				<div class="titleFrame"><%=goods.getGoodsContent()%></div>
			</div>
		</div>
		<%
			}
		}
		%>
	</div>
</body>
</html>