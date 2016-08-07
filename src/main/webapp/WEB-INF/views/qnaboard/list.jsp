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
<h3>QnA게시판</h3>
<form action="${pageContext.request.contextPath}/qnaboard/write.do">
<table class="list_table">
		<colgroup>
			<col width="15%" />
			<col width="45%" />
			<col width="20%" />
		</colgroup>
		<thead>
			<tr>
				<th>번호</th>
				<th>제목</th>
				<th>내용</th>
			</tr>
		</thead>
		<tbody align="center">
			<c:forEach var="a" items="${list}">
			<tr>
				<td>${a.num }</td>
				<td>${a.title}</td>
				<td><a href="${pageContext.request.contextPath}/qnaboard/read.do?num=${a.num}">${a.content}</a></td>
			</tr>
			</c:forEach>			
		</tbody>
	</table>
	<input type="submit" value="글쓰기" >
</form>
</body>
</html>
