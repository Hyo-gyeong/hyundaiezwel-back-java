<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
		<!-- 
		request 객체에 저장되어져 전달되는 answer 값에 따라 두 페이지 중 하나로 포워딩(redirect)
		응답에 대한 표현은 없이 처리만 하는 페이지들에서는 html코드 필요 없음
		불필요한 html태그가 있으면 서블릿으로 변환될 때 전부 다 out.print문에 의해 출력됨
		따라서 <!DOCTYPE html>부터 안쓰는 모든 html태그 삭제
		 -->
		<%! String ans; %>
		<% 
			request.setCharacterEncoding("UTF-8");
			ans = request.getParameter("answer");
			if (ans.equals("서울")){
				response.sendRedirect("pass.jsp");
			}else {
				response.sendRedirect("fail.jsp");
			}
		%>