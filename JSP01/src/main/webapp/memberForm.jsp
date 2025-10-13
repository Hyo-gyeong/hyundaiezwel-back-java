<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1> 회원 가입창</h1>
	<form name="frmMember" method="post" action="newMemberOk.jsp">
		아이디: <input type="text" name="memId"><br>
		비밀번호: <input type="password" name="memPw"><br>
		이름: <input type="text" name="memName"><br>
		이메일: <input type="text" name="memMail"><br>
		<input type="submit" value="확인">
	</form>
</body>
</html>