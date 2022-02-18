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
	var user_id = document.getElementById("user_id").value;
	var user_pw = document.getElementById("user_pw").value;
	
	//1. id, pw 유무 검사
	if(user_id.length == "" || user_pw.length == ""){
		document.getElementById("check").innerHTML='아이디, 비밀번호를 입력해주세요';
	return false;
	}
	
	//2. id, pw 둘다 잘못 입력 되었을 경우
	if((user_id.length < 4 || user_pw.length > 10) &&
			(user_pw.length < 4 || user_pw.length > 10)){
	document.getElementById("check").innerHTML='아이디, 비밀번호를 올바르게 입력하세요';
	return false;
	}
	
	
	//3. id 유효성 검사
	if(user_id.length < 4 || user_pw.length > 10){
		document.getElementById("check").innerHTML='아이디를 올바르게 입력하세요';
	return false;
	}
	
	//4. pw 유효성 검사
	if(user_pw.length < 4 || user_pw.length > 10){
		document.getElementById("check").innerHTML='비밀번호를 올바르게 입력하세요';
	return false;
	}
	
return true;
}


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