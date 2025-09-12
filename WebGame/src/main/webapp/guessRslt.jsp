<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" errorPage="inputError.jsp"%>
    <style>

/* 결과에 따라 색 강조 */
.result-box.true {
	color: #2c7a2c;
}

.result-box.false {
	color: #b91c1c;
}
</style>
<%
	String rslt = (String) request.getAttribute("rslt");
	if (rslt != null) {%>
<div class="result-box <%=rslt.toLowerCase()%>">
	<span style="font-weight: bold"><%=rslt%>
	<% if (rslt.equals("true")) {%> 🎉 <%} %>
	</span><br>
</div>
<%} %>
<%
String error = (String) request.getAttribute("error");
if (error != null) {
%>
<span style="color: red; font-weight: bold;"><%=error%>!</span>
<br>
<%
}
%>