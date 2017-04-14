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
		<th width="100px">名称</th>
		<th width="100px">详情</th>
		<th width="100px">位置</th>
		<th width="100px">外观图</th>
		<th width="100px">路线图</th>
		<th width="100px">花费时间</th>
		<th width="100px">价格</th>
		<th width="100px">人群指数</th>
		<th width="100px">偏好指数</th>
		<th width="100px">天气指数</th>
		<th width="100px">距离</th>
	</tr>
	<c:forEach items="${list}" var="route">
		<route>
		<tr align="center">
			<td><id>${route.id}</id></td>
			<td><name>${route.name}</name></td>
			<td><detail>${route.detail}</detail></td>
			<td><local>${route.local }</local></td>
			<td><exterior>${route.exterior }</exterior></td>
			<td><routepicture>${route.routepicture }</routepicture></td>
			<td><time>${route.time }</time></td>
			<td><price>${route.price }</price></td>
			<td><forcrowds>${route.forcrowds }</forcrowds></td>
			<td><forviewpreference>${route.forviewpreference }</forviewpreference></td>
			<td><forweatherindex>${route.forweatherindex }</forweatherindex></td>
			<td><distance>${route.distance }</distance></td>
		</tr>
		</route>
	</c:forEach>
</table>
</body>
</html>