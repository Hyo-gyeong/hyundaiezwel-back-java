<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    import="java.util.*, sec01.MemberVO"
    isELIgnored="false"%>
<!-- import 구문으로 자바 클래스 사용 isElIgnored="fase"는 el표현어를 text로 인식 -->
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ArrayList 사용</title>
</head>
<body>
	<jsp:useBean id="m" class="sec01.MemberVO" /> <!-- setter, getter용으로 주로 사용 -->
    <jsp:useBean id="membersList" class="java.util.ArrayList" /> <!-- setter, getter용으로 주로 사용 -->

    <%
        MemberVO m1 = new MemberVO("son", "1234", "손흥민", "son@test.com");
        MemberVO m2 = new MemberVO("son", "1234", "손준민", "son@test.com");
        membersList.add(m1); // 객체 참조 변수가 넘어오기 때문에 내부에 정의된 메서드 사용 가능. 권장 x
        membersList.add(m2); // generic type으로 사용되길 권장
        request.setAttribute("memList", membersList);
    %>
    <jsp:forward page="elArr_forward_result.jsp"/>
</body>
</html>