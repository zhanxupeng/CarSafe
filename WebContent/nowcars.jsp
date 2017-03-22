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
		<th width="100px">车次号</th>
		<th width="100px">x坐标</th>
		<th width="100px">y坐标</th>
		<th width="100px">速度</th>
		<th width="100px">路线</th>
		<th width="100px">方向</th>
	</tr>
	<c:forEach items="${nowcars}" var="car">
		<orderss>
		<tr align="center">
			<td><car_id>${car.car_id}</car_id></td>
			<td><xx>${car.xx}</xx></td>
			<td><yy>${car.yy}</yy></td>
			<td><speed>${car.speed}</speed></td>
			<td><flag>${car.flag}</flag></td>
			<td><direction>${car.direction}</direction></td>
		</tr>
		</orderss>
	</c:forEach>
</table>
</body>
</html>