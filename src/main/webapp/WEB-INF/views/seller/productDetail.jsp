<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>${PRODUCT.name }</title>
<script src="${pageContext.request.contextPath}/resources/scripts/bootstrap.min.js"></script>
<link href="${pageContext.request.contextPath}/resources/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<jsp:include page="../action.jsp"></jsp:include>
<div id='main' class="container">
	<div id='productDefaultInfo'>
		<p>상품번호: ${PRODUCT.num }</p>
		<p>상품명: ${PRODUCT.name }</p>
		<p>카테고리번호: ${PRODUCT.category_num }</p>
		<p>판매일자: ${PRODUCT.sell_date }</p>
		<p>판매 기본 가격: ${PRODUCT.price }</p>
		<p>상품 설명</p>
		<div id='productExplanation'>
			${PRODUCT.details}
		</div>
		<p>원산지: ${PRODUCT.origin }</p>
		<p>제조일자: ${PRODUCT.made_date }</p>
		<p>무게: ${PRODUCT.weight }</p>
		<p><input type='button' value='기본정보 수정' onclick='location.href="${pageContext.request.contextPath}/seller/editDefaultInfoForm.do?num=${PRODUCT.num }"'></p>
	</div>
	
	<div id='productOptionInfo'>
		<c:forEach var='productOption' items='${PROD_OPTS }'>
		<p>상품옵션: ${productOption.options }, 상품수량: ${productOption.amount }, 추가가격: ${productOption.additional_price }</p>
		</c:forEach>
		<p><input type='button' value='옵션정보 수정' onclick='location.href="${pageContext.request.contextPath}/seller/editOptionsInfoForm.do?num=${PRODUCT.num }"'></p>
	</div>
	
	<div id='productImgInfo'>
		<c:forEach var='productImg' items='${PROD_IMGS }'>
		<p><img src='${productImg.path }' style="width:300px;"></p>
		</c:forEach>
		<p><input type='button' value='사진 수정' onclick='location.href="${pageContext.request.contextPath}/seller/editImgsInfoForm.do?num=${PRODUCT.num }"'></p>
	</div>
	
	<p><input class="btn btn-default" type='button' value='돌아가기' onclick="location.href='${pageContext.request.contextPath}/seller/main.do'"></p>
</div>
</body>
</html>