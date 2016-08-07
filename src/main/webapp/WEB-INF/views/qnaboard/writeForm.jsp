<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="${pageContext.request.contextPath}/qnaboard/writeok.do">
	<input type="text" name="writer_num" value="${sessionScope.num}" readonly="readonly"><br>	
	제목 : <input type="text" name="title"><br>
	내용 : <textarea name="content" rows="10" cols="40"></textarea><br>
	<input type="submit" value="전송">
	</form>
	
</body>
</html>