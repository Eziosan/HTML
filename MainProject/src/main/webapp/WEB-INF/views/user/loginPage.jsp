<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인 페이지</title>
<script type="text/javascript">
	function formCheck(){
		//유효성 검사
		var user_id = document.getElementById("user_id").value;
		var user_pw = document.getElementById("user_pw").value;
		
		//1. id, pw 유무 검사
		if(user_id.length == "" || user_pw.length == ""){
			alert('아이디와 비밀번호를 입력해 주세요');
			return false;
		}
		
		//2. id 유효성 검사
		if(user_id.length < 4 || user_pw.length > 10){
			alert('아이디를 올바르게 입력하세요');
		} else{
			alert('아이디가 입력되었습니다.');
		}
		
		//3. pw 유효성 검사
		if(user_pw.length < 4 || user_pw.length > 10){
			alert('비밀번호를 올바르게 입력하세요');
		}	else{
			alert('비밀번호가 입력되었습니다.');
		}
		
	return true;
	}
</script>
</head>
<body>
	<h2>로그인</h2>
	<form action="login" method="post" onsubmit="return formCheck()">
		<table>
			<tr>
				<th>아이디</th>
				<td>
				<input type="text" name="user_id" id="user_id">
				</td>
			</tr>
			<tr>
				<th>패스워드</th>
				<td>
				<input type="password" name="user_pw" id="user_pw">
				</td>
			</tr>
			<tr>
				<td colspan="2">
					<p style="color: red">${errorMsg}</p>
				</td>
			</tr>
			<tr>
				<td colspan="2">
					<input type="submit" value="로그인"><br>
					계정이 없으신가요?<a href="join">회원가입</a>
				</td>
			</tr>
		</table>
	</form>
</body>
</html>