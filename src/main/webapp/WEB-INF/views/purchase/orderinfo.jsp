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
	
</script>
<script src="${pageContext.request.contextPath}/resources/scripts/bootstrap.min.js"></script>
<link href="${pageContext.request.contextPath}/resources/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
	<jsp:include page="../action.jsp"></jsp:include>
<div  class="container">
	<h3>진행중인 주문 목록</h3>	
	<div>
		<table class="table table-hover" id="orderInfoTable" style="width:100%; text-align:center;">
			<thead>
				<tr>
					<th>주문번호</th>
					<th>주문상품정보</th>
					<th>상품금액</th>
					<th>수량</th>
					<th>주문일자</th>
					<th>주문상태</th>
				</tr>
			</thead>
			<tbody>
				<c:choose>
					<c:when test="${OLIST eq null}"><tr><td colspan="6">주문중인 상품이 없습니다</td></tr></c:when>
					<c:otherwise>
						<c:forEach var="olist" items="${OLIST}">
					<tr>
						<td>${olist.num}</td>
						<td><a href="${pageContext.request.contextPath}/viewcont/showitem.do?prod_num=${olist.prod_num}">${olist.prod_name}</a>/옵션 : ${olist.opt_name}</td>
						<td>${olist.price+(olist.additional_price*olist.amount)}</td>
						<td>${olist.amount}</td>
						<td>${olist.order_date}</td>
						<td>
							<c:choose>
								<c:when test="${olist.status == 1}">결제완료</c:when>
								<c:when test="${olist.status == 2}">결제완료</c:when>
								<c:when test="${olist.status == 3}">배송준비중</c:when>
								<c:when test="${olist.status == 4}">배송중</c:when>
								<c:when test="${olist.status == 5}">배송완료</c:when>
								<c:when test="${olist.status == 6}">구매 확정</c:when>
								<c:when test="${olist.status == 7}">환불 요청</c:when>
								<c:when test="${olist.status == 8}">환불 승인</c:when>
								<c:when test="${olist.status == 9}">환불 거부</c:when>
								<c:otherwise>환불완료</c:otherwise>
							</c:choose>
						</td>
					</tr>
				</c:forEach>
					</c:otherwise>
				</c:choose>
			</tbody>
		</table>
	</div>
	<div>
		<h3>완료된 주문목록</h3>
		<table class="table table-hover" id="orderInfoTable" style="width:100%; text-align:center;">
			<thead>
				<tr>
					<th>주문번호</th>
					<th>주문상품정보</th>
					<th>상품금액</th>
					<th>수량</th>
					<th>주문일자</th>
					<th>주문상태</th>
				</tr>
			</thead>
			<tbody>
				<c:choose>
					<c:when test="${TOLIST eq null}"><tr><td colspan="6">주문중인 상품이 없습니다</td></tr></c:when>
					<c:otherwise>
						<c:forEach var="tolist" items="${TOLIST}">
					<tr>
						<td>${tolist.num}</td>
						<td><a href="${pageContext.request.contextPath}/viewcont/showitem.do?prod_num=${tolist.prod_num}">${tolist.prod_name}</a>/옵션 : ${tolist.opt_name}</td>
						<td>${tolist.price+(tolist.additional_price*tolist.amount)}</td>
						<td>${tolist.amount}</td>
						<td>${tolist.order_date}</td>
						<td>
							<c:choose>
								<c:when test="${tolist.status == 5}">배송완료</c:when>
								<c:when test="${tolist.status == 6}">구매 확정</c:when>
								<c:when test="${tolist.status == 7}">환불 요청</c:when>
								<c:when test="${tolist.status == 8}">환불 승인</c:when>
								<c:when test="${tolist.status == 9}">환불 거부</c:when>
								<c:otherwise>환불완료</c:otherwise>
							</c:choose>
						</td>
					</tr>
				</c:forEach>
					</c:otherwise>
				</c:choose>
			</tbody>
		</table>
	</div>
</div>
</body>
</html>