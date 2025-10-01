<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
plain text 로 출력 : 100<br>
표현식으로 출력 <%= 100 %><br>
표현언어(EL)로 출력 : ${100}<br>
표현언어(EL)로 출력 : ${true}<br>
표현언어(EL)로 출력 : ${true && true}<br>
표현언어(EL)로 출력 : ${"문자열"}<br>
표현언어(EL)로 출력 : ${100-90}<br>
표현언어(EL)로 출력 : ${100%90}<br>
표현언어(EL)로 출력 : ${100 mod 90} -> 나머지 연산자<br>
<%-- <!-- 표현언어(EL)로 출력 : ${"hello "+"world"}<br> --> --%>
<!-- 주석처리를 해서 영향이 없을 것 같지만 jsp가 servlet으로 구성이 되면서 out.write로 전송이 되고 코드 부분은 해석하게됨 -->
<!-- 코드가 해석되지 않게 하려면 'jsp주석으로' 사용해야함-->
<!-- 문자열 연산 결과 오류 발생 -->
</body>
</html>