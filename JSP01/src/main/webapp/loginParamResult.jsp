<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>forward 액션 태그</title>
	</head>
	<body>
	<%! String msg = "아이디를 입력하지 않았습니다. 아이디를 입력하세요"; %>
	<%
		request.setCharacterEncoding("UTF-8");
		String user_id = request.getParameter("user_id");
		
		if (user_id.length() == 0){
			// jsp 액션 태그 param 사용해서 포워딩 되는 페이지로 msg전달 - param 태그는 파라미터를 어느 페이지로 전달할 것인지 설정되어있어야 함
			// name="" value=""
			// forward/include 액션태그를 이용해서 파라미터를 전달
		%>
			<jsp:forward page="login_param.jsp">
				<jsp:param value="<%= msg %>" name="message"/>
			</jsp:forward>
		<%}
	%>
		<h3>환영합니다 <%= user_id %> 님</h3>
	</body>
</html>