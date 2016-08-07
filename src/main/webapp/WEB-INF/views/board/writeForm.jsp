<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
	<%
 	int prod_num = Integer.parseInt(request.getParameter("prod_num"));
	%>
<html lang="ko">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Insert title here</title>
<script src="${pageContext.request.contextPath}/resources/scripts/bootstrap.min.js"></script>
<link href="${pageContext.request.contextPath}/resources/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<div class="container">
<form class="form" action="${pageContext.request.contextPath}/board/write.do" method="post" enctype="multipart/form-data">
	

	제목 : <input type="text" name="title"/><br>
	내용 : <textarea class="form-control" name="content" rows="10" cols="40"></textarea><br>
	사진 : <input type="file" name="file"/><br>
	<input type="hidden" name="writer_num" value="${sessionScope.num}">
	<input type="hidden" value="<%=prod_num %>" name="prod_num">				
	
	<input class="btn btn-default" type="submit" value="글쓰기"/>
</form>
</div>
</body>
</html>