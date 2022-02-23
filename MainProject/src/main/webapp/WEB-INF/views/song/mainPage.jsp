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
      
    <link href="../resources/css/Allusic.css" rel="stylesheet">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>
      
    <link rel="stylesheet" href="https://unpkg.com/swiper/swiper-bundle.min.css"/>
      
      <script src="https://code.jquery.com/jquery-3.6.0.min.js" integrity="sha256-/xUj+3OJU5yExlq6GSYGSHk7tPXikynS7ogEvDej/m4=" crossorigin="anonymous">
      </script>
      
       <script>
      
  $(window).scroll(function() {

      
      if($(this).scrollTop() > 200) {
        $("#AllusicH2").show();
        $("#AllusicH2").css('visibility','visible');
        $("#AllusicH").hide();
		$("#AllusicH2").css('background','#FFFFFF');
        
        
	}
	else {
        $("#AllusicH").show();
		$("#AllusicH2").hide();

	}
});
      
      
      </script>
      
      <!-- CSS , JS -->
<link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
      
    <title>곡 화면</title>
  	<c:import url="../menu.jsp"></c:import>
</head>
    <body>
         
<!-- 200 미만일때 헤더B-->
    
    <header class="p-2 mb-3 fixed-top align-items-center border-bottom border-info" id="AllusicH2" 
            style="font-family: 'Noto Sans KR', sans-serif; visibility: hidden; 
                   z-index: 20;">
    <div class="container-fluid w-75">
      <div class="d-flex flex-wrap align-items-center justify-content-start ">
          
        <a href="/" class="d-flex align-items-center mb-2 mb-lg-0 text-dark text-decoration-none">
          <svg class="bi me-2" width="40" height="32" role="img" aria-label="Bootstrap"><use xlink:href="#bootstrap"></use></svg>
        </a>

        <ul class="nav col-12 col-lg-auto me-lg-auto mlmb-2 justify-content-center mb-md-0">
          <li><div  class="nav-link px-2 w-100" ><img src="../resources/img/mainLogo.png" alt="img" width="" height="40" style="margin-right: 30px"> </div></li>
          <li><a href="https://www.naver.com/" class="nav-link px-2 mt-3   mb-0 link-secondary" style="">곡</a></li>
          <li><a href="#" class="nav-link px-2 mt-3 link-dark">앨범</a></li>
          <li><a href="#" class="nav-link px-2 mt-3 link-dark">가수</a></li>
        </ul>

        <form class="col-12 col-lg-auto mb-3 mb-lg-0 me-lg-3">
          <input type="search" class="form-control" placeholder="# 태그를 검색해보세요"  aria-label="Search" control-id="ControlID-2" style="background: #F2F2F2">
        </form>

          
          
        <div class="dropdown text-end">
          <a href="#" class="d-block link-dark text-decoration-none dropdown-toggle" id="dropdownUser1" data-bs-toggle="dropdown" aria-expanded="false">
            <img src="https://github.com/mdo.png" alt="mdo" width="32" height="32" class="rounded-circle">
          </a>
                 
            
            
            <ul class="dropdown-menu text-small" aria-labelledby="dropdownUser1">
           <c:if test="${user_id == null }">
            <li><a class="dropdown-item" href="#" data-bs-toggle="modal" data-bs-target="#로그인모달" id="#로그인모달버튼">로그인</a></li>
            <li><a class="dropdown-item" href="#" data-bs-toggle="modal" data-bs-target="#회원가입모달">회원가입</a></li>
            </c:if>
            
            <c:if test="${user_id != null }">
            <li><a class="dropdown-item" href="#">프로필</a></li>
            <li><a class="dropdown-item" id="openModalBtn" data-bs-toggle="modal" data-bs-target="#staticBackdrop">마이 리스트</a></li>
            <li><hr class="dropdown-divider"></li>
            <li><a class="dropdown-item" href="logout?song_id=${song_id }&singer_id=${singer_id}">Sign out</a></li>
            </c:if>
          </ul>
        </div>
      </div>
    </div>
  </header>

    
<!--  200 이상일때 헤더A-->
    <header class="p-2 mb-3 fixed-top align-items-center" id="AllusicH" style="font-family: 'Noto Sans KR', sans-serif; ">
    <div class="container-fluid w-75">
      <div class="d-flex flex-wrap align-items-center justify-content-start ">
<!--          justify-content-lg-start-->
        <a href="/" class="d-flex align-items-center mb-2 mb-lg-0 text-dark text-decoration-none">
          <svg class="bi me-2" width="40" height="32" role="img" aria-label="Bootstrap"><use xlink:href="#bootstrap"></use></svg>
        </a>

        <ul class="nav col-12 col-lg-auto me-lg-auto mlmb-2 justify-content-center mb-md-0 text-white">
          <li><div  class="nav-link px-2 w-100" >
          <a href="/mylife/main">
          <img src="../resources/img/songLogo.png" alt="img" width="" height="40" style="margin-right: 30px">
          </a>
          </div></li>
          
          <li><a href="https://www.naver.com/" class="nav-link px-2 mt-3   mb-0 text-white" style="">곡</a></li>
          <li><a href="#" class="nav-link px-2 mt-3 text-white">앨범</a></li>
          <li><a href="#" class="nav-link px-2 mt-3 text-white">가수</a></li>
        </ul>

        <form class="col-12 col-lg-auto mb-3 mb-lg-0 me-lg-3">
          <input type="search" class="form-control" placeholder="# 태그를 검색해보세요"  aria-label="Search" control-id="ControlID-2" 
                 style="background: transparent; 
                        ">
        </form>

          
          
        <div class="dropdown text-end">
          <a href="#" class="d-block link-white text-decoration-none dropdown-toggle" id="dropdownUser1" data-bs-toggle="dropdown" aria-expanded="false">
            <img src="https://github.com/mdo.png" alt="mdo" width="32" height="32" class="rounded-circle">
          </a>
                 
            
            
            <ul class="dropdown-menu text-small" aria-labelledby="dropdownUser1">
           <c:if test="${user_id == null }">
            <li><a class="dropdown-item" href="#" data-bs-toggle="modal" data-bs-target="#로그인모달" id="#로그인모달버튼">로그인</a></li>
            <li><a class="dropdown-item" href="#" data-bs-toggle="modal" data-bs-target="#회원가입모달">회원가입</a></li>
            </c:if>
            
            <c:if test="${user_id != null }">
            <li><a class="dropdown-item" href="#">프로필</a></li>
            <li><a class="dropdown-item" id="openModalBtn" data-bs-toggle="modal" data-bs-target="#staticBackdrop">마이 리스트</a></li>
            <li><hr class="dropdown-divider"></li>
            <li><a class="dropdown-item" href="logout?song_id=${song_id }&singer_id=${singer_id}">Sign out</a></li>
            </c:if>
          </ul>
        </div>
      </div>
    </div>
  </header>
 
 

    
<div class="전체화면 text-center overflow-hidden" style="background-color: rgba(248,248,248); height: auto;">


      </div>

    

    <div class="banner1" style="background-color: rgba(0,0,0); text-align: center; ">


            <img src="../resources/img/banner/${Song.song_banner }" style="margin: 0 auto;" height="420px;">

        
        <div class="gradient"></div>
    </div>
    
  <div class="곡정보 자리 w-100 border" style="height: 232px;  padding: 13px 16px 22px; background-color: white; position: relative; z-index: 10;">
<!--      background-color: rgba(199,221,253);-->
    <div class="정보 자리잡기용 m-auto" style="width:  960px">
    <img src="../resources/img/album/${Song.album_img }" width="250px" style="float: left; margin-left: -70px; margin-top: -52px; vertical-align: top; border:3px solid #eaeaea; border-radius: 2%;" >
        
     <div class="곡정보 주황" style="width: 745px; height: 197px; border-radius: 10px;  float: right; font-family: 'Noto Sans KR', sans-serif; text-align: left; margin-top: 5px;">
<!--         background-color: rgba(255,229,208);-->
         
        <div class="곡 제목 fw-bold" style="width: 520px; height: 41px; text-align: left; font-size: 33px;">
            ${Song.song_name }
        </div>
         
        <div class="제목 바로 밑" style="color: darkgray; margin-top: 5px; height: 22px">
            <span class="연도" style="">
                ${Song.album_date } ・
            </span>
            <span>
                ${Song.genre } ・
            </span>
            <span>
                ${Song.country }
            </span>
         </div>
        <div class="예상" style="height: 42px; margin-top: 20px; padding-top: 8px; border-top: 1px solid ; border-bottom: 1px solid; border-color: darkgray">
            별점 ★★★★★ ${Song.song_like } 
         </div>
         <div class="row" style="width: 730px; height: 58px; margin-top: 8px; align-content: center; ">
			
             <div id="likeDiv" class="col-2" style="align-content: center; margin-left: ">
                <img id="like1"src="../resources/img/like1.png" width="30px">
                
                 <span> 좋아요 </span>
             </div>
             
             <div class="col-2">
                 <img src="../resources/img/add_tag.JPG" width="30px">
                 <span> 태그  </span>

             </div>
             
             <div class="col-3">
             <a href="selectList"><img src="../resources/img/more.JPG" width="30px" ></a>
                 <span> 리스트 추가 </span>
                 
             </div>
             
             <div class="col-2">
             <img src="../resources/img/more.JPG" width="30px">
                 <span> 더보기 </span>
                 
             </div>
        
        </div>
        </div>
        
    </div>        
 </div>    

    
    
    <div class="main1 mt-3 m-auto" style="width: 960px; height: 1000px; background-color: rgba(248,248,248); ">

        <div class="컨텐츠 핑크 border" style="width: 638px; height: auto; border-radius: 10px; float: left; background-color:  white; font-family: 'Noto Sans KR', sans-serif; font-size: 0px; padding-bottom: 40px;">
            
<!--            가수 -->
            <div class="가수" 
                 style="width: 598px; height: 200px; text-align: left; margin-left: 20px; margin-right: 20px; padding-top: 8px; border-bottom: 1px solid; border-color: darkgray;">
                
                <div class="가수 fw-bold" style="margin-left: px; margin-top: 5px; font-size: 18px; height: 30px; ">
                    가수
                </div>
                <div class="row 가수 프로필 mt-2" style="height: 150px">
                    <div class="col-3 text-center">
                        <div class="프로필 카드" style="margin-right: auto; margin-left: auto; margin-top: 5px">
                        <img src="../resources/img/profile/IU_profile.jpg" width="80px" style="border-radius: 50%">
                        <div class="가수명" style="margin-top: 5px; font-size: 25px">
                            ${Song.singer_name }
                        </div>
                    </div>
                    </div>
                
                </div>
            
            </div>
            
<!--           작사  -->
           <div class="작사" 
                style="width: 598px; height: 200px; text-align: left; margin-left: 20px; margin-right: 20px; margin-top: 20px; padding-top: 8px; border-bottom: 1px solid; border-color: darkgray;">
                
                <div class="작사 fw-bold" style="margin-left: px; margin-top: 5px; font-size: 18px; height: 30px; ">
                    작사
                </div>
                <div class="row 작사 프로필" style="height: 150px">
                    <div class="col-3 text-center mt-2">
                        <div class="프로필 카드" style="margin-right: auto; margin-left: auto; margin-top: 5px">
                        <img src="../resources/img/profile/IU_profile.jpg" width="80px" style="border-radius: 50%">
                        <div class="작사가명" style="margin-top: 5px; font-size: 25px">
                            ${Song.writer }
                        </div>
                    </div>
                    </div>
                
                </div>
            
            </div>
            
<!--           작곡 -->
            <div class="작곡" style="width: 598px; height: 200px; text-align: left; margin-left: 20px; margin-right: 20px; margin-top: 20px; padding-top: 8px; border-bottom: 1px solid; border-color: darkgray;">
                
                <div class="작곡 fw-bold" style="margin-left: px; margin-top: 5px; font-size: 18px; height: 30px; ">
                    작곡
                </div>
                <div class="row 작사 프로필 mt-2" style="height: 150px">
                    <div class="col-3 text-center">
                        <div class="프로필 카드" style="margin-right: auto; margin-left: auto; margin-top: 5px">
                        <img src="../resources/img/profile/basic_profile.jpg" width="80px" style="border-radius: 50%">
                        <div class="작곡가명" style="margin-top: 5px; font-size: 25px">
                            ${Song.composer }
                        </div>
                            
                    </div>
                    </div>
                    
                   
                
                </div>
            
            </div>
<!--            가사 -->
            <div class="가사 text-left" style="width: 598px; height: auto; text-align: left; margin-left: 20px; margin-right: 20px; margin-top: 20px; padding-top: 8px;">
               
                <div class="가사 fw-bold" style="margin-left: px; margin-top: 5px; font-size: 22px; height: 50px; ">
                    가사
                    <span >
                        <a class="더보기" data-bs-toggle="collapse" data-bs-target="#가사란" aria-expanded="false" aria-controls="collapseExample" 
                        style="background-color: white; 
                               border-color: white;
                               text-decoration:none;
                               color: dodgerblue;
                               font-size: 15px;
                               float: right;
                               margin-top: 15px;">

                            더보기

                        </a>
                    </span>
                </div>
                <div class="collapse" id="가사란">
                 <div class="가사 card" style="margin-left: px; margin-top: 5px; font-size: 18px; height: auto; white-space: pre; padding-left: 8px; background-color: rgb(245,245,245); pa">
					${Song.lyrics }
                </div>
                </div>
            </div>
            
            

        </div>
        	<c:forEach var="playlist" items="${listId }">
           		<a href="/mylife/list/listPage?playlist_id=${playlist.playlist_id}">리스트페이지 테스트</a>
        	</c:forEach>

 	
   		
      
        
          <div class="오른쪽 보라 border" style="width: 318px; height: auto; border-radius: 10px; float: right; padding-left: 5px; padding-right: 5px; background-color: white; font-family: 'Noto Sans KR', sans-serif; overflow: hidden; padding-bottom: 40px;" >   
              
<!--             갤러리 -->
              <div class="갤러리타이틀"
                   style="width: 268px; height: 44px; margin: 0px 20px;">
                  <p class="fw-bold" style="vertical-align: middle; text-align: left; margin-top: 15px; ">
                    갤러리
                </p>
              </div>
    
              
              
              
              <div class="사진들" style="width: 328px; height: 121px; ">
                
                  <div id="캐러셀사진" class="carousel slide" data-bs-ride="carousel" data-bs-interval="false" style="width: 328px; height: 89px; padding-left: 10px; position: relative;">
                      
                <div class="carousel-inner">
                 <div class="carousel-item active">
                <div class="사진란" style="width: 132px; height: 89px; margin: 0px 0px 0px 10px; float: left">
                    <img src="lilac1.jpg" width="132px;">
                  
                  
                  </div>
                
               
                <div class="사진란" style="width: 132px; height: 89px; margin: 0px 0px 0px 10px; float: left;">
                    <img src="lilac1.jpg" width="132px;">
                  
                  
                  </div> 
                      </div>
                      
                       <div class="carousel-item">
                <div class="사진란" style="width: 132px; height: 89px; margin: 0px 0px 0px 10px; float: left;">
                  <img src="lilac1.jpg" width="132px;">
                  
                           </div>
                  </div>
                </div>
                 <button class="carousel-control-prev" type="button" data-bs-target="#캐러셀사진" data-bs-slide="prev" style="right:30px; width: 20px; ">
                     <img src="../resources/img/왼2.png" width="15px">

                  </button>
                  <button class="carousel-control-next" type="button" data-bs-target="#캐러셀사진" data-bs-slide="next">
                      <img src="../resources/img/오2.png" width="15px">

                  </button>      
              </div>
              </div>
              
              <!--            동영상 -->
              <div class="동영상타이틀"
                   style="width: 268px; height: 44px; margin: 30px 0px 0px 20px;">
                  <p class="fw-bold" style="vertical-align: middle; text-align: left; margin-top: 15px; ">
                    동영상
                </p>
              </div>
    
              
              
              
              <div class="동영상들" style="width: 328px; height: 121px; ">
                
                  <div id="캐러셀동영상" class="carousel slide" data-bs-ride="carousel" data-bs-interval="false" style="width: 328px; height: 89px; padding-left: 10px; position: relative;">
                      
                <div class="carousel-inner">
                 <div class="carousel-item active">
                <div class="동영상사진" style="width: 132px; height: 89px; margin: 0px 0px 0px 10px; float: left">
                    <img src="lilac1.jpg" width="132px;">
                  
                  
                  </div>
                
               
                <div class="동영상사진" style="width: 132px; height: 89px; margin: 0px 0px 0px 10px; float: left;">
                    <img src="lilac1.jpg" width="132px;">
                  
                  
                  </div> 
                      </div>
                      
                       <div class="carousel-item">
                <div class="동영상사진" style="width: 132px; height: 89px; margin: 0px 0px 0px 10px; float: left;">
                  <img src="lilac1.jpg" width="132px;">
                  
                           </div>
                  </div>
                </div>
                 <button class="carousel-control-prev" type="button" data-bs-target="#캐러셀동영상" data-bs-slide="prev" style="right:30px; width: 20px; ">
                     <img src="../resources/img/왼2.png" width="15px">

                  </button>
                  <button class="carousel-control-next" type="button" data-bs-target="#캐러셀동영상" data-bs-slide="next">
                      <img src="../resources/img/오2.png" width="15px">

                  </button>      
              </div>
              </div>
              
              
              
              
        </div>
     </div>
        
        
      
        
</body>
</html>
