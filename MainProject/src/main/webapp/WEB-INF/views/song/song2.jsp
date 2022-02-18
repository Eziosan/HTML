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
      
    <link href="../resources/css/Allusic.css" rel="stylesheet">

      
    <title>곡 화면</title>
  <style>
     @import url(//fonts.googleapis.com/earlyaccess/jejuhallasan.css);
    
      
      
  </style>
  <script src="http://code.jquery.com/jquery-3.6.0.min.js"></script>
  <script type="text/javascript">
  
  $(document).ready(function(){
	  $("#like1").on('click', function(){
		  
		  
		  $("#likeDiv").html("<img onclick='result();' id='like2' src='../resources/img/like2.png' width='30px'> <span> 좋아요 </span>");
	  });
	  

	  $("#like2").on('click', function(){
		alert("왜 안되냐고");

		  
		  
		 
	  });
	  
  });
  function result(){
		alert("이미지 2 클릭 됨");
		$("#likeDiv").html("<img id='like1' src='../resources/img/like1.png' width='30px'> <span> 좋아요 </span>");
	  }
  
 
  </script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>
</head>
    <header class="p-2 mb-3 fixed-top align-items-center " style="font-family: 'Noto Sans KR', sans-serif;">
    <div class="container-fluid w-75">
      <div class="d-flex flex-wrap align-items-center justify-content-start ">
<!--          justify-content-lg-start-->
        <a href="/" class="d-flex align-items-center mb-2 mb-lg-0 text-dark text-decoration-none">
          <svg class="bi me-2" width="40" height="32" role="img" aria-label="Bootstrap"><use xlink:href="#bootstrap"></use></svg>
        </a>

        <ul class="nav col-12 col-lg-auto me-lg-auto mlmb-2 justify-content-center mb-md-0 text-white">
          <li><div  class="nav-link px-2 w-100" ><img src="../resources/img/songLogo.png" alt="img" width="" height="40" style="margin-right: 30px"> </div></li>
          <li><a href="#" class="nav-link px-2 mt-3   mb-0 text-white" style="">곡</a></li>
          <li><a href="#" class="nav-link px-2 mt-3 text-white">앨범</a></li>
          <li><a href="#" class="nav-link px-2 mt-3 text-white">가수</a></li>
        </ul>

        <form class="col-12 col-lg-auto mb-3 mb-lg-0 me-lg-3">
          <input type="search" class="form-control" placeholder="# 태그를 검색해보세요"  aria-label="Search" control-id="ControlID-2" style="background: transparent; font: white;">
        </form>

          
          
        <div class="dropdown text-end">
          <a href="#" class="d-block link-white text-decoration-none dropdown-toggle" id="dropdownUser1" data-bs-toggle="dropdown" aria-expanded="false">
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
    

<div class="전체화면 text-center overflow-hidden" style="background-color: rgba(248,248,248)">

    <div class="banner1" style="background-color: rgba(0,0,0);">

            <img src="../resources/img/banner/${Song.song_banner }" style="position:relative;" width="800px">

        
        <div class="gradient"></div>
    </div>
    
  <div class="곡정보 자리 w-100 border" style="height: 232px;  padding: 13px 16px 22px; background-color: white;">
<!--      background-color: rgba(199,221,253);-->
    <div class="정보 자리잡기용 m-auto" style="width:  960px">
    <img src="../resources/img/album/${Song.album_img }" width="230px" style="float: left; margin-left: -50px; margin-top: -32px; vertical-align: top;" >
        
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
            별점 ★${Song.song_like } 
         </div>
         <div class="row" style="width: 730px; height: 58px; margin-top: 8px; align-content: center; ">
			
             <div id="likeDiv" class="col-2" style="align-content: center;">
                <img id="like1" src="../resources/img/like1.png" width="30px">
                
                 <span> 좋아요 </span>
             </div>
             
             <div id="a"></div>
             
             <div class="col-2">
                 <img src="../resources/img/add_tag.JPG" width="30px">
                 <span> 태그  </span>

             </div>
             
             <div class="col-2">
             <img src="../resources/img/more.JPG" width="30px">
                 <span> 더보기 </span>
                 
             </div>
        
        </div>
        </div>
        
    </div>        
 </div>    

    
    
    <div class="main1 mt-3 m-auto" style="width: 960px; background-color: rgba(248,248,248)">

        <div class="컨텐츠 핑크 border" style="width: 638px; height: 934px; border-radius: 10px; float: left; background-color:  white; font-family: 'Noto Sans KR', sans-serif; font-size: 0px;">
<!--            rgba(247,214,230)-->
            <div class="가수" 
                 style="width: 598px; height: 200px; text-align: left; margin-left: 20px; margin-right: 20px; padding-top: 8px; border-bottom: 1px solid; border-color: darkgray;">
                
                <div class="가수 텍스트 fw-bold" style="margin-left: px; margin-top: 5px; font-size: 18px; height: 30px; ">
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
            
           <div class="작사" 
                style="width: 598px; height: 200px; text-align: left; margin-left: 20px; margin-right: 20px; margin-top: 20px; padding-top: 8px; border-bottom: 1px solid; border-color: darkgray;">
                
                <div class="작사 텍스트 fw-bold" style="margin-left: px; margin-top: 5px; font-size: 18px; height: 30px; ">
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
            
            <div class="작곡" style="width: 598px; height: 200px; text-align: left; margin-left: 20px; margin-right: 20px; margin-top: 20px; padding-top: 8px; border-bottom: 1px solid; border-color: darkgray;">
                
                <div class="작곡 텍스트 fw-bold" style="margin-left: px; margin-top: 5px; font-size: 18px; height: 30px; ">
                    작곡
                </div>
                <div class="row 작사 프로필 mt-2" style="height: 150px">
                    <div class="col-3 text-center">
                        <div class="프로필 카드" style="margin-right: auto; margin-left: auto; margin-top: 5px">
                        <img src="../resources/img/profile/Dr.JO_profile.png" width="80px" style="border-radius: 50%">
                        <div class="작곡가명" style="margin-top: 5px; font-size: 25px">
                            ${Song.composer }
                        </div>
                            
                    </div>
                    </div>
                    
                    <div class="col-3 text-center">
                        <div class="프로필 카드" style="margin-right: auto; margin-left: auto; margin-top: 5px">
                        <img src="../resources/img/profile/basic_profile.jpg" width="80px" style="border-radius: 50%">
                        <div class="작곡가명" style="margin-top: 5px; font-size: 25px">
                            Dr.Jo
                        </div>
                            
                    </div>
                    </div>
                
                </div>
            
            </div>

            
            </div>
            
        
          <div class="오른쪽 보라" style="width: 318px; height: 934px; border-radius: 10px; float: right; padding-left: 5px; padding-right: 5px; background-color: rgba(217,204,240);" >   
        </div>
        </div>
        </div>
        
        
      
        
    </div>
    </div>
</html>
