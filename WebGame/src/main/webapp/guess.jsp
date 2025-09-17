<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}"  />
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<title>Guess Game</title>
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
        max-width: 500px;
    }

    h1 {
        margin-bottom: 25px;
        color: #444;
    }

    form {
        margin-top: 20px;
    }

    input[type="text"] {
        padding: 10px;
        border-radius: 6px;
        border: 1px solid #ccc;
        width: 150px;
        font-size: 16px;
        margin-right: 10px;
        transition: border 0.3s ease, box-shadow 0.3s ease;
    }

    input[type="text"]:focus {
        border: 1px solid #f9c5d1;
        box-shadow: 0 0 6px #f9c5d1;
        outline: none;
    }

    button {
        background: linear-gradient(135deg, #fff6b7, #f9c5d1);
        border: none;
        padding: 10px 20px;
        margin: 10px 5px;
        border-radius: 8px;
        font-size: 16px;
        font-weight: bold;
        cursor: pointer;
        box-shadow: 0 3px 8px rgba(0,0,0,0.15);
        transition: all 0.3s ease;
    }

    button:hover {
        background: linear-gradient(135deg, #f9c5d1, #fff6b7);
        transform: translateY(-2px);
        box-shadow: 0 5px 14px rgba(0,0,0,0.25);
    }

   

    a {
        display: inline-block;
        margin-top: 20px;
        color: #444;
        text-decoration: none;
        font-weight: bold;
        transition: color 0.3s ease;
    }

    a:hover {
        color: #d46a92;
    }
</style>
</head>
<body>
    <div class="container">
        <h1>숫자 알아맞히기 게임에 오신걸 환영합니다!</h1>
        <form method="post" action="${contextPath }/Game/guess">
            <p>1–10 사이의 숫자를 입력하세요:
            <input type="text" id="num" name="num" placeholder="숫자 입력"></p>
            <button type="submit" name="btnAction" value="reset">다시하기</button>
            <button type="submit" name="btnAction" value="submit">선택 완료</button>
        </form>
        <jsp:include page="guessRslt.jsp" flush="true"/>

        <a href="${contextPath}/main.jsp">메인으로 돌아가기</a>
    </div>
</body>
</html>
