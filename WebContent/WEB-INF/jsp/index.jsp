<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h3>Add/Updated User</h3>
	<c:if test="${not empty param.d }">
		<c:choose>
			<c:when test="${ param.d == 1 }">
				<label>User updated Successfully</label>
			</c:when>
			<c:when test="${ param.d == 0 }">
				<label>User Could not updated</label>
			</c:when>
		</c:choose>
	</c:if>
	<c:if test="${not empty param.e }">
		<c:choose>
			<c:when test="${ param.e == 1 }">
				<label>User Deleted Successfully</label>
			</c:when>
			<c:when test="${ param.e == 0 }">
				<label>User Could not Deleted</label>
			</c:when>
		</c:choose>
	</c:if>
	<c:if test="${not empty param.f }">
		<c:choose>
			<c:when test="${ param.f == 1 }">
				<label>User added Successfully</label>
			</c:when>
			<c:when test="${ param.f == 0 }">
				<label>User Could not added</label>
			</c:when>
		</c:choose>
	</c:if>
	<c:choose>
		<c:when test="${not empty user}">
			<form action="../save" method="post">
		</c:when>
		<c:otherwise>
			<form action="save" method="post">
		</c:otherwise>
	</c:choose>
		<table>
			<c:if test="${not empty user }">
				<input type="hidden" name="id" value="${ user.id }">
			</c:if>
			<tr>
				<td>Name: </td>
				<td><input type="text" name="name" value="${ user.name }" /></td>
			</tr>
			<tr>
				<td>Email: </td>
				<td><input type="text" name="email" value="${ user.email }" /></td>
			</tr>
			<tr>
				<td>Password: </td>
				<td><input type="password" name="password" value="${ user.password }" /></td>
			</tr>
			<tr>
				<td colspan="2"><input type="submit" name="Submit"></td>
			</tr>
		</table>
	</form>
	<c:if test="${not empty userList}">
		<table>
			<thead>
				<tr>
					<th>Id</th>
					<th>Name</th>
					<th>Email</th>
					<th>Password</th>
					<th>Actions</th>
				</tr>
			</thead>
			<tbody>
				<c:choose>
					<c:when test="${not empty userList}">
						<c:forEach var="user" items="${userList}">
							<tr>
								<td>${user.id}</td>
								<td>${user.name}</td>
								<td>${user.email}</td>
								<td>${user.password}</td>
								<td><a href="edit/${user.id}">Edit</a>/<a href="delete/${user.id}">Delete</a></td>
							</tr>
						</c:forEach>
					</c:when>
					<c:otherwise>
						<tr>
							<td colspan="4">No Record Found</td>
						</tr>
					</c:otherwise>
				</c:choose>
			</tbody>
		</table>
	</c:if>
</body>
</html>