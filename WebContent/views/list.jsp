<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
	<script src="https://code.jquery.com/jquery-3.6.0.min.js" integrity="sha256-/xUj+3OJU5yExlq6GSYGSHk7tPXikynS7ogEvDej/m4=" crossorigin="anonymous"></script>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	<style>

	</style>
		<script>
			console.log('${list}');
		</script>
</head>
<body>
	<table border="1">
		<thead>
			<tr>
				<td>회원번호</td>
				<td>아이디</td>
				<td>이름</td>
				<td>등급</td>
				<td>포인트</td>
			</tr>
		</thead>
		<tbody>

			<c:forEach var="member" items="${list}">
				<tr>
					<td>${member.no}</td>
					<td>${member.id}</td>
					<td>${member.name}</td>
					<td>${member.grade}</td>
					<td>${member.point}</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</body>
</html>