<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시판</title>
<link href="${cp}/resources/stylesheet.css" rel="stylesheet">
<%@include file="header.jsp"%>
</head>
<body>
<!-- 
	<c:if test="${member == null}">
		<script>
			alert("로그인이 필요한 서비스입니다.")
			location.href = '/ex22/member/memLoginForm';
		</script>
	</c:if>
 -->
<nav>
	<h1> BOARD </h1>
</nav>
<form id="brdList" name="brdList">
	<table class="list">
    	<colgroup>
			<col width="10%" />
            <col width="25%" />
            <col width="10%" />
            <col width="10%" />
            <col width="10%" />
        </colgroup>
        <thead>
        	<tr>
        		<td><a href="/ex22" style="text-align: left;"> ◀ Go to Main </a>
        		<td></td>
        		<td></td>
        		<td></td>
        		<td><a href="/ex22/board/brdWriteForm" style="text-align: right;"> Write ▶ </a></td>
        	</tr>        
        	<tr>
            	<th>NUM</th>
                <th>TITLE</th>
                <th>HIT</th>
                <th>ID</th>
                <th>DATE</th>
            </tr>
	            <c:forEach var="brd" items="${list}">
		            <tr>
		            	<td>${brd.bno}</td>
		            	<td><a href="/ex22/board/brdRead?bno=${brd.bno}">${brd.btitle}</a></td>
		            	<td>${brd.bcnt}
		            	<td>${brd.bid}
		            	<td>${brd.bdate}
		            </tr>
            	</c:forEach>
        </thead>  
	</table>
</form>
<wrap><%@include file="footer.html"%></wrap>       
</body>
</html>