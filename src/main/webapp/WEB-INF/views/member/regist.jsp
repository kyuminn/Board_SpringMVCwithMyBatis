<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입 양식</title>
</head>
<body>
	<form:form commandName="vo">
		<table border="1">
			<tr>
				<td>이름</td>
				<td>
					<form:input path="name"/>
					<form:errors path="name"/>
				</td>
			</tr>
			<tr>
				<td>이메일</td>
				<td>
					<form:input path="email"/>
					<form:errors path="email"/>
				</td>
			</tr>
			<tr>
				<td>비밀번호</td>
				<td>
					<form:password path="password"/>
					<form:errors path="password"/>
				</td>
			</tr>
			<tr>
				<td>비밀번호 확인</td>
				<td>
					<form:password path="confirmPassword"/>
					<form:errors path="confirmPassword"/>
				</td>
			</tr>
			<tr>
				<td colspan="2" align="center">
					<input type="submit" value="가입하기">
				</td>
			</tr>
		</table>
	</form:form>
</body>
</html>