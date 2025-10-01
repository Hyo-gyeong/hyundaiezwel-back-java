<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<!-- 로그인 페이지로 이동하는 a 태그 location을 여러 방법으로 설정 -->
<a href="http://localhost:8080/JSP01/el/login.jsp">서버 정보부터 전부 직접 작성한 로그인</a><br>
<a href="/JSP01/el/login.jsp">서버 주소 없이 로그인</a><br> <!-- 현재 페이지를 요청할 때 서버의 주소는 이미 브라우저에 저장됨.
											헤더에 서버의 주소와 포트를 전부 다 가지고있음 -->
<a href="<%=request.getContextPath()%>/el/login.jsp">context 표현식 이용 로그인</a><br>
<!-- 서버에서 클라이언트로 이 페이지가 넘어왔을 때 어떤 context를 통해서 왔는지도 알 수 있음
	현재 페이지 요청 시 사용했던 context path와 동일한 path를 동적으로 사용하겠다.
	context path는 프로젝트명과 일치하지 않을 수 있음
	/el/login.jsp : 이건 내가 결정한 경로 -->

<a href="${pageContext.request.contextPath}/el/login.jsp">로그인</a><br> <!-- 위와 동일 -->
</body>
</html>