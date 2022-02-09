<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
  <script async src='/cdn-cgi/bm/cv/669835187/api.js'></script></head>
  <body>
         
    
    
    <header class="p-2 mb-3 bg-white fixed-top align-items-center border-bottom border-info">
    <div class="container-fluid w-75">
      <div class="d-flex flex-wrap align-items-center justify-content-start ">
<!--          justify-content-lg-start-->
        <a href="/" class="d-flex align-items-center mb-2 mb-lg-0 text-dark text-decoration-none">
          <svg class="bi me-2" width="40" height="32" role="img" aria-label="Bootstrap"><use xlink:href="#bootstrap"></use></svg>
        </a>

        <ul class="nav col-12 col-lg-auto fw-bold me-lg-auto mlmb-2 justify-content-center mb-md-0">
          <li><a href="https://www.naver.com/" class="nav-link px-2 link-secondary">곡</a></li>
          <li><a href="#" class="nav-link px-2 link-dark">앨범</a></li>
          <li><a href="#" class="nav-link px-2 link-dark">가수</a></li>
        </ul>

        <form class="col-12 col-lg-auto mb-3 mb-lg-0 me-lg-3">
          <input type="search" class="form-control" placeholder="# 태그를 검색해보세요"  aria-label="Search" control-id="ControlID-2" style="background: #F2F2F2">
        </form>

          
          
        <div class="dropdown text-end">
          <a href="#" class="d-block link-dark text-decoration-none dropdown-toggle" id="dropdownUser1" data-bs-toggle="dropdown" aria-expanded="false">
            <img src="https://github.com/mdo.png" alt="mdo" width="32" height="32" class="rounded-circle">
          </a>
                 
            
            
          <ul class="dropdown-menu text-small" aria-labelledby="dropdownUser1">
            <li><a class="dropdown-item" href="#">프로필</a></li>
            <li><a class="dropdown-item" id="openModalBtn" href="#">마이 리스트</a></li>
            <li><hr class="dropdown-divider"></li>
            <li><a class="dropdown-item" href="#">Sign out</a></li>
          </ul>
        </div>
      </div>
    </div>
        
 
        
  </header>
   
      <div class="modal" id="modalBox" tabindex="-1">
  <div class="modal-dialog">
    <div class="modal-content">
      <div class="modal-header">
        <h5 class="modal-title">Modal title</h5>
        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
      </div>
      <div class="modal-body">
        <p>Modal body text goes here.</p>
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Close</button>
        <button type="button" class="btn btn-primary">Save changes</button>
      </div>
    </div>
  </div>
</div>

      
      
      
<script>
      
     // 모달 버튼에 이벤트를 건다.
        $('#openModalBtn').on('click', function(){
        $('#modalBox').modal('show');
        });
        


        // 모달 안의 취소 버튼에 이벤트를 건다.
        $('#closeModalBtn').on('click', function(){
        $('#modalBox').modal('hide');

           
       }))

       
 </script>


<!--
      <div class="modal modal-signin position-static d-block bg-secondary py-5" tabindex="-1" role="dialog" id="modalBox" >
  <div class="modal-dialog" role="document">
    <div class="modal-content rounded-5 shadow">
      <div class="modal-header p-5 pb-0 border-bottom-0 col-12">
         <h5 class="modal-title">Modal title</h5> 
       
          <button type="button" class="btn-close" id="closeModalBtn" data-bs-dismiss="modal" aria-label="Close"></button>
         
         
      </div>
        
         <div class="row text-center" style="width: 100%"> 
             <div style="float: none; margin:0 auto" >
             
              <img src="%EC%B4%88%EC%95%882.png" alt="img" width="50%" height="50%">
                </div>
          </div>

      <div class="modal-body p-5 pt-0">
        <form class="">
          <div class="form-floating mb-3">
            <input type="email" class="form-control rounded-4" id="floatingInput" placeholder="name@example.com" control-id="ControlID-1">
            <label for="floatingInput">ID</label>
          </div>
          <div class="form-floating mb-3">
            <input type="password" class="form-control rounded-4" id="floatingPassword" placeholder="Password" control-id="ControlID-2">
            <label for="floatingPassword">Password</label>
          </div>
          <button class="w-100 mb-2 btn btn-lg rounded-4 btn-primary" type="submit" control-id="ControlID-3">Sign in</button>
          
          <hr class="my-4">
          
          <button class="w-100 py-2 mb-2 btn btn-outline-dark rounded-4" type="submit" control-id="ControlID-4">
            <svg class="bi me-1" width="16" height="16"><use xlink:href="#twitter"></use></svg>
            Sign up
          </button>
         
        </form>
      </div>
    </div>
  </div>
</div>    
-->
      
      
      
<main>
    
    

<!-- 메인 페이지 -->
    
  <div class="album py-5 bg-white mt-4" style="font-family: 'Noto Sans KR', sans-serif;">
    <div class="container">

    <div class="titles fw-bold mb-3" style="font-size: 25px;">
        #겨울에 듣기 좋은 노래
        </div>
        
 
        
<!-- 곡 화면-->        
      <div class="row row-cols-sm-3 row-cols-lg-5">
<!--          row-cols-1  row-cols-sm-2 row-cols-md-3 g-3 -->
<!-- 1번 곡 프로필-->
        <div class="col">
          <div class="card border border-white">
            <img src="https://ww.namu.la/s/65f8c2198d2433b464f8a410a43174ed44e13d0863daebe7ce025089360ecc932fdb6dd7af01ad32c906d3f577a692e6f8116f14371a08171a21db191a0909813d7f3174c038c55feeef55df219000037a2195c4d18ac3658f956fd4d3e0f7fe2c09b8f9c819b400dcc7b7da7e47872b" alt="img" width="100%" height="225">

            <div class="card1 mt-3 "> 
                <p class="card-text mb-1 fw-bold" style="font-size: 23px;">밤편지</p>
                <p class="card-text mb-0" style="font-size: 15px;">아이유</p>
                <span class="card-text mb-0" style="font-size: 13px; margin-left: 1px">
                    2017 </span>
                <span class="card-text mb-0 fw-bold" style="font-size: 13px; margin-left: 2px">
                    • </span>
                <span class="card-text mb-0" style="font-size: 13px; margin-left: 2px">
                    밤편지 </span> 
                <p class="card-text mb-0 text-danger" style="font-size: 13px; margin-left: 1px">예상 ★2.4</p>
              <div class="d-flex justify-content-between align-items-center">

                <small class="text-muted"></small>
              </div>
            </div>
          </div>
        </div>
          
<!--  2번 곡 프로필 -->
      <div class="col">
          <div class="card border border-white">
            <img src="https://w.namu.la/s/1caff802e768dbe216eaa495f470e010c5d145ae5046861cf18ace1dbfab1dfa958bddb7329ce5003e40cfc5245cd12529d14f9a39f5516080324f2605832d43e862bfe64fc8b7937f2b7e653fb0b0135a3f37ec4a4d1fd81e59281817daa0857a9dc961fb745eec13859164dc4f522e" alt="img" width="100%" height="225">

            <div class="card1 mt-3 "> 
                <p class="card-text mb-1 fw-bold" style="font-size: 23px;">좋니</p>
                <p class="card-text mb-0" style="font-size: 15px;">윤종신</p>
                <span class="card-text mb-0" style="font-size: 13px; margin-left: 1px">
                    2017 </span>
                <span class="card-text mb-0 fw-bold" style="font-size: 13px; margin-left: 2px">
                    • </span>
                <span class="card-text mb-0" style="font-size: 13px; margin-left: 2px">
                    LISTEN 010  </span> 
                <p class="card-text mb-0 text-danger" style="font-size: 13px; margin-left: 1px">예상 ★2.4</p>
              <div class="d-flex justify-content-between align-items-center">

                <small class="text-muted"></small>
              </div>
            </div>
          </div>
        </div>
        
<!--  3번 곡 프로필 -->
      <div class="col">
          <div class="card border border-white">
            <img src="https://w.namu.la/s/c002522e92ef6255598c1631fde9f26a85e639768452cb5536a7c1072cac0555fc1bf806b0f29a027d21fbf25219b057d1baaf04ec9aec9f58690928cc522fa22712993071cf3ba913240542926b64d8dc22415a515b380649ffb19e53b6bc15a9bb0c56f29bc1767180278f06f3911f" alt="img" width="100%" height="225">

            <div class="card1 mt-3 "> 
                <p class="card-text mb-1 fw-bold" style="font-size: 23px;">No.1</p>
                <p class="card-text mb-0" style="font-size: 15px;">보아</p>
                <span class="card-text mb-0" style="font-size: 13px; margin-left: 1px">
                    2002 </span>
                <span class="card-text mb-0 fw-bold" style="font-size: 13px; margin-left: 2px">
                    • </span>
                <span class="card-text mb-0" style="font-size: 13px; margin-left: 2px">
                    The 2nd Album  </span> 
                <p class="card-text mb-0 text-danger" style="font-size: 13px; margin-left: 1px">예상 ★2.4</p>
              <div class="d-flex justify-content-between align-items-center">

                <small class="text-muted"></small>
              </div>
            </div>
          </div>
        </div>
          
<!--  4번 곡 프로필 -->
      <div class="col">
          <div class="card border border-white">
            <img src="https://w.namu.la/s/cd053e3a38b6689a54fae13730a9fded7af31c9c060fbf30253d6a815ac0d735cc0d36f16191aef0e5dd2a877171babd1811b8b6408bcdeb0d097f04411c2a3ab19b17241e3b33d6dbc9b696ba923a9140bda84e5ecf23ad0c8e89e5b8735724d1e2cff4d79bb1ab917391f5a378cf3d" alt="img" width="100%" height="225">

            <div class="card1 mt-3 "> 
                <p class="card-text mb-1 fw-bold" style="font-size: 23px;">으르렁 / 咆哮 (Growl)</p>
                <p class="card-text mb-0" style="font-size: 15px;">EXO</p>
                <span class="card-text mb-0" style="font-size: 13px; margin-left: 1px">
                    2013 </span>
                <span class="card-text mb-0 fw-bold" style="font-size: 13px; margin-left: 2px">
                    • </span>
                <span class="card-text mb-0" style="font-size: 13px; margin-left: 2px">
                    XOXO (Kiss&Hug) (Repackage)  </span> 
                <p class="card-text mb-0 text-danger" style="font-size: 13px; margin-left: 1px">예상 ★2.4</p>
              <div class="d-flex justify-content-between align-items-center">

                <small class="text-muted"></small>
              </div>
            </div>
          </div>
        </div>
          
<!--  5번 곡 프로필 -->
      <div class="col">
          <div class="card border border-white">
            <img src="https://ww.namu.la/s/591a3efcddacffb88d724adbbee700e96370f3d0708828b7fc72cfa28c8cbab35ab40df3a1ab782bba72c5ce8ff7be392ab96f79d3ff90994e4f4ec9c1612c5a64ef33559fc5b561a3aa773e9ecb5c69dca6c39e8ebb9c18de5605e17be13811" alt="img" width="100%" height="225">

            <div class="card1 mt-3 "> 
                <p class="card-text mb-1 fw-bold" style="font-size: 23px;">강남스타일</p>
                <p class="card-text mb-0" style="font-size: 15px;">싸이</p>
                 <span class="card-text mb-0" style="font-size: 13px; margin-left: 1px">
                    2012 </span>
                 <span class="card-text mb-0 fw-bold" style="font-size: 13px; margin-left: 2px">
                      • </span>
                 <span class="card-text mb-0" style="font-size: 13px; margin-left: 2px">
                      싸이6甲 Part 1  </span> 
                <p class="card-text mb-0 text-danger" style="font-size: 13px; margin-left: 1px">예상 ★2.4</p>
              <div class="d-flex justify-content-between align-items-center">

                <small class="text-muted"></small>
              </div>
            </div>
          </div>
          
          
        </div>
        </div>
        
    
      </div>
    </div>

    <!-- 메인 페이지 -->
  <div class="album py-5 bg-white" style="font-family: 'Noto Sans KR', sans-serif;">
    <div class="container">

    <div class="titles fw-bold mb-3" style="font-size: 25px;">
        #여름에 듣기 좋은 노래
        </div>        
<!-- 곡 화면-->        
      <div class="row row-cols-sm-5">
<!--          row-cols-1  row-cols-sm-2 row-cols-md-3 g-3 -->
<!-- 1번 곡 프로필-->
        <div class="col">
          <div class="card border border-white">
            <img src="https://ww.namu.la/s/65f8c2198d2433b464f8a410a43174ed44e13d0863daebe7ce025089360ecc932fdb6dd7af01ad32c906d3f577a692e6f8116f14371a08171a21db191a0909813d7f3174c038c55feeef55df219000037a2195c4d18ac3658f956fd4d3e0f7fe2c09b8f9c819b400dcc7b7da7e47872b" alt="img" width="100%" height="225">

            <div class="card1 mt-3 "> 
                <p class="card-text mb-1 fw-bold" style="font-size: 23px;">밤편지</p>
                <p class="card-text mb-0" style="font-size: 15px;">아이유</p>
                <span class="card-text mb-0" style="font-size: 13px; margin-left: 1px">
                    2017 </span>
                <span class="card-text mb-0 fw-bold" style="font-size: 13px; margin-left: 2px">
                    • </span>
                <span class="card-text mb-0" style="font-size: 13px; margin-left: 2px">
                    밤편지  </span> 
                <p class="card-text mb-0 text-danger" style="font-size: 13px; margin-left: 1px">예상 ★2.4</p>
              <div class="d-flex justify-content-between align-items-center">

                <small class="text-muted"></small>
              </div>
            </div>
          </div>
        </div>
          
<!--  2번 곡 프로필 -->
      <div class="col">
          <div class="card border border-white">
            <img src="https://w.namu.la/s/1caff802e768dbe216eaa495f470e010c5d145ae5046861cf18ace1dbfab1dfa958bddb7329ce5003e40cfc5245cd12529d14f9a39f5516080324f2605832d43e862bfe64fc8b7937f2b7e653fb0b0135a3f37ec4a4d1fd81e59281817daa0857a9dc961fb745eec13859164dc4f522e" alt="img" width="100%" height="225">

            <div class="card1 mt-3 "> 
                <p class="card-text mb-1 fw-bold" style="font-size: 23px;">좋니</p>
                <p class="card-text mb-0" style="font-size: 15px;">윤종신</p>
                <span class="card-text mb-0" style="font-size: 13px; margin-left: 1px">
                    2017 </span>
                <span class="card-text mb-0 fw-bold" style="font-size: 13px; margin-left: 2px">
                    • </span>
                <span class="card-text mb-0" style="font-size: 13px; margin-left: 2px">
                    LISTEN 010  </span> 
                <p class="card-text mb-0 text-danger" style="font-size: 13px; margin-left: 1px">예상 ★2.4</p>
              <div class="d-flex justify-content-between align-items-center">

                <small class="text-muted"></small>
              </div>
            </div>
          </div>
        </div>
        
<!--  3번 곡 프로필 -->
      <div class="col">
          <div class="card border border-white">
            <img src="https://w.namu.la/s/c002522e92ef6255598c1631fde9f26a85e639768452cb5536a7c1072cac0555fc1bf806b0f29a027d21fbf25219b057d1baaf04ec9aec9f58690928cc522fa22712993071cf3ba913240542926b64d8dc22415a515b380649ffb19e53b6bc15a9bb0c56f29bc1767180278f06f3911f" alt="img" width="100%" height="225">

            <div class="card1 mt-3 "> 
                <p class="card-text mb-1 fw-bold" style="font-size: 23px;">No.1</p>
                <p class="card-text mb-0" style="font-size: 15px;">보아</p>
                <span class="card-text mb-0" style="font-size: 13px; margin-left: 1px">
                    2002 </span>
                <span class="card-text mb-0 fw-bold" style="font-size: 13px; margin-left: 2px">
                    • </span>
                <span class="card-text mb-0" style="font-size: 13px; margin-left: 2px">
                    The 2nd Album  </span> 
                <p class="card-text mb-0 text-danger" style="font-size: 13px; margin-left: 1px">예상 ★2.4</p>
              <div class="d-flex justify-content-between align-items-center">

                <small class="text-muted"></small>
              </div>
            </div>
          </div>
        </div>
          
<!--  4번 곡 프로필 -->
      <div class="col">
          <div class="card border border-white">
            <img src="https://w.namu.la/s/cd053e3a38b6689a54fae13730a9fded7af31c9c060fbf30253d6a815ac0d735cc0d36f16191aef0e5dd2a877171babd1811b8b6408bcdeb0d097f04411c2a3ab19b17241e3b33d6dbc9b696ba923a9140bda84e5ecf23ad0c8e89e5b8735724d1e2cff4d79bb1ab917391f5a378cf3d" alt="img" width="100%" height="225">

            <div class="card1 mt-3 "> 
                <p class="card-text mb-1 fw-bold" style="font-size: 23px;">으르렁 / 咆哮 (Growl)</p>
                <p class="card-text mb-0" style="font-size: 15px;">EXO</p>
                <span class="card-text mb-0" style="font-size: 13px; margin-left: 1px">
                    2013 </span>
                <span class="card-text mb-0 fw-bold" style="font-size: 13px; margin-left: 2px">
                    • </span>
                <span class="card-text mb-0" style="font-size: 13px; margin-left: 2px">
                    XOXO (Kiss&Hug) (Repackage)  </span> 
                <p class="card-text mb-0 text-danger" style="font-size: 13px; margin-left: 1px">예상 ★2.4</p>
              <div class="d-flex justify-content-between align-items-center">

                <small class="text-muted"></small>
              </div>
            </div>
          </div>
        </div>
          
<!--  5번 곡 프로필 -->
      <div class="col">
          <div class="card border border-white">
            <img src="https://ww.namu.la/s/591a3efcddacffb88d724adbbee700e96370f3d0708828b7fc72cfa28c8cbab35ab40df3a1ab782bba72c5ce8ff7be392ab96f79d3ff90994e4f4ec9c1612c5a64ef33559fc5b561a3aa773e9ecb5c69dca6c39e8ebb9c18de5605e17be13811" alt="img" width="100%" height="225">

            <div class="card1 mt-3 "> 
                <p class="card-text mb-1 fw-bold" style="font-size: 23px;">강남스타일</p>
                <p class="card-text mb-0" style="font-size: 15px;">싸이</p>
                 <span class="card-text mb-0" style="font-size: 13px; margin-left: 1px">
                    2012 </span>
                 <span class="card-text mb-0 fw-bold" style="font-size: 13px; margin-left: 2px">
                      • </span>
                 <span class="card-text mb-0" style="font-size: 13px; margin-left: 2px">
                      싸이6甲 Part 1  </span> 
                <p class="card-text mb-0 text-danger" style="font-size: 13px; margin-left: 1px">예상 ★2.4</p>
              <div class="d-flex justify-content-between align-items-center">

                <small class="text-muted"></small>
              </div>
            </div>
          </div>
          
          
        </div>
        </div>
        
    
      </div>
    </div>

</main>

  <script type="text/javascript">(function(){window['__CF$cv$params']={r:'6d92770c9b8f350e',m:'FOa7nQ9_4UxjNBSKP08nsf09deji_oUFVvUJyuojbx4-1644130444-0-Ad0zIEq7TyC9f9WcB1ONhnf1NRJQeQKcfw63XunFWW+5Weov0sTBO6uTRqErbjiNLWJE3KdP3xzs2waCj8M1klghEgMw7zH3H7VKvR6rTYkptzMtuKZmF5uQQdOft9kLDRdEM8VR359VaGYuqPifPTL0EQL/UDynqt9Dfyu5Y4Hw7MNJAKsl82hORJvGWQLooA==',s:[0x9f1d549bde,0x8d8a13d09f],}})();</script></body>
</html>