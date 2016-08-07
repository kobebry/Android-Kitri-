<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>새 제품 올리기</title>
<script type="text/javascript" src="${pageContext.request.contextPath }/resources/scripts/objectManager.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath }/resources/scripts/httpRequest.js"></script>
<script type="text/javascript">
	var numOfImgUpload = 0;
	
	function addMoreImg() {
		//document.productForm.enctype='multipart/form-data';
		if(numOfImgUpload < 8) {
			var obj = makeObject('uploadImgs', null, 'p', null);
			makeObject(obj, null, 'input', null, ['type', 'file'], ['name', 'img']);
			numOfImgUpload += 1;			
		}
	}
	
	function addOption() {
		window.open('${pageContext.request.contextPath}/seller/setOptions.do?level=0', '_blank', 'width=300,height=700,menubar=no,toolbar=no,location=no,status=no,fullscreen=no');
	}
	
	function test() {
		window.open('${pageContext.request.contextPath}/seller/test.do?level=0', '_blank', 'width=300,height=700,menubar=no,toolbar=no,location=no,status=no,fullscreen=no');
	}
	
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
<form class="form" action="${pageContext.request.contextPath }/seller/addProduct.do" name='productForm' method="post" enctype='multipart/form-data'>
	<p>제품명: <input type='text' name='name'></p>
	<p>카테고리 선택: 
	<select name='parent_category_num' onchange='showDetailCategory(this.form)'>
		<c:forEach var='category' items='${CATE_LIST }'>
			<c:if test="${category.parent_category_num eq 0}"><option value='${category.num }'>${category.name }</option></c:if>
		</c:forEach>
	</select>

	<select name='category_num' id='category_num' style='visibility:hidden'>
		<option value="-1" id="1">------</option>
		<c:forEach var='category' items='${CATE_LIST }'>
			<c:if test="${category.parent_category_num ne 0}"><option value='${category.num }' id="category_${category.parent_category_num }">${category.name }</option></c:if>
		</c:forEach>
	</select>
	</p>
	<p>상품 이미지 업로드 <input type='button' value='이미지 추가' onclick='addMoreImg()'></p>
	<div id='uploadImgs'>
	</div>
	<p>가격: <input type='text' name='price'></p>
	<p><input type='button' value='옵션을 추가하려면 눌러주세요.' onclick="addOption()"></p>
	<div id='options' style='visibility:hidden;'>
		<table id='optionsTable'>
			<thead id='optionsTableHead'>
				<tr><th>옵션명</th><th>수량</th><th>추가가격</th></tr>
			</thead>
			<tbody id='optionsTableBody'>
			</tbody>
		</table>
	</div>
	
	<p>제품설명</p>
	<p><textarea rows="10" cols="100" name='details'></textarea></p>
	
	<p>원산지: <input type='text' name='origin'></p>
	<p>제조일자: <input type='date' name='made_date'></p>
	<p>무게: <input type='text' name='weight'></p>
	
	<p><input type='submit' value='저장하기'> <input type='button' value='판매자 페이지로 돌아가기' onclick='location.href="${pageContext.request.contextPath}/seller/main.do"'></p>
</form>
</div>
</body>
</html>