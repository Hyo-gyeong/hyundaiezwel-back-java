<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}"  />
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<title>RSP Game</title>
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
	background: rgba(255, 255, 255, 0.85);
	padding: 40px 60px;
	border-radius: 16px;
	box-shadow: 0 8px 20px rgba(0, 0, 0, 0.2);
	text-align: center;
	max-width: 500px;
}

h1 {
	margin-bottom: 25px;
	color: #444;
}

.choices {
	display: flex;
	justify-content: space-around;
	margin: 20px 0;
}

label {
	cursor: pointer;
	font-size: 40px; /* 이모지/이미지 크기 */
	display: flex;
	flex-direction: column;
	align-items: center;
	transition: transform 0.2s ease;
}

input[type="radio"] {
	display: none;
}

input[type="radio"]:checked+label {
	transform: scale(1.2);
}

button {
	background: linear-gradient(135deg, #fff6b7, #f9c5d1);
	border: none;
	padding: 10px 20px;
	margin: 10px;
	border-radius: 8px;
	font-size: 16px;
	font-weight: bold;
	cursor: pointer;
	box-shadow: 0 3px 8px rgba(0, 0, 0, 0.15);
	transition: all 0.3s ease;
}

button:hover {
	background: linear-gradient(135deg, #f9c5d1, #fff6b7);
	transform: translateY(-2px);
	box-shadow: 0 5px 14px rgba(0, 0, 0, 0.25);
}

a {
	display: inline-block;
	margin-top: 20px;
	color: #444;
	text-decoration: none;
	font-weight: bold;
	transition: color 0.3s ease;
}

a:hover {
	color: #d46a92;
}
</style>
</head>
<body>
	<div class="container">
		<h1>가위바위보 게임에 오신걸 환영합니다!</h1>
		<form name="guessform" method="post" action="${contextPath}/Game/rsp">
			<div class="choices">
				<input type="radio" id="scissors" value="0" name="rsp">
					<label for="scissors">✌️<span style="font-size: 16px;">가위</span></label>
				<input type="radio" id="rock" value="1" name="rsp">
					<label for="rock">✊<span style="font-size: 16px;">바위</span></label>
				<input type="radio" id="paper" value="2" name="rsp">
					<label for="paper">🖐<span style="font-size: 16px;">보</span></label>
			</div>
			<button type="submit" name="btnAction" value="reset">다시하기</button>
			<button type="submit" name="btnAction" value="submit">선택 완료</button>
		</form>
		<jsp:include page="rspRslt.jsp" flush="true"/>

		<a href="${contextPath}/main.jsp">메인으로 돌아가기</a>
	</div>
</body>
</html>
