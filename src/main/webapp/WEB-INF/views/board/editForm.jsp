<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%
int prod_num = Integer.parseInt(request.getParameter("prod_num"));
%>

<html lang="ko">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<script type="text/javascript">
	function listgo(){
		document.edit_form_ok.action="${pageContext.request.contextPath}/board/list.do"
		document.edit_form_ok.submit()
	}

	
</script>
<title>Insert title here</title>
<script src="${pageContext.request.contextPath}/resources/scripts/bootstrap.min.js"></script>
<link href="${pageContext.request.contextPath}/resources/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<jsp:include page="../action.jsp"></jsp:include>
<div class="container">
<h3>수정</h3>
<form class="form" name="edit_form_ok" action="${pageContext.request.contextPath}/board/edit_ok.do?num=${board.num}" method="post">
	<table class="table table-hover" border="1" >
		<tr>
			<th>${board.num}</th><th colspan=""><input type="text" value="${board.title}" name="title"></th>			
		</tr>
		<tr>
			<td style="width:200px;height:200px" align="center"><img src="${board.img_path }" style="width:150px;height:150px"><br><input type="file" name="img_path"> </td>
			<td colspan="2" style="width:200px;height:200px"><input type="text" value="${board.content}" name="content"></td>
		</tr>
		
	</table>
		<input type="hidden" value="<%=prod_num %>" name="prod_num">	
	<c:if test="${sessionScope.num == board.writer_num }">
		<input class="btn btn-default" type="submit" value="완료">
		<input class="btn btn-default" type="button" value="취소" onclick="listgo()">
	</c:if>
</form>
</div>

</body>
</html>