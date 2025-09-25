<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
String msg = (String) request.getAttribute("msg");
if (msg != null) {
%>
<span style="color: red; font-weight: bold; text-align:center"><%=msg%></span>
<br>
<%
}
%>