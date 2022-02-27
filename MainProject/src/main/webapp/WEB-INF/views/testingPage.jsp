<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!doctype html>
<html lang="en">
  <head>

    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">


    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
      
    <link href="https://fonts.googleapis.com/css2?family=Noto+Sans+KR:wght@100;300;400;500;700;900&display=swap" rel="stylesheet">

    <link rel="stylesheet" href="https://unpkg.com/swiper/swiper-bundle.min.css"/>  
    
    <link href="./resources/css/Allusic.css" rel="stylesheet"/>  
      
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>
    
    <script src="https://code.jquery.com/jquery-3.6.0.min.js" integrity="sha256-/xUj+3OJU5yExlq6GSYGSHk7tPXikynS7ogEvDej/m4=" crossorigin="anonymous"></script>  
      


      
    <title>홈 화면</title>
	
	<main style="margin-top: 130px">
	 
	
	<!-- 메인 페이지 -->
	    
	<!--  <div class="album py-5 bg-white" style="font-family: 'Noto Sans KR', sans-serif; margin-top: 80px"></div>-->
	      
	<!-- 위쪽 슬라이드(1번째 슬라이드) 영역
		*** 좌버튼 target, 우버튼 target, 카로셀 id 가 같아야됨. 밑 참조 ex)아무거나1
	 -->
	    <div class="container" id="메인컨테이너">
	        
	        <!-- 좌버튼 -->
	         <button class="carousel-control-prev" type="button" data-bs-target="#아무거나1" data-bs-slide="prev"  id="좌버튼메인">

	        <img src="./resources/img/left.png" width="30px">

	    <span class="visually-hidden">Previous</span>
	  </button>
	  
	        
	        
	    <div class="titles fw-bold mb-4" style="font-size: 25px;">
	        한국
	        </div>
	        
	  
	        
	<!-- 곡 화면. **** 이쪽 데이터만 손대면 되긴 함--> 
	<div id="아무거나1" class="carousel slide" data-bs-ride="carousel" data-bs-interval="false">
		
		<!-- 간단 요약 : active 슬라이드는 한개만 만들고 나머지는 carousel-item으로 슬라이드 만듬  -->
		<c:forEach var="nomean" items="${korean }" step="5" varStatus="status">
						<c:choose>
							<c:when test="${status.index == 0 }">
								<div class="carousel-item active">
								<div class="row row-cols-sm-3 row-cols-lg-5">
							</c:when>
							
							<c:when test="${status.index != 0 }">
								<div class="carousel-item">
								<div class="row row-cols-sm-3 row-cols-lg-5">
										<!--          row-cols-1  row-cols-sm-2 row-cols-md-3 g-3 -->
							</c:when>
							<c:otherwise>
							</c:otherwise>
						</c:choose>
						
						<!-- 곡 프로필  begin : 현재 인덱스 위치(각 슬라이드의 첫번째 곡의 인덱스), end : 각 슬라이드의 마지막 곡의 인덱스
							각 슬라이드의 1,2,3,4,5번째 곡이 들어감
						 -->
								<c:forEach var="song" items="${korean }" begin="${status.index }" end="${status.index + 4 }">
									<div class="col">
										<div class="card border border-white">
										<a href="/mylife/song/songPage?song_id=${song.song_id }&singer_id=${song.singer_id}">
											<img src="${song.album_img} " alt="img" width="100%"
												height="225"></a>
	
											<div class="card1 " style="text-overflow: ellipsis;
												    overflow: hidden;
												    white-space: nowrap;
												    margin-top: 12px;">
												<a href="/mylife/song/songPage?song_id=${song.song_id }&singer_id=${song.singer_id}" 
												class="card-text mb-1 fw-bold" id="메인곡명">${song.song_name}</a>
												<p class="card-text mb-0" style="font-size: 15px;">${song.singer_name }</p>
												<span class="card-text mb-0"
													style="font-size: 13px; margin-left: 1px; color: #74747b;">
													${song.album_date } </span> <span class="card-text mb-0 fw-bold"
													style="font-size: 13px; margin-left: 2px; color: #74747b;"> • </span> <span
													class="card-text mb-0"
													style="font-size: 13px; margin-left: 2px;
													text-overflow: ellipsis;
												    overflow: hidden;
												    white-space: nowrap;
												    color: #74747b;">
													${song.album_name } </span>
												<div
													class="d-flex justify-content-between align-items-center">
	
													<small class="text-muted"></small>
												</div>
											</div>
										</div>
									</div>
								</c:forEach>
								
								<!-- <div class="row row-cols-sm-3 row-cols-lg-5"> 닫는 태그 -->
							</div>
							<!-- <div class="carousel-item active / item 닫는 태그"> -->
						</div>
		<!-- 큰 forEach문 닫는 태그 -->
		</c:forEach>	
		<!-- carousel slide닫는 태그. 이 다음 우버튼 -->
		</div>
	        
	        <button class="carousel-control-next" type="button" data-bs-target="#아무거나1" data-bs-slide="next"  
	        id="우버튼메인">
	<!--    <span class="오른쪽" aria-hidden="true" style="position: absolute; left: 200px; top: 130px">-->
	        <img src="./resources/img/right.png" width="30px">
	<!--    
	style="position: absolute; left: 100px; top: 130px"-->
	<!--      </span>-->
	    <span class="visually-hidden">Next</span>
	  </button>
	       
	       <!-- 메인페이지  닫는 태그 --> 
	</div>
	
	
	
	
	<!-- 두번째 슬라이드 -->
	    
	<!--  <div class="album py-5 bg-white" style="font-family: 'Noto Sans KR', sans-serif; margin-top: 80px"></div>-->
	      
	<!-- 위쪽 슬라이드(1번째 슬라이드) 영역
		*** 좌버튼 target, 우버튼 target, 카로셀 id 가 같아야됨. 밑 참조 ex)아무거나1
	 -->
	    <div class="container" id="메인컨테이너">
	        
	        <!-- 좌버튼 -->
	         <button class="carousel-control-prev" type="button" data-bs-target="#아무거나2" data-bs-slide="prev"  id="좌버튼메인">

	        <img src="./resources/img/left.png" width="30px">

	    <span class="visually-hidden">Previous</span>
	  </button>
	  
	        
	        
	    <div class="titles fw-bold mb-4" style="font-size: 25px;">
	        일본
	        </div>
	        
	  
	        
	<!-- 곡 화면. **** 이쪽 데이터만 손대면 되긴 함--> 
	<div id="아무거나2" class="carousel slide" data-bs-ride="carousel" data-bs-interval="false">
		
		<!-- 간단 요약 : active 슬라이드는 한개만 만들고 나머지는 carousel-item으로 슬라이드 만듬  -->
		<c:forEach var="nomean" items="${japanese }" step="5" varStatus="status">
						<c:choose>
							<c:when test="${status.index == 0 }">
								<div class="carousel-item active">
								<div class="row row-cols-sm-3 row-cols-lg-5">
							</c:when>
							
							<c:when test="${status.index != 0 }">
								<div class="carousel-item">
								<div class="row row-cols-sm-3 row-cols-lg-5">
										<!--          row-cols-1  row-cols-sm-2 row-cols-md-3 g-3 -->
							</c:when>
							<c:otherwise>
							</c:otherwise>
						</c:choose>
						
						<!-- 곡 프로필  begin : 현재 인덱스 위치(각 슬라이드의 첫번째 곡의 인덱스), end : 각 슬라이드의 마지막 곡의 인덱스
							각 슬라이드의 1,2,3,4,5번째 곡이 들어감
						 -->
								<c:forEach var="song" items="${japanese }" begin="${status.index }" end="${status.index + 4 }">
									<div class="col">
										<div class="card border border-white">
										<a href="/mylife/song/songPage?song_id=${song.song_id }&singer_id=${song.singer_id}">
											<img src="${song.album_img} " alt="img" width="100%"
												height="225"></a>
	
											<div class="card1 " style="text-overflow: ellipsis;
												    overflow: hidden;
												    white-space: nowrap;
												    margin-top: 12px;">
												<a href="/mylife/song/songPage?song_id=${song.song_id }&singer_id=${song.singer_id}" 
												class="card-text mb-1 fw-bold" id="메인곡명">${song.song_name}</a>
												<p class="card-text mb-0" style="font-size: 15px;">${song.singer_name }</p>
												<span class="card-text mb-0"
													style="font-size: 13px; margin-left: 1px; color: #74747b;">
													${song.album_date } </span> <span class="card-text mb-0 fw-bold"
													style="font-size: 13px; margin-left: 2px; color: #74747b;"> • </span> <span
													class="card-text mb-0"
													style="font-size: 13px; margin-left: 2px;
													text-overflow: ellipsis;
												    overflow: hidden;
												    white-space: nowrap;
												    color: #74747b;">
													${song.album_name } </span>
												<div
													class="d-flex justify-content-between align-items-center">
	
													<small class="text-muted"></small>
												</div>
											</div>
										</div>
									</div>
								</c:forEach>
								
								<!-- <div class="row row-cols-sm-3 row-cols-lg-5"> 닫는 태그 -->
							</div>
							<!-- <div class="carousel-item active / item 닫는 태그"> -->
						</div>
		<!-- 큰 forEach문 닫는 태그 -->
		</c:forEach>	
		<!-- carousel slide닫는 태그. 이 다음 우버튼 -->
		</div>
	        
	        <button class="carousel-control-next" type="button" data-bs-target="#아무거나2" data-bs-slide="next"  
	        id="우버튼메인">
	<!--    <span class="오른쪽" aria-hidden="true" style="position: absolute; left: 200px; top: 130px">-->
	        <img src="./resources/img/right.png" width="30px">
	<!--    
	style="position: absolute; left: 100px; top: 130px"-->
	<!--      </span>-->
	    <span class="visually-hidden">Next</span>
	  </button>
	       
	       <!-- 메인페이지  닫는 태그 --> 
	</div>
	
	
	<!-- 세번째 슬라이드 영역(밑에 슬라이드) -->
	    <div class="container" id="메인컨테이너">
	        
	        <!-- 좌버튼 -->
	         <button class="carousel-control-prev" type="button" data-bs-target="#아무거나3" data-bs-slide="prev"  id="좌버튼메인">
	<!--    <span class="왼쪽" aria-hidden="true" style="position: absolute; top: 130px" >-->
	        <img src="./resources/img/left.png" width="30px">
	<!--        </span>-->
	    <span class="visually-hidden">Previous</span>
	  </button>
	        
	        
	    <div class="titles fw-bold mb-4" style="font-size: 25px;">
	        미국
	    </div>
	        
	  
	        
	<!-- 곡 화면--> 
	<div id="아무거나3" class="carousel slide" data-bs-ride="carousel" data-bs-interval="false">
		
		<!-- searchResult 첫번째 창 곡 리스트 -->
		<c:forEach var="nomean" items="${american }" step="5"  varStatus="status">
						<c:choose>
							<c:when test="${status.index == 0 }">
								<div class="carousel-item active">
								<div class="row row-cols-sm-3 row-cols-lg-5">
							</c:when>
							
							<c:when test="${status.index != 0 }">
								<div class="carousel-item">
								<div class="row row-cols-sm-3 row-cols-lg-5">
										<!--          row-cols-1  row-cols-sm-2 row-cols-md-3 g-3 -->
							</c:when>
							<c:otherwise>
							</c:otherwise>
						</c:choose>
						
						<!-- 곡 프로필  begin : 현재 인덱스 위치(각 슬라이드의 첫번째 곡의 인덱스), end : 각 슬라이드의 마지막 곡의 인덱스 -->
								<c:forEach var="song" items="${american }" begin="${status.index }" end="${status.index + 4 }">
									<div class="col">
										<div class="card border border-white">
											<a href="/mylife/song/songPage?song_id=${song.song_id }&singer_id=${song.singer_id}">
												<img src="${song.album_img} " alt="img" width="100%"
													height="225"></a>
		
												<div class="card1 " style="text-overflow: ellipsis;
													    overflow: hidden;
													    white-space: nowrap;
													    margin-top: 12px;">
													<a href="/mylife/song/songPage?song_id=${song.song_id }&singer_id=${song.singer_id}" 
													class="card-text mb-1 fw-bold" id="메인곡명">${song.song_name}</a>
													<p class="card-text mb-0" style="font-size: 15px;">${song.singer_name }</p>
													<span class="card-text mb-0"
														style="font-size: 13px; margin-left: 1px; color: #74747b;">
														${song.album_date } </span> <span class="card-text mb-0 fw-bold"
														style="font-size: 13px; margin-left: 2px; color: #74747b;"> • </span> <span
														class="card-text mb-0"
														style="font-size: 13px; margin-left: 2px;
														text-overflow: ellipsis;
													    overflow: hidden;
													    white-space: nowrap;
													    color: #74747b;">
														${song.album_name } </span>
													<div
														class="d-flex justify-content-between align-items-center">
		
														<small class="text-muted"></small>
													</div>
												</div>
											</div>
										<%-- <div class="card border border-white">
											<img src="./resources/img/album/${song.album_img} " alt="img" width="100%"
												height="225">
	
											<div class="card1 mt-3 " style="
													text-overflow: ellipsis;
												    overflow: hidden;
												    white-space: nowrap;">
												<a href="/mylife/song/songPage?song_id=${song.song_id }&singer_id=${song.singer_id}" class="card-text mb-1 fw-bold" style="font-size: 23px;">${song.song_name}</a>
												<p class="card-text mb-0" style="font-size: 15px;">${song.singer_name }</p>
												
												
												<span class="card-text mb-0"
													style="font-size: 13px; margin-left: 1px">
													${song.album_date } </span> <span class="card-text mb-0 fw-bold"
													style="font-size: 13px; margin-left: 2px"> • </span> 
													<span
													class="card-text mb-0"
													style="font-size: 13px; 
													margin-left: 2px;
													text-overflow: ellipsis;
												    overflow: hidden;
												    white-space: nowrap; 
													">
													${song.album_name } </span>

												<div
													class="d-flex justify-content-between align-items-center">
	
													<small class="text-muted"></small>
												</div>
											</div>
										</div> --%>
									</div>
								</c:forEach>
								
								<!-- <div class="row row-cols-sm-3 row-cols-lg-5"> 닫는 태그 -->
							</div>
							<!-- <div class="carousel-item active / item 닫는 태그"> -->
						</div>
		<!-- 큰 forEach문 닫는 태그 -->
		</c:forEach>	
		<!-- carousel slide닫는 태그. 이 다음 우버튼 -->
		</div>
	        
	        <button class="carousel-control-next" type="button" data-bs-target="#아무거나3" data-bs-slide="next"  
	        id="우버튼메인">
	<!--    <span class="오른쪽" aria-hidden="true" style="position: absolute; left: 200px; top: 130px">-->
	        <img src="./resources/img/right.png" width="30px">
	<!--    
	style="position: absolute; left: 100px; top: 130px"-->
	<!--      </span>-->
	    <span class="visually-hidden">Next</span>
	  </button>
	       
	       <!-- 두번째 슬라이드 영역 닫는 태그 --> 
	</div>
	
	
	
	
	
	</main>

  </body>
</html>