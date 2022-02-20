<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!doctype html>
<html lang="ko">
  <head>

    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">


    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
      
    <link href="https://fonts.googleapis.com/css2?family=Noto+Sans+KR:wght@100;300;400;500;700;900&display=swap" rel="stylesheet">

    <link rel="stylesheet" href="https://unpkg.com/swiper/swiper-bundle.min.css"/>  
    
    <link href="../resources/css/Allusic.css" rel="stylesheet"/>  
      
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
    
    </script>
  </head>
  <body style="background-color: #f8f8f8;">
         
    
         
    

    
    <header class="p-2 fixed-top align-items-center border-bottom border-info" id="AllusicH" style="font-family: 'Noto Sans KR', sans-serif; background-color: white;">
    <div class="container-fluid" style="width: 91%;">
      <div class="d-flex flex-wrap align-items-center justify-content-start ">
        <a href="/" class="d-flex align-items-center mb-2 mb-lg-0 text-dark text-decoration-none">
          <svg class="bi me-2" width="40" height="32" role="img" aria-label="Bootstrap"><use xlink:href="#bootstrap"></use></svg>
        </a>

        <ul class="nav col-12 col-lg-auto me-lg-auto mlmb-2 justify-content-center mb-md-0">
          <li><div  class="nav-link px-2 w-100" ><img src="../resources/img/mainLogo.png" alt="img" width="" height="40" style="margin-right: 30px"> </div></li>
          <li><a href="#" class="nav-link px-3 mt-3   mb-0 link-secondary">곡</a></li>
          <li><a href="#" class="nav-link px- mt-3 link-dark">앨범</a></li>
          <li><a href="#" class="nav-link px-3 mt-3 link-dark">가수</a></li>
        </ul>

        <form class="col-12 col-lg-auto mb-3 mb-lg-0 me-lg-3">
          <input type="search" class="form-control" placeholder="# 태그를 검색해보세요"  aria-label="Search" control-id="ControlID-2" style="background: #F2F2F2">
        </form>

          
          
        <div class="dropdown text-end">
          <a href="#" class="d-block link-dark text-decoration-none dropdown-toggle" id="dropdownUser1" data-bs-toggle="dropdown" aria-expanded="false">
            <img src="https://github.com/mdo.png" alt="mdo" width="32" height="32" class="rounded-circle">
          </a>
                 
            
            
          <ul class="dropdown-menu text-small color-white" aria-labelledby="dropdownUser1">
            <c:if test="${user_id == null }">
            <li><a class="dropdown-item" href="#" data-bs-toggle="modal" data-bs-target="#로그인모달">로그인</a></li>
            <li><a class="dropdown-item" href="#" data-bs-toggle="modal" data-bs-target="#회원가입모달">회원가입</a></li>
            </c:if>
            
            <c:if test="${user_id != null }">
            <li><a class="dropdown-item" href="#">프로필</a></li>
            <li><a class="dropdown-item" id="openModalBtn" href="#">마이 리스트</a></li>
            <li><hr class="dropdown-divider"></li>
            <li><a class="dropdown-item" href="logout?song_id=${song_id }&singer_id=${singer_id}">Sign out</a></li>
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
        <img src="../resources/img/mainLogo.png" width="150px" >
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
        <img src="../resources/img/mainLogo.png" width="150px" >
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


<!--      메인 -->
<main class="배경" id="리스트배경">
            
        <div class="container" id="container">
            
            <div>
            <div id="프로필베너" >
               <c:forEach var="playlist" items="${banner }" begin="0" end="4" varStatus="status">
               		<span >
                    	<img src="../resources/img/album/${playlist.album_img }" id="커버${status.count }">
                	</span>
               </c:forEach>
            </div>
                
                <span id="배너닉네임">
                 	${listInfo.user_id }
                </span>
                
                
            </div>
            <div id="리스트소개란">
                <div class="p-0" id="리스트타이틀">
                  <p> 
                  	${listInfo.list_name } 
                  </p>
                </div>
                <div id="리스트설명">
                  <p> 
               		${listInfo.list_explain }
                  </p>
                </div>
                <div class="p-0" id="리스트정보 ">
                    <span id="좋아요수"> 좋아요 <em>${listInfo.list_like }</em> <span> ㅣ </span> </span>
                    <span id="좋아요수"> 댓글 <em></em> <span> ㅣ </span> </span>
                    <span id="좋아요수">  <em></em> 일 전 업데이트 <span>  </span> </span>
                
                </div>
            </div>
            <section class="버튼박스" id="버튼박스">
                <div id="버튼박스내용">
<!--                    공유 드롭다운-->
            <div class="dropdown">
                <button type="button"  id="좋아요박스">
                        <div id="좋아요">
                            <img src="../resources/img/like1.png" id="좋아요버튼" width="15px">
                            좋아요
                        </div>
                    </button>
                        <span style="font-size: 20px">
                            I
                        </span>
                        <button type="button"  id="좋아요박스">
                        <div id="좋아요">
                             <img src="../resources/img/comment.JPG" id="좋아요버튼" width="23px">
                            댓글
                        </div>
                    </button>
                        <span style="font-size: 20px">
                            I
                        </span>

                        <button class="btn" type="button" data-bs-toggle="dropdown"  aria-expanded="false" id="좋아요박스">
                        <div id="좋아요" >
                            <img src="../resources/img/share.JPG" id="좋아요버튼" width="23px">
                            공유
                        </div>
                    </button>
                   
                
                
                
<!--
  <button class="btn btn-secondary dropdown-toggle" type="button" id="dropdownMenuButton1" data-bs-toggle="dropdown" aria-expanded="false">
    Dropdown button
  </button>
-->
  <ul class="dropdown-menu" id="공유드롭다운" aria-labelledby="dropdownMenuButton1">
    <li><a class="dropdown-item" href="#">페이스북<img src="facebook1.png" height="23px" style="float: right"></a></li>
    <li><a class="dropdown-item" href="#">카카오톡<img src="kakao1.png" height="23px" style="float: right"></a></li>
    <li><a class="dropdown-item" href="#">트위터<img src="twitter1.png" height="23px" style="float: right"></a></li>
    <li><a class="dropdown-item" href="#">링크복사<img src="share2.png" height="23px" style="float: right"></a></li>
      
  </ul>
</div>
                    </div>
            
            </section>
            <section id="작품들란">
                <div id="작품들란2">
                    <div id="작품들란3">
                        <span class="" id="작품들명">곡</span>
                        <span id="작품수">${countSong }</span>
                    </div>
                </div>    
                
                
                
               <div id="작품란">
                    
<!--리스트에 추가된 곡들 -->
                 <div class="row row-cols-3" id="작품란2">
                     <c:forEach var="playlist" items="${listSong}" begin="0" end="${sta+5 }" varStatus="sta">
                        <div class="col" id="작품카드" >
                            <img src="../resources/img/album/${playlist.album_img }" id="리스트앨범커버">
                            <div id="작품명">
                                <a href="/mylife/song/songPage?song_id=${song.song_id }&singer_id=${song.singer_id}">
                                ${playlist.song_name }
                                </a>
                            </div>
                            <div id="리스트평균">
                                ${playlist.singer_name }
                            </div>
                            <div id="리스트평균">
                                평균 ★ 2.8
                            </div>
                         
                            <div id="리스트정보">
                                ${playlist.genre } · ${playlist.country }
                            </div>
                        
                        </div>
                      </c:forEach>
                      
                 </div>
                 
                </div>
            </section>
            <div id="버튼란">
                <button class="더보기" id="더보기">
                    더보기
                     <img src="../resources/img/moredown.PNG" width="20px" >
                 </button>
            </div>
            <section id="댓글란1">
                <div id="댓글란2">
                    <div id="댓글타이틀">
                        <span >댓글</span>
                        <span id="댓글수"> 2 </span>
                    </div>
                    
                    
                     <div id="ㄹㅇ댓글">
                        <div id="댓글프로필">
                         <img src="../resources/img/comment.JPG" id="댓글프로필사진">
                         </div>
                        <div id="댓글우측">
                            <div id="닉네임란">
                                <span id="닉네임">
                                    잔스틴
                                </span>
                                <div id="댓글며칠전">
                                    1개월전
                                </div>
                            </div>
                            <div id="댓글내용">
                                밤편지밖에없네요!
                            </div>
                            <div id="댓글버튼">
                                <button id="댓글좋아요">
                                    <img src="../resources/img/like1.png" width="15px" style="margin-right: 6px;" >
                                    0
                                </button>
                                 <button id="댓글더보기">
                                     <img src="../resources/img/more.JPG" height="18px">
                                </button>
                            </div>
                     </div>
                    </div> 
                    
   <!-- 댓글 입력창 -->                
                    <div id="댓글입력창">
						<form action="comment" method="post" id="comment" enctype="multipart/form-data">
	                        <input type="text" name="comment" id="댓글입력" placeholder="컬렉션에 댓글을 남겨보세요.">
	                        <input type="submit" id="댓글입력버튼" value="등록">
						</form>
                </div>
                </div>

            </section>

        </div> 
        
      </main>
    </body>
</html>
