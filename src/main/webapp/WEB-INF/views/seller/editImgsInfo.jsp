<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>사진 정보 수정</title>
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/scripts/objectManager.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/scripts/httpRequest.js"></script>
<script type="text/javascript">
	var numOfImgUpload = 0;
	var isFormOpened = false;
	
	/* function deleteImg(num, prod_num) {
		sendRequest('${pageContext.request.contextPath}/seller/deleteImg.do', 'num='+num+'&prodNum='+prod_num, 'refreshImg', 'post');
	}
	
	function refreshImg() {
		if (httpRequest.readyState == 4) {
			if (httpRequest.status == 200) {
				var num = eval('('+httpRequest.responseText+')');
				removeObject('img_'+num);
			} else {
				alert("실패: " + httpRequest.status);
			}
		}
	} */
	
	function addMoreImg() {
		if(numOfImgUpload < 8 && !isFormOpened) {
			var obj = makeObject('uploadImgs', null, 'p', null);
			makeObject(obj, null, 'input', null, ['type', 'file'], ['name', 'img']);
			numOfImgUpload += 1;			
		}
	}
</script>
<script src="${pageContext.request.contextPath}/resources/scripts/bootstrap.min.js"></script>
<link href="${pageContext.request.contextPath}/resources/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<jsp:include page="../action.jsp"></jsp:include>
<div id='main' class="container">
	<c:forEach var='img' items='${PROD_IMG_LIST }'>
	<p id='img_${img.num }'><img src="${img.path }" height='400'> <input type='button' value='삭제' onclick='location.href="${pageContext.request.contextPath}/seller/editImgsInfoForm.do?num=${PROD_NUM }&img_num=${img.num }"'></p>
	<script type="text/javascript">numOfImgUpload += 1;</script>
	</c:forEach>
	<p>상품 이미지 업로드 <input type='button' value='새로운 이미지 넣기' onclick='addMoreImg()'></p>
	<form class="form" action="${pageContext.request.contextPath }/seller/addNewImgs.do" name='imgForm' enctype='multipart/form-data' method='post'>
		<div id='uploadImgs'>
		</div>
		<input type='hidden' name='num' value='${PROD_NUM }'>
		<p><input class="btn btn-default" type='submit' value='이미지 정보 수정'> <input type='button' value='돌아가기' onclick='location.href="${pageContext.request.contextPath}/seller/productDetail.do?num=${PROD_NUM }"'></p>
	</form>
</div>
</body>
</html>