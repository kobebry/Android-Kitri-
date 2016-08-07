<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>옵션 설정</title>
<script type="text/javascript" src="${pageContext.request.contextPath }/resources/scripts/objectManager.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath }/resources/scripts/httpRequest.js"></script>
<script type="text/javascript">
	var allOptions = new Array();
	var optionIndexes = '';

	function addSelection(form, seq) {
		removeObject(document.getElementById('addButton_' + seq));
		var pTag = makeObjectBeforeTarget(document.getElementById('option_'+seq).nextSibling, 'option_'+(seq+1), 'p', null);
		makeObject(pTag, null, 'input', null, ['name', 'option'], ['type', 'text'], ['placeholder', 'Option ' + (seq+1)]);
		pTag.innerHTML += ' ';
		makeObject(pTag, null, 'input', null, ['class','btn btn-default'],['type', 'button'], ['value', '추가'], ['onclick', 'addSelection(this.form, '+(seq+1)+')'], ['id', 'addButton_'+(seq+1)]);
	}
	
	function addDataToArray(form) {
		if(optionIndexes.length > 0) {
			optionIndexes += '/'
		}
		if(allOptions.length < 1) {
			optionIndexes += form.option_name.value + ',';
			for(var i = 0; i < form.option.length; i++) {
				allOptions.push(form.option[i].value);
				optionIndexes += form.option[i].value + ',';
			}
		} else {
			var tempArr = new Array();
			optionIndexes += form.option_name.value + ',';
			for(var i = 0; i < form.option.length; i++) {
				optionIndexes += form.option[i].value + ',';
			}
			for(var i = 0; i < allOptions.length; i++) {
				for(var j = 0; j < form.option.length; j++) {
					tempArr.push(allOptions[i] + ' / ' + form.option[j].value);
				}
			}
			
			allOptions = tempArr;
		}
	}
	
	
	function sendToParent(form) {
		addDataToArray(form);
		var tableBodyAtParent = parent.opener.document.getElementById('optionsTableBody');
		for(var i = 0; i < allOptions.length; i++) {
			var trTag = makeObject(tableBodyAtParent, null, 'tr', null);
			var tdTag = makeObject(trTag, null, 'td', null);
			makeObject(tdTag, null, 'input', null, ['type', 'text'], ['name', 'poList['+i+'].options'], ['readonly', 'readonly'], ['value', allOptions[i]]);
			tdTag = makeObject(trTag, null, 'td', null);
			makeObject(tdTag, null, 'input', null, ['type', 'text'], ['name', 'poList['+i+'].amount']);
			tdTag = makeObject(trTag, null, 'td', null);
			makeObject(tdTag, null, 'input', null, ['type', 'text'], ['name', 'poList['+i+'].additional_price']);	
		}
		var parentForm = parent.opener.document.productForm;
		makeObject(parentForm, null, 'input', null, ['type', 'hidden'], ['name', 'option_indexes'], ['value', optionIndexes]);
		parent.opener.document.getElementById('options').style.visibility = 'visible';
		window.self.close();
	}
	
	function addOption(form) {
		addDataToArray(form);
		clearForm(form);
	}
	
	function optionCancel() {
		window.self.close();
	}
	
	function clearForm(form) {
		var target = removeObject(form);
		var form = makeObject(target, null, 'form', null, ['name', 'optionForm']);
		var pTag = makeObject(form, null, 'p', '옵션명: ');
		makeObject(pTag, null, 'input', null, ['type', 'text'], ['name', 'option_name']);
		makeObject(form, null, 'p', '옵션을 입력하세요.');
		pTag = makeObject(form, null, 'p', null);
		makeObject(pTag, null, 'input', null, ['type', 'text'], ['name', 'option'], ['placeholder', 'Option 1']);
		pTag = makeObject(form, 'option_2', 'p', null);
		makeObject(pTag, null, 'input', null, ['type', 'text'], ['name', 'option'], ['placeholder', 'Option 2']);
		pTag.innerHTML += ' ';
		makeObject(pTag, 'addButton_2', 'input', null, ['class','btn btn-default'],['type', 'button'], ['value', '추가'], ['onclick', 'addSelection(this.form, 2)']);
		pTag = makeObject(form, null, 'p', null);
		makeButton(pTag, null, '완료', 'sendToParent', 'this.form');
		pTag.innerHTML += ' ';
		makeButton(pTag, null, '옵션 추가', 'addOption', 'this.form');
		pTag.innerHTML += ' ';
		makeButton(pTag, null, '취소', 'optionCancel');
	}
</script>
<script src="${pageContext.request.contextPath}/resources/scripts/bootstrap.min.js"></script>
<link href="${pageContext.request.contextPath}/resources/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<div id='main' class="container">
	<form class="form" action="" name='optionForm'>
		<p>옵션명: <input type='text' name='option_name'></p>
		<p>옵션을 입력하세요.</p>
		<p><input type='text' name='option' placeholder='Option 1'></p>
		<p id='option_2'><input type='text' name='option' placeholder='Option 2'> <input type='button' id='addButton_2' value='추가' onclick='addSelection(this.form, 2)'></p>
		<p><input class="btn btn-default" type='button' value='완료' onclick='sendToParent(this.form)'> <input class="btn btn-default" type='button' value='옵션 추가' onclick='addOption(this.form)'> <input class="btn btn-default" type='button' value='취소' onclick='optionCancel()'></p>
	</form>
</div>
</body>
</html>