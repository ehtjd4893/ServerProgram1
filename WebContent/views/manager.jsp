<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
<!DOCTYPE html>
<html>
<head>
<script src="https://code.jquery.com/jquery-3.6.0.min.js" integrity="sha256-/xUj+3OJU5yExlq6GSYGSHk7tPXikynS7ogEvDej/m4=" crossorigin="anonymous"></script>

<meta charset="UTF-8">
<title>Insert title here</title>

	<script>
		$(function(){
			$('#update_btn').on('click',function(){
				if( '${loginDTO.name}' != $('#name').val() || '${loginDTO.point}' !=$('#point').val()){
					location.href = 'update.do?id=${loginDTO.id}&name='+$('#name').val()+'&point='+$('#point').val();
				}
				else{
					alert('변경 내역이 없습니다.');
				}
			})
			
		})
	</script>
	<style>
		table{
			border-collapse: collapse;
		}
		thead td{
			border-top: 2px solid grey;
			border-bottom: 1px solid grey;
		}
		tbody td{
			border-top: 1px solid grey;
			border-bottom: 2px solid grey;
		}
	</style>
</head>
<body>

	
	
	<h1>회원 관리 시스템</h1>
	<a href="logout.do">로그아웃</a>
	<hr>
	<table>
		<thead>
			<tr>
				<td>아이디</td>
				<td>이름</td>
				<td>등급</td>
				<td>포인트</td>
			</tr>
		</thead>
		<tbody>
			<tr>
				<td>${loginDTO.id}</td>
				<td><input type="text" id="name" value="${loginDTO.name}"></td>
				<td>${loginDTO.grade}</td>
				<td><input type="text" id="point" value="${loginDTO.point}"></td>
			</tr>
				
		</tbody>
		<tfoot>
			<td colspan="2" style="text-align:right"><input type="button" id="delete_btn" value="탈퇴하기"></td>
			<td colspan="2" style="text-align:left"><input type="button" id="update_btn" value="수정하기"></td>
		</tfoot>
	</table>
</body>
</html>