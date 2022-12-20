<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>동영상 목록</title>
<%@ include file="../common/bootstrap.jsp" %>
</head>
<body>
	<div class="container">
		<h2>동영상 목록</h2>
		<hr>
		<div>
			<table class="table text-center">
				<tr>
					<th>타이틀</th>
					<th>채널이름</th>
					<th>파트</th>
				</tr>
				<c:forEach items="${list }" var="video">
					<tr>
						<td>
							<a href="detail?id=${video.videoID }">${video.title }</a>
						</td>				
						<td>${video.name	 }</td>		
							<td>${video.part }</td>				
					</tr>
				</c:forEach>
			</table>
			

		</div>
	</div>
</body>
</html>