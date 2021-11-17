<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.pjt.ex22.board.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시글 수정</title>
<link href="${cp}/resources/stylesheet.css" rel="stylesheet">
<%@include file="header.jsp"%>
</head>
<body>
<nav>
	<h1> BOARD </h1>
</nav>
<form action="/ex22/board/brdModify" method="post" enctype=enctype="multipart/form-data">
		<table class="write_table">
			<tr>
				<td>제목</td>
				<td><input name="btitle" type="text" style="width:100%;" value="${board.btitle}"/></td>
			</tr>
			<tr>
				<td>내용</td>
				<td><textarea name="btext" rows="30" cols="30" style="width:100%">${board.btext}</textarea></td>
			</tr>
			<tr>
				<td>파일 추가</td>
				<td><input type="file" name="bfile" value="${board.bfile}"/></td>
			</tr>
			<tr>
				<td colspan=2 align=center>
					<input type="hidden" name=bno value="${board.bno}">
					<input type="button" value="취소" onclick='location.href="brdList"'>
					<input type="submit" value="확인">
				</td>
			</tr>
		</table>
	</form>
<wrap><%@include file="footer.html"%></wrap> 
</body>
</html>