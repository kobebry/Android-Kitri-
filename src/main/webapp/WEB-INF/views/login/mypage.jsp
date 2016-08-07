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
	function pw_check(num){
		if(num == 'm'){
			var params = "num="+document.getElementById("loginUser").value+"&password="+document.getElementById("psword").value;
			sendRequest("${pageContext.request.contextPath}/logincont/getuserpw.do", params, alert_chk, 'POST');
		}else if(num == 'm2'){
			if(event.keyCode == 13){
				alert(document.getElementById("psword").value);
				var params = "num="+document.getElementById("loginUser").value+"&password="+document.getElementById("psword").value;
				//sendRequest("${pageContext.request.contextPath}/logincont/getuserpw.do", params, alert_chk, 'POST');
			}
		}else if(num == 'd'){
			var params = "num="+document.getElementById("loginUser").value+"&password="+document.getElementById("psword").value;
			sendRequest("${pageContext.request.contextPath}/logincont/getuserpw.do", params, delete_user_chk, 'POST');
		}else{
			var params = "num="+num+"&password="+document.getElementById("pw").value;
			sendRequest("${pageContext.request.contextPath}/logincont/getuserpw.do", params, print_pw, 'POST');
		}
	}
	function print_pw(){
		if (httpRequest.readyState == 4) {
			if (httpRequest.status == 200) {
				var result = httpRequest.responseText;
				if(result == 0){
					document.getElementById("pwcheckspan").innerHTML = "<font color=red>비밀번호가 일치하지 않습니다</font>";
				}else if(result == 1){
					document.getElementById("isChecked").value = "1";
					document.getElementById("pwcheckspan").innerHTML = "<font color=blue>비밀번호 일치</font>";
				}
			}
		}
	}
	function alert_chk(){
		if (httpRequest.readyState == 4) {
			if (httpRequest.status == 200) {
				var result = httpRequest.responseText;
				if(result == 0){
					alert("비밀번호가 일치하지 않습니다");
				}else if(result == 1){
					document.getElementById("selectForm").removeChild(document.getElementById("selectform"));
					makeObject('selectForm', 'selectform', 'div', null)
					makeObject('selectform', 'modifypwform', 'form', null, ['action', '${pageContext.request.contextPath}/logincont/modifypw.do']);
					makeObject('modifypwform', null, 'input', null, ['type', 'hidden'], ['name', 'num'], ['value', document.getElementById("loginUser").value])
					makeObject('modifypwform', 'psword2', 'input', null, ['type', 'password'], ['name', 'password'], ['placeholder', '변경할 비밀번호 입력']);
					makeObject('modifypwform', null, 'input', null, ['class', 'btn btn-default'],['type', 'button'], ['value', '확인'], ['onclick', "modifypw_do()"])
				}
			}
		}
	}
	function delete_user_chk(){
		if (httpRequest.readyState == 4) {
			if (httpRequest.status == 200) {
				var result = httpRequest.responseText;
				if(result == 0){
					alert("비밀번호가 일치하지 않습니다");
				}else if(result == 1){
					document.getElementById("selectForm").removeChild(document.getElementById("selectform"));
					makeObject('selectForm', 'selectform', 'div', null);
					makeObject('selectform', null, 'h3', '회원탈퇴 페이지');
					makeObject('selectform', null, 'p', '회원탈퇴후 다시 회원가입 할 경우 기존의 주문목록은 확인이 불가합니다');
					makeObject('selectform', 'deletebtn', 'input', null, ['value', '탈퇴'], ['type', 'button'], ['onclick', "delete_do('y')"]);
					makeObject('selectform', 'canceldelbtn', 'input', null, ['value', '취소'], ['type', 'button'], ['onclick', "delete_do('n')"]);
				}
			}
		}
	}
	function delete_do(status){
		if(status == 'y'){
			location.href="${pageContext.request.contextPath}/logincont/delete.do?num="+document.getElementById("loginUser").value;
		}else{
			location.href="${pageContext.request.contextPath}/viewcont/main.do";
		}
	}
	function modify_do(){
		var form = document.getElementById("form");
		if(form.isChecked.value == '0'){
			alert("비밀번호를 확인해주세요");
		}else{
			form.submit();
		}
	}
	function modifypw_do(){
		var form = document.getElementById("modifypwform");
		form.submit();
	}
	function select_function(num){
		var params="num="+document.getElementById("loginUser").value;
		if(num == 1){
			document.getElementById("selectForm").removeChild(document.getElementById("selectform"));
			makeObject('selectForm', 'selectform', 'div', null)
			sendRequest("${pageContext.request.contextPath}/logincont/getuserinfo.do", params, printModify, 'POST');
		}else if(num == 2){
			var num = document.getElementById("loginUser").value;
			document.getElementById("selectForm").removeChild(document.getElementById("selectform"));
			makeObject('selectForm', 'selectform', 'div', null)
			makeObject('selectform', null, 'h3', '비밀번호 확인');
			makeObject('selectform', 'form', 'form', null, ['action', '${pageContext.request.contextPath}/logincont/modify.do']);
			makeObject('form', 'psword', 'input', null, ['type', 'password'], ['name', 'password'], ['placeholder', '현재 비밀번호 입력']);
			makeObject('form', null, 'input', null, ['class', 'btn btn-default'],['type', 'button'], ['value', '확인'], ['onclick', "pw_check('m')"]);
		}else if(num == 3){
			location.href="${pageContext.request.contextPath}/viewcont/myorderinfo.do";
		}else if(num == 4){
			location.href="${pageContext.request.contextPath}/viewcont/mybasketform.do";
		}else if(num == 5){
			if(confirm("정말 탈퇴하시겠습니까?") == true){
				document.getElementById("selectForm").removeChild(document.getElementById("selectform"));
				makeObject('selectForm', 'selectform', 'div', null)
				makeObject('selectform', null, 'h3', '비밀번호 확인');
				makeObject('selectform', 'form', 'form', null, ['action', '${pageContext.request.contextPath}/logincont/modify.do']);
				makeObject('form', 'psword', 'input', null, ['type', 'password'], ['name', 'password'], ['placeholder', '현재 비밀번호 입력']);
				makeObject('form', null, 'input', null, ['type', 'button'], ['value', '확인'], ['onclick', "pw_check('d')"]);
			}
		}
	}
	function printModify(){
		if (httpRequest.readyState == 4) {
			if (httpRequest.status == 200) {
				var result = httpRequest.responseText;
				var userInfo = eval("("+ result +")");
				makeObject('selectform', 'title', 'h3', '개인정보변경');
				makeObject('selectform', 'form', 'form', null, ['action', '${pageContext.request.contextPath}/logincont/modify.do']);
				makeObject('form', 'p_pw2', 'p', '비밀번호  ');
				makeObject('p_pw2', 'pw', 'input', null, ['placeholder', '비밀번호 확인'], ['onkeyup', 'pw_check('+userInfo.num+')']);
				makeObject('p_pw2', 'pwcheckspan', 'span', null);
				makeObject('form', 'p_name', 'p', '이름  ');
				makeObject('p_name', null, 'input', null, ['type', 'text'],['value', userInfo.name],['name', 'name']);
				makeObject('form', 'p_addr', 'p', '주소  ');
				makeObject('p_addr', null, 'input', null, ['type', 'text'],['value', userInfo.address],['name', 'address']);
				makeObject('form', 'p_phone', 'p', '핸드폰번호  ');
				makeObject('p_phone', null, 'input', null, ['type', 'text'],['value', userInfo.phone],['name', 'phone']);
				makeObject('form', 'p_email', 'p', 'email  ');
				makeObject('p_email', null, 'input', null, ['type', 'text'],['value', userInfo.email],['name', 'email']);
				makeObject('form', 'isChecked', 'input', null, ['type', 'hidden'], ['value', '0']);
				makeObject('form', null, 'input', null, ['type', 'hidden'],['value', userInfo.num],['name', 'num']);
				makeObject('form', null, 'input', null, ['class', 'btn btn-default'],['type', 'button'],['value', '수정하기'], ['onclick', 'modify_do()']);
			}
		}
	}
</script>
<script src="${pageContext.request.contextPath}/resources/scripts/bootstrap.min.js"></script>
<link href="${pageContext.request.contextPath}/resources/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<div class="container">
	<jsp:include page="../action.jsp"></jsp:include>
	<input class="btn btn-default" type="button" value="개인정보변경" onclick="select_function(1)">
	<input class="btn btn-default" type="button" value="비밀번호변경" onclick="select_function(2)">
	<input class="btn btn-default" type="button" value="주문내역" onclick="select_function(3)">
	<input class="btn btn-default" type="button" value="장바구니" onclick="select_function(4)">
	<input class="btn btn-default" type="button" value="회원탈퇴" onclick="select_function(5)">
	<div>
		<div id="selectForm">
		<div id="selectform"></div>
		</div>
	</div>
</div>
</body>
</html>