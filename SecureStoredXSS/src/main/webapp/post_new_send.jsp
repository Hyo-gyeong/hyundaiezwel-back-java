<%@page import="java.util.Date"%>
<%@page import="java.sql.Timestamp"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Timestamp" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%
try {
	Class.forName("oracle.jdbc.driver.OracleDriver");
	String db_address = "jdbc:oracle:thin:@localhost:1521:xe";
	String db_username = "C##SQL_USER";
	String db_pwd = "1234";
	Connection conn = DriverManager.getConnection(db_address, db_username, db_pwd);
	
	String maxNum = "select max(num) from practice_board";
	PreparedStatement pstmt = conn.prepareStatement(maxNum);
	ResultSet result = pstmt.executeQuery();
	int num = 0;
	while (result.next()){
		num = result.getInt("max(num)")+1;
	}
	Timestamp today = new Timestamp(System.currentTimeMillis());
	request.setCharacterEncoding("UTF-8"); // 입력값이 한글인 경우 조합하는 방법 명시, 위에서 설정한 charset이랑 별개
	String title = request.getParameter("title");
	String writer = request.getParameter("writer");
	String content = request.getParameter("content");
	
	String insertQuery = "insert into practice_board values (?,?,?,?,?)";
	pstmt = conn.prepareStatement(insertQuery);
	pstmt.setInt(1, num);
	pstmt.setString(2, title);
	pstmt.setString(3, writer);
	pstmt.setString(4, content);
	pstmt.setTimestamp(5, today);
	
	pstmt.executeUpdate();
	response.sendRedirect("post_list.jsp");
	// post_new.jsp -> 저장 버튼 클릭하면 요청
	// post_new_send.jsp -> db에 데이터 저장 완료 되면 요청
	// -> post_list로 감
	
} catch (Exception ex) {
	out.println("오류가 발생했습니다. 오류 메시지 : " + ex.getMessage());
}
%>