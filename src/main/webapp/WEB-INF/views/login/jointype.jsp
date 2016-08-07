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
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/scripts/action.js"></script>
<script src="${pageContext.request.contextPath}/resources/scripts/bootstrap.min.js"></script>
<link href="${pageContext.request.contextPath}/resources/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
	<jsp:include page="../action.jsp"></jsp:include>
	<div class="container" align="center" style="padding-top:150px;">
	<a href="${pageContext.request.contextPath}/viewcont/joinformcustomer.do"><img alt="개인회원m1" src="/logos/m.png"> </a>
	<a href="${pageContext.request.contextPath}/viewcont/joinformseller.do"><img alt="기업회원m2" src="/logos/m2.png"> </a>
	</div>
</body>
</html>