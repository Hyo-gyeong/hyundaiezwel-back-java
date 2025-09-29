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
	String keyword ;
	request.setCharacterEncoding("UTF-8");

	keyword = request.getParameter("keyword");%>
console.log(<%=keyword%>);	
<%	
	response.sendRedirect("main4.jsp?keyword="+keyword);
%>
</body>
</html>