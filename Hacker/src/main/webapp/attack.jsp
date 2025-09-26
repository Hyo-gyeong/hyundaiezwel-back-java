<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
	//application.log : 애플리케이션의 로그 메시지를 기록하는 데 사용되는 메서드
	application.log(request.getParameter("JSESSIONID")); // 파라미터로 전달된 JSESSIONID의 값을 log에 기록
%>
<script>
	history.back(-1)
</script>
</body>
</html>