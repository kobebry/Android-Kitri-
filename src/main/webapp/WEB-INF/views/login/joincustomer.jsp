<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>회원가입 ::</title>
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/scripts/objectManager.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/scripts/httpRequest.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/scripts/action.js"></script>
<script type="text/javascript">
	function joindo(str){
		var form = document.joinform;
		if(str == 'join'){
			form.submit();
		}else if(str == 'cancel'){
			location.href = '${pageContext.request.contextPath}/viewcont/loginform.do';
		}
	}
	function id_check(){
		var id = document.getElementById("id");
		var params = "id="+id.value;
		sendRequest("${pageContext.request.contextPath}/logincont/idcheck.do", params, printIdCheck, 'POST');
	}
	function printIdCheck(){
		if (httpRequest.readyState == 4) {
			if (httpRequest.status == 200) {
				if(httpRequest.responseText == 0) {
					document.getElementById("idcheckspan").innerHTML = "<font color=blue>사용가능한 아이디</font>";
				} else if(httpRequest.responseText == 1) {
					document.getElementById("idcheckspan").innerHTML = "<font color=red>중복된 아이디</font>";
				}
				
			} else {
				alert("실패: " + httpRequest.status);
			}
		}
	}
	function pw_check(){
		var pw = document.getElementById("pw");
		var pw2 = document.getElementById("pw2");
		if(pw.value != pw2.value && pw2.value != ''){
			document.getElementById("pwcheckspan").innerHTML = "<font color=red>비밀번호가 일치하지 않습니다</font>";
		}else if(pw.value == pw2.value){
			document.getElementById("pwcheckspan").innerHTML = "<font color=blue>비밀번호 일치</font>";
		}
	}
</script>
<script src="${pageContext.request.contextPath}/resources/scripts/bootstrap.min.js"></script>
<link href="${pageContext.request.contextPath}/resources/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
	<jsp:include page="../action.jsp"></jsp:include>
	<div class="container">
		<h3>MemberShip <small>일반구매자 회원가입</small></h3>
		<hr>
		<form class="form" action="${pageContext.request.contextPath}/logincont/join.do" method="post" name="joinform">
			<input type="text" id="id" name="id" placeholder="아이디입력" onkeyup="id_check()"><span id="idcheckspan"></span><br>
			<input type="password" id="pw" name="password" placeholder="비밀번호입력"><br>
			<input type="password" id="pw2" name="password2" placeholder="비밀번호 재입력" onkeyup="pw_check()"><span id="pwcheckspan"></span><br>
			<input type="text" name="name" placeholder="이름"><br>
			<input type="text" name="address" placeholder="주소"><br>
			<input type="text" name="phone" placeholder="핸드폰번호"><br>
			<input type="text" name="email" placeholder="email"><br>
			<input type="hidden" name="type" value="1">
			<input class="btn btn-default" type="button" value="회원가입" onclick="joindo('join')">
			<input class="btn btn-default" type="button" value="돌아가기" onclick="joindo('cancel')">
		</form>
	</div>
</body>
</html>