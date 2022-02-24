<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
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
//	if($(this).scrollTop() < 200) {
//        $("#AllusicH").show();
//		$("#AllusicH2").hide();
//		$("#AllusicH").css('background','rgba(255,255,255,0)');
//        
//	}
//	else {
//		$("#AllusicH2").show();
//        $("#AllusicH").hide();
//		$("#AllusicH2").css('background','#FFFFFF');
//	}
      
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


      
      
$(document).ready(function(){
	  $("#like1").on('click', function(){
		  $("#likeDiv").html("<img onclick='result();' id='like2' src='../resources/img/like2.png' width='30px'> <span> 좋아요 </span>");
		  location.href = "plusStar?song_id="+9;	
	  });
	
	   
});
function result(){
	
		$("#likeDiv").html("<img onclick='result2();' id='like1' src='../resources/img/like1.png' width='30px'> <span> 좋아요 </span>");
		 location.href = "minusStar?song_id="+9;
			
}
function result2(){
	  $("#like1").on('click', function(){
		  $("#likeDiv").html("<img onclick='result();' id='like2' src='../resources/img/like2.png' width='30px'> <span> 좋아요 </span>");
		 
	  });
}



      </script>
      
      <link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
      
	<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
	<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
      
    <title>곡 화면</title>
    
    <c:import url="../menu.jsp"></c:import>
   
    
    <script type="text/javascript">
    
   function addSongtoList(){
	   var list = $(":radio[name='list']:checked");
	   //$로 묶고 .submit하면 컨트롤러로 감
	   
	   alert("선택한 리스트 리스트 ID : " + list.val());
	   $("#playlist_id").val(list.val());
	   alert("보낼 플레이리스트 ID" +$("#playlist_id").val());
	   alert("보낼 곡 ID" +$("#song_id").val());
	   
	   
	 }
	 function addPlayListCheck(){
			 var list_name = document.getElementById("list_name").value;
			
			alert(document.getElementById("list_name").value);
			
			//3. pw 유효성 검사
			var list_explain = document.getElementById("list_explain").value;
			
			alert(document.getElementById("list_explain").value);
			
			
			if( list_name == '' || list_explain == ''){
				alert("3개 다 입력해주셔야 해요");
				alert("리스트 생성 실패!");
				return false;
			}
			
		return true;
	 }
    
    
    </script>
  <style>
     @import url(//fonts.googleapis.com/earlyaccess/jejuhallasan.css);
    
      
      
  </style>
</head>
    <body>
         
         
<!--  200 이상일때 헤더A-->
    <header class="p-2 mb-3 fixed-top align-items-center" id="AllusicH" style="font-family: 'Noto Sans KR', sans-serif; ">
    <div class="container-fluid" style="width: 93%">
      <div class="d-flex flex-wrap align-items-center justify-content-start ">
<!--          justify-content-lg-start-->
        <a href="/" class="d-flex align-items-center mb-2 mb-lg-0 text-dark text-decoration-none">
          <svg class="bi me-2" width="40" height="32" role="img" aria-label="Bootstrap"><use xlink:href="#bootstrap"></use></svg>
        </a>

        <ul class="nav col-12 col-lg-auto me-lg-auto mlmb-2 justify-content-center mb-md-0 text-white">
          <li><a href="/mylife/main" ><div  class="nav-link px-2 w-100" ><img src="../resources/img/곡용.png" alt="img" width="" height="40" style="margin-right: 30px"> </div></a></li>
        
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
  
  
<!-- 200 미만일때 헤더B-->
    
    <header class="p-2 mb-3 fixed-top align-items-center border-bottom border-info" id="AllusicH2" 
            style="font-family: 'Noto Sans KR', sans-serif; visibility: hidden; 
                   z-index: 20;">
    <div class="container-fluid" style="width: 93%">
      <div class="d-flex flex-wrap align-items-center justify-content-start ">
          
        <a href="/" class="d-flex align-items-center mb-2 mb-lg-0 text-dark text-decoration-none">
          <svg class="bi me-2" width="40" height="32" role="img" aria-label="Bootstrap"><use xlink:href="#bootstrap"></use></svg>
        </a>

        <ul class="nav col-12 col-lg-auto me-lg-auto mlmb-2 justify-content-center mb-md-0">
          <li><div class="nav-link px-2 w-100" ><img src="../resources/img/초안2.png" alt="img" width="" height="40" style="margin-right: 30px"> </div></li>
          <li><a href="#" class="nav-link px-2 mt-3   mb-0 link-secondary" style="">곡</a></li>
          <li><a href="#" class="nav-link px-2 mt-3 link-dark">앨범</a></li>
          <li><a href="#" class="nav-link px-2 mt-3 link-dark">가수</a></li>
        </ul>

        <form class="col-12 col-lg-auto mb-3 mb-lg-0 me-lg-3">
          <input type="search" class="form-control" placeholder="# 태그를 검색해보세요"  aria-label="Search" control-id="ControlID-2" style="background: #F2F2F2">
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
       <div class="예상" id="예상" >
           ★ 평균 ${Song.avg }
         </div>
         <div class="row" style="width: 730px; height: 58px; margin-top: 8px; align-content: center; ">

             <div class="col-4" style="align-content: center; margin-left: ">
                 <div id="별점큰박스">
                     <span id="별점기록" >
                        <span class="fw-bold" id="별점평균"> 4.26 </span>/  5
                     </span>
     <div class="starpoint_wrap" id="별점박스">
          <div class="starpoint_box">
            <label for="starpoint_1" class="label_star" title="0.5"><span class="blind">0.5점</span></label>
            <label for="starpoint_2" class="label_star" title="1"><span class="blind">1점</span></label>
            <label for="starpoint_3" class="label_star" title="1.5"><span class="blind">1.5점</span></label>
            <label for="starpoint_4" class="label_star" title="2"><span class="blind">2점</span></label>
            <label for="starpoint_5" class="label_star" title="2.5"><span class="blind">2.5점</span></label>
            <label for="starpoint_6" class="label_star" title="3"><span class="blind">3점</span></label>
            <label for="starpoint_7" class="label_star" title="3.5"><span class="blind">3.5점</span></label>
            <label for="starpoint_8" class="label_star" title="4"><span class="blind">4점</span></label>
            <label for="starpoint_9" class="label_star" title="4.5"><span class="blind">4.5점</span></label>
            <label for="starpoint_10" class="label_star" title="5"><span class="blind">5점</span></label>
            <input type="radio" name="starpoint" id="starpoint_1" class="star_radio">
            <input type="radio" name="starpoint" id="starpoint_2" class="star_radio">
            <input type="radio" name="starpoint" id="starpoint_3" class="star_radio">
            <input type="radio" name="starpoint" id="starpoint_4" class="star_radio">
            <input type="radio" name="starpoint" id="starpoint_5" class="star_radio">
            <input type="radio" name="starpoint" id="starpoint_6" class="star_radio">
            <input type="radio" name="starpoint" id="starpoint_7" class="star_radio">
            <input type="radio" name="starpoint" id="starpoint_8" class="star_radio">
            <input type="radio" name="starpoint" id="starpoint_9" class="star_radio">
            <input type="radio" name="starpoint" id="starpoint_10" class="star_radio">
            <span class="starpoint_bg"></span>
          </div>
        </div>
    </div>        
    
   				

             </div>
             
            
             
               
             <div class="col-2" >
                 <div type="button" id="송리스트버튼" class="btn btn-primary" data-bs-toggle="modal" data-bs-target="#리스트추가"  >
             <img src="../resources/img/plus.png" width="20px">
                 	
                 <span> 리스트 </span>
                 </div>
             </div>
                
             
            
        
        </div>
        </div>
        
    </div>        
 </div>    





	
	<c:if test="${user_id != null }">
			<!--    리스트 추가 모달-->
		    <div class="modal fade" id="리스트추가" tabindex="-1" aria-labelledby="exampleModalCenterTitle" style="display: none;" aria-hidden="true">
		  <div class="modal-dialog modal-dialog-centered">
		    <div class="modal-content" id="리모달창">
		      <div class="modal-header" id="리모달헤더">
		        <h5 class="modal-title" id="exampleModalCenterTitle">리스트 추가</h5>
		        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
		      </div>
		     
		      <div class="modal-body" id="리모달바디">
		      
		      	<c:forEach var="plist" items="${playlist }" varStatus="status">
					<div id="리스트한칸 ">
					<input type="radio" value="${plist.playlist_id }" id= "리스트체크"  name="list">
						${plist.list_name}</div>
				</c:forEach> 
		    
		        </div>
		        
		        <!-- 리스트에 곡 추가시 보내질 데이터  -->
		        <form action="addSongList" method="post" id="addSongListForm" >
		        	<input type="hidden" id ="song_id" name="song_id" value="${Song.song_id}">
		        	<input type="hidden" id="playlist_id" name="playlist_id" >
		        	
		      <div class="modal-footer" id="리모달푸터">
		          <button type="submit" id="곡추가" class="btn" onclick="addSongtoList()">추가</button>
		        <button type="button" id="새리스트버튼" class="btn" data-bs-toggle="modal" data-bs-target="#리스트추가2">
		            + 새 리스트</button>
		      </div>
		        </form>
				
		    </div>
		  </div>
		</div>
		    
		
		<!--    리스트 추가 모달2-->
		    <div class="modal fade" id="리스트추가2" tabindex="-1" aria-labelledby="exampleModalCenterTitle" style="display: none;" aria-hidden="true">
		  <div class="modal-dialog modal-dialog-centered">
		    <div class="modal-content" id="리모달창2">
		      <div class="modal-header" id="리모달헤더">
		        <h5 class="modal-title" id="exampleModalCenterTitle">리스트 추가</h5>
		        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
		      </div>
		      <div class="modal-body" id="리모달바디">
		      <!-- 리스트 추가 부분 -->
		      <form action="addPlayList" method="post" id="addPlayListForm" onsubmit="return addPlayListCheck()">
		        	<input type="text" placeholder="리스트 이름 입력.." name= "list_name" id="list_name">
		        	<input type="text" placeholder="리스트 설명 입력" name= "list_explain" id ="list_explain">
		        	<input type="hidden" id ="song_id" name="song_id" value="${Song.song_id}">
		        
		        </div>
		     
		        
		    <div class="modal-footer" id="리모달푸터">
		          <button type="submit" id="곡추가2" class="btn">추가</button>
		
		    </div>
		    </form>
		  </div>
		</div>
		    </div>
		  
	
	
	</c:if>
	






  



<!-- 송 내용칸 -->

    
    
    <div class="main1 mt-3 m-auto" style="width: 960px; height: 1000px; background-color: rgba(248,248,248); ">

        <div class="컨텐츠 핑크 border" style="width: 900px; height: auto; border-radius: 10px; float: left; background-color:  white; font-family: 'Noto Sans KR', sans-serif; font-size: 0px; padding-bottom: 40px;">
            
<!--            가수 -->
            <div class="가수" 
                 style="width: 598px; height: 200px; text-align: left; margin-left: 20px; margin-right: 20px; padding-top: 8px; border-bottom: 1px solid; border-color: darkgray;">
                
                <div class="가수 fw-bold" style="margin-left: px; margin-top: 5px; font-size: 18px; height: 30px; ">
                    가수
                </div>
                <div class="row 가수 프로필 mt-2" style="height: 150px">
                    <div class="col-3 text-center">
                        <div class="프로필 카드" style="margin-right: auto; margin-left: auto; margin-top: 5px">
                        <img src="../resources/img/profile/basic_profile.jpg" width="80px" style="border-radius: 50%">
                        <div class="가수명" id="아티스트이름">
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
                        <img src="../resources/img/profile/basic_profile.jpg" width="80px" style="border-radius: 50%">
                        <div class="작사가명" id="아티스트이름">
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
                        <div class="작곡가명" id="아티스트이름">
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
            

        
  <!--           태그 -->
            <div id="태그큰창">
                
                <div class="태 fw-bold" style="margin-left: margin-top: 20px; font-size: 22px; height: 50px; ">
                태그
                   
                </div>
                <div id="태그큰칸3">
                    <div id="태그칸">
                    	<c:forEach var="Tags" items="${Tag }"  varStatus="status">
                    		
                    		<c:choose>
                    			<c:when test="${status.count <=3 && status.count > 0}"><span id="큰태그${status.count }">${Tags.tag_name }</span></c:when>
                    			<c:when test="${status.count > 3}"><span id="작은태그${status.count - 3 }">${Tags.tag_name }</span></c:when>
                    			
                    			<c:otherwise></c:otherwise>
                    		</c:choose>
                    	</c:forEach>
                 
					                      
                       
                    </div>
                
                </div>
                
                
            
            </div>

       
        
        
        	<%-- <c:forEach var="playlist" items="${listId }">
           		<a href="/mylife/list/listPage?playlist_id=${playlist.playlist_id}">리스트페이지 테스트</a>
        	</c:forEach> --%>
        
        
        <!--            리스트 목록 -->
          <div class="송리스트목록" id="가수정보칸" style="height: 350px; border-bottom: none;">
             <div class="태그 fw-bold" style="margin-top: 20px; font-size: 22px; height: 50px; ">
                리스트
                 
             </div>
              <div class="row" id="리스트작칸">
                  
<!--                  리스트 한칸-->
                <div class="col-3">
                    <div id="송리스트한칸">
                        <span><img src="https://ww.namu.la/s/65f8c2198d2433b464f8a410a43174ed44e13d0863daebe7ce025089360ecc932fdb6dd7af01ad32c906d3f577a692e6f8116f14371a08171a21db191a0909813d7f3174c038c55feeef55df21900003b4e9208d92596e1335bea6c2c0fc0baeecaae02f398c2886a36c99bcd7d9ceb1" width="86px" style="margin: 2px; border-radius: 6px;"></span>
                        <span><img src="https://ww.namu.la/s/65f8c2198d2433b464f8a410a43174ed44e13d0863daebe7ce025089360ecc932fdb6dd7af01ad32c906d3f577a692e6f8116f14371a08171a21db191a0909813d7f3174c038c55feeef55df21900003b4e9208d92596e1335bea6c2c0fc0baeecaae02f398c2886a36c99bcd7d9ceb1" width="86px" style="margin: 2px; border-radius: 6px;"></span>
                        <span><img src="https://ww.namu.la/s/65f8c2198d2433b464f8a410a43174ed44e13d0863daebe7ce025089360ecc932fdb6dd7af01ad32c906d3f577a692e6f8116f14371a08171a21db191a0909813d7f3174c038c55feeef55df21900003b4e9208d92596e1335bea6c2c0fc0baeecaae02f398c2886a36c99bcd7d9ceb1" width="86px" style="margin: 2px; border-radius: 6px;"></span>
                        <span><img src="https://ww.namu.la/s/65f8c2198d2433b464f8a410a43174ed44e13d0863daebe7ce025089360ecc932fdb6dd7af01ad32c906d3f577a692e6f8116f14371a08171a21db191a0909813d7f3174c038c55feeef55df21900003b4e9208d92596e1335bea6c2c0fc0baeecaae02f398c2886a36c99bcd7d9ceb1" width="86px" style="margin: 2px; border-radius: 6px;"></span>
                    
                    </div>
                    <div id="송리스트타이틀">
                    밤편지모음집
                    </div>
                     <div id="송리스트좋아요">
                   좋아요 200
                  </div>
                    
                  </div>
        
        
          </div>
     </div>
 </div>
        
   </div>
 </div>     
      
        
</body>
</html>
