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
	<table border="1">
		<tr>
			<td>제목</td>
			<td>${vo.title }</td>
		</tr>
		<tr>
			<td>내용</td>
			<td>${vo.content }</td>
		</tr>
		<tr>
			<td>작성자</td>
			<td>${vo.writer }</td>
		</tr>
		<tr>
			<td>작성일</td>
			<td>${vo.regdate }</td>
		</tr>
		<tr>
			<td>조회수</td>
			<td>${vo.cnt }</td>
		</tr>
	</table>
	<a href='<c:url value="/board/edit/${vo.seq}"/>'>수정</a>
	<a href="<c:url value='/board/list'/>">목록</a>
</body>
</html>