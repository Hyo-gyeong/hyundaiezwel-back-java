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
			int dan = Integer.parseInt(request.getParameter("dan")); // 웹에서 데이터교환은 전부 문자형
		%>
		<%= dan %>단
		<table border="1">
			<% for(int i = 1; i <= 9; i++){ %>
			<tr>
				<td> <!-- 태그는 서블릿 태그로 감싸면 자바코드로 읽기 때문에 htmlm태그 그대로 둬야함 -->
					<%= dan%>*<%= i %> = <%= dan*i %>
				</td>
			</tr>
			<% } %>
		</table>
	</body>
</html>