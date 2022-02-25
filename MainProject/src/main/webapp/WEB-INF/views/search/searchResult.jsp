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

<link href="../resources/css/Allusic.css" rel="stylesheet" />

<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"
	integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p"
	crossorigin="anonymous"></script>

<script src="https://code.jquery.com/jquery-3.6.0.min.js"
	integrity="sha256-/xUj+3OJU5yExlq6GSYGSHk7tPXikynS7ogEvDej/m4="
	crossorigin="anonymous"></script>




<title>홈 화면</title>

   <script type="text/javascript">

	function searchCheck(){
		if($("#searchText").val().length < 1){
			alert("글자 수는 1자 이상 입력하셔야 합니다!!")
			return false;
		}

		return true;
			
	} 
    
    </script>

<!-- 
</head>
<body>
 -->

  	<!-- 리스트 해당하는 로그인, 회원가입 모달 불러오기 -->
	<c:import url="../searchmenu.jsp"></c:import>

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
					<li><a href="/mylife/main" ><div class="nav-link px-2 w-100">
							<img src="../resources/img/mainLogo.png" alt="img" width=""
								height="40" style="margin-right: 30px">
						</div></a></li>
				</ul>

				<form action="/mylife/search/searchResult" method="get"
					onsubmit="return searchCheck();"
					class="col-12 col-lg-auto mb-3 mb-lg-0 me-lg-3">
					<input type="search" id="searchText" name="searchText"
						class="form-control" placeholder="# 태그를 검색해보세요"
						aria-label="Search" control-id="ControlID-2"
						style="background: #F2F2F2">
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
						<c:if test="${user_id == null }">
							<li><a class="dropdown-item" href="#" data-bs-toggle="modal"
								data-bs-target="#로그인모달" id="#로그인모달버튼">로그인</a></li>
							<li><a class="dropdown-item" href="#" data-bs-toggle="modal"
								data-bs-target="#회원가입모달">회원가입</a></li>
						</c:if>

						<c:if test="${user_id != null }">
							<li><a class="dropdown-item" href="#">프로필</a></li>
							<li><a class="dropdown-item" id="openModalBtn"
								data-bs-toggle="modal" data-bs-target="#staticBackdrop">마이
									리스트</a></li>
							<li><hr class="dropdown-divider"></li>
							<li><a class="dropdown-item" href="logout?searchText=${searchText }">Sign out</a></li>
						</c:if>
					</ul>
				</div>
			</div>
		</div>



	</header>
	
	


	<!--      메인 -->
	<main class="배경 mt-3"
		style="width: 100vw; height: 1000px; font-family: 'Noto Sans KR', sans-serif;">

		<!--      검색결과1-->
		<div class="검색결과" id="검색결과">

			<div class="결과란" id="결과란">
				<p>"${searchText }"의 검색결과입니다.</p>
			</div>

		</div>
		<section id="결과창">
			<!-- 		<div id="종류">
				<div class="가수" id="컨텐츠종류"
					style="border-bottom-color: black; border-bottom: 2px solid;">
					컨텐츠</div>
				<div id="컨텐츠종류">가수</div>
				<div id="컨텐츠종류">리스트</div>
				<div id="컨텐츠종류">유저</div>
			</div> -->


			<c:choose>
				<c:when test="${searchResult1.size() < 1 }">
					<div class="titles fw-bold mb-4" style="font-size: 25px;">
						곡명으로 검색 ${songCount }</div>
					<br>
					<h1>검색 결과가 없습니다</h1>
				</c:when>
				<c:otherwise>

					<!-- 좌,우 버튼, 카로셀 슬라이드 덮는 태그 -->
					<div class="곡결과 " id="곡결과">

						<!--            좌버튼-->
						<button class="carousel-control-prev" type="button"
							data-bs-target="#곡결과s" data-bs-slide="prev"
							style="width: 30px; height: 30px; position: absolute; top: 380px; left: 180px;">
							<!--    <span class="왼쪽" aria-hidden="true" style="position: absolute; top: 130px" >-->
							<img src="../resources/img/왼2.png" width="30px">
							<!--        </span>-->
							<span class="visually-hidden">Previous</span>
						</button>

						<div class="titles fw-bold mb-4" style="font-size: 25px;">
							곡명으로 검색 ${songCount }</div>


						<!-- 카로셀 슬라이드들 감싸는 태그 -->
						<div id="곡결과s" class="carousel slide" data-bs-ride="carousel"
							style="height: 400px;" data-bs-interval="false">


							<!-- 첫번째 카로셀 모든 곡을 5개씩 여러개의 슬라이드로 나눠서 출력 -->

							<c:forEach var="nomean" items="${searchResult1 }" begin="0"
								step="5" end="${searchResult1.size() - 1 }" varStatus="status">
							현재 인덱스 : ${status.index }
						<!-- 현재 인덱스 0이면 1번째 곡(1번째 슬라이드)
							해당 슬라이드는 active가 되어야 함
							나머지 슬라이드는 active 없이
							div 태그 어디서 닫아주냐?? 저~~~~~~밑에 c:forEach 닫는 태그 위에 놓아 두었습니다
						 -->
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
								<c:forEach var="song" items="${searchResult1 }"
									begin="${status.index }" end="${status.index + 4 }">
									<div class="col">
										<div class="card border border-white">
											<img src="${song.album_img} " alt="img" width="100%"
												height="225">

											<div class="card1 mt-3 ">
												<p class="card-text mb-1 fw-bold" style="font-size: 23px;">
													<a
														href="/mylife/song/songPage?song_id=${song.song_id }&singer_id=${song.singer_id}">${song.song_name}</a>
												</p>
												<p class="card-text mb-0" style="font-size: 15px;">${song.singer_name }</p>
												<span class="card-text mb-0"
													style="font-size: 13px; margin-left: 1px">
													${song.album_date } </span> <span class="card-text mb-0 fw-bold"
													style="font-size: 13px; margin-left: 2px"> • </span> <span
													class="card-text mb-0"
													style="font-size: 13px; margin-left: 2px">
													${song.album_name } </span>
												<!-- 
												
												<p class="card-text mb-0 text-danger"
													style="font-size: 13px; margin-left: 1px">예상 ★2.4</p>
												 -->
												<div
													class="d-flex justify-content-between align-items-center">

													<small class="text-muted"></small>
												</div>
											</div>
										</div>
									</div>
								</c:forEach>
						</div>
					</div>
					</c:forEach>

					</div>


					<!--         우버튼-->
					<button class="carousel-control-next" type="button"
						data-bs-target="#곡결과s" data-bs-slide="next"
						style="width: 20px; height: 30px; position: absolute; top: 380px; right: 200px">
						<!--    <span class="오른쪽" aria-hidden="true" style="position: absolute; left: 200px; top: 130px">-->
						<img src="../resources/img/오2.png" width="30px">
						<!--    
style="position: absolute; left: 100px; top: 130px"-->
						<!--      </span>-->
						<span class="visually-hidden">Next</span>
					</button>

					</div>

				</c:otherwise>
			</c:choose>


			<c:choose>
				<c:when test="${searchResult2.size() < 1 }">
					<div class="titles fw-bold mb-4" style="font-size: 25px;">
						가수명으로 검색 ${songCount }</div>
					<br>
					<h1>검색 결과가 없습니다</h1>
				</c:when>
				<c:otherwise>


					<!--        앨범결과-->
					<div class="앨범결과 " id="앨범결과">

						<!--            좌버튼-->
						<button class="carousel-control-prev" id="앨범결과좌" type="button"
							data-bs-target="#앨범결과s" data-bs-slide="prev" style="">
							<!--    <span class="왼쪽" aria-hidden="true" style="position: absolute; top: 130px" >-->
							<img src="../resources/img/왼2.png" width="30px">
							<!--        </span>-->
							<span class="visually-hidden">Previous</span>
						</button>

						<div class="titles fw-bold mb-4" style="font-size: 25px;">
							가수명으로 검색</div>

						<!-- 카로셀 슬라이드 목록들을 감싸는 태그 -->
						<div id="앨범결과s" class="carousel slide" data-bs-ride="carousel"
							style="height: 400px;" data-bs-interval="false">


							<!-- 두번째 카로셀(앨범) 목록 표시 -->
							<c:forEach var="nomean" items="${searchResult2 }" begin="0"
								step="5" end="${searchResult2.size() - 1 }" varStatus="status">
							현재 인덱스 : ${status.index }
							
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

								<!-- 6~10 곡 프로필-->
								<c:forEach var="song" items="${searchResult2 }"
									begin="${status.index }" end="${status.index + 4 }">
									<div class="col">
										<div class="card border border-white">
											<img src="${song.album_img} " alt="img" width="100%"
												height="225">

											<div class="card1 mt-3 ">
												<p class="card-text mb-1 fw-bold" style="font-size: 23px;">
													<a
														href="/mylife/song/songPage?song_id=${song.song_id }&singer_id=${song.singer_id}">${song.song_name}</a>
												</p>
												<p class="card-text mb-0" style="font-size: 15px;">${song.singer_name }</p>
												<span class="card-text mb-0"
													style="font-size: 13px; margin-left: 1px">
													${song.album_date } </span> <span class="card-text mb-0 fw-bold"
													style="font-size: 13px; margin-left: 2px"> • </span> <span
													class="card-text mb-0"
													style="font-size: 13px; margin-left: 2px">
													${song.album_name } </span>
												<!-- 
												<p class="card-text mb-0 text-danger"
													style="font-size: 13px; margin-left: 1px">예상 ★2.4</p>
												
												 -->
												<div
													class="d-flex justify-content-between align-items-center">

													<small class="text-muted"></small>
												</div>
											</div>
										</div>
									</div>
								</c:forEach>
						</div>
					</div>
					</c:forEach>

					<!-- 두번째 2페이지 -->


					</div>

					<!--         우버튼-->
					<button class="carousel-control-next" id="앨범결과좌" type="button"
						data-bs-target="#앨범결과s" data-bs-slide="next" style="float: right;">
						<!--    <span class="오른쪽" aria-hidden="true" style="position: absolute; left: 200px; top: 130px">-->
						<img src="../resources/img/오2.png" width="30px">
						<!--    
style="position: absolute; left: 100px; top: 130px"-->
						<!--      </span>-->
						<span class="visually-hidden">Next</span>
					</button>


					</div>

				</c:otherwise>
			</c:choose>

		</section>
		<div class="container"></div>



	</main>
</body>
</html>
