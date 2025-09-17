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
		background: rgba(255, 255, 255, 0.9);
		width: 75%; /* 가로 75% */
		height: 65%; /* 세로 65% */
		padding: 40px;
		border-radius: 16px;
		box-shadow: 0 8px 20px rgba(0, 0, 0, 0.2);
		display: flex;
		flex-direction: column;
		justify-content: space-between;
	}
	
	h1 {
		text-align: center;
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
		font-size: 70px; /* 이모지/이미지 크기 */
		display: flex;
		flex-direction: column;
		align-items: center;
		transition: transform 0.2s ease;
	}
	
	form {
		text-align: center; /* 버튼들을 가운데 정렬 */
	}
	
	.result {
	    text-align: center; /* 결과 영역도 가운데 정렬 */
	    margin-top: 20px;
	}

	input[type="radio"] {
		display: none;
		flex-direction: column;
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
		display: block; /* 인라인 → 블록 */
		margin: 20px auto 0; /* 위쪽 여백 + 좌우 auto로 가운데 정렬 */
		color: #444;
		text-decoration: none;
		font-weight: bold;
		text-align: center; /* 글씨도 중앙 */
		width: fit-content; /* 글자 길이에 맞게 블록 크기 */
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
		<div class="result">
		    <jsp:include page="rspRslt.jsp" flush="true"/>
		</div>
		<a href="${contextPath}/main.jsp">메인으로 돌아가기</a>
	</div>
</body>
</html>
