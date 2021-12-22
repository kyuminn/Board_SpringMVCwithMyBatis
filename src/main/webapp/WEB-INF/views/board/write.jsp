<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>입력 폼</title>
</head>
<body>
	<!-- form tag에 action 경로를 따로 지정하지 않으면 자기 자신에게 요청함 -->
	<form:form commandName="vo">
		<table border="1">
			<tr>
				<td>제목</td>
				<td>
					<form:input path="title"/>
				</td>
				<td>
					<form:errors path="title"/>
				</td>
			</tr>
			<tr>
				<td>작성자</td>
				<td>
					<form:input path="writer" value="${authInfo.name }"/>
				</td>
				<td>
					<form:errors path="writer"/>
				</td>
			</tr>
			<tr>
				<td>내용</td>
				<td>
					<form:input path="content"/>
				</td>
				<td>
					<form:errors path="content"/>
				</td>
			</tr>
			<tr>
				<td>비밀번호</td>
				<td>
					<form:password path="password"/>
				</td>
				<td>
					<form:errors path="password"/>
				</td>
			</tr>
			<tr>
				<td colspan="2">
					<input type="submit" value="글쓰기">
				</td>
			</tr>
		</table>
		
	</form:form>
</body>
</html>