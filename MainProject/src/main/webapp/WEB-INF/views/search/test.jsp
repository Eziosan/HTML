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
    
    <link href="Allusic.css" rel="stylesheet"/>  
      
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>
    
    <script src="https://code.jquery.com/jquery-3.6.0.min.js" integrity="sha256-/xUj+3OJU5yExlq6GSYGSHk7tPXikynS7ogEvDej/m4=" crossorigin="anonymous"></script>  
      


      
    <title>홈 화면</title>
    <script type="text/javascript">
  //유효성 검사
	//1. 이름 필수 입력
	var namecheck = document.getElementById("user_name").value;
	
if(namecheck == ''){
		document.getElementById("nameCheck").innerHTML='이름을 입력해 주세요';
	return false;
	}
	//2. id 유효성 검사
	var user_id = document.getElementById("user_id").value;
	
	if(user_id.length < 4 || user_id.length > 10){
		document.getElementById("idCheck").innerHTML='아이디를 올바르게 입력해 주세요';
	return false;
	} 
	
	//3. pw 유효성 검사
	var user_pw = document.getElementById("user_pw").value;
	var pwcheck = document.getElementById("user_pw").value;
	
	
	if(user_pw.length < 4 || user_pw.length > 10){
		document.getElementById("pwCheck").innerHTML='비밀번호를 올바르게 입력해 주세요';
	return false;
	} 
	//4. pwcheck 유효성 검사
	if(pwcheck != user_pw){
		document.getElementById("pw2Check").innerHTML='비밀번호가 일치하지 않습니다';
	return false;
	}
	
	
	//5. 모든 값이 입력 되지 않을 경우 값을 보내지 않는다.
	if(namecheck == '' || user_id == '' || user_pw == '' || pwcheck == ''){
		return false;
	}
	
return true;
}

function searchCheck(){
//몇 자 유효성 검사
	if(window.event.keyCode == 13){
		alert("enter키 클릭")
		var searchText = $("#searchText").text();
		location.href = "/mylife/search/search?searchText=" + searchText
	}
}
    
    </script>
      <style>
         @import url(//fonts.googleapis.com/earlyaccess/jejuhallasan.css);
    
      
      </style>
  </head>
  <body>
         
    
         
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
<c:forEach var="song" items="${searchResult1 }" begin="0" end="3">
        <div class="col">
          <div class="card border border-white">
            <img src="${song.album_img} " alt="img" width="100%" height="225">

            <div class="card1 mt-3 "> 
                <p class="card-text mb-1 fw-bold" style="font-size: 23px;">${song.song_name}</p>
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
<c:forEach var="song" items="${searchResult1 }" begin="0" end="4">
        <div class="col">
          <div class="card border border-white">
            <img src="${song.album_img }" alt="img" width="100%" height="225">

            <div class="card1 mt-3 "> 
                <p class="card-text mb-1 fw-bold" style="font-size: 23px;">${song.song_name}</p>
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
                <p class="card-text mb-1 fw-bold" style="font-size: 23px;">${song.song_name}</p>
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
                <p class="card-text mb-1 fw-bold" style="font-size: 23px;">${song.song_name}</p>
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