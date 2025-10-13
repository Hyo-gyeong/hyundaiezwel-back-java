<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%!
 // 선언부
 int x = 10; // 전역변수
 float f = 3.14f;
 public int plus(int x){
	 return x+10;
 }
%>
<%
 // 스크립트릿에서 메서드는 선언이 불가능함 - method정의는 선언부에서만 가능
 /*public int minus(int x){
	return 0;
}*/
%>
<%= x %><br>
f변수의 값 : <%= f %><br>
plus 메서드 호출 : <%= plus(x) %> <%-- jsp 선언문에서 정의한 메서드 호출 후 결과 출력 : jsp 주석 사용(클라이언트에게 전달 안됨) --%>
<!-- jsp파일에서 html태그 사용 : html 주석 사용(클라이언트에 전달됨)-->
</body>
</html>