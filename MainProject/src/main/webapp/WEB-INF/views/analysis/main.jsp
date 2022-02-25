<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

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

</head>
<body style="background-color: #f8f8f8;">


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
							<img src="%EC%B4%88%EC%95%882.png" alt="img" width="" height="40"
								style="margin-right: 30px">
						</div></li>
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
						<li><a class="dropdown-item" id="openModalBtn" href="/mylife/analysis/main">취향분석</a></li>
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
					<img src="%EC%B4%88%EC%95%882.png" width="150px">
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
						<button type="submit" class="로그인버튼" id="로그인버튼">로그인</button>
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
					<img src="%EC%B4%88%EC%95%882.png" width="150px">
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
	<main class="배경" id="리스트배경">

		<div class="container" id="konomibanner">
			<div class="프로필 카드"
				style="margin-right: auto; margin-left: auto; margin-top: 180px; margin-left: 20px ">
				<img src="../resources/img/profile/basic_profile.jpg"  height="40"
					style="border-radius: 50%">
				<span class="작사가명" id="아티스트이름">${user_id }</span>
			</div>
			
			<!--          
margin-top: 100px;
    width: 638px;
    height: 244.75px;
        background-color: white;
    border: 1px solid;
    border-color: lightgray;
    border-radius: 6px;
    padding: 0px;
    overflow: hidden;
-->
		</div>
		<div class="container" id="평가박스">
			<div id="평가">
				<div id="평가수">
					<div class="fw-bold" id="평가수텍">평가수</div>

				</div>

				<!--                평가 칸-->
				<div class="row" id="평가수내용">
					<div class="col-3" id="평가한칸">
						<div class="fw-bold" id="평가숫자">${userGradeList.allStarCount }</div>
						<div id="평가내용">총 별점 수</div>

					</div>
					<div class="col-3" id="평가한칸">
						<div class="fw-bold" id="평가숫자">
							<fmt:formatNumber type="number" maxFractionDigits="0"
								value="${userGradeList.listLikeNum}">
							</fmt:formatNumber>
						</div>
						<div id="평가내용">리스트 좋아요 수</div>

					</div>
					<div class="col-3" id="평가한칸">
						<div class="fw-bold" id="평가숫자">
							<fmt:formatNumber type="number" maxFractionDigits="0"
								value="${userGradeList.listCommentNum}">
							</fmt:formatNumber>
						</div>
						<div id="평가내용">리스트 댓글 수</div>

					</div>
					<div class="col-3" id="평가한칸">
						<div class="fw-bold" id="평가숫자">
							<fmt:formatNumber type="number" maxFractionDigits="0"
								value="${userGradeList.listCount}">
							</fmt:formatNumber>
						</div>
						<div id="평가내용">리스트 수</div>
					</div>
				</div>
				<div id="분포큰칸">
					<div id="평가수">
						<div class="fw-bold" id="평가수텍">평점 분포</div>

					</div>
					<div id="분포작은칸">

						<div id="분포도"></div>
						<div id="분포내용란" style="margin: 0 atuo;">
							<div id="분포내용">
								<div id="평가숫자">
									<fmt:formatNumber type="number" maxFractionDigits="1"
										value="${userGradeList.allStarSum}">
									</fmt:formatNumber>
								</div>
								<div id="평가내용">별점 평균</div>
							</div>
							<div id="분포내용">
								<div id="평가숫자">
									<fmt:formatNumber type="number" maxFractionDigits="0"
										value="${userGradeList.allsongCount}">
									</fmt:formatNumber>
								</div>
								<div id="평가내용">곡 평가 개수</div>
							</div>
							<div id="분포내용">
								<div id="평가숫자">${userGradeList.topStar}</div>
								<div id="평가내용">많이 준 별점</div>
							</div>
						</div>
					</div>

				</div>


			</div>

		</div>


		<div class="container" id="분석큰칸">
			<div id="태그큰칸">
				<div id="평가수">
					<div class="fw-bold" id="평가수텍">선호태그</div>
				</div>
				<div id="태그큰칸2">
					<div id="태그칸">
						<c:forEach var="tagName" items="${tagNameList }"
							varStatus="status">
							<c:choose>
								<c:when test="${status.count <= 3}">
									<span id="큰태그${status.count}">${tagName} ${status.count}</span>
								</c:when>
								<c:when test="${status.count > 3}">
									<span id="작은태그${status.count-3 }">${tagName}
										${status.count-3 }</span>
								</c:when>
								<c:otherwise>
								</c:otherwise>
							</c:choose>

						</c:forEach>
					</div>

				</div>


				<!--
                <div id="겨울" class="carousel slide" data-bs-ride="carousel" data-bs-interval="false">
    <div class="carousel-item active" >
-->
				<!-- 좌, 우 슬라이드 감쌈 -->
				<div id="가수큰칸">

					<button class="carousel-control-prev" style="" type="button"
						data-bs-target="#아무거나1" data-bs-slide="prev" id="좌버튼취향">
						<img src="../resources/img/왼2.png" width="15px"> <span
							class="visually-hidden">Previous</span>
					</button>
					<div id="평가수">
						<div class="fw-bold" id="평가수텍">선호가수</div>
					</div>





					<div id="가수큰칸2">

						<div id="아무거나1" class="carousel slide" data-bs-ride="carousel"
							data-bs-interval="false">
							<c:forEach var="nomean" items="${singerList }" step="3"
								varStatus="status">

								<c:choose>
									<c:when test="${status.index == 0 }">
										<div class="carousel-item active">
									</c:when>

									<c:when test="${status.index != 0 }">
										<div class="carousel-item">
											<!--          row-cols-1  row-cols-sm-2 row-cols-md-3 g-3 -->
									</c:when>
									<c:otherwise>
									</c:otherwise>
								</c:choose>

								<div id="캐러셀한칸">
									<c:forEach var="singer" items="${singerList }"
										begin="${status.index }" end="${status.index + 2 }">
										<div id="가수한칸">

											<span id="가수프로필칸"> 
												<img src="../resources/img/profile/basic_profile.jpg" id="선호가수프로필" width="80px" style="border-radius: 50%">
											</span>

											<div id="가수정보란">
												<div id="선호가수명">
													${singer.singer_name } <span id="선호가수점수"> 87점 • 12편
													</span>
													<div id="선호가수앨범">Love Poem</div>
												</div>
											</div>
										</div>
									</c:forEach>
								</div>
						</div>
						</c:forEach>
						<!-- slide 닫는 태그 -->
					</div>
					<button class="carousel-control-next" type="button"
						data-bs-target="#아무거나1" data-bs-slide="next" id="우버튼취향">
						<img src="../resources/img/오2.png" width="15px"> <span
							class="visually-hidden">Next</span>
					</button>
				</div>
			</div>


			<div id="국가큰칸">
				<div id="평가수">
					<div class="fw-bold" id="평가수텍">선호국가</div>
				</div>
				<div id="국가큰칸2">
					<div id="국가칸">
						<div id="국가탑">
							<c:forEach var="countryLog" items="${countryLogList}" begin="0"
								end="2">
								<div id="국가탑1">
									<div id="국가탑나라">${countryLog.country }</div>
									<div id="국가탑정보">${countryLog.all_star }점•
										${countryLog.grade_count }곡</div>
								</div>

							</c:forEach>

						</div>
						<ul id="국가밑큰">
							<c:forEach var="countryLog" items="${countryLogList}" begin="3"
								end="5">
								<li id="국가밑작">${countryLog.country }<span id="국밑내용">
										${countryLog.all_star }점 • ${countryLog.grade_count }곡 </span>
								</li>

							</c:forEach>

						</ul>


					</div>


				</div>

			</div>


			<div id="국가큰칸">
				<div id="평가수">
					<div class="fw-bold" id="평가수텍">선호장르</div>
				</div>
				<div id="국가큰칸2">
					<!--  
							<div id="장르코멘트">발라드충이군요</div>
						
						-->
					<div id="국가칸">
						<div id="국가탑">
							<c:forEach var="genreLog" items="${genreLogList}" begin="0"
								end="2">
								<div id="국가탑1">
									<div id="국가탑나라">${genreLog.genre }</div>
									<div id="국가탑정보">${genreLog.all_star }점•
										${genreLog.grade_count}곡</div>
								</div>
							</c:forEach>

						</div>
						<ul id="국가밑큰">
							<c:forEach var="genreLog" items="${genreLogList}" begin="3"
								end="5">
								<li id="국가밑작">${genreLog.genre }<span id="국밑내용">
										${genreLog.all_star }점 • ${genreLog.grade_count}곡 </span>
								</li>
							</c:forEach>
						</ul>


					</div>


				</div>

			</div>
		</div>
		</div>

	</main>
</body>
</html>
