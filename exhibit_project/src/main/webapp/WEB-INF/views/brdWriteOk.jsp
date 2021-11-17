<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.pjt.ex22.member.*" %>
<%@ page import="com.pjt.ex22.board.*" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<link href="${cp}/resources/stylesheet.css" rel="stylesheet">
<%@include file="header.jsp"%>
<title>게시글 확인</title>
</head>
 	<c:if test="${member == null}">
		<script>
			alert("로그인이 필요한 서비스입니다.")
			location.href = '/ex22/member/memLoginForm';
		</script>
	</c:if>
<body>
<nav>
	<h1> BOARD </h1>
</nav>
<form enctype="multipart/form-data">
	<table class="written_table">
		<colsgroup>
			<col width="10%" />
            <col width="20%" />
            <col width="10%" />
            <col width="20%" />
		</colsgroup>
			<tr colspan=2>
				<th style="text-align: left;">글번호</th>
				<td>${board.bno}</td>
				<th style="text-align: center;">작성자</th>
				<td>${board.bid}</td>
			</tr>
			<tr>
				<th>제목</th>
				<td colspan=3>${board.btitle}</td>
			</tr>
			<tr>
				<th>내용</th>
				<td colspan=3 height=450px; style="text-align: left !important">
					<c:if test= "${board.bfile ne null}">
					<img src="${cp}/resources/temp/${board.bfile}"/><br/>
					</c:if>
					${board.btext}
				</td>
			</tr>
				<c:if test="${board.bfile ne null}">
				<tr>
					<th>파일명</th>
					<td colspan=3><a href="${cp}/resources/temp/${board.bfile}">${board.bfile}</a></td>
				</tr>
				</c:if>
			<tr>
				<th colspan=4 style="text-align: center;">
				<br/>
					<c:if test="${board.bid eq member.memId}">
						<input type="hidden" name="bno" value="${board.bno}">
					    <a href="/ex22/board/brdModifyForm?bno=${board.bno}" class="written_form_button">수정</a>
				     	<a href="/ex22/board/brdDelete?bno=${board.bno}" class="written_form_button" 
				     		onclick="if(!confirm('삭제하시겠습니까?')){return false;}">삭제</a> 
				        <a href="/ex22/board/brdList" class="written_form_button">LIST</a>
					</c:if>
					<c:if test="${board.bid ne member.memId}">
						<a href="/ex22/board/brdList" class="written_form_button">LIST</a>
					</c:if>
				</th>
			</tr>
		</table>
</form>
<wrap><%@include file="footer.html"%></wrap> 
</body>
</html>