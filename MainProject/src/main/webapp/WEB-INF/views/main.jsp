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

    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>
    
    <script src="https://code.jquery.com/jquery-3.6.0.min.js" integrity="sha256-/xUj+3OJU5yExlq6GSYGSHk7tPXikynS7ogEvDej/m4=" crossorigin="anonymous"></script>  
      
    <title>홈 화면</title>
      <style>
         @import url(//fonts.googleapis.com/earlyaccess/jejuhallasan.css);
    
      
      </style>
  </head>
  <body>
   </head>
  <body>
         
    
    
    <header class="p-2 mb-3 bg-white fixed-top align-items-center border-bottom border-info" style="font-family: 'Noto Sans KR', sans-serif;">
    <div class="container-fluid w-75">
      <div class="d-flex flex-wrap align-items-center justify-content-start ">
<!--          justify-content-lg-start-->
        <a href="/" class="d-flex align-items-center mb-2 mb-lg-0 text-dark text-decoration-none">
          <svg class="bi me-2" width="40" height="32" role="img" aria-label="Bootstrap"><use xlink:href="#bootstrap"></use></svg>
        </a>



<!-- 메뉴바 -->
        <ul class="nav col-12 col-lg-auto me-lg-auto mlmb-2 justify-content-center mb-md-0">
          <li><div  class="nav-link px-2 w-100" ><img src="./resources/img/로고.png" alt="img" width="" height="40" style="margin-right: 30px"> </div></li>
          <li><a href="https://www.naver.com/" class="nav-link px-2 mt-3   mb-0 link-secondary" style="">곡</a></li>
          <li><a href="#" class="nav-link px-2 mt-3 link-dark">앨범</a></li>
          <li><a href="#" class="nav-link px-2 mt-3 link-dark">가수</a></li>
        </ul>


<!-- 검색 툴바 -->
        <form class="col-12 col-lg-auto mb-3 mb-lg-0 me-lg-3">
          <input type="search" class="form-control" placeholder="# 태그를 검색해보세요"  aria-label="Search" control-id="ControlID-2" style="background: #F2F2F2">
        </form>

          
          
        <div class="dropdown text-end">
          <a href="#" class="d-block link-dark text-decoration-none dropdown-toggle" id="dropdownUser1" data-bs-toggle="dropdown" aria-expanded="false">
            <img src="https://github.com/mdo.png" alt="mdo" width="32" height="32" class="rounded-circle">
          </a>
                 
            
         
<!-- 로그인, 회원가입 -->            
          <ul class="dropdown-menu text-small" aria-labelledby="dropdownUser1">
            
            <c:if test="${user_id == null }">
            <li><a class="dropdown-item" href="/mylife/user/login">로그인</a></li>
            <li><a class="dropdown-item" href="/mylife/user/join">회원가입</a></li>
            </c:if>
            
            <c:if test="${user_id != null }">
            <li><a class="dropdown-item" href="#">프로필</a></li>
            <li><a class="dropdown-item" id="openModalBtn" href="#">마이 리스트</a></li>
            <li><hr class="dropdown-divider"></li>
            <li><a class="dropdown-item" href="/mylife/user/logout">Sign out</a></li>
            </c:if>
            
            
          </ul>
        </div>
      </div>
    </div>
        
 
        
  </header>
   


      
      
      
<main>
<!-- 메인 페이지 -->
    
  <div class="album py-5 bg-white" style="font-family: 'Noto Sans KR', sans-serif; margin-top: 80px">
    <div class="container" >

    <div class="titles fw-bold mb-4" style="font-size: 25px;">
        오늘의 TOP 5
        </div>
        
 
        
<!-- 곡 화면-->        
      <div class="row row-cols-sm-3 row-cols-lg-5" >
<!--          row-cols-1  row-cols-sm-2 row-cols-md-3 g-3 -->


<!-- [조회수] 곡 프로필-->
      <c:forEach var="song" items="${songList }">
        <div class="col">
          <div class="card border border-white">
            <img src="./resources/img/main/${song.album_img }" alt="img" width="100%" height="225">

            <div class="card1 mt-3 "> 
                <p class="card-text mb-1 fw-bold" style="font-size: 23px;">${song.song_name}</p>
                <p class="card-text mb-0" style="font-size: 15px;">${song.singer_name }</p>
                <span class="card-text mb-0" style="font-size: 13px; margin-left: 1px">
                    ${song.album_date } </span>
                <br>
                <span class="card-text mb-0" style="font-size: 13px; margin-left: 2px">
                    ${song.album_name } </span> 
                <p class="card-text mb-0 text-danger" style="font-size: 13px; margin-left: 1px">예상 ★2.4</p>
              <div class="d-flex justify-content-between align-items-center">

                <small class="text-muted"></small>
              </div>
            </div>
          </div>
        </div>
      </c:forEach>
       
        </div>
        
    
      </div>
    </div>




    <!-- 메인 페이지 -->
  <div class="album py-5 bg-white" style="font-family: 'Noto Sans KR', sans-serif;">
    <div class="container">

    <div class="titles fw-bold mb-4" style="font-size: 25px; ">
        지금 인기 있는 곡
        </div>        
<!-- 곡 화면-->        
      <div class="row row-cols-sm-5">
<!--          row-cols-1  row-cols-sm-2 row-cols-md-3 g-3 -->


<!-- [좋아요] 곡 프로필-->
	<c:forEach var="song" items="${likeSong }">
        <div class="col">
          <div class="card border border-white">
            <img src="./resources/img/main/${song.album_img }" alt="img" width="100%" height="225">
			
			
            <div class="card1 mt-3 "> 
                <p class="card-text mb-1 fw-bold" style="font-size: 23px;">${song.song_name }</p>
                <p class="card-text mb-0" style="font-size: 15px;">${song.singer_name }</p>
                <span class="card-text mb-0" style="font-size: 13px; margin-left: 1px">
                    ${song.album_date } </span>
                <br>
                <span class="card-text mb-0" style="font-size: 13px; margin-left: 2px">
                    ${song.album_name }  </span> 
                <p class="card-text mb-0 text-danger" style="font-size: 13px; margin-left: 1px">예상 ★2.4</p>
              <div class="d-flex justify-content-between align-items-center">

                <small class="text-muted"></small>
              </div>
            </div>
          </div>
        </div>
	</c:forEach>

 
        </div>
        
    
      </div>
    </div>

</main>

  </body>
</html>