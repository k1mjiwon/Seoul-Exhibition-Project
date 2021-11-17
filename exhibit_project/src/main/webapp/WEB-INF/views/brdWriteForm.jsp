<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시글 작성</title>
<link href="${cp}/resources/stylesheet.css" rel="stylesheet">
<%@include file="header.jsp"%>
 	<c:if test="${member == null}">
		<script>
			alert("로그인이 필요한 서비스입니다.")
			location.href = '/ex22/member/memLoginForm';
		</script>
	</c:if>
<!--
<script>
function boardCheck(){
	var btitle = document.brdField[0].btitle.value;
	var btext = document.brdField[0].btext.value;
}
</script>
-->
</head>
<body>
<nav>
	<h1> BOARD </h1>
</nav>
	<form name="brdField" action="/ex22/board/brdWrite" method="post" enctype="multipart/form-data">
		<table class="write_table">
			<tr>
				<th>제목</th>
				<td><input name="btitle" type="text" style="width:100%" placeholder="제목을 입력하세요"></td>
			</tr>
			<tr>
				<th>내용</th>
				<td><textarea name="btext" rows="30" cols="30" style="width:100%" placeholder="내용을 입력하세요"></textarea></td>
			</tr>
			<tr>
				<th>파일</th>
				<td><input type="file" name="bfile" /></td>
			</tr>
			<tr>
				<td colspan=2 align=center>
					<input type="hidden" name=bid value="${member.memId}">
					<input type="button" value="취소" onclick='location.href="brdList"'>
					<input type="submit" value="확인">
				</td>
			</tr>
		</table>
	</form>
<wrap><%@include file="footer.html"%></wrap> 	
</body>
</html>