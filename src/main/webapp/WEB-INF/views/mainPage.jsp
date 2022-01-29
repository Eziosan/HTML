<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<html>
<head>
<title>메인 페이지</title>
<link rel="stylesheet" type="text/css"
	href="./resources/css/default.css">
<script src="https://code.jquery.com/jquery-3.6.0.js"></script>
<script type="text/javascript">
$(document).ready(function(){
	$(".open").on('click', function(){
		$(".popup").show();
		$(".dim").show();

	});
	$(".popup .close").on('click', function(){
		$(this).parent().hide();
		$(".dim").hide();

	});
});

</script>
</head>
<body>

	<a href="#a" class="open">로그인</a>
	
	<jsp:include page="/WEB-INF/views/popupPage.jsp" />

</body>
</html>
