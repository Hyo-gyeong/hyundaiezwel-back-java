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
   
   <!--  input 태그에 들어가는 값은 필터링을 하지만 이렇게 해도 url에 직접 입력하는 공격은 막지 못함 -->
   <script type="text/javascript">
        function submitHandler() { // 정규식을 통해 특수문자 입력 불가능 하도록 필터링
            const keyword = document.querySelector("input[name='keyword']");
            const regex = /^[ㄱ-ㅎ|가-힣|a-z|A-Z|0-9| |]+$/;
            if (!regex.test(keyword.value)) { // RegExp.prototype.test(),정규식(RegExp) 객체가 가진 메서드 중 하나
											//  	주어진 문자열이 정규식과 매치되는지 검사하고,결과를 true / false 로 반환
                alert('특수 문자는 입력할 수 없습니다.');
                return false; // submit 막기
            }
            return true;
        }
    </script>    
<title>XSS Attack Filter</title>
</head>
<body>
<h1>Reflected XSS 공격</h1>

<div class="form">
    <form action="reflected2.jsp" method="get" onsubmit="return submitHandler();">
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
	
    <div class="container__header">검색어 <%=keyword %></div>
</div>

</body>
</html>