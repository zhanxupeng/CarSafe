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
		<th width="100px">我的路线</th>
		<th width="100px">去的路线</th>
		<th width="100px">合理速度</th>
	</tr>
	<c:forEach items="${crowdeds}" var="crowded">
		<crowded>
		<tr align="center">
			<td><id>${crowded.id}</id></td>
			<td><myflag>${crowded.myflag}</myflag></td>
			<td><nextflag>${crowded.nextflag}</nextflag></td>
			<td><speed>${crowded.speed}</speed></td>
		</tr>
		</crowded>
	</c:forEach>
</table>
</body>
</html>