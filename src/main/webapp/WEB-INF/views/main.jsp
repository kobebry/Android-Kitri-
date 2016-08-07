<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Main Page::</title>
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/scripts/objectManager.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/scripts/httpRequest.js"></script>
<%-- <script type="text/javascript" src="${pageContext.request.contextPath}/resources/scripts/action.js"></script> --%>
<script type="text/javascript">
	function searchEvent(){ //검색기능 enter 와 나머지키로 구분하여 기능수행
		var params = "searchData="+encodeURIComponent(document.getElementById("search").value);
		if(event.keyCode == 13){
			location.href="${pageContext.request.contextPath}/custcont/search.do?"+params;
		}/* else{ //검색시 리스트형태로 보여주기
			sendRequest("${pageContext.request.contextPath}/cont/searchlist.do", params, callback, method);
		} */
	}
	function select_category(num){
		if(num == '1'){
			var viewcon = document.getElementById("rows1");
			viewcon.style.backgroundColor = '#9acd32';
			
			var viewdetail = document.getElementById("row1");
			viewdetail.style.display = '';
		}else if(num == '2'){
			var viewcon = document.getElementById("rows2");
			viewcon.style.backgroundColor = '#9acd32';
		}else if(num == '3'){
			var viewcon = document.getElementById("rows3");
			viewcon.style.backgroundColor = '#9acd32';
		}else if(num == '4'){
			var viewcon = document.getElementById("rows4");
			viewcon.style.backgroundColor = '#9acd32';
		}else if(num == '5'){
			var viewcon = document.getElementById("rows5");
			viewcon.style.backgroundColor = '#9acd32';
		}else if(num == '6'){
			var viewcon = document.getElementById("rows6");
			viewcon.style.backgroundColor = '#9acd32';
		}
	}
	function selectOut(num){
		var viewcon = document.getElementById("rows"+num);
		viewcon.style.backgroundColor = '#7fff00';
	}
	function action_do(str){
		if(str == 'login'){
			location.href="${pageContext.request.contextPath}/viewcont/loginform.do";
		}else if(str == 'logout'){
			location.href="${pageContext.request.contextPath}/logincont/logout.do";
		}else if(str == 'mypage'){
			location.href="${pageContext.request.contextPath}/viewcont/myform.do";
		}else if(str == 'orderInfo'){
			location.href="${pageContext.request.contextPath}/viewcont/myorderform.do";
		}
	}
</script>
<script src="${pageContext.request.contextPath}/resources/scripts/bootstrap.min.js"></script>
<link href="${pageContext.request.contextPath}/resources/css/bootstrap.min.css" rel="stylesheet">
<style type="text/css">
	#rows1, #rows2, #rows3, #rows4, #rows5, #rows6 {
		background-color:#7fff00;
	}
</style>
</head>
<body>
<jsp:include page="action.jsp"></jsp:include>
<div class="container">
	<hr>
	<div>
		<table class="table table-hover">
			<tr class="success">
				<th>브랜드패션</th>
				<th>패션의류</th>
				<th>잡화/뷰티</th>
				<th>유아동</th>
				<th>식품</th>
				<th>생필품</th>
				<th>홈데코</th>
				<th>건강</th>
			</tr>
			<tr>
				<td>
					<a href="${pageContext.request.contextPath}/viewcont/catesearch.do?type=17">브랜드 남성의류</a><br>
					<a href="${pageContext.request.contextPath}/viewcont/catesearch.do?type=18">브랜드 진/캐쥬얼</a><br>
					<a href="${pageContext.request.contextPath}/viewcont/catesearch.do?type=19">브랜드 아동패션</a><br>
					<a href="${pageContext.request.contextPath}/viewcont/catesearch.do?type=20">브랜드 신발/가방</a><br>
					<a href="${pageContext.request.contextPath}/viewcont/catesearch.do?type=21">쥬얼리/시계</a><br>
					<a href="${pageContext.request.contextPath}/viewcont/catesearch.do?type=22">아웃도어</a><br>
					<a href="${pageContext.request.contextPath}/viewcont/catesearch.do?type=23">브랜드 스포츠패션</a><br>
				</td>
				<td>
					<a href="${pageContext.request.contextPath}/viewcont/catesearch.do?type=24">여성의류</a><br>
					<a href="${pageContext.request.contextPath}/viewcont/catesearch.do?type=25">남성의류</a><br>
					<a href="${pageContext.request.contextPath}/viewcont/catesearch.do?type=26">유아의류</a><br>
					<a href="${pageContext.request.contextPath}/viewcont/catesearch.do?type=27">언더웨어</a><br>
				</td>
				<td>
					<a href="${pageContext.request.contextPath}/viewcont/catesearch.do?type=28">신발</a><br>
					<a href="${pageContext.request.contextPath}/viewcont/catesearch.do?type=29">가방/잡화</a><br>
					<a href="${pageContext.request.contextPath}/viewcont/catesearch.do?type=30">아동신발</a><br>
					<a href="${pageContext.request.contextPath}/viewcont/catesearch.do?type=31">쥬얼리/시계</a><br>
					<a href="${pageContext.request.contextPath}/viewcont/catesearch.do?type=32">수입명품</a><br>
					<a href="${pageContext.request.contextPath}/viewcont/catesearch.do?type=33">화장품/향수</a><br>
					<a href="${pageContext.request.contextPath}/viewcont/catesearch.do?type=34">바디/헤어</a><br>
				</td>
				<td>
					<a href="${pageContext.request.contextPath}/viewcont/catesearch.do?type=35">기저귀/분유</a><br>
					<a href="${pageContext.request.contextPath}/viewcont/catesearch.do?type=36">육아용품</a><br>
					<a href="${pageContext.request.contextPath}/viewcont/catesearch.do?type=37">장난감</a><br>
					<a href="${pageContext.request.contextPath}/viewcont/catesearch.do?type=38">유아동의류</a><br>
					<a href="${pageContext.request.contextPath}/viewcont/catesearch.do?type=39">유아동잡화</a><br>
				</td>
				<td>
					<a href="${pageContext.request.contextPath}/viewcont/catesearch.do?type=40">신선식품</a><br>
					<a href="${pageContext.request.contextPath}/viewcont/catesearch.do?type=41">건강식품</a><br>
					<a href="${pageContext.request.contextPath}/viewcont/catesearch.do?type=42">가공식품</a><br>
					<a href="${pageContext.request.contextPath}/viewcont/catesearch.do?type=43">커피/음료</a><br>
				</td>
				<td>
					<a href="${pageContext.request.contextPath}/viewcont/catesearch.do?type=44">화장지/세제</a><br>
					<a href="${pageContext.request.contextPath}/viewcont/catesearch.do?type=45">물티슈/생리대</a><br>
					<a href="${pageContext.request.contextPath}/viewcont/catesearch.do?type=46">바디/헤어</a><br>
				</td>
				<td>
					<a href="${pageContext.request.contextPath}/viewcont/catesearch.do?type=47">가구</a><br>
					<a href="${pageContext.request.contextPath}/viewcont/catesearch.do?type=48">침구</a><br>
					<a href="${pageContext.request.contextPath}/viewcont/catesearch.do?type=49">조명/인테리어</a><br>
					<a href="${pageContext.request.contextPath}/viewcont/catesearch.do?type=50">생활용품</a><br>
					<a href="${pageContext.request.contextPath}/viewcont/catesearch.do?type=51">주방용품</a><br>
					<a href="${pageContext.request.contextPath}/viewcont/catesearch.do?type=52">이벤트용품</a><br>
				</td>
				<td>
					<a href="${pageContext.request.contextPath}/viewcont/catesearch.do?type=53">건강용품</a><br>
					<a href="${pageContext.request.contextPath}/viewcont/catesearch.do?type=54">건강식품</a><br>
					<a href="${pageContext.request.contextPath}/viewcont/catesearch.do?type=55">운동용품</a><br>
				</td>
			</tr>
			<tr class="success">
				<th>문구/취미</th>
				<th>스포츠</th>
				<th>자동차/공구</th>
				<th>가전</th>
				<th>디지털</th>
				<th>컴퓨터</th>
				<th>여행/도서</th>
				<th>디켓/e쿠폰</th>
			</tr>
			<tr>
				<td>
					<a href="${pageContext.request.contextPath}/viewcont/catesearch.do?type=56">문구/사무용품</a><br>
					<a href="${pageContext.request.contextPath}/viewcont/catesearch.do?type=57">사무기기</a><br>
					<a href="${pageContext.request.contextPath}/viewcont/catesearch.do?type=58">악기/수집</a><br>
					<a href="${pageContext.request.contextPath}/viewcont/catesearch.do?type=59">반려동물용품</a><br>
				</td>
				<td>
					<a href="${pageContext.request.contextPath}/viewcont/catesearch.do?type=60">휘트니스/수영</a><br>
					<a href="${pageContext.request.contextPath}/viewcont/catesearch.do?type=61">구기/라켓</a><br>
					<a href="${pageContext.request.contextPath}/viewcont/catesearch.do?type=62">골프</a><br>
					<a href="${pageContext.request.contextPath}/viewcont/catesearch.do?type=63">자전거/보드</a><br>
					<a href="${pageContext.request.contextPath}/viewcont/catesearch.do?type=64">캠핑/낚시</a><br>
					<a href="${pageContext.request.contextPath}/viewcont/catesearch.do?type=65">등산</a><br>
				</td>
				<td>
					<a href="${pageContext.request.contextPath}/viewcont/catesearch.do?type=66">자동차용품</a><br>
					<a href="${pageContext.request.contextPath}/viewcont/catesearch.do?type=67">타이어/부품</a><br>
					<a href="${pageContext.request.contextPath}/viewcont/catesearch.do?type=68">공구설비/자재</a><br>
				</td>
				<td>
					<a href="${pageContext.request.contextPath}/viewcont/catesearch.do?type=69">대형가전</a><br>
					<a href="${pageContext.request.contextPath}/viewcont/catesearch.do?type=70">주방가전</a><br>
					<a href="${pageContext.request.contextPath}/viewcont/catesearch.do?type=71">계절가전</a><br>
					<a href="${pageContext.request.contextPath}/viewcont/catesearch.do?type=72">생활/미용가전</a><br>
					<a href="${pageContext.request.contextPath}/viewcont/catesearch.do?type=73">음향가전</a><br>
					<a href="${pageContext.request.contextPath}/viewcont/catesearch.do?type=74">건강</a><br>
				</td>
				<td>
					<a href="${pageContext.request.contextPath}/viewcont/catesearch.do?type=75">휴대폰</a><br>
					<a href="${pageContext.request.contextPath}/viewcont/catesearch.do?type=76">카메라</a><br>
					<a href="${pageContext.request.contextPath}/viewcont/catesearch.do?type=77">테블릿</a><br>
					<a href="${pageContext.request.contextPath}/viewcont/catesearch.do?type=78">게임</a><br>
				</td>
				<td>
					<a href="${pageContext.request.contextPath}/viewcont/catesearch.do?type=79">PC</a><br>
					<a href="${pageContext.request.contextPath}/viewcont/catesearch.do?type=80">모니터/프린터</a><br>
					<a href="${pageContext.request.contextPath}/viewcont/catesearch.do?type=81">주변기기</a><br>
					<a href="${pageContext.request.contextPath}/viewcont/catesearch.do?type=82">노트북</a><br>
				</td>
				<td>
					<a href="${pageContext.request.contextPath}/viewcont/catesearch.do?type=83">여행/항공권</a><br>
					<a href="${pageContext.request.contextPath}/viewcont/catesearch.do?type=84">도서/음반</a><br>
				</td>
				<td>
					<a href="${pageContext.request.contextPath}/viewcont/catesearch.do?type=85">티켓</a><br>
					<a href="${pageContext.request.contextPath}/viewcont/catesearch.do?type=86">e쿠폰</a><br>
					<a href="${pageContext.request.contextPath}/viewcont/catesearch.do?type=87">상품권</a><br>
				</td>
			</tr>
		</table>
	</div>
	
	<div>
		<h3>새로 올라온 상품</h3>
		<c:choose>
			<c:when test="${PLIST eq null }">표시할 품목이 없습니다</c:when>
			<c:otherwise>
				<table class="table" style="width:100%;">
					<tr>
						<c:forEach var="plist" items="${PLIST}">
							<td>
								
								<a href="${pageContext.request.contextPath}/viewcont/showitem.do?prod_num=${plist.num}">
								<img src="${plist.piList[0].path}" style='width:200px'><br>
								${plist.name}
								</a><br>
								<font style="border:5;">${plist.price}</font>
							</td>
						</c:forEach>
					</tr>
				</table>
			</c:otherwise>
		</c:choose>
	</div>
	</div>
</body>
</html>