<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ page import="java.util.ArrayList" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>request 연습문제 요청 처리</title>
	</head>
	<%!
		// 변수 선언
		String name, id, pwd, h1, h2, h3, department;
		String interests[];
	%>
	<%
		request.setCharacterEncoding("UTF-8");
		
		name = request.getParameter("name");
		pwd = request.getParameter("pw");
		h1 = request.getParameter("hp1");
		h2 = request.getParameter("hp2");
		h3 = request.getParameter("hp3");
		String grade = request.getParameter("grade");
		String department = request.getParameter("department");
		interests = request.getParameterValues("interests");
	%>
	<body>
	 	 이름 :  <%= name %> <br>
	 	 아이디 : <%= id %><br>
	 	 비밀번호 : <%= pwd %><br>
	 	 전화번호 : <%= h1 %>-<%= h2 %>-<%= h3 %><br>
	 	 학년 : <%= grade %><br>
	 	 관심있는 분야 :
	 	 <% for (String i : interests){
	 		out.println(i+" ");

	 	 	}
	 	%>
								 	 <br>
	 	 학과 : <%= department %>
	 	 
	</body>
</html>