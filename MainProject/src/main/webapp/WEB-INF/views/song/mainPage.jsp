<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<jsp:include page="/WEB-INF/views/menu/menu.jsp" />
	<h1>곡 페이지</h1>
	
	이런식으로 사진 출력
	<div>
		<img src="https://cloudfront-ap-northeast-1.images.arcpublishing.com/chosun/XG2MW2H3ZRW5FHDVSOMF6FDT3E.jpg"
		style="width : 1500px; height : 250px;">
	</div>
	
	
	<table>
		<tr>
			<td style= "border-right:2px solid; 
						border-top:2px solid;
						border-bottom:2px solid;
			color:gray" rowspan="3">
				<div>
					<img src="data:image/jpeg;base64,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"
					style="width : 200px; height : 300px;">
				</div>
			</td>
			<td style= "border-top:2px solid; 
						border-bottom:2px solid;
						color:gray">
				<h6>밤편지</h6>
				<h6>IU(아이유) | 밤편지</h6>
				<h6>2017 · 발라드 · 한국</h6>
			</td>
		</tr>
		<tr>
			<td style= "border-bottom:2px solid; color:gray">
				<h6>예상 ★2.4 | 평균 ★3.6(500명)</h6>
			</td>
		</tr>
		<tr>
			<td style= "border-bottom:2px solid; color:gray">
				<img src="https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRIWBqegTDdZcDQVLIw6TqgusGfOaFpeOrPMA&usqp=CAU"
				style="width : 50px; height :30px;">
			<h6>태그 보기</h6>
			</td>
		</tr>
	</table>
	1. 배너 사진 - select문 좋아요 수가 가장 높은 사진을 가져옴.  getBanner
	2. 앨범 사진 - select문 url을 가져와서 바로 출력			getAlbumPic
	3. 노래 정보 (제목, 가수, 앨범 명, 발매일, 장르, 국적) - select문 전체 join문 써야함.
	
	4. 예상 별점 <-기능 x 이름만 적어놓는걸로 평균<- 아예 날려버림*****
	
	5. 좋아요 수, 태그 추가 ....더보기(디자인만) - 좋아요 수 - select문, insert문을 활용하여 좋아요를 봄과 동시에 추가하면 추가되도록 하는 기능 구현
										태그 추가 버튼 누르면 tagPage로 이동 또는 팝업창으로 띄움.
	
	6. 가수 정보(가수 이름, 가수 사진) - select문
	7. 작사/작곡 정보 (이름, 사진) - select문
	
	8. 동영상 (URL로 표시) - select문 url
	9. 공연(디자인만)		-만약한다면 select
	
	Type 지정 resultType, parametertType 정하기
	
	
</body>
</html>