<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}"  />
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<title>게임 선택</title>
<style>
    body {
        margin: 0;
        padding: 0;
        font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
        background: url("test.jpg") no-repeat center center/cover;
        height: 100vh;
        display: flex;
        justify-content: center;
        align-items: center;
    }

    .container {
        background: rgba(255, 255, 255, 0.85);
        padding: 40px 60px;
        border-radius: 16px;
        box-shadow: 0 8px 20px rgba(0,0,0,0.2);
        text-align: center;
    }

    h1 {
        margin-bottom: 20px;
        color: #444;
    }

    ul {
        list-style: none;
        padding: 0;
    }

    li {
        margin: 15px 0;
    }

    a {
        text-decoration: none;
        color: #444;
        background: linear-gradient(135deg, #fff6b7, #f9c5d1); /* 연노랑 → 연분홍 */
        padding: 12px 24px;
        border-radius: 8px;
        font-size: 18px;
        font-weight: bold;
        transition: all 0.3s ease;
        display: inline-block;
        box-shadow: 0 3px 8px rgba(0,0,0,0.15);
    }

    a:hover {
        background: linear-gradient(135deg, #f9c5d1, #fff6b7); /* hover 시 반전 */
        transform: translateY(-3px);
        box-shadow: 0 5px 14px rgba(0,0,0,0.25);
    }
</style>
</head>
<body>
    <div class="container">
    <%
    		if (session.getAttribute("loginUserId") == null){
    	%>
    		<h1>게임을 하려면 로그인을 해야합니다</h1>
    		<form method="post" action="${contextPath}/User/login">
    			ID : <input type="text" id="id" name="id">
    			PW : <input type="password" id="pw" name="pw">
    			<button type="submit" name="action" value="submit">로그인</button>
    		</form>
    		<a href="${contextPath}/signup.jsp">회원 가입</a>
    		<%
			String msg = (String) request.getAttribute("msg");
			if (msg != null) {
		%>
			<span style="color: red; font-weight: bold;"><%=msg%>!</span>
			<br>
		<%
			}
		%>
    	<%		
    		} else {
    %>
        <h1>게임을 고르세요</h1>
        <ul>
            <li><a href="${contextPath}/rsp.jsp">가위바위보</a></li>
            <li><a href="${contextPath}/guess.jsp">숫자 알아맞히기</a></li>
        </ul>
        <form method="post"action="${contextPath}/User/logout">
        <%= session.getAttribute("loginUserName") %>님 안녕하세요!
        		<input type="text" id="id" name="id" hidden value=<%= session.getAttribute("loginUserId") %>>
    			<button type="submit" name="action" value="submit">로그아웃</button>
    		</form>
    <%		
    		}
    %>
    </div>
</body>
</html>
