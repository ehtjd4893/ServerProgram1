<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<script src="https://code.jquery.com/jquery-3.6.0.min.js" integrity="sha256-/xUj+3OJU5yExlq6GSYGSHk7tPXikynS7ogEvDej/m4=" crossorigin="anonymous"></script>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	<script>
		$(function(){
			$('#f').on('submit',function(){
				if($('#id').val() == '' || $('#name').val() == ''){
					alert('가입 정보를 모두 입력하세요.');
					event.preventDefault();
					return false;
				}
				
				$('#f').submit();
			})
			$('#goBack').on('click',function(){
				history.back();
			})
		})
	</script>
</head>
<body>
	<h1>회원 가입 폼</h1>
	<form id="f" action="join.do" method="post">
		아이디 <input type="text" id="id" name="id" placeholder="ID"><br>
		이름 <input type="text" id="name" name="name" placeholder="이름"><br>
		<button>회원가입</button><input type="button" id="goBack" value="돌아가기">
	</form>
</body>
</html>