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
			$('#f').on('submit',function(event){
				if($('#id').val() == '' || $('#name').val() == ''){
					alert('아이디와 이름은 필수입니다.');
					event.preventDefault();
					return false;
				}
				
				$('#f').submit();
			})
		})
	</script>
	<style>
		a{
			color:black;
		}
		h1{
			text-align: center;
		}
		body{
			margin: 200px auto;
		}
		#f{
			width: 300px;
			margin: 0px auto;
			text-align: center;
		}
		input[type='text']{
			width:200px;
			height: 30px;
			margin-bottom: 10px;
		}
	</style>
</head>
<body>
	<h1>회원 관리 프로그램</h1>
	<form id="f" action="login_chk.do" method="post">
		<input type="text" id="id" name="id" placeholder="ID"><br>
		<input type="text" id="name" name="name" placeholder="이름"><br>
		<button>로그인</button> <a href="joinPage.do">회원가입</a>
	</form>
</body>
</html>