<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Login Page::</title>
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/scripts/action.js"></script>
<script type="text/javascript">
	function loginchk(str){
		var form = document.loginform;
		var id = form.id.value;
		var pw = form.password.value;
		
		if(str == 'enter'){
			if(event.keyCode == 13){
				if(id == '' || pw == ''){
					alert("ID와 비밀번호를 확인해주세요");
				}else{
					form.submit();	
				}
			}
		}else if(str == 'click'){
			form.submit();
		}		
	}
</script>
<script src="${pageContext.request.contextPath}/resources/scripts/bootstrap.min.js"></script>
<link href="${pageContext.request.contextPath}/resources/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<jsp:include page="../action.jsp"></jsp:include>
	<div class="container">
		<h3>Login</h3>
		<form class="form-horizontal" action="${pageContext.request.contextPath}/logincont/login.do" method="post" name="loginform">
			<div class="form-group">
			    <label for="inputId" class="col-sm-2 control-label">ID</label>
			    <div class="col-sm-10">
					<input type="text" id="inputId" name="id" placeholder="ID">			    </div>
			 </div>
			<div class="form-group">
			   	<label for="inputPassword" class="col-sm-2 control-label">Password</label>
			    <div class="col-sm-10">
			      <input type="password" id="inputPassword" name="password" placeholder="PW" onkeyup="loginchk('enter')">
			    </div>
			</div>
			<div class="form-group">
			   <div class="col-sm-offset-2 col-sm-10">
			      <input class="btn btn-default" type="button" value="Login" onclick="loginchk('click')">
			      <a href="${pageContext.request.contextPath}/viewcont/jointype.do">회원가입</a>
			   </div>
			</div>
		</form>
	</div>
</body>
</html>