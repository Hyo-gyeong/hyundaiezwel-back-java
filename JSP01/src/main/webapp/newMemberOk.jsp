<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<jsp:useBean id="member" class="sec02.MemberBean" scope="page">
		<jsp:setProperty property="*" name="member"/> <!-- 모든 속성을 이름에 맞게 알아서 주입 -->
	</jsp:useBean>
	<h1>Bean 속성값 출력</h1>
	아이디 : <%= member.getMemId() %><br>
	비밀번호 : <%= member.getMemPw() %><br>
	이름 : <%= member.getMemName() %><br>
	이메일 : <%= member.getMemMail() %><br>
</body>
</html>