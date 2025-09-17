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
        background: rgba(255, 255, 255, 0.9);
        width: 75%;     /* 가로 75% */
        height: 65%;    /* 세로 65% */
        padding: 40px;
        border-radius: 16px;
        box-shadow: 0 8px 20px rgba(0,0,0,0.2);
        display: flex;
        flex-direction: column;
        justify-content: space-between;
    }

    h1 {
        text-align: center;
        color: #444;
        margin-bottom: 30px;
    }

    .welcome-msg {
        font-size: 16px;
        font-weight: normal;
        color: #666;
        margin-left: 15px;
    }

    .form-section {
        flex: 1;
        display: flex;
        justify-content: center;
        align-items: center;
    }

    .form-box {
        background: rgba(255, 255, 255, 0.95);
        padding: 30px;
        border-radius: 20px;
        box-shadow: 0 4px 12px rgba(0,0,0,0.15);
        display: flex;
        flex-direction: column;
        gap: 15px;
        align-items: center;
    }

    .form-box input {
        width: 250px;
        padding: 10px 14px;
        border-radius: 25px;
        border: 1px solid #ccc;
        font-size: 16px;
        outline: none;
        transition: all 0.3s ease;
    }

    .form-box input:focus {
        border-color: #888;
        box-shadow: 0 0 6px rgba(0,0,0,0.2);
    }

    .btn-group {
        display: flex;
        justify-content: center;
        gap: 20px;
        margin-top: 20px;
        margin-bottom: 10px;
    }

    a, button {
        text-decoration: none;
        color: #444;
        background: linear-gradient(135deg, #fff6b7, #f9c5d1);
        padding: 12px 24px;
        border-radius: 8px;
        font-size: 18px;
        font-weight: bold;
        transition: all 0.3s ease;
        display: inline-block;
        box-shadow: 0 3px 8px rgba(0,0,0,0.15);
        border: none;
        cursor: pointer;
    }

    a:hover, button:hover {
        background: linear-gradient(135deg, #f9c5d1, #fff6b7);
        transform: translateY(-3px);
        box-shadow: 0 5px 14px rgba(0,0,0,0.25);
    }
    
    #logoutbtn {
    		background:none;
    }
    
    #logoutbtn:hover {
    		transform:none;
    		box-shadow: 0 3px 5px rgba(0,0,0,0.25);
    }

    .msg {
        color: red;
        font-weight: bold;
        text-align: center;
    }

    /* --- 게임 선택 부분 --- */
    .game-section {
        display: flex;
        justify-content: center;
        gap: 40px; /* 카드 간격 */
        margin-bottom: 20px;
    }

    .game-card {
        width: 180px;
        height: 180px;
        display: flex;
        justify-content: center;
        align-items: center;
        text-decoration: none;
        font-size: 20px;
        font-weight: bold;
        color: #444;
        background: rgba(0,0,0,0.05); /* 아주 희미한 회색 */
        border-radius: 12px;
        box-shadow: 0 3px 6px rgba(0,0,0,0.1);
        transition: all 0.3s ease;
    }

    .game-card:hover {
        background: linear-gradient(135deg, #fff6b7, #f9c5d1);
        transform: translateY(-5px);
        box-shadow: 0 6px 16px rgba(0,0,0,0.2);
    }

    .logout-form {
        display: flex;
        justify-content: right;
        margin-top: auto;
    }

    .logout-form button {
        font-size: 14px;
        padding: 8px 16px;
        border-radius: 6px;
    }
</style>
</head>
<body>
    <div class="container">
    <%
    		if (session.getAttribute("loginUserId") == null){
    	%>
    		<h1>게임을 하려면 로그인을 해야합니다</h1>
    		<div class="form-section">
	    		<form method="post" action="${contextPath}/User/login" class="form-box">
	    			<input type="text" id="id" name="id" placeholder="아이디">
	    			<input type="password" id="pw" name="pw" placeholder="비밀번호">
	    			<div class="btn-group">
	    				<button type="submit" name="action" value="submit">로그인</button>
	    				<a href="${contextPath}/signup.jsp">회원 가입</a>
	    			</div>
	    		</form>
    		</div>
    		<%
			String msg = (String) request.getAttribute("msg");
			if (msg != null) {
		%>
			<div class="msg"><%=msg%>!</div>
		<%
			}
		%>
    	<%		
    		} else {
    %>
    		<form method="post" action="${contextPath}/User/logout" class="logout-form">
            <input type="hidden" id="id" name="id" value="<%= session.getAttribute("loginUserId") %>">
            <button id="logoutbtn" type="submit" name="action" value="submit">로그아웃</button>
        </form>
        <h1>
            <%= session.getAttribute("loginUserName") %>님 안녕하세요! 하고 싶은 게임을 고르세요😊
            <span class="welcome-msg"></span>
        </h1>
        <div class="game-section">
            <a href="${contextPath}/rsp.jsp" class="game-card">가위바위보</a>
            <a href="${contextPath}/guess.jsp" class="game-card">숫자 알아맞히기</a>
        </div>
        
    <%		
    		}
    %>
    </div>
</body>
</html>
