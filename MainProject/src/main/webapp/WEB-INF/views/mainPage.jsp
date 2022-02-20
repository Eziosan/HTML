<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!doctype html>
<html lang="ko">
<head>

<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">


<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3"
	crossorigin="anonymous">

<link
	href="https://fonts.googleapis.com/css2?family=Noto+Sans+KR:wght@100;300;400;500;700;900&display=swap"
	rel="stylesheet">

<link rel="stylesheet"
	href="https://unpkg.com/swiper/swiper-bundle.min.css" />

<link href="./resources/css/Allusic.css" rel="stylesheet" />

<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"
	integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p"
	crossorigin="anonymous"></script>

<script src="https://code.jquery.com/jquery-3.6.0.min.js"
	integrity="sha256-/xUj+3OJU5yExlq6GSYGSHk7tPXikynS7ogEvDej/m4="
	crossorigin="anonymous"></script>




<title>홈 화면</title>

</head>
<body>





	<header
		class="p-2 fixed-top align-items-center border-bottom border-info"
		id="AllusicH"
		style="font-family: 'Noto Sans KR', sans-serif; background-color: white;">
		<div class="container-fluid w-75">
			<div
				class="d-flex flex-wrap align-items-center justify-content-start ">
				<!--          justify-content-lg-start-->
				<a href="/"
					class="d-flex align-items-center mb-2 mb-lg-0 text-dark text-decoration-none">
					<svg class="bi me-2" width="40" height="32" role="img"
						aria-label="Bootstrap">
						<use xlink:href="#bootstrap"></use></svg>
				</a>

				<ul
					class="nav col-12 col-lg-auto me-lg-auto mlmb-2 justify-content-center mb-md-0">
					<li><div class="nav-link px-2 w-100">
							<img src="../resources/img/mainLogo.png" alt="img" width=""
								height="40" style="margin-right: 30px">
						</div></li>
					<li><a href="#"
						class="nav-link px-2 mt-3   mb-0 link-secondary">곡</a></li>
					<li><a href="#" class="nav-link px-2 mt-3 link-dark">앨범</a></li>
					<li><a href="#" class="nav-link px-2 mt-3 link-dark">가수</a></li>
				</ul>

				<form class="col-12 col-lg-auto mb-3 mb-lg-0 me-lg-3">
					<input type="search" class="form-control"
						placeholder="# 태그를 검색해보세요" aria-label="Search"
						control-id="ControlID-2" style="background: #F2F2F2">
				</form>



				<div class="dropdown text-end">
					<a href="#"
						class="d-block link-dark text-decoration-none dropdown-toggle"
						id="dropdownUser1" data-bs-toggle="dropdown" aria-expanded="false">
						<img src="https://github.com/mdo.png" alt="mdo" width="32"
						height="32" class="rounded-circle">
					</a>



					<ul class="dropdown-menu text-small"
						aria-labelledby="dropdownUser1">
						<li><a class="dropdown-item" href="#" data-bs-toggle="modal"
							data-bs-target="#로그인모달">로그인</a></li>
						<li><a class="dropdown-item" href="#">프로필</a></li>
						<li><a class="dropdown-item" id="openModalBtn"
							data-bs-toggle="modal" data-bs-target="#staticBackdrop">마이
								리스트</a></li>
						<li><hr class="dropdown-divider"></li>
						<li><a class="dropdown-item" href="#" data-bs-toggle="modal"
							data-bs-target="#회원가입모달">Sign in</a></li>
					</ul>
				</div>
			</div>
		</div>



	</header>


	<!-- 로그인모달  -->
	<div class="modal fade" id="로그인모달" tabindex="-1"
		aria-labelledby="exampleModalCenterTitle"
		style="display: none; font-family: 'Noto Sans KR', sans-serif;"
		aria-hidden="true">
		<div class="modal-dialog modal-dialog-centered">
			<div class="modal-content"
				style="display: flex; justify-content: center; align-items: center; padding: 32px 0px 48px; width: 375px; height: 545px; border-radius: 3%">
				<header>
					<img src="../resources/img/mainLogo.png" width="150px">
				</header>

				<h2 class="로그인">로그인</h2>


				<section class="center-block;"
					style="width: 375px; height: 456px; margin: 0; align-content: center;">
					<!--  아이디 -->
					<div class="form-floating" id="모달정보입력란">
						<input type="email" class="form-control" id="floatingInput"
							placeholder="name@example.com" control-id="ControlID-1"
							style="background: rgb(245, 245, 245); border: none;"> <label
							for="floatingInput"
							style="color: rgb(160, 160, 160); padding-left: 20px">아이디</label>
					</div>
					<!-- 비밀번호 -->
					<div class="form-floating" id="모달정보입력란막내">
						<input type="password" class="form-control" id="floatingPassword"
							placeholder="Password" control-id="ControlID-2"
							style="background: rgb(245, 245, 245); border: none;"> <label
							for="floatingPassword"
							style="color: rgb(160, 160, 160); padding-left: 20px">비밀번호</label>
					</div>
					<div class="로그인버튼"
						style="width: 375px; align-content: center; align-items: center;">
						<button type="submit" class="로그인버튼" id="로그인버튼">
							로그인</button>
					</div>

					<div class="비번잃" id="로긘이미">
						<p style="color: red;">비밀번호를 잊어버리셨나요?</p>

					</div>

					<div class="회원가입" id="횐갑이미">
						<span>계정이 없으신가요?</span> <a
							style="color: red; text-decoration: none;" data-bs-toggle="modal"
							data-bs-target="#회원가입모달">회원가입</a>
					</div>
				</section>

			</div>
		</div>
	</div>


	<!-- 횐갑모달  -->
	<div class="modal fade" id="회원가입모달" tabindex="-1"
		aria-labelledby="exampleModalCenterTitle"
		style="display: none; font-family: 'Noto Sans KR', sans-serif;"
		aria-hidden="true">
		<div class="modal-dialog modal-dialog-centered">
			<div class="modal-content" id="회원가입모달창">
				<header>
					<img src="../resources/img/mainLogo.png" width="150px">
				</header>

				<div class="회원가입란" style="margin: 30px 0px 0px;">
					<p class="회원가입 fw-bold">회원가입</p>
				</div>

				<section class="center-block;"
					style="width: 375px; height: 350px; margin: 0; align-content: center;">
					<!--  아이디 -->
					<div class="form-floating" id="모달정보입력란">
						<input type="email" class="form-control" id="floatingInput"
							placeholder="name@example.com" control-id="ControlID-1"
							style="background: rgb(245, 245, 245); border: none;"> <label
							for="floatingInput"
							style="color: rgb(160, 160, 160); padding-left: 20px"> 이름</label>
					</div>

					<!-- 비밀번호 -->
					<div class="form-floating" id="모달정보입력란">
						<input type="email" class="form-control" id="floatingPassword"
							placeholder="Password" control-id="ControlID-2"
							style="background: rgb(245, 245, 245); border: none;"> <label
							for="floatingPassword"
							style="color: rgb(160, 160, 160); padding-left: 20px">이메일</label>
					</div>

					<!-- 비밀번호 -->
					<div class="form-floating" id="모달정보입력란막내">
						<input type="password" class="form-control" id="floatingPassword"
							placeholder="Password" control-id="ControlID-2"
							style="background: rgb(245, 245, 245); border: none;"> <label
							for="floatingPassword"
							style="color: rgb(160, 160, 160); padding-left: 20px">비밀번호</label>
					</div>

					<!--          회원가입 버튼 -->
					<div class="로그인버튼"
						style="width: 375px; align-content: center; align-items: center;">
						<button type="submit" class="로그인버튼" id="로그인버튼" style="">
							회원가입</button>
					</div>

					<div class="비번잃" id="로긘이미">
						<span>이미 가입하셨나요? </span> <a
							style="color: red; text-decoration: none;" data-bs-toggle="modal"
							data-bs-target="#로그인모달">로그인</a>

					</div>


				</section>

			</div>
		</div>
	</div>
		<!--      메인 -->
		      
	<main style="margin-top: 130px">
	    
	
	<!-- 메인 페이지 -->
	    
	<!--  <div class="album py-5 bg-white" style="font-family: 'Noto Sans KR', sans-serif; margin-top: 80px"></div>-->
	      
	<!-- 위쪽 슬라이드(1번째 슬라이드) 영역
		*** 좌버튼 target, 우버튼 target, 카로셀 id 가 같아야됨. 밑 참조 ex)아무거나1
	 -->
	    <div class="container" id="메인컨테이너">
	        
	        <!-- 좌버튼 -->
	         <button class="carousel-control-prev" type="button" data-bs-target="#아무거나1" data-bs-slide="prev"  id="좌버튼메인">
	<!--    <span class="왼쪽" aria-hidden="true" style="position: absolute; top: 130px" >-->
	        <img src="%EC%99%BC2.png" width="30px">
	<!--        </span>-->
	    <span class="visually-hidden">Previous</span>
	  </button>
	        
	        
	    <div class="titles fw-bold mb-4" style="font-size: 25px;">
	        #겨울에 듣기 좋은 노래
	        </div>
	        
	  
	        
	<!-- 곡 화면. **** 이쪽 데이터만 손대면 되긴 함--> 
	<div id="아무거나1" class="carousel slide" data-bs-ride="carousel" data-bs-interval="false">
		
		<!-- 간단 요약 : active 슬라이드는 한개만 만들고 나머지는 carousel-item으로 슬라이드 만듬  -->
		<c:forEach var="nomean" items="${songList }" begin="0" step="5" end="${songList.size() - 1 }" varStatus="status">
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
								<c:forEach var="song" items="${songList }" begin="${status.index }" end="${status.index + 4 }">
									<div class="col">
										<div class="card border border-white">
											<img src="${song.album_img} " alt="img" width="100%"
												height="225">
	
											<div class="card1 mt-3 ">
												<p class="card-text mb-1 fw-bold" style="font-size: 23px;">${song.song_name}</p>
												<p class="card-text mb-0" style="font-size: 15px;">${song.singer_name }</p>
												<span class="card-text mb-0"
													style="font-size: 13px; margin-left: 1px">
													${song.album_date } </span> <span class="card-text mb-0 fw-bold"
													style="font-size: 13px; margin-left: 2px"> • </span> <span
													class="card-text mb-0"
													style="font-size: 13px; margin-left: 2px">
													${song.album_name } </span>
												<p class="card-text mb-0 text-danger"
													style="font-size: 13px; margin-left: 1px">예상 ★2.4</p>
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
	        <img src="%EC%98%A42.png" width="30px">
	<!--    
	style="position: absolute; left: 100px; top: 130px"-->
	<!--      </span>-->
	    <span class="visually-hidden">Next</span>
	  </button>
	       
	       <!-- 메인페이지  닫는 태그 --> 
	</div>
	
	
	
	<!-- 두번째 슬라이드 영역(밑에 슬라이드) -->
	    <div class="container" id="메인컨테이너">
	        
	        <!-- 좌버튼 -->
	         <button class="carousel-control-prev" type="button" data-bs-target="#아무거나2" data-bs-slide="prev"  id="좌버튼메인">
	<!--    <span class="왼쪽" aria-hidden="true" style="position: absolute; top: 130px" >-->
	        <img src="%EC%99%BC2.png" width="30px">
	<!--        </span>-->
	    <span class="visually-hidden">Previous</span>
	  </button>
	        
	        
	    <div class="titles fw-bold mb-4" style="font-size: 25px;">
	        #여름에 듣기 좋은 노래
	        </div>
	        
	  
	        
	<!-- 곡 화면--> 
	<div id="아무거나2" class="carousel slide" data-bs-ride="carousel" data-bs-interval="false">
		
		<!-- searchResult 첫번째 창 곡 리스트 -->
		<c:forEach var="nomean" items="${likeSong }" begin="0" step="5" end="${likeSong.size() - 1 }" varStatus="status">
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
								<c:forEach var="song" items="${likeSong }" begin="${status.index }" end="${status.index + 4 }">
									<div class="col">
										<div class="card border border-white">
											<img src="${song.album_img} " alt="img" width="100%"
												height="225">
	
											<div class="card1 mt-3 ">
												<p class="card-text mb-1 fw-bold" style="font-size: 23px;">${song.song_name}</p>
												<p class="card-text mb-0" style="font-size: 15px;">${song.singer_name }</p>
												<span class="card-text mb-0"
													style="font-size: 13px; margin-left: 1px">
													${song.album_date } </span> <span class="card-text mb-0 fw-bold"
													style="font-size: 13px; margin-left: 2px"> • </span> <span
													class="card-text mb-0"
													style="font-size: 13px; margin-left: 2px">
													${song.album_name } </span>
												<p class="card-text mb-0 text-danger"
													style="font-size: 13px; margin-left: 1px">예상 ★2.4</p>
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
	        <img src="%EC%98%A42.png" width="30px">
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