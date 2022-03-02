<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form method="post" action="navigationServlet">
		<table>
			<c:forEach items="${requestScope.allItems}" var="currentitem">
				<tr>
					<td><input type="radio" name="id" value="${currentauthor.id}">
					</td>
					<td>${currentitem.title}</td>
					<td>${currentitem.author}</td>
				</tr>
			</c:forEach>
		</table>
		<input type="submit" value="edit" name="doThisToAuthor"> <input
			type="submit" value="delete" name="doThisToAuthor"> <input
			type="submit" value="add" name="doThisToAuthor">
	</form>

</body>
</html>