<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입 페이지</title>
<script src="https://code.jquery.com/jquery-3.6.0.js"></script>
<script type="text/javascript">
	function formCheck(){
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
	
/* 	//아이디 중복 확인 창 띄우기
	function idCheckOpen(){
		window.open("idCheck", "newwin", "top = 100, left = 200, width = 200, heigth = 150, resizeable = no" );
	} */

</script>
</head>
<body>
	<h2>회원가입</h2>
	<form action="join" method="post" onsubmit="return formCheck()">
		<table>
			<tr>
				<td>
				<input type="text" placeholder="이름" name="user_name" id="user_name"><br>
				<div style="color:red" id="nameCheck"></div>
				</td>
			</tr>
			<tr>
				<td>
				<input type="text" placeholder="아이디" name="user_id" id="user_id"><br>
				<div style="color:red" id="idCheck"></div>
				</td>
			</tr>
			<tr>
				<td>
				<input type="password" placeholder="비밀번호" name="user_pw" id="user_pw"><br>
				<div style="color:red" id="pwCheck"></div>
				<input type="password" placeholder="비밀번호 확인" name="pwcheck" id="pwcheck"><br>
				<div style="color:red" id="pw2Check"></div>
				</td>
			</tr>
		</table>
		<input type="submit" value="회원가입">
		<input type="reset" value="다시입력"><br>
		계정이 있으신가요?<a href="login">로그인</a>
	</form>

</body>
</html>