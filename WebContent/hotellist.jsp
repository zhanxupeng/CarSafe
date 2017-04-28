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
		<th width="100px">详情</th>
		<th width="100px">位置</th>
		<th width="100px">房型</th>
		<th width="100px">价格</th>
		<th width="100px">说明</th>
		<th width="100px">外观</th>
		<th width="100px">细节照片</th>
	</tr>
	<c:forEach items="${list}" var="hotel">
		<hotel>
		<tr align="center">
			<td><id>${hotel.id }</id></td>
			<td><name>${hotel.name }</name></td>
			<td><detail>${hotel.detail }</detail></td>
			<td><local>${hotel.local }</local></td>
			<td><types>${hotel.types }</types></td>
			<td><price>${hotel.price }</price></td>
			<td><pricedetail>${hotel.pricedetail }</pricedetail></td>
			<td><picture>${hotel.picture }</picture></td>
			<td><picturexi>${hotel.picturexi }</picturexi></td>
		</tr>
		</hotel>
	</c:forEach>
</table>
</body>
</html>