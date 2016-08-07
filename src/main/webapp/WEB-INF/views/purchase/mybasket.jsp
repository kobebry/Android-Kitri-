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
	function order_do(str){
		if(str == 'cancel'){
			location.href = "${pageContext.request.contextPath}/viewcont/main.do";
		}else{
			var length = document.getElementsByName("chkOrder").length;
			var chk = document.getElementsByName("chkOrder");
			var blist = new Array();
			var count = 0;
			//alert(chk[1].value);
			for(var i  = 0 ; i < length ; i++){
				if(chk[i].checked == true){
					blist[count++] = chk[i].value;
				}
			}
			location.href = "${pageContext.request.contextPath}/custcont/orderProducts.do?blist="+blist;
		}
	}
</script>
<script src="${pageContext.request.contextPath}/resources/scripts/bootstrap.min.js"></script>
<link href="${pageContext.request.contextPath}/resources/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
	<jsp:include page="../action.jsp"></jsp:include>
<div class="container">
	<h3>장바구니</h3>	
	<div>
		<table class="table table-hover" id="orderInfoTable">
			<thead>
				<tr>
					<th>선택</th>
					<th>상품번호</th>
					<th>상품정보</th>
					<th>상품금액</th>
					<th>수량</th>
				</tr>
			</thead>
			<c:choose>
				<c:when test="${BLIST eq null}">
					<tbody>
						<tr><td colspan="5">장바구니에 등록된 상품이 없습니다</td></tr>
					</tbody>
				</c:when>
				<c:otherwise>
					<tbody>
						<c:forEach var="blist" items="${BLIST}">
							<tr>
								<td><input type="checkbox" name="chkOrder" value="${blist.num}"></td>
								<td><a href="">${blist.num}</a></td>
								<td>${blist.name}/옵션 : ${blist.options}</td>
								<td>${blist.price+blist.add_price}</td>
								<td>${blist.amount}</td>
							</tr>
						</c:forEach>
					</tbody>
					<tfoot>
						<tr>
							<td colspan="5">
								<input class="btn btn-default" type="button" value="주문하기" onclick="order_do('order')">
								<input class="btn btn-default" type="button" value="취소" onclick="order_do('cancel')">
							</td>
						</tr>
					</tfoot>
				</c:otherwise>
			</c:choose>
		</table>
	</div>
</div>
</body>
</html>