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
    <input type="hidden" name="searchText" value="${searchText }">
    
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
	<input type="hidden" name="searchText" value="${searchText }">
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