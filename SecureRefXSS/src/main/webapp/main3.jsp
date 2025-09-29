<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
    <style>
        .form {
            border: #323232 solid 1px;
            margin: auto;
            padding: 10px;
            width: 70vw;
            height: 100%;
        }

        .form__input {
            display: flex;
            flex-direction: column;
            gap: 1rem;
        }

        .form__input > div {
            display: flex;
            justify-content: space-between;
        }

        .form__button {
            margin-top: 10px;
            width: 100%;
        }

        .container {
            position: relative;
            overflow-x: auto;
            border: #323232 solid 1px;
            margin: 10px auto;
            padding: 10px;
            width: 70vw;
            height: 300px;
        }

        .container__header {
            position: absolute;
            top: 1rem;
            right: 1rem;
        }
    </style>
   
   <script type="text/javascript">
	// 서버특에서 값을 전송하기 전에 XSS에 취약한 특수 문자들에 대해서 치환하는 기능의 함수
	function replaceChr(){
		let value = document.querySelector("input[name='keyword']").value;
		value = value.replaceAll("&", "&amp;");
		value = value.replaceAll("<", "&lt;");
		value = value.replaceAll(">", "&gt;");
		value = value.replaceAll("(", "&#40;");
		value = value.replaceAll(")", "&#41;");
		value = value.replaceAll("\"", "&quot;");
		value = value.replaceAll("'", "&#x27;");
		value = value.replaceAll("/", "&#x2F;");
		// 치환한 value로 변경해서 input value에 넣어주기
		document.querySelector("input[name='keyword']").value = value;
		// return 값이 없으면 undefined가 반환됨
		// 명확하게 특정 값을 반환해야 하는 경우에는 반드시 return문을 작성해야함
	}
    </script>    
<title>XSS Attack Filter</title>
</head>
<body>
<h1>Reflected XSS 공격</h1>

<div class="form">
    <form action="reflected3.jsp" method="get" onsubmit="return replaceChr();">
    <!-- HTML 이벤트 핸들러에서 undefined 는 false 로 취급되지 않고 그냥 무시되기 때문에, 사실상 submit은 계속 진행됨 -->
        <div class="form__input">
            <div>
                <span>검색어</span>
                <input type="text" name="keyword"/>
            </div>
        </div>
        <input class="form__button" type="submit" value="검색"/>
    </form>
</div>

<div class="container">
<%	request.setCharacterEncoding("UTF-8");
	String keyword = request.getParameter("keyword");
	if (keyword==null) {
	keyword="";}	
	%>
	
    <div class="container__header">검색어 <%= keyword %></div>
</div>

</body>
</html>