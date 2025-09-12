<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<style>

/* 결과에 따라 색 강조 */
.result-box.win {
	color: #2c7a2c;
}

.result-box.lose {
	color: #b91c1c;
}

.result-box.same {
	color: #0c5460;
}
</style>

<%
String rslt = (String) request.getAttribute("rslt");
if (rslt != null) {
%>
<div class="result-box <%=rslt.toLowerCase()%>">
	<span style="font-weight: bold">You <%=rslt%>! 🎉
	</span><br>
</div>
<%
}
%>
<%
String error = (String) request.getAttribute("error");
if (error != null) {
%>
<span style="color: red; font-weight: bold;"><%=error%></span>
<br>
<%
}
%>