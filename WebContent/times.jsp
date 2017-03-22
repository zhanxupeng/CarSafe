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
		<th width="100px">x坐标</th>
		<th width="100px">y坐标</th>
		<th width="100px">车速</th>
		<th width="100px">时间</th>
	</tr>
	<c:forEach items="${times}" var="time">
		<orderss>
		<tr align="center">
			<td><id>${time.id}</id></td>
			<td><car_id>${time.car_id}</car_id></td>
			<td><xx>${time.xx}</xx></td>
			<td><yy>${time.yy}</yy></td>
			<td><speed>${time.speed}</speed></td>
			<td><time>${time.time}</time></td>
		</tr>
		</orderss>
	</c:forEach>
</table>
</body>
</html>