<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="com.pjt.ex22.member.*" %>
<%
      Member sess = (Member)session.getAttribute("member");    
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="${cp}/resources/stylesheet.css" rel="stylesheet">
</head>
<body>
	<c:if test="${log == 'out'}">
		<script>
			location.href="${cp}";
		</script>
	</c:if>
<header class="menu">

    <% if (sess == null) { %> 
    	<a href="/ex22">MAIN</a>
    	<a href="/ex22/member/memJoinForm">JOIN</a>
        <a href="/ex22/member/memLoginForm">LOGIN</a>
        <a href="/ex22/board/brdList">BOARD</a>
    <% } 
    else { %>
    	<!-- <a id="user_welcome"><strong>${member.memId}</strong>님, 반갑습니다!</a> -->
		<a href="/ex22">MAIN</a>
		<a href="/ex22/member/memLogout">LOGOUT</a>
		<a href="/ex22/member/memModifyForm">MODIFY</a>
		<a href="/ex22/board/brdList">BOARD</a>
   <% } %>
</header>
</body>
</html>
