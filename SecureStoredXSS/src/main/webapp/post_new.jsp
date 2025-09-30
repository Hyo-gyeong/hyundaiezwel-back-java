<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>신규 게시글 작성</title>
<script type="text/javascript">
	// 서버특에서 값을 전송하기 전에 XSS에 취약한 특수 문자들에 대해서 치환하는 기능의 함수
	function replaceChr(){
		let tvalue = document.querySelector("input[name='title']").value;
		tvalue = tvalue.replaceAll("&", "&amp;");
		tvalue = tvalue.replaceAll("<", "&lt;");
		tvalue = tvalue.replaceAll(">", "&gt;");
		tvalue = tvalue.replaceAll("(", "&#40;");
		tvalue = tvalue.replaceAll(")", "&#41;");
		tvalue = tvalue.replaceAll("\"", "&quot;");
		tvalue = tvalue.replaceAll("'", "&#x27;");
		tvalue = tvalue.replaceAll("/", "&#x2F;");
		document.querySelector("input[name='title']").value = tvalue;
		
		let cvalue = document.querySelector("textarea[name='content']").value;
		cvalue = cvalue.replaceAll("&", "&amp;");
		cvalue = cvalue.replaceAll("<", "&lt;");
		cvalue = cvalue.replaceAll(">", "&gt;");
		cvalue = cvalue.replaceAll("(", "&#40;");
		cvalue = cvalue.replaceAll(")", "&#41;");
		cvalue = cvalue.replaceAll("\"", "&quot;");
		cvalue = cvalue.replaceAll("'", "&#x27;");
		cvalue = cvalue.replaceAll("/", "&#x2F;");
		document.querySelector("textarea[name='content']").value = cvalue;
	}
    </script> 
</head>
<body>
	<h1>신규 게시글 작성</h1>
	<form action="post_new_send.jsp" method="post" onsubmit="return replaceChr();">
		<table>
			<tr>
				<td>작성자</td>
				<td><input type="text" name="writer"></td>
			</tr>
			<tr>
				<td>제목</td>
				<td><input type="text" name="title"></td>
			</tr>
			<tr>
				<td>내용</td>
				<td><textarea rows="10" cols="20" name="content"></textarea></td>
			</tr>
			<tr>
				<td colspan="2">
					<button type="submit">저장</button>
					<button type="button" onclick="location.href='post_list.jsp'">목록으로</button>
					<button type="reset">초기화</button>
				</td>
			</tr>
		</table>
	</form>
</body>
</html>