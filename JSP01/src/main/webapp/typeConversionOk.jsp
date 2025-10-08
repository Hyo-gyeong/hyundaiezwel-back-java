<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Insert title here</title>
	</head>
	<body>
		<%!
			int width, height;
		%>
		<%
			width = Integer.parseInt(request.getParameter("width")); // 자동 형변환 안돼서 직접 처리해줘야함
			height = Integer.parseInt(request.getParameter("height")); // 직접 처리하는게 가장 안전하기도 함
		%>
		사각형 넓이 : <%= width*height %>
	</body>
</html>