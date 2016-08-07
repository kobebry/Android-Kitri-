<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>판매자 페이지입니다.</title>
<script src="${pageContext.request.contextPath}/resources/scripts/bootstrap.min.js"></script>
<link href="${pageContext.request.contextPath}/resources/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<jsp:include page="../action.jsp"></jsp:include>
<div id='main' class="container">
	<div id='myProductList'>
		<h2>내 판매 목록</h2>
		<table id='myProductTable' class="table table-hover">
		<thead>
		<tr><th>상품번호</th><th>상품명</th><th>가격</th><th>판매 시작 일자</th><th>상품 삭제</th></tr>
		</thead>
		<tbody>
		<c:forEach var='product' items='${PRODLIST }'>
			<tr>
			<td>${product.num }</td>
			<td><a href='${pageContext.request.contextPath}/seller/productDetail.do?num=${product.num}'>${product.name }</a></td>
			<td>${product.price }</td>
			<td>${product.sell_date}</td>
			<td><input type='button' value='삭제하기' onclick='location.href="${pageContext.request.contextPath}/seller/deleteProduct.do?num=${product.num}"'></td>
			</tr>
		</c:forEach>
		</tbody>
		</table>
	</div>
	<input class="btn btn-default" type='button' value='새 제품 넣기' onclick="location.href='${pageContext.request.contextPath }/seller/newProduct.do'">
	<input class="btn btn-default" type='button' value='메인 페이지로 돌아가기' onclick="location.href='${pageContext.request.contextPath }/'">
</div>
</body>
</html>