<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="ko">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>게시판</title>

<style>
* {
	margin:0px;
	padding: 0px;
	font-size:11px;
	color:#898989;
	font-family: "wdu", "돋움";
}

table { border:0; border-spacing:0px; border-collapse:collapse;}

/* 목록 **************************************************************************************************************/
.boardList th { background-color:#dddddd; height:40px; color:#000000;}

.boardList td { height:16px; border-bottom:1px solid #e8e8e8; text-align:center; padding:8px 0 5px 0; }
.boardList .left { text-align:left; padding-left:5px; }
.boardList tr:hover, .boardList .overBg { background-color:#f7f7f7; }
.boardList .outBg { background-color:#ffffff; }


.boardLineList th { background-color:#dddddd; height:40px; color:#000000; }
.boardLineList tr { background-color:#ffffff;}
.boardLineList td { height:16px; text-align:center; padding:8px 0 5px 0; word-wrap:break-word;}

.boardLineList .left { text-align:left; padding-left:5px; padding-right:5px; }
.boardLineList .right { text-align:right; padding-right:5px; padding-left:5px; height:20px;}
.boardLineList tr:hover, .boardLineList .overBg { background-color:#f7f7f7; }
.boardLineList .outBg { background-color:#ffffff; }
.boardLineList { background-color:#c5c5c5; }
</style>
<script src="${pageContext.request.contextPath}/resources/scripts/bootstrap.min.js"></script>
<link href="${pageContext.request.contextPath}/resources/css/bootstrap.min.css" rel="stylesheet">
</head>

<body>
<div class="container">
<form class="form" action="${pageContext.request.contextPath}/board/writeForm.do">

<div id="body">
<div id="contents">

		<div id="boardList">
			<table class="table table-hover" width="50%" class="boardList" >
				<colgroup>
					<col width="5%">
					<col width="5%">
					<col width="7%">

					<col width="10%">
					<col width="10%">
				</colgroup>
				<tr>
					<th></th>
					<th>글번호</th>
					<th>제목</th>
					<th>내용</th>
				</tr>
				<c:forEach var="b" items="${list }">

				<tr>
					<td><img src="${b.img_path}" style="width:60px;height:60px"></td>
					<td>${b.num}</td>
					<td><a href="${pageContext.request.contextPath}/board/read.do?num=${b.num}">${b.title}</a></td>

					<td>${b.content}</td>
				</tr>
				
				</c:forEach>
			</table>
			<input class="btn btn-default" type="submit" value="글쓰기">
			
		</div>
		</div>
		</div>
</form>
</div>
</body>
</html>