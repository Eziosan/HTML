<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입</title>
<link rel="stylesheet" type="text/css"
	href="./resources/css/default.css">
<script src="https://code.jquery.com/jquery-3.6.0.js"></script>
<script type="text/javascript">
</script>
</head>
<body>
<div class="popup">
		<img src="./resources/img/왓챠피디아.jpg" alt="왓챠피디아" width="500px" height="200px">
		<h2>회원가입</h2>
		<form action="user/join" method="post">
		<table>
			<tr>
				<td>
					<input type="text" placeholder="이름" name="name"><br>
				</td>
			</tr>
			<tr>
				<td>
					<input type="email" placeholder="이메일" name="email"><br>
				</td>
			</tr>
			<tr>
				<td>
					<input type="password" placeholder="비밀번호" name="password"><br>
				</td>
			</tr>
		</table>
		<input type="submit" value="회원가입">
		</form>
		<a href="#join" class="close">X</a>
</div>

<div class="dim"></div>
</body>
</html>