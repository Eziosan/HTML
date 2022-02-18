<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<title>메인 페이지</title>
<link rel="stylesheet" type="text/css"
	href="../resources/css/default.css">
<script src="https://code.jquery.com/jquery-3.6.0.js"></script> 
<script type="text/javascript">
	$(document).ready(function() {
		$(".join").on('click', function() {
			$(".popup").show();
			$(".dim").show();
		});
		
		$(".login").on('click', function() {
			$(".popup").show();
			$(".dim").show();
		});

		//popup안에있는 close버튼을 클릭했을 시 .close의 부모
		$(".popup .close").on('click', function() {
			$(this).parent().hide();
			$(".dim").hide();
		});

	});
</script>
</head>
<body>
	<h1>배너</h1>
	<br>
	<h1>프로필 / 이름 / 자기소개</h1>
	<br>
	<h1>평가 수</h1>
	<br>
	<h1>별점 분포 </h1>
	<br>
	<h1>선호 태그</h1>
	<br>
	<h1>선호 가수</h1>
	<br>
	<h1>선호 장르</h1>
	<br>
	<h1>선호 국가</h1>
	<br>
	
	
	<c:if test="${user_id == null }">
		<%-- <button class="join">회원가입</button>
		<jsp:include page="/WEB-INF/views/user/joinPopup.jsp" />
		<button class="login">로그인</button> --%>
		
		<a href="user/join">회원가입</a>
		<br>
		<a href="user/login">로그인</a>
	</c:if> 

	<c:if test="${user_id != null }">
		<a href="logout">로그아웃</a>
		<br>
		<a href="mypage">마이페이지</a>
	</c:if>
	
	<a href="song/mainPage">송페이지 이동</a>
	<br>
	<a href="search/test">검색 페이지 테스팅</a>


</body>
</html>
