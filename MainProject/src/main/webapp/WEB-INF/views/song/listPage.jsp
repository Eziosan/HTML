<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-3.6.0.js"></script>
<script type="text/javascript">

function formCheck(){
	//유효성 검사

	//2. id 유효성 검사
	var user_id = document.getElementById("user_id").value;
	
	alert(document.getElementById("user_id").value);
	
	//3. pw 유효성 검사
	var list_name = document.getElementById("list_name").value;
	
	alert(document.getElementById("list_name").value);
	
	var list_explain = document.getElementById("list_explain").value;
	
	alert(document.getElementById("list_explain").value);
	
	var song_id = document.getElementById("song_id").value;
	
	alert(document.getElementById("song_id").value);
	
	
	//5. 모든 값이 입력 되지 않을 경우 값을 보내지 않는다.
	if( user_id == '' || list_name == '' || list_explain == ''){
		alert("3개 다 입력해주셔야 해요");
		return false;
	}
	
return true;
}

function result(){
	alert(document.getElementById())
}


</script>
</head>
<body>
	<h1> 리스트 페이지 </h1>
	
	<%-- <c:forEach var="song" items="${songList }" begin="0" end="4"> --%>
	dsfdsf
	
	<c:forEach var="plist" items="${playlist }">
		<h6><a href="insertSong?plist=${plist.list_name}"><h6>${plist.list_name }</h6> </a></h6>
	</c:forEach> 
	
	<!-- 특정 playlist를 컨트롤러로 보내는걸 어떻게?? -->
	 
	
	
	
	<h2>리스트 추가</h2>
	<form action="insertList" method="post" onsubmit="return formCheck()">
		<table>
			<tr>
				<td>
				<input type="text" placeholder="유저 아이디" name="user_id" id="user_id"><br>
				<div style="color:red" id="idCheck"></div>
				</td>
			</tr>
			
			<tr>
				<td>
				<input type="text" placeholder="리스트 이름" name="list_name" id="list_name"><br>
				<div style="color:red" id="nameCheck"></div>
				</td>
			</tr>
			<tr>
				<td>
				<input type="text" placeholder="리스트 설명" name="list_explain" id="list_explain"><br>
				<div style="color:red" id="explainCheck"></div>
				</td>
			</tr>
			<tr>
				<td>
				<input type="text" placeholder="곡 id ( 1~ 8까지)" name="song_id" id="song_id"><br>
				<div style="color:red" id="songCheck"></div>
				</td>
			</tr>
		</table>
		<input type="submit" value="리스트추가">
		
		
		
		
		<h2>곡 추가</h2>
	<form action="insertSong" method="post" onsubmit="return formCheck()">
		<table>
			<tr>
				<td>
				<input type="text" placeholder="유저 아이디" name="user_id" id="user_id"><br>
				<div style="color:red" id="idCheck"></div>
				</td>
			</tr>
			
			<tr>
				<td>
				<input type="text" placeholder="리스트 이름" name="list_name" id="list_name"><br>
				<div style="color:red" id="nameCheck"></div>
				</td>
			</tr>
			<tr>
				<td>
				<input type="text" placeholder="리스트 설명" name="list_explain" id="list_explain"><br>
				<div style="color:red" id="explainCheck"></div>
				</td>
			</tr>
			<tr>
				<td>
				<input type="text" placeholder="곡 id ( 1~ 8까지)" name="song_id" id="song_id"><br>
				<div style="color:red" id="songCheck"></div>
				</td>
			</tr>
		</table>
		<input type="submit" value="리스트추가">
		
		
		
</body>
</html>