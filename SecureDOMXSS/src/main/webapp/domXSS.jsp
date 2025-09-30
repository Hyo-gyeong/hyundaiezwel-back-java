<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<!DOCTYPE html>
<html>
<head>
    <style>
        
    </style>
    <script type="text/javascript">
		// 서버에서 해석해야할 내용이 없는 공격. 맨 위 page 뿐.
		// 정적 페이지니까 한 번 서버가 해석을 했으면 그 다음에 요청을 해도 새로 읽기 않고 읽은 내용 그대로 보냄
		// 서버는 일정 시간이 지난 후 새로 읽도록 요청 가능. 그 전에는 매번 새로 읽지 않음
		const hash = window.location.hash.slice(1);
			// window.location.hash는 #부터 뒤쪽 문자열을 가져옴, 현 domain에 대한 정보 반환, slice(idx) idx부터 끝까지 추출
			// .slice(1)을 해서 #을 잘라내고 → first.jsp만 남김. hash.slice(1) -> hash 문자열이 #first.jsp면 first.jsp가 반환됨
		if (hash){ // 만약 해시 값이 있으면, first.jsp -> 일반 문자열에 해당
			// decodeURIComponent로 디코딩한 뒤 해당 URL로 강제로 이동시킴
			window.location.href = decodeURIComponent(hash); // first.jsp -> /first.jsp로 구성 -> hashevent발생
		}
		// 사용자가 브라우저에서 #second.jsp 같은 새로운 해시로 바꾸면
		// 이벤트(hashchange)가 발생 → 자동으로 해당 페이지로 이동
		window.addEventListener('hashchange', function(){
			// 클라이언트단에서 script 코드가 전부 다 보이기 때문에 이 안에서 필터링을 하는것은 의미가 없음.
			// 하지만 최소한 해시 url은 필터링이랑 같이 써야함.
			window.location.href = decodeURIComponent(window.location.hash.slice(1));
		});
    </script>
    <meta charset="UTF-8">
    <title>DOM Based XSS 공격</title>
</head>

<body>
<h1>DOM Based XSS 공격</h1>

<div class="container">
	<!-- 
		http://localhost:8080/SecureDOMXSS/domXSS.jsp -> First 바로가기 클릭
		-> url이 http://localhost:8080/SecureDOMXSS/domXSS.jsp#first.jsp 이렇게 바뀜
		-> 브라우저가 못알아들으니까 값을 바꿔주거나 해시값을 가져다가 #을 없애고 /first.jsp 만들어서 붙여넣기
	 -->
    <a id="first" href="#first.jsp" class="item">First 바로가기</a>
    <a id="second" href="#second.jsp" class="item">Second 바로가기</a>
</div>

</body>
</html>