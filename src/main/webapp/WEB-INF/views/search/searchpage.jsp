<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Insert title here</title>
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/scripts/objectManager.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/scripts/httpRequest.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/scripts/action.js"></script>
<script src="${pageContext.request.contextPath}/resources/scripts/bootstrap.min.js"></script>
<link href="${pageContext.request.contextPath}/resources/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
	<jsp:include page="../action.jsp"></jsp:include>
<div id="container">
	<h3>'${searchData}'<small>검색결과</small></h3>
	<table class="table table-hover">
		<thead>
			<tr>
				<th></th>
				<th>상품</th>
				<th>금액</th>
				<th>판매자</th>
			</tr>
		</thead>
		<c:forEach var="plist" items="${PLIST}">
		<tbody>
			<tr>
				<td><img class="img-thumbnail" src="${plist.piList[0].path}" style='height:100px'></td>
				<td><a href="${pageContext.request.contextPath}/viewcont/showitem.do?prod_num=${plist.num}">${plist.name}</a></td>
				<td>${plist.price}</td>
				<td>${plist.seller_name}</td>
			</tr>
		</tbody>
		</c:forEach>
	</table>
</div>
</body>
</html>