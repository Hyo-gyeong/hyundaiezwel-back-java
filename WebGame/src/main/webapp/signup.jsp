<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<title>회원가입</title>

<style>
body {
	margin: 0;
	padding: 0;
	font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
	background: url("test.jpg") no-repeat center center/cover;
	height: 100vh;
	display: flex;
	justify-content: center;
	align-items: center;
}

.container {
	background: rgba(255, 255, 255, 0.9);
	width: 75%;
	padding: 40px;
	border-radius: 16px;
	box-shadow: 0 8px 20px rgba(0,0,0,0.2);
	display: flex;
	flex-direction: column;
	justify-content: space-between;
}

h1 {
	text-align: center;
	margin-bottom: 25px;
	color: #444;
}

.form-group {
	display: flex;
	flex-direction: column;
	margin-bottom: 20px;
}

label {
	margin-bottom: 8px;
	font-weight: bold;
	color: #333;
}

input[type="text"], 
input[type="password"] {
	padding: 12px;
	border: 1px solid #ccc;
	border-radius: 25px;
	font-size: 16px;
	text-align: center;
	outline: none;
	transition: border-color 0.3s ease;
}

input[type="text"]:focus, 
input[type="password"]:focus {
	border-color: #f9c5d1;
}

.btn-group {
	flex-direction: row;
	text-align: center;
}

button, .link-btn {
	background: linear-gradient(135deg, #fff6b7, #f9c5d1);
	border: none;
	padding: 12px 24px;
	margin: 10px;
	border-radius: 25px;
	font-size: 16px;
	font-weight: bold;
	cursor: pointer;
	box-shadow: 0 3px 8px rgba(0, 0, 0, 0.15);
	transition: all 0.3s ease;
	text-align: center;
	text-decoration: none;
	color: #444;
	display: inline-block;
	width: fit-content;
}

button:hover, .link-btn:hover {
	background: linear-gradient(135deg, #f9c5d1, #fff6b7);
	transform: translateY(-2px);
	box-shadow: 0 5px 14px rgba(0, 0, 0, 0.25);
}
</style>
</head>
<body>
	<div class="container">
		<h1>회원가입</h1>
		<form method="post" action="${contextPath}/User/signup">
			<div class="form-group">
				<label for="id">아이디</label>
				<input type="text" id="id" name="id" required>
			</div>
			<div class="form-group">
				<label for="pw">비밀번호</label>
				<input type="password" id="pw" name="pw" required>
			</div>
			<div class="form-group">
				<label for="name">이름</label>
				<input type="text" id="name" name="name" required>
			</div>
			<div class="btn-group">
				<jsp:include page="/signupRslt.jsp"></jsp:include>
				<button type="submit">회원가입</button>
				<a href="${contextPath}/main.jsp" class="link-btn">메인으로 돌아가기</a>
			</div>
		</form>
	</div>
</body>
</html>
