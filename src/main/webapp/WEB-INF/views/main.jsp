<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Main page</title>
</head>
<body>
	<h2>게시판 웹 페이지</h2>
	<c:if test="${empty authInfo }">
		<input type="button" onclick="window.location.href='${pageContext.request.contextPath}/member/login'" value="로그인하기">
		<input type="button" onclick="window.location.href='${pageContext.request.contextPath}/member/regist'" value="회원가입하기">
	</c:if>
	<c:if test="${!empty authInfo }">
		<table>
			<tr>
				<td>${authInfo.name }님으로 로그인 중</td>
			</tr>
			<tr>
				<td>
					<input type="button" onclick="window.location.href='${pageContext.request.contextPath}/board/list'" value="게시판 목록">
				</td>
			</tr>
		</table>
	</c:if>
</body>
</html>