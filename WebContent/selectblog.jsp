<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Insert title here</title>
</head>
<body>
<table>
	<tr>
		<th width="100px">id</th>
		<th width="100px">车次号</th>
		<th width="100px">用户名</th>
		<th width="100px">内容</th>
	</tr>
	<c:forEach items="${blogs}" var="blog">
		<blog>
		<tr align="center">
			<td><id>${blog.id}</id></td>
			<td><car_id>${blog.car_id}</car_id></td>
			<td><username>${blog.username}</username></td>
			<td><mysign>${blog.mysign }</mysign></td>
		</tr>
		</blog>
	</c:forEach>
</table>
</body>
</html>