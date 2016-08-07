<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>상품 기본 정보 수정 - ${PRODUCT.name }</title>
<script type="text/javascript">
	function showDetailCategory(form) {
		form.category_num.selectedIndex = 0;
		if(form.parent_category_num.selectedIndex == 0) {
			form.category_num.style.visibility = 'hidden';
		} else {
			for(var i = 0; i < form.category_num.options.length; i++) {
				if(form.category_num.options[i].id != 'category_' + form.parent_category_num.options[form.parent_category_num.selectedIndex].value) {
					form.category_num.options[i].style.display = 'none';
				} else {
					form.category_num.options[i].style.display = 'block';
				}
			}
			form.category_num.style.visibility = 'visible';
		}
	}
</script>
<script src="${pageContext.request.contextPath}/resources/scripts/bootstrap.min.js"></script>
<link href="${pageContext.request.contextPath}/resources/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<jsp:include page="../action.jsp"></jsp:include>
<div id='main' class="container">
	<form class="form" action="${pageContext.request.contextPath }/seller/editDefaultInfo.do" name="editForm">
	<p>상품명: <input type='text' value='${PRODUCT.name }' name='name'></p>
	<p>카테고리: 
	<select name='parent_category_num' onchange='showDetailCategory(this.form)'>
		<c:forEach var='category' items='${CATE_LIST }'>
			<c:if test="${category.parent_category_num eq 0}"><option value='${category.num }' <c:if test="${category.num eq PARENT_CATE_NUM}">selected='selected'</c:if>>${category.name }</option></c:if>
		</c:forEach>
	</select>

	<select name='category_num' id='category_num' style='visibility:visible'>
		<option value="-1" id="1">------</option>
		<c:forEach var='category' items='${CATE_LIST }'>
			<c:if test="${category.parent_category_num ne 0}"><option value='${category.num }' id="category_${category.parent_category_num }" <c:if test="${category.num eq PRODUCT.num }">selected="selected"</c:if>>${category.name }</option></c:if>
		</c:forEach>
	</select>
	</p>
	<p>판매 기본 가격: <input type='text' value='${PRODUCT.price }' name='price'>
	<p>상품 설명</p>
	<textarea rows="10" cols="100" name='details'>${PRODUCT.details }</textarea>
	<p>원산지: <input type="text" value="${PRODUCT.origin }" name='origin'></p>
	<p>제조일자: <input type="date" value="${PRODUCT.made_date }" name='made_date'></p>
	<p>무게: <input type='text' value='${PRODUCT.weight }' name='weight'></p>
	<input type='hidden' value='${PRODUCT.num }' name='num'>
	<p><input class="btn btn-default" type='submit' value='수정'></p>
	</form>
</div>
</body>
</html>