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
		<th width="400px">封面</th>
		<th width="400px">路线</th>
		<th width="200px">路线id标识</th>
		<th width="100px">指数</th>
		<th width="100px">花费时间</th>
		<th width="100px">价格</th>
	</tr>
	<c:forEach items="${list}" var="myroute">
		<orderss>
		<tr align="center">
			<td><mypicture>${myroute.mypicture }</mypicture></td>
			<td><route>${myroute.route}</route></td>
			<td><routeid>${myroute.routeid}</routeid></td>
			<td><zhishu>${myroute.zhishu}</zhishu></td>
			<td><time>${myroute.time}</time></td>
			<td><price>${myroute.price}</price></td>
		</tr>
		</orderss>
	</c:forEach>
</table>
</body>
</html>