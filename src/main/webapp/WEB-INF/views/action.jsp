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
<script type="text/javascript">
	function searchEvent(){ //검색기능 enter 와 나머지키로 구분하여 기능수행
		var params = "searchData="+encodeURIComponent(document.getElementById("searchD").value);
		if(event.keyCode == 13){
			location.href="${pageContext.request.contextPath}/custcont/search.do?"+params;
		}/* else{ //검색시 리스트형태로 보여주기
			sendRequest("${pageContext.request.contextPath}/cont/searchlist.do", params, callback, method);
		} */
	}
</script>
<script src="${pageContext.request.contextPath}/resources/scripts/bootstrap.min.js"></script>
<link href="${pageContext.request.contextPath}/resources/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<div class="container">
	<div id='logos' style='width:400px; height:200px; float:left'>
	<a href="${pageContext.request.contextPath}/viewcont/main.do"><img src="/logos/zmarket_bi_sm.png" width="200"></a><br>
	</div>
	<div id='login' style='width:300px; height:200px; float:right'>
		<div style='margin:auto'>
		<c:choose>
			<c:when test="${TYPE eq null}"><input class="btn btn-default" type="button" value="Login" onclick="action_do('login')"></c:when>
			<c:otherwise>
				<input class="btn btn-default" type="button" value="Logout" onclick="action_do('logout')">
				<input class="btn btn-default" type="button" value="Mypage" onclick="action_do('mypage')">
				<c:if test="${TYPE eq 2 }">
				<input class="btn btn-default" type='button' value='판매자 페이지' onclick="location.href='${pageContext.request.contextPath}/seller/main.do'">
				</c:if>
				<c:if test="${TYPE eq 3 }">
				<input class="btn btn-default" type='button' value='관리자 페이지' onclick="">
				</c:if>
			</c:otherwise>
		</c:choose><br>
		</div>
	</div>
	<div style='clear:both'></div>
	<div id='search' style='width:300px;margin:auto; '>
		<input type="text" id="searchD" name="searchData" onkeyup="searchEvent()" placeholder='상품명을 검색하세요' size="20"><br>
	</div>
	<input type="hidden" id="loginUser" value="${num}">
</div>
</body>
</html>