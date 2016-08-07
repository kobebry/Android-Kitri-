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
	function payment(form) {
		if(confirm('결제하시겠습니까?')) {
			form.submit();
		}
	}
</script>
<script src="${pageContext.request.contextPath}/resources/scripts/bootstrap.min.js"></script>
<link href="${pageContext.request.contextPath}/resources/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<div id="main">
	<jsp:include page="../action.jsp"></jsp:include>
	<div class="container">
	<h3>주문결제</h3>
	
	<div id="productInfo">
	<table class="table">
		<tr><td><img class="img-thumbnail" src="${PROD_IMG.path }" height="50"></td><td>${PRODUCT.name }
		<c:set var="totalAmount" value="0"/>
		<c:forEach var="basket" items="${BASKETS }">
			<br>${basket.prod_opt_options}
			<c:set var="totalAmount" value="${totalAmount + basket.amount }"/>
		</c:forEach>
		</td><td>총 ${totalAmount}건</td></tr>
	</table>
	</div>
	
	<form action="${pageContext.request.contextPath }/custcont/payment.do">
	<div id='addressInfo'>
		<p>주소: <input type='text' name='address' value='${MEMBER.address }'></p>
		<p>전화번호: <input type='text' name='phone' value='${MEMBER.phone }'></p>
	</div>
	
	<div id='paymentInfo'>
		<h3>총 결제금액: ${PRICE}</h3>
		<p><input class="btn btn-info" type='button' value='결제' onclick='payment(this.form)'></p> 
	</div>
	<c:set var="i" value="0"/>
	<c:forEach var="basket" items="${BASKETS }">
		<input type='hidden' name='basketList[${i }].customer_num' value='${MEMBER.num }'>
		<input type='hidden' name='basketList[${i }].prod_num' value='${PRODUCT.num }'>
		<input type='hidden' name='basketList[${i }].prod_opt_num' value='${basket.prod_opt_num}'>
		<input type='hidden' name='basketList[${i }].amount' value='${basket.amount}'>
		<c:set var="i" value="${i+1 }"/>
	</c:forEach>
	
	</form>
	</div>
</div>
	
</body>
</html>