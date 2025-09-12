<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
        <h1>게임을 고르세요</h1>
        <ul>
            <li><a href="rsp.jsp">가위바위보</a></li>
            <li><a href="guess.jsp">숫자 알아맞히기</a></li>
        </ul>
    </div>
</body>
</html>
