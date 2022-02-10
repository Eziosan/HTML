<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<jsp:include page="/WEB-INF/views/menu/header.jsp" />
	<h1>곡 페이지</h1>
	
	
	
		완료 1. 배너 사진 - select문 좋아요 수가 가장 높은 사진을 가져옴. 
		완료 2. 앨범 사진 - select문 url을 가져와서 바로 출력		
		완료	3. 노래 정보 (제목, 가수, 앨범 명, 발매일, 장르, 국적) 
		
		
			
		완료	5. 좋아요 수 - select문, update문을 활용하여 좋아요를 봄과 동시에 추가하면 추가되도록 하는 기능 구현
		
		완료 6.  태그 추천수 증가, 태그 상위 3개 가져오기 완료  
		
		태그 추가만 미구현 	6.	태그 추가 - 태그 추가 버튼 누르면 tagPage로 이동 또는 팝업창으로 띄움.
		
		특정 곡에 7가지의 태그를 넣는 기능.
		만약 이미 태그가 있으면 좋아요 수만 증가하도록 함.
			
		완료	6. 가수 정보(가수 이름, 가수 사진) - select문
			7. 작사/작곡 정보 (이름, 사진) - select문
		
	
	<h1>배너 사진 URL 입니다. ${banner } </h1>
	<h1>앨범 사진 URL 입니다. ${ai }</h1>
	<h1>곡 좋아요 수 입니다. ${sl }</h1>
	
	
</body>
</html>