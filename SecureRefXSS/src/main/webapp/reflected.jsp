<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<!-- 아래 코드는 클라이언트가 
     form태그 활용 요청 시 전달한 keyword 파라미터값을 추출해
     main.jsp를 클라이언트측으로 응답하면서 추출한 keyword 변수 값을 같이 전송 해 주는 코드
 -->
<%
	String keyword ;
	request.setCharacterEncoding("UTF-8");

	keyword = request.getParameter("keyword");%> <!-- keyword 파라미터값을 추출 -->
    console.log(<%=keyword%>);	
<%	
	response.sendRedirect("main.jsp?keyword="+keyword); //main.jsp를 클라이언트측으로 응답하면서 추출한 keyword 변수 값을 같이 전송
%>
</body>
</html>