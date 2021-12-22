<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인 양식</title>
</head>
<body>
	<form:form commandName="vo"> <!-- form:form은 method를 적어주지 않으면 default가 post, html form tag의 경우에는 default가 get!! -->
		<table border="1">
			<tr>
				<th>이메일</th>
				<td><form:input path="email"/>
					<form:errors path="email"/>
				</td> <!-- input type="text" name="email" id="email"과 같은 표현 -->
			</tr>
			<tr>
				<td>비밀번호</td>
				<td><form:password path="password"/>
					<form:errors path="password"/>
				</td>
			</tr>
			<tr>
				<td colspan="2">
					<input type="submit" value="로그인">
				</td>
			</tr>
		</table>
		<form:errors/> <!-- 글로벌 에러 코드 표시 -->
	</form:form>
</body>
</html>