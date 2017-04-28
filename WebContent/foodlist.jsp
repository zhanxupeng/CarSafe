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
		<th width="100px">id号</th>
		<th width="100px">名称</th>
		<th width="100px">等级</th>
		<th width="100px">估价</th>
		<th width="100px">类型</th>
		<th width="100px">经度</th>
		<th width="100px">纬度</th>
		<th width="100px">菜单详情</th>
		<th width="100px">照片</th>
		<th width="100px">细节照片</th>
	</tr>
	<c:forEach items="${list}" var="food">
		<food>
		<tr align="center">
			<td><id>${food.id }</id></td>
			<td><name>${food.name }</name></td>
			<td><rank>${food.rank }</rank></td>
			<td><price>${food.price }</price></td>
			<td><category>${food.category }</category></td>
			<td><longitude>${food.longitude }</longitude></td>
			<td><latitude>${food.latitude }</latitude></td>
			<td><dishes>${food.dishes }</dishes></td>
			<td><exterior>${food.exterior }</exterior></td>
			<td><detailpicture>${food.detailpicture }</detailpicture></td>
		</tr>
		</food>
	</c:forEach>
</table>
</body>
</html>