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
    <script type="text/javascript">
    //로그인 유효성
    function formLogin(){
		//유효성 검사
		var user_id = document.getElementById("user_id").value;
		var user_pw = document.getElementById("user_pw").value;
	
		//1. id, pw 유무 검사
		if(user_id.length == "" && user_pw.length == ""){
			document.getElementById("loginCheck").innerHTML='아이디, 비밀번호를 입력해주세요';
		return false;
		}
		
		if(user_id.length == ""){
			document.getElementById("loginCheck").innerHTML='아이디를 입력해주세요';
		return false;
		}
		
		if(user_pw.length == ""){
			document.getElementById("loginCheck").innerHTML='비밀번호를 입력해주세요';
		return false;
		}
		
		//2. id, pw 둘다 잘못 입력 되었을 경우
		if((user_id.length < 4 || user_pw.length > 10) &&
				(user_pw.length < 4 || user_pw.length > 10)){
		document.getElementById("loginCheck").innerHTML='아이디, 비밀번호를 올바르게 입력하세요';
		return false;
		}
		
		
		//3. id 유효성 검사
		if(user_id.length < 4 || user_pw.length > 10){
			document.getElementById("loginCheck").innerHTML='아이디를 올바르게 입력하세요';
		return false;
		}
		
		//4. pw 유효성 검사
		if(user_pw.length < 4 || user_pw.length > 10){
			document.getElementById("loginCheck").innerHTML='비밀번호를 올바르게 입력하세요';
		return false;
		}
		
	return true;
	}
    
    //회원가입 유효성
    function formJoin(){
	//유효성 검사
	var join_name = document.getElementById("join_name").value;
	var join_id = document.getElementById("join_id").value;
	var join_pw = document.getElementById("join_pw").value;
	
	//1. 이름, id, pw 입력 안되었을 경우
	if(join_name.length == "" && join_id.length == "" && join_pw.length == ""){
		document.getElementById("joinCheck").innerHTML='이름, 아이디, 비밀번호를 입력해주세요';
		return false;
	}
	
	if(join_name.length == ""){
		document.getElementById("joinCheck").innerHTML='이름을 입력해주세요';
		return false;
	}
	
	if(join_id.length == ""){
		document.getElementById("joinCheck").innerHTML='아이디를 입력해주세요';
		return false;
	}
	
	if(join_pw.length == ""){
		document.getElementById("joinCheck").innerHTML='비밀번호를 입력해주세요';
		return false;
	}
	
	
	//2. id, pw 둘다 잘못 입력 되었을 경우
	if((join_id.length < 4 || join_pw.length > 10) &&
			(user_pw.length < 4 || user_pw.length > 10)){
	document.getElementById("joinCheck").innerHTML='아이디, 비밀번호를 올바르게 입력하세요';
	return false;
	}
	
	
	//3. id 유효성 검사
	if(join_id.length < 4 || join_pw.length > 10){
		document.getElementById("joinCheck").innerHTML='아이디를 올바르게 입력하세요';
	return false;
	}
	
	//4. pw 유효성 검사
	if(join_pw.length < 4 || join_pw.length > 10){
		document.getElementById("joinCheck").innerHTML='비밀번호를 올바르게 입력하세요';
	return false;
	}
	
		return true;
	}

	function searchCheck(){
		if(window.event.keyCode == 13){
			alert("enter키 클릭");
			var searchText = $("#searchText").text();
			location.href="/mylife/search/search?searchText=" + searchText;
		}
	}
    
    </script>
      <style>
         @import url(//fonts.googleapis.com/earlyaccess/jejuhallasan.css);
    
      
      </style>
  </head>
  <body>
                  
    
    
    <header class="p-2 mb-3 fixed-top align-items-center border-bottom border-info" id="AllusicH" style="font-family: 'Noto Sans KR', sans-serif; background-color: white;">
    <div class="container-fluid w-75">
      <div class="d-flex flex-wrap align-items-center justify-content-start ">
<!--          justify-content-lg-start-->
        <a href="/" class="d-flex align-items-center mb-2 mb-lg-0 text-dark text-decoration-none">
          <svg class="bi me-2" width="40" height="32" role="img" aria-label="Bootstrap"><use xlink:href="#bootstrap"></use></svg>
        </a>

        <ul class="nav col-12 col-lg-auto me-lg-auto mlmb-2 justify-content-center mb-md-0">
          <li><div  class="nav-link px-2 w-100" ><img src="./resources/img/mainLogo.png" alt="img" width="" height="40" style="margin-right: 30px"> </div></li>
          <li><a href="https://www.naver.com/" class="nav-link px-2 mt-3   mb-0 link-secondary" style="">곡</a></li>
          <li><a href="#" class="nav-link px-2 mt-3 link-dark">앨범</a></li>
          <li><a href="#" class="nav-link px-2 mt-3 link-dark">가수</a></li>
        </ul>

        <form action="/mylife/search/search" method="get" onsubmit="return searchCheck()"
        			class="col-12 col-lg-auto mb-3 mb-lg-0 me-lg-3">
          <input type="search" id="searchText" name="searchText" class="form-control" placeholder="# 태그를 검색해보세요"  aria-label="Search" control-id="ControlID-2" style="background: #F2F2F2">
        </form>

          
          
        <div class="dropdown text-end">
          <a href="#" class="d-block link-dark text-decoration-none dropdown-toggle" id="dropdownUser1" data-bs-toggle="dropdown" aria-expanded="false">
            <img src="https://github.com/mdo.png" alt="mdo" width="32" height="32" class="rounded-circle">
          </a>
                 
            
            
          <ul class="dropdown-menu text-small" aria-labelledby="dropdownUser1">
           <c:if test="${user_id == null }">
            <li><a class="dropdown-item" href="#" data-bs-toggle="modal" data-bs-target="#로그인모달">로그인</a></li>
            <li><a class="dropdown-item" href="#" data-bs-toggle="modal" data-bs-target="#회원가입모달">회원가입</a></li>
            </c:if>
            
            <c:if test="${user_id != null }">
            <li><a class="dropdown-item" href="#">프로필</a></li>
            <li><a class="dropdown-item" id="openModalBtn" data-bs-toggle="modal" data-bs-target="#staticBackdrop">마이 리스트</a></li>
            <li><hr class="dropdown-divider"></li>
            <li><a class="dropdown-item" href="logout">Sign out</a></li>
            </c:if>
          </ul>
        </div>
      </div>
    </div>
        
 
        
  </header>
   
      
     <!-- 로그인모달  -->
    <div class="modal fade" id="로그인모달" tabindex="-1" aria-labelledby="exampleModalCenterTitle" style="display: none; font-family: 'Noto Sans KR', sans-serif;" aria-hidden="true" >
  <div class="modal-dialog modal-dialog-centered">
    <div class="modal-content" style="display: flex; justify-content: center; align-items: center; padding: 32px 0px 48px; width: 375px; height: 545px; border-radius: 3%">
        <header>
        <img src="./resources/img/mainLogo.png" width="150px" >
        </header>
        
        <h2 class="로그인">로그인</h2>
         
        
        <section class="center-block;" style="width: 375px; height: 456px; margin: 0; align-content: center;">



<!--  아이디 -->
<form action="login" method="post" onsubmit="return formLogin()">
    <div class="form-floating" style=
         "width: 100%;
          height: 44px;
          padding: 0px 12px;
          margin-bottom: 20px;
          ">
      <input type="text" class="form-control" id="user_id" name="user_id" control-id="ControlID-1" 
             style="background: rgb(245, 245, 245);
                    border: none;">
      <label for="floatingInput" style="color: rgb(160, 160, 160); padding-left: 20px">아이디</label>
      
      
   
    </div>
<!-- 비밀번호 -->
<div class="form-floating" style=
        "width: 100%;
         height: 44px;
         padding: 0px 12px;">
      <input type="password" class="form-control" id="user_pw" name="user_pw" control-id="ControlID-2"
             style="background: rgb(245, 245, 245);
                    border: none;">
      <label for="floatingPassword" style="color: rgb(160, 160, 160); padding-left: 20px">비밀번호</label>
      
      <div style="color:red" id="loginCheck"></div>
      
    </div>
    
        <div class="로그인버튼" style="width: 375px; align-content: center; align-items: center;">
        
            <button type="submit" class="로그인b" 
                    style="width: 355px;
                           height: 44px;
                           background: rgb(255, 47, 110);
                           color: rgb(255, 255, 255);
                           text-align: center;
                           font-size: 17px;
                           font-weight: 400;
                           border-radius: 10px;
                           margin-top: 40px;
                           margin-left: 10px;
                           box-shadow: none;
                           border: none;">
                로그인
            </button>
            </div>
            
            <div class="비밀번호" style="
                                    margin-top: 20px;
                                    margin-bottom: 14px;
                                    text-align: center;
                                    width: 355px;
                                    height: 21px;">
            
            </div>
            
            <div class="회원가입" style="text-align: center;
                                    width: 355px;
                                    height: 21px;">
            <span>계정이 없으신가요?</span>
            <a style="color: red; text-decoration:none;" data-bs-toggle="modal" data-bs-target="#회원가입모달">회원가입</a>
            </div>
</form>
        </section>
      
    </div>
  </div>
</div>
    
    
    
    
        
        <!-- 회원가입모달  -->
    <div class="modal fade" id="회원가입모달" tabindex="-1" aria-labelledby="exampleModalCenterTitle" style="display: none; font-family: 'Noto Sans KR', sans-serif;" aria-hidden="true" >
  <div class="modal-dialog modal-dialog-centered">
    <div class="modal-content" style="display: flex; justify-content: center; align-items: center; padding: 32px 0px 48px; width: 375px; height: 580px; border-radius: 3%">
        <header>
        <img src="./resources/img/mainLogo.png" width="150px" >
        </header>
        
        <div class="회원가입란" style="margin: 30px 0px 0px;">
            <p class="회원가입 fw-bold">회원가입</p>
         </div>
        
        <section class="center-block;" style="width: 375px; height: 350px; margin: 0; align-content: center;">
        
        
<!--  이름  -->
<form action="join" method="post" onsubmit="return formJoin()">
    <div class="form-floating" style=
         "width: 100%;
          height: 44px;
          padding: 0px 12px;
          margin-bottom: 20px;
          ">
          
      <input type="text" class="form-control" id="join_name" name="user_name" control-id="ControlID-1" 
             style="background: rgb(245, 245, 245);
                    border: none;
                    ">
      <label for="floatingInput" style="color: rgb(160, 160, 160); padding-left: 20px">
          이름</label>
          
    </div>
           
            
<!-- 아이디 -->
<div class="form-floating" style=
        "width: 100%;
         height: 44px;
         padding: 0px 12px;
         margin-bottom: 20px;">
      <input type="text" class="form-control" id="join_id" name="user_id" control-id="ControlID-2"
             style="background: rgb(245, 245, 245);
                    border: none;">
      <label for="floatingPassword" style="color: rgb(160, 160, 160); padding-left: 20px">아이디</label>
      
      
    </div>
            
 <!-- 비밀번호 -->
<div class="form-floating" style=
        "width: 100%;
         height: 44px;
         padding: 0px 12px;">
      <input type="password" class="form-control" id="join_pw" name="user_pw" control-id="ControlID-2"
             style="background: rgb(245, 245, 245);
                    border: none;">
      <label for="floatingPassword" style="color: rgb(160, 160, 160); padding-left: 20px">비밀번호</label>
      
      
      <div style="color:red" id="joinCheck"></div>
    </div>
            
<!--          로그인 버튼 -->
        <div class="로그인버튼" style="width: 375px; align-content: center; align-items: center;">
            <button type="submit" class="로그인b" 
                    style="width: 355px;
                           height: 44px;
                           background: rgb(255, 47, 110);
                           color: rgb(255, 255, 255);
                           text-align: center;
                           font-size: 17px;
                           font-weight: 400;
                           border-radius: 10px;
                           margin-top: 40px;
                           margin-left: 10px;
                           box-shadow: none;
                           border: none;">
                회원가입
            </button>
            </div>
            
            <div class="비밀번호" style="
                                    margin-top: 20px;
                                    margin-bottom: 14px;
                                    text-align: center;
                                    width: 355px;
                                    height: 21px;">
            <span>이미 가입하셨나요? </span>
                <a style="color: red; text-decoration:none;" data-bs-toggle="modal" data-bs-target="#로그인모달">로그인</a>
            
            </div>
            
</form> 
        </section>
      
    </div>
  </div>
</div>

      
  
      
<main>
    
    

<!-- 메인 페이지 -->
   <div class="album py-5 bg-white" style="font-family: 'Noto Sans KR', sans-serif; margin-top: 80px">
    <div class="container" style="height: 500px">
        
         <button class="carousel-control-prev" type="button" data-bs-target="#겨울" data-bs-slide="prev"  style="width: 30px; height: 30px; position: absolute; top:380px; left: 180px; ">
<!--    <span class="왼쪽" aria-hidden="true" style="position: absolute; top: 130px" >-->
        <img src="./resources/img/left.png" width="30px">
<!--        </span>-->
    <span class="visually-hidden">Previous</span>
  </button>
        
        
    <div class="titles fw-bold mb-4" style="font-size: 25px;">
        오늘의 TOP SONG
    </div>
       
       
        <div>
  
        
<!-- 곡 화면--> 
<div id="겨울" class="carousel slide" data-bs-ride="carousel" style="height: 400px;"  data-bs-interval="false">
    <div class="carousel-item active" >
      <div class="row row-cols-sm-3 row-cols-lg-5">
<!--          row-cols-1  row-cols-sm-2 row-cols-md-3 g-3 -->


<!-- [조회수] 곡 프로필-->
<c:forEach var="song" items="${songList }" begin="0" end="4">
        <div class="col">
          <div class="card border border-white">
            <img src="./resources/img/album/${song.album_img} " alt="img" width="100%" height="225">

            <div class="card1 mt-3 "> 
                <p class="card-text mb-1 fw-bold" style="font-size: 23px;">
                <a href="/mylife/song/songPage?song_id=${song.song_id }&singer_id=${song.singer_id}">${song.song_name}</a>
                </p>
                <p class="card-text mb-0" style="font-size: 15px;">${song.singer_name }</p>
                <span class="card-text mb-0" style="font-size: 13px; margin-left: 1px">
                    ${song.album_date } </span>
                <span class="card-text mb-0" style="font-size: 13px; margin-left: 1px">
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
       

    <div class="carousel-item" >
      <div class="row row-cols-sm-3 row-cols-lg-5">
<!--          row-cols-1  row-cols-sm-2 row-cols-md-3 g-3 -->
<!-- 2페이지 -->
<c:forEach var="song" items="${songList }" begin="5" end="7">
        <div class="col">
          <div class="card border border-white">
            <img src="./resources/img/album/${song.album_img }" alt="img" width="100%" height="225">

            <div class="card1 mt-3 "> 
                <p class="card-text mb-1 fw-bold" style="font-size: 23px;">
                <a href="songPage?song_id=${song.song_id }&singer_id=${song.singer_id}">${song.song_name}</a>
                </p>
                <p class="card-text mb-0" style="font-size: 15px;">${song.singer_name }</p>
                <span class="card-text mb-0" style="font-size: 13px; margin-left: 1px">
                    ${song.album_date } </span>
                <br>
                <span class="card-text mb-0" style="font-size: 13px; margin-left: 1px">
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
        <button class="carousel-control-next" type="button" data-bs-target="#겨울" data-bs-slide="next"   style="width: 20px; height: 30px; position: absolute; top:380px; right: 200px">
<!--    <span class="오른쪽" aria-hidden="true" style="position: absolute; left: 200px; top: 130px">-->
        <img src="./resources/img/right.png" width="30px">
<!--    
style="position: absolute; left: 100px; top: 130px"-->
<!--      </span>-->
    <span class="visually-hidden">Next</span>
  </button>
        
</div>

        
  </div>
</div>




<!-- 메인 페이지 2 -->
    <div class="album py-5 bg-white" style="font-family: 'Noto Sans KR', sans-serif; margin-top: 80px">
    <div class="container" style="height: 500px">
        
         <button class="carousel-control-prev" type="button" data-bs-target="#좋아요" data-bs-slide="prev"  style="width: 30px; height: 30px; position: absolute; top:380px; left: 180px; ">
<!--    <span class="왼쪽" aria-hidden="true" style="position: absolute; top: 130px" >-->
        <img src="./resources/img/left.png" width="30px">
<!--        </span>-->
    <span class="visually-hidden">Previous</span>
  </button>
        
        
    <div class="titles fw-bold mb-4" style="font-size: 25px;">
        지금 인기 있는 곡
        </div>
        <div>
  
        
<!-- 곡 화면--> 
<div id="좋아요" class="carousel slide" data-bs-ride="carousel" style="height: 400px;"  data-bs-interval="false">
    <div class="carousel-item active" >
      <div class="row row-cols-sm-3 row-cols-lg-5">
<!--          row-cols-1  row-cols-sm-2 row-cols-md-3 g-3 -->


<!-- [좋아요] 곡 프로필-->
<c:forEach var="song" items="${likeSong }" begin="0" end="4">
        <div class="col">
          <div class="card border border-white">
            <img src="./resources/img/album/${song.album_img} " alt="img" width="100%" height="225">

            <div class="card1 mt-3 "> 
                <p class="card-text mb-1 fw-bold" style="font-size: 23px;">
                <a href="songPage?song_id=${song.song_id }&singer_id=${song.singer_id}">${song.song_name}</a>
                </p>
                <p class="card-text mb-0" style="font-size: 15px;">${song.singer_name }</p>
                <span class="card-text mb-0" style="font-size: 13px; margin-left: 1px">
                    ${song.album_date } </span>
                <span class="card-text mb-0" style="font-size: 13px; margin-left: 1px">
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
       

    <div class="carousel-item" >
      <div class="row row-cols-sm-3 row-cols-lg-5">
<!--          row-cols-1  row-cols-sm-2 row-cols-md-3 g-3 -->
<!-- 2페이지 -->
<c:forEach var="song" items="${likeSong }" begin="5" end="7">
        <div class="col">
          <div class="card border border-white">
            <img src="./resources/img/album/${song.album_img }" alt="img" width="100%" height="225">

            <div class="card1 mt-3 "> 
                <p class="card-text mb-1 fw-bold" style="font-size: 23px;">
                <a href="songPage?song_id=${song.song_id }&singer_id=${song.singer_id}">${song.song_name}</a>
                </p>
                <p class="card-text mb-0" style="font-size: 15px;">${song.singer_name }</p>
                <span class="card-text mb-0" style="font-size: 13px; margin-left: 1px">
                    ${song.album_date } </span>
                <br>
                <span class="card-text mb-0" style="font-size: 13px; margin-left: 1px">
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
        <button class="carousel-control-next" type="button" data-bs-target="#좋아요" data-bs-slide="next"   style="width: 20px; height: 30px; position: absolute; top:380px; right: 200px">
<!--    <span class="오른쪽" aria-hidden="true" style="position: absolute; left: 200px; top: 130px">-->
        <img src="./resources/img/right.png" width="30px">
<!--    
style="position: absolute; left: 100px; top: 130px"-->
<!--      </span>-->
    <span class="visually-hidden">Next</span>
  </button>
        
</div>

        
  </div>
</div>

</main>

  </body>
</html>