<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1> 리스트 페이지 </h1>
	
	<%-- <c:forEach var="song" items="${songList }" begin="0" end="4"> --%>
	dsfdsf
	
	<c:forEach var="playlist" items="${playlist }">
		<h1>${playlist.list_name }</h1>
	</c:forEach>
</body>
</html>