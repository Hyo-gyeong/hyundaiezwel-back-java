<%@page import="java.lang.reflect.Parameter"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>

<head>
<meta charset="UTF-8">
<title>게시글 상세 열람</title>
</head>

<body>
	<h1>게시글 상세 열람</h1>
	<%
	try {
		Class.forName("oracle.jdbc.driver.OracleDriver");
		String db_address = "jdbc:oracle:thin:@localhost:1521:xe";
		String db_username = "C##SQL_USER";
		String db_pwd = "1234";
		Connection conn = DriverManager.getConnection(db_address, db_username, db_pwd);
		request.setCharacterEncoding("UTF-8");
		String num = request.getParameter("num");
		String insertQuery = "select * from practice_board where num=?";
		PreparedStatement pstmt = conn.prepareStatement(insertQuery);
		pstmt.setString(1, num);
		ResultSet result = pstmt.executeQuery(); // 조회된 데이터가 반환되면
	%>

	<table border="1">
		<%
		while (result.next()) {
		%>
		<tr>
			<td>번호</td>
			<td><%=result.getString("num")%></td>
		</tr>
		<tr>
			<td>작성일</td>
			<td><%=result.getString("regdate")%></td>
		</tr>
		<tr>
			<td>작성자</td>
			<td><%=result.getString("writer")%></td>
		</tr>
		<tr>
			<td>제목</td>
			<%
			    String title = result.getString("title"); // db에서 값을 꺼냄 ex) <script>
			    request.setAttribute("title", title); // JSP에서 EL 문법 ${title}로 접근할 수 있도록 request 객체에 저장
			%>
			<td><c:out value="${title}"/></td> <!-- JSTL을 통해 출력 -->
		</tr>
		<tr>
			<td>내용</td>
			<%
			    String content = result.getString("content"); // db에서 값을 꺼냄 ex) <script>
			    request.setAttribute("content", content); // JSP에서 EL 문법 ${content}로 접근할 수 있도록 request 객체에 저장
				
			%>
			<td><c:out value="${content}"/></td> <!-- JSTL을 통해 출력 -->
		</tr>
		<tr>
			<td colspan="2">
				<button type=button onclick="location.href='post_list.jsp'">목록으로</button>
			</td>
		</tr>
		<%
		}
		%>
	</table>
	<%
	} catch (Exception ex) {
	out.println("오류가 발생했습니다. 오류 메시지 : " + ex.getMessage());
	}
	%>

</body>
</html>