<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>EL 내장 객체 사용</title>
</head>
<body>
<% request.setCharacterEncoding("UTF-8"); %>
아이디 : ${ param.id }<br> <!-- param은 이미 만들어져서 제공되는 내장객체. 파라미터명이 id에 해당하는 value를 가져옴 -->
비밀번호 : ${ param.pwd }<br>
이름 : ${ param.name }<br>
이메일 : ${ param.email }<br>
</body>
</html>