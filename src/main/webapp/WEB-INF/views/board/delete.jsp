<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form method="post">
		<input type="text" value="${seq }" size="1">번 글을 삭제하시겠습니까?<br>
		<input type="password" name="password"/>
		<input type="submit" value="삭제하기">
		<a href="<c:url value='/board/detail/${seq }'/>">취소</a>
	</form>
</body>
</html>