<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
<!-- �Ʒ� �ڵ�� Ŭ���̾�Ʈ�� 
     form�±� Ȱ�� ��û �� ������ keyword �Ķ���Ͱ��� ������
     main.jsp�� Ŭ���̾�Ʈ������ �����ϸ鼭 ������ keyword ���� ���� ���� ���� �� �ִ� �ڵ�
 -->
<%
	String keyword ;
	request.setCharacterEncoding("UTF-8");

	keyword = request.getParameter("keyword");%> <!-- keyword �Ķ���Ͱ��� ���� -->
    console.log(<%=keyword%>);	
<%	
	response.sendRedirect("main2.jsp?keyword="+keyword); //main.jsp�� Ŭ���̾�Ʈ������ �����ϸ鼭 ������ keyword ���� ���� ���� ����
%>
</body>
</html>