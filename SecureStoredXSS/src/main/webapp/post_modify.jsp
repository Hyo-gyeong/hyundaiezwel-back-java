<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>글 수정</title>
<script type="text/javascript">
	// 서버특에서 값을 전송하기 전에 XSS에 취약한 특수 문자들에 대해서 치환하는 기능의 함수
	function replaceChr(){
		let tvalue = document.querySelector("input[name='title']").value;
		tvalue = tvalue.replaceAll("&", "&amp;");
		tvalue = tvalue.replaceAll("<", "&lt;");
		tvalue = tvalue.replaceAll(">", "&gt;");
		tvalue = tvalue.replaceAll("(", "&#40;");
		tvalue = tvalue.replaceAll(")", "&#41;");
		tvalue = tvalue.replaceAll("\"", "&quot;");
		tvalue = tvalue.replaceAll("'", "&#x27;");
		tvalue = tvalue.replaceAll("/", "&#x2F;");
		document.querySelector("input[name='title']").value = tvalue;
		
		let cvalue = document.querySelector("textarea[name='content']").value;
		cvalue = cvalue.replaceAll("&", "&amp;");
		cvalue = cvalue.replaceAll("<", "&lt;");
		cvalue = cvalue.replaceAll(">", "&gt;");
		cvalue = cvalue.replaceAll("(", "&#40;");
		cvalue = cvalue.replaceAll(")", "&#41;");
		cvalue = cvalue.replaceAll("\"", "&quot;");
		cvalue = cvalue.replaceAll("'", "&#x27;");
		cvalue = cvalue.replaceAll("/", "&#x2F;");
		document.querySelector("textarea[name='content']").value = cvalue;
	}
    </script>
</head>
<body>
    <h1>글 수정</h1>
    <%
    try
    {
		Class.forName("oracle.jdbc.driver.OracleDriver");
		String db_address = "jdbc:oracle:thin:@localhost:1521:xe";
		String db_username = "C##SQL_USER";
		String db_pwd = "1234";
        Connection connection = DriverManager.getConnection(db_address, db_username, db_pwd);
        
        request.setCharacterEncoding("UTF-8");
        
        String num = request.getParameter("num");
        
        String insertQuery = "SELECT * FROM practice_board WHERE num=" + num;
        
        PreparedStatement psmt = connection.prepareStatement(insertQuery);
        
        ResultSet result = psmt.executeQuery();
        
        while(result.next())
        {%>
            <form action="post_modify_send.jsp" method="post" onsubmit="return replaceChr();">
            <input type="hidden" name="num" value="<%=result.getInt("num") %>">
            <table border="1">
                <tr>
                    <td>작성자</td>
                    <td><input type="text" name="writer" value="<%=result.getString("writer") %>"></td>
                </tr>
                <tr>
                    <td>제목</td>
                    <td><input type="text" name="title" value="<%=result.getString("title") %>"></td>
                </tr>
                <tr>
                    <td>내용</td>
                    <td><textarea rows="10" cols="20" name="content"><%=result.getString("content") %></textarea>
                </tr>
                <tr>
                    <td colspan="2">
                        <button type="submit">수정</button>
                        <button type="button" onclick="location.href='post_list.jsp'">목록으로</button>
                        <button type="reset">원상복구</button>
                    </td>
                </tr>
            </table>
            </form>
    <%
        }
    }
    catch (Exception ex)
    {
    	out.println("오류가 발생했습니다. 오류 메시지 : " + ex.getMessage());
    }%>
</body>
</html>