<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>목록</title>
</head>
<body>
	<c:if test="${!empty authInfo }">
		<table>
			<tr>
				<td>${authInfo.name }으로 로그인 됨</td>
			</tr>
		</table>
	</c:if>
	<table border="1">
		<tr>
			<th>NO</th>
			<th>제목</th>
			<th>작성자</th>
			<th>작성일</th>
			<th>조회수</th>
		</tr>
		<c:forEach items="${boardList }" var="vo" varStatus="loop">
			<tr>
				<td>${vo.seq }</td>
				<td>
					<a href="<c:url value='/board/detail/${vo.seq}'/>">${vo.title }</a>
				</td>
				<td>${vo.writer }</td>
				<td>${vo.regdate }</td>
				<td>${vo.cnt }</td>
			</tr>
		</c:forEach>
	</table>
	<a href='<c:url value="/board/write"/>'>새 글</a>
	<c:if test="${!empty authInfo }">
	<a href="<c:url value='/member/logout'/>">로그아웃</a>
	<!-- c tag 사용할 때 경로 주의 -->
	</c:if>
</body>
</html>