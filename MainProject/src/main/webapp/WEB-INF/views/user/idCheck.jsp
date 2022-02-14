<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>아이디 중복확인</title>
<script type="text/javascript">
	
	//유효성 검사
	function formCheck(){
		var searchId = document.getElementById("searchId");
		
		if(searchId.value.length < 4 || searchId.value.length > 10){
			alert('사용할 수 없는 아이디 입니다.');
			return false;
		}
		
	return true;
	}
	
	//id 사용 확정
	function Selected(id){
		opener.document.getElementById("user_id").value = id;
		this.close();
	}
</script>
</head>
<body>
	<h2>ID 중복 확인</h2>
	
	<form action="idCheck" method="post" onsubmit="return formCheck()">
		<input type="text" name="searchId" id="searchId" placeholder="아이디 입력">
		<input type="submit" value="검색">
	</form>
	
	<c:if test="${search}">
		<!-- id가 없을 경우 -->
		<c:if test="${searchResult == null }">
			<p>${searchId } : 사용가능한 ID 입니다.</p>
			<p>
				<input type="button" value="확인" onclick="Selected('${searchId}')">
			</p>
		</c:if>
		
		<!-- id가 사용중일 경우 -->
		<c:if test="${searchResult != null }">
			<p>${searchId }는 이미 사용 중인 ID 입니다.</p>
		</c:if>
	</c:if>
</body>
</html>