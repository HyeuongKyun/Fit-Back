<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>영상보기</title>
<%@ include file="../common/bootstrap.jsp" %>
</head>
<body>
	<div class="container">
		<h2>영상 보기</h2>
		<hr>
		<div class="card">
			<div class="card-body">
				<h5 class="card-title">${video.title }<span class="badge text-bg-danger">${video.viedoViewCnt }</span></h5>
				<div class="d-flex justify-content-between">
					<div class="card-subtitle mb-2 text-muted">${video.part }</div>
				</div>
				<div>
					<a href="updateform?id=${video.videoID }" class="btn btn-success">수정</a>
					<a href="delete?id=${video.videoID }" class="btn btn-info">삭제</a>
					<a href="list" class="btn btn-warning">목록</a>
				</div>
			
			</div>
		</div>
	</div>
</body>
</html>