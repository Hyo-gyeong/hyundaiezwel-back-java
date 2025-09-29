<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
					<!-- JSP 페이지 내에서 변수 처리, 제어 흐름, 데이터 출력 등 다양한 태그 기능을 제공
						 주요 기능으로는 if, forEach, choose, set, out 태그 등을 포함 -->
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
    <style>
        .form {
            border: #323232 solid 1px;
            margin: auto;
            padding: 10px;
            width: 70vw;
            height: 100%;
        }

        .form__input {
            display: flex;
            flex-direction: column;
            gap: 1rem;
        }

        .form__input > div {
            display: flex;
            justify-content: space-between;
        }

        .form__button {
            margin-top: 10px;
            width: 100%;
        }

        .container {
            position: relative;
            overflow-x: auto;
            border: #323232 solid 1px;
            margin: 10px auto;
            padding: 10px;
            width: 70vw;
            height: 300px;
        }

        .container__header {
            position: absolute;
            top: 1rem;
            right: 1rem;
        }
    </style>
<title>XSS attack JSTL</title>
</head>
<body>
<h1>Reflected XSS 공격</h1>

<div class="form">
    <form action="reflected4.jsp" method="get">
        <div class="form__input">
            <div>
                <span>검색어</span>
                <input type="text" name="keyword"/>
            </div>
        </div>
        <input class="form__button" type="submit" value="검색"/>
    </form>
</div>

<div class="container">

<%	request.setCharacterEncoding("UTF-8");%>
<!-- jstl 라이브러리는 java코드가 아니기 때문에 자바스크립트릿 태그 사용 불가 -->
	<!-- 변수 생성해서 값을 대입하는 코드, String keyword = request.getParameter("keyword"); 와 같은 역할-->
	<c:set var="keyword" value= "${param.keyword}" /> <!-- ${} : jsp 객체 사용 -->
	<!--  value : parameter사용 가능, param이라는 약속된 객체로 사용해야함 -->
	<c:if test="${empty keyword}">
		<!-- 위에서 생성했으니 새롭게 keyword라는 변수를 생성하지는 않음 -->
		<c:set var="keyword" value= ""/>
	</c:if>	
    <div class="container__header">검색어 <c:out value="${keyword}" /></div>
    <!-- 태그를 해석하지 않고 있는 그대로 표현, url에 직접 태그를 넣어도 태그로 해석되지 않아서 XSS를 방지할 수 있음 -->
</div>

</body>
</html>