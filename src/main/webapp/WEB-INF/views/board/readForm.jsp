<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
int prod_num = Integer.parseInt(request.getParameter("prod_num"));
%>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="ko">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<script type="text/javascript">
	function formedit(){
		document.read_form.action="${pageContext.request.contextPath}/board/edit.do?num=${board.num}"
		document.read_form.submit()
	}
	function formdel(){
		var flag = confirm("삭제하시겠습니까?");
		if(!flag){
			return
		}else{
		
		document.read_form.action="${pageContext.request.contextPath}/board/del.do?num=${board.num}"
		document.read_form.submit()
		}
	}
	function listgo(){
		document.read_form.action="${pageContext.request.contextPath}/board/list.do"
		document.read_form.submit()
	}

</script>
<title>Insert title here</title>
<script src="${pageContext.request.contextPath}/resources/scripts/bootstrap.min.js"></script>
<link href="${pageContext.request.contextPath}/resources/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<div class="container">
<h3>글읽기</h3>

<form class="form" name="read_form" method="post">
	<table class="table table-hover" border="1">
		<tr>
			<th>${board.num}</th><th colspan="">${board.title}</th>			
		</tr>
		<tr>
			<td style="width:200px;height:200px" align="center"><img src="${board.img_path }" style="width:150px;height:150px"></td>
			<td colspan="2" style="width:200px;height:200px">${board.content}</td>
		</tr>

	
	</table>
	<input type="hidden" value="<%=prod_num %>" name="prod_num">	
	<c:if test="${sessionScope.num == board.writer_num }">
		<input class="btn btn-default" type="submit" value="수정" onclick="formedit()">
		<input class="btn btn-default" type="button" value="삭제" onclick="formdel()">
	</c:if>
		<input class="btn btn-default" type="button" value="뒤로가기" onclick="listgo()">
</form>
</div>
</body>
</html>