<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/scripts/httpRequest.js"></script>
<script type="text/javascript">
	function formedit(){
		document.read_form.action="${pageContext.request.contextPath}/qnaboard/edit.do?num=${board.num}"
		document.read_form.submit()
	}
	function formdel(){
		var flag = confirm("삭제하시겠습니까?");
		var num = ${board.num};
		if(!flag){
			return
		}else{
		alert(num)
		document.read_form.action="${pageContext.request.contextPath}/qnaboard/del.do?num="+num;
		document.read_form.submit()
		}
	}
	function listgo(){
		document.read_form.action="${pageContext.request.contextPath}/qnaboard/list.do"
		document.read_form.submit()
	}
	function repdo(){
		document.getElementById("repdiv").style.display="";
	}
	
	function repok(){
		var num = ${board.num};
		alert(num)
		var writer_num = ${board.writer_num};
		var title = document.rep_form.title.value;
		var content = document.rep_form.content.value;
		var params = "writer_num="+writer_num+"&num="+num+"&title="+encodeURIComponent(title)+"&content="+encodeURIComponent(content);
		sendRequest("${pageContext.request.contextPath}/qnaboard/rep.do", params, represult, "GET")	
	}
	function represult(){
		if(httpRequest.readyState == 4){
			if(httpRequest.status == 200){
				alert('리플달기')
				var str = httpRequest.responseText;
				alert('1')
				var rep = eval("("+str+")");
				alert('2')
				document.getElementById("repdiv").style.display="none";
				alert('3')
				makeRepDiv(rep);				
			}

		}
	}
	function makeRepDiv(rep){
		var RepDiv = document.createElement('div');
		RepDiv.setAttribute('id', 'rep_'+rep.num);
		var html =" 제목 : "+rep.title+"<br>"+" 내용 : "+rep.content+"<br>"+"<input type='button'value='삭제' onclick='delrep("+rep.num+")'>";
		RepDiv.innerHTML = html;
		var repList = document.getElementById("repList");
		repList.appendChild(RepDiv);
		
		
	}
	
	window.onload = function (){
		loadlist();
	} 
	
	function loadlist(){
		var num = ${board.num};
		var params = "num="+num;
		sendRequest("${pageContext.request.contextPath}/qnaboard/replist.do", params, loadedlist, "GET")
	}
	function loadedlist(){
		if(httpRequest.readyState == 4){
			if(httpRequest.status == 200){
				var str = httpRequest.responseText;
				var repList = eval("("+str+")");
				for(var i = 0; i < repList.length; i++){
					makeRepDiv(repList[i]);
				}				
			}		
		}
	}
</script>

<title>Insert title here</title>
</head>
<body>
	<form name="read_form">
	${board.num}번째 글<br>
	${board.title} <br>
	${board.content} <br>
	
		<c:if test="${sessionScope.num == board.writer_num }">
		<input type="submit" value="수정" onclick="formedit()">
		<input type="button" value="삭제" onclick="formdel()">
	</c:if>
		<input type="button" value="뒤로가기" onclick="listgo()">
		<input type="button" value="답글달기" onclick="repdo()">
		
	</form>
	<div id="repdiv" style="display:none">
		<form name="rep_form">
			<input type="text" name="title" value="[RE] ${board.title}"><br>
			 <textarea name="content" rows="10" cols="40" >[RE] ${board.content}</textarea><br>
			<input type="hidden" name="num" value="${board.num}">
			<input type="button" value="완료" onclick="repok()">
		</form>	
	</div>
	<div id="repList"></div>

</body>
</html>