<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form:form commandName="vo" method="POST"> <!-- model에 add 한  name -->
		<table border="1">
			<tr>
				<th>제목</th>
				<td><form:input path="title"/>
				<form:errors path="title"/>
				</td>
			</tr>
			<tr>
				<th>내용</th>
				<td><form:input path="content"/>
				<form:errors path="content"/>
				</td>
			</tr>
			<tr>
				<th>작성자</th>
				<td><form:input path="writer"/>
				<form:errors path="writer"/>
				</td>
			</tr>
			<tr>
				<th>비밀번호</th>
				<td>
					<input type="password" name="password"/>
					${msg }
				</td>
			</tr>
		</table>
		<input type="submit" value="등록">
		<a href="<c:url value='/board/list'/>">목록</a>
	</form:form>
</body>
</html>