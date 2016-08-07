<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Item ::</title>
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/scripts/objectManager.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/scripts/httpRequest.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/scripts/action.js"></script>
<script type="text/javascript">
	var numOfOptionForm = 0;
	var numOfOptions = 0;
	
	function add_price(){
		var slc = document.getElementById("options");
		document.getElementById("totalPrice").innerHTML = "가격 : <font color=red>"+slc.options[slc.selectedIndex].value+"</font>";
	}
	function add_basket(form){
		if('${sessionScope.num}' == '') {
			alert('로그인 해주세요')
			location.href="${pageContext.request.contextPath}/viewcont/loginform.do";
		} else {
			var params = "prod_num="+form.prod_num.value+"&prod_opt_num="+form.opt_num.value;
			sendRequest("${pageContext.request.contextPath}/custcont/addbasket.do", params, add_basket_chk, "POST");			
		}
	}
	function add_basket_chk(){
		if (httpRequest.readyState == 4) {
			if (httpRequest.status == 200) {
				var result = httpRequest.responseText;
				if(result == 1){
					if(confirm('장바구니에 추가되었습니다. 장바구니로 이동하시겠습니까?') == true){
						location.href="${pageContext.request.contextPath}/viewcont/mybasketform.do";
						form.submit();
					}
				}
			}
		}
	}
	
	function selectedOptions(form, price, prod_num) {
		numOfOptions += 1;
		var params = "options=";
		if(numOfOptionForm > 1) {
			for(var i = 0; i < form.options.length; i++) {
				params += form.options[i].value;
				if(i != form.options.length - 1) {
					params += '-';
				}
			}
		} else {
			params += form.options.value;
		}
		params += "&prod_num=" + prod_num;
		sendRequest("${pageContext.request.contextPath}/seller/getProductOpt.do", params, setTotalPrice, "POST");
	}
	
	function setTotalPrice() {
		if (httpRequest.readyState == 4) {
			if (httpRequest.status == 200) {
				var result = eval('('+httpRequest.responseText+')');
				document.getElementById('totalPrice').innerHTML = result.additional_price + Number(document.getElementById('totalPrice').innerHTML);
				var form = document.orderForm;
				var pTag = makeObjectAtFirst(form, 'option_' + result.num, 'p', null);
				makeObject(pTag, null, 'label', result.options);
				pTag.innerHTML += ' 수량: ';
				makeObject(pTag, null, 'input', null, ['type', 'number'], ['name', 'amount'], ['min', '1'], ['max', result.amount], ['value', '1']);
				pTag.innerHTML += ' ';
				makeObject(pTag, null, 'input', null, ['type', 'button'], ['value', '취소'], ['onclick', 'cancelOption("option_'+result.num+'", '+result.additional_price+')']);
				makeObject(pTag, null, 'input', null, ['type', 'hidden'], ['name', 'opt_num'], ['value', result.num]);
			}
		}
	}
	
	function cancelOption(obj, price) {
		removeObject(obj);
		document.getElementById('totalPrice').innerHTML = Number(document.getElementById('totalPrice').innerHTML) - price;
		numOfOptions -= 1;
	}
	
	function orderProduct(form) {
		if('${sessionScope.num}' == '') {
			alert('로그인 해주세요')
			location.href="${pageContext.request.contextPath}/viewcont/loginform.do";
		} else {
			if(numOfOptions == 0) {
				alert('옵션을 선택하세요');
			} else {
				form.submit();
			}
		}
	}
</script>
<script src="${pageContext.request.contextPath}/resources/scripts/bootstrap.min.js"></script>
<link href="${pageContext.request.contextPath}/resources/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
	<jsp:include page="../action.jsp"></jsp:include>
<div class="container">
	<table class="table">
		<thead class="table-hover">
			<tr>
				<td>${P.name}</td>
			</tr>
		</thead>
		<tbody>
			<tr>
				<!-- 이미지 추가 부분 -->
				<td rowspan="4" id="imgSpace" style='width:400px; height:400px;'>
				<img src="${P.piList[0].path }" style='width:400px; padding-left: 10px; padding-right: 10px; padding-bottom: 10px;'>
				</td>
				<td>기본가격 : ${P.price}</td>
			</tr>
			<tr>
				<td>옵션</td>
			</tr>
			<tr>
				<td>
				<form name="optionForm">
				<c:forEach var="option" items="${OPTIONS}">
					<select id='options'>
						<c:forEach var="attr" items="${option }">
						<option>${attr }</option>
						
						</c:forEach>
					</select>
					<script type="text/javascript">numOfOptionForm += 1;</script>
				</c:forEach>
				<input type='button' value='선택' onclick='selectedOptions(this.form, ${P.price}, ${P.num })'>
				</form>
				</td>
			</tr>
			<tr>
				<td>최종가격 : <span id="totalPrice">${P.price}</span></td>
			</tr>
		</tbody>
		<tfoot>
			<tr>
				<td colspan='2'>
				<form action="${pageContext.request.contextPath }/custcont/orderProduct.do" name='orderForm'>
					<input type='hidden' name='prod_num' value='${P.num}'>
					<input class="btn btn-info" type="button" value="장바구니" onclick="add_basket(this.form)"> <input class="btn btn-info" type="button" value="구매하기" onclick="orderProduct(this.form)">
				</form>
				</td>
			</tr>
		</tfoot>
	</table>
	<div>
	<h4>제품 설명<small>이미지 첨부</small></h4>
	${P.details}
	</div>
	
	<div>
		<h4>판매자 정보</h4>
		<table class="table table-hover">
			<tr>
				<td>상호  ${P.seller_name}</td>
			</tr>
		</table>
	</div>
	<div>
		<h4>상품 후기 </h4>
		<c:choose>
			<c:when test="${BOLIST eq null }">
				아직 후기가 없습니다  <br>
			<form action="${pageContext.request.contextPath}/board/writeForm.do">
				<input type="hidden" name="prod_num" value="${P.num}">										
				<c:if test="${null ne sessionScope.num}">
					<input class="btn btn-info" type="submit" value="글쓰기">
				</c:if>		

			</form>	
			</c:when>
			<c:otherwise>
			
			<form action="${pageContext.request.contextPath}/board/writeForm.do">			
				<table width="50%" class="boardList" >
				<colgroup>
					<col width="5%">
					<col width="5%">
					<col width="7%">

					<col width="10%">
					<col width="10%">
				</colgroup>
				<tr>
					<th></th>
					<th>글번호 </th>
					<th>제목</th>
					<th>내용</th>
				</tr>
					<c:forEach var="bolist" items="${BOLIST}">

				<tr>
				
					<td><img src="${bolist.img_path}" style="width:60px;height:60px"></td>
					<td>${bolist.num}</td>
					<td><a href="${pageContext.request.contextPath}/board/read.do?num=${bolist.num}&prod_num=${P.num}">${bolist.title}</a></td>

					<td>${bolist.content} </td>
				</tr>
				<input type="hidden" name="prod_num" value="${P.num}">			
				</c:forEach>
				</table>
				<c:if test="${null ne sessionScope.num}">
				<input  class="btn btn-info" type="submit" value="글쓰기">
				</c:if>				
				</form>

			</c:otherwise>
		</c:choose>
	</div>
</div>
</body>
</html>