<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

	<link rel="stylesheet" href="//code.jquery.com/ui/1.13.0/themes/base/jquery-ui.css">	
	<!-- date picker -->
	<script src="https://code.jquery.com/ui/1.13.0/jquery-ui.js"></script>
	<!-- 우편번호 -->
	<script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
	
</head>
<body>
	<h1>회원정보 수정</h1>
	<form class="body container" method="post" action="<%=request.getContextPath()%>/mypage">
		<div class="form-group">
			<input type="text" class="form-control" readonly value="${user.me_id}">
		</div>
		<div class="form-group">
			<input type="password" class="form-control"  placeholder="비밀번호" name="me_pw" id="me_pw">
		</div>
		<div class="form-group">
			<input type="password" class="form-control" placeholder="비밀번호 확인" name="pw2">
		</div>
		<div class="form-group">
			<input type="text" class="form-control"  name="me_name" value="${user.me_name}">
		</div>
		<div class="form-group">
			<input type="text" class="form-control"  name="me_birth" id="birth" value="${user.me_birth}">
		</div>
		<div class="form-group">
			<input type="text" class="form-control"  name="me_phone" value="${user.me_phone}"> 
		</div>
		<div class="form-group">
			<div class="form-check-inline">
				<label class="form-check-label">
					<input type="radio" class="form-check-input" name="me_gender" value="남성" <c:if test="${user.me_gender == '남성'}">checked</c:if>>남성
				</label>
			</div>
			<div class="form-check-inline">
				<label class="form-check-label">
					<input type="radio" class="form-check-input" name="me_gender" value="여성" <c:if test="${user.me_gender == '여성'}">checked</c:if>>여성
				</label>
			</div>
			<label id="me_gender-error" class="error" for="me_gender"></label>
		</div>
		<div class="form-group">
			<div class="form-inline mb-2">
				<input type="text" id="postcode" placeholder="우편번호" class="form-control col-6">
				<input type="button" onclick="execDaumPostcode()" value="우편번호 찾기" class="form-control col-6">
			</div>
			<input type="text" id="address" placeholder="주소" class="form-control mb-2">
			<input type="text" id="detailAddress" placeholder="상세주소" class="form-control mb-2">
			<input type="hidden" name="me_address">
			
			<button class="btn btn-outline-success col-12 btn_mod">회원정보수정</button>
		</div>			
	</form>		
	<script>
		$('.btn_mod').click(function () {

			var address = $('#address').val() + ' ' +$('#detailAddress').val();
			$('[name=me_address]').val(address);
			
			var me_pw = $('[name=me_pw]').val();
			if(address == '' || me_pw == '')
			{
				return confirm('비밀번호 / 주소를 입력하지 않으면 변경되지 않습니다');
			}
			
		});
		
		$('#birth').datepicker();
		$('#birth').datepicker('option','dateFormat', 'yy-mm-dd');
		$('#birth').val('${user.me_birth_str}');
		
		function execDaumPostcode() {
			new daum.Postcode({
				oncomplete: function(data) {
					var addr = ''; // 주소 변수
					var extraAddr = ''; // 참고항목 변수
					if (data.userSelectedType === 'R') { // 사용자가 도로명 주소를 선택했을 경우
						addr = data.roadAddress;
					} else { // 사용자가 지번 주소를 선택했을 경우(J)
						addr = data.jibunAddress;
					}
	
					// 사용자가 선택한 주소가 도로명 타입일때 참고항목을 조합한다.
					if(data.userSelectedType === 'R'){
						// 법정동명이 있을 경우 추가한다. (법정리는 제외)
						// 법정동의 경우 마지막 문자가 "동/로/가"로 끝난다.
						if(data.bname !== '' && /[동|로|가]$/g.test(data.bname)){
								extraAddr += data.bname;
						}
						// 건물명이 있고, 공동주택일 경우 추가한다.
						if(data.buildingName !== '' && data.apartment === 'Y'){
								extraAddr += (extraAddr !== '' ? ', ' + data.buildingName : data.buildingName);
						}					
					} 
					// 우편번호와 주소 정보를 해당 필드에 넣는다.
					document.getElementById('postcode').value = data.zonecode;
					document.getElementById("address").value = addr;
					// 커서를 상세주소 필드로 이동한다.
					document.getElementById("detailAddress").focus();
				}
			}).open();		
		};		
	
	</script>
</body>
</html>