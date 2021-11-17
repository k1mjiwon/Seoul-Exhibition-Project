<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="${cp}/resources/stylesheet.css" rel="stylesheet">
<%@include file="header.jsp"%>
</head>
<body>
	<c:if test="${res == 'fail'}">
		<script>
			alert("입력하신 정보를 확인하신 후 다시 시도해주세요.")
		</script>
	</c:if>
	
	<c:if test="${res == 'success'}">
		<script>
			alert("회원 삭제가 완료되었습니다. 이용해주셔서 감사합니다.")
			location.href="${cp}";
		</script>
	</c:if>
		
	<nav>
		<h1> 회원 탈퇴 </h1>
	</nav>
		<h3 style="text-align: center";>아이디와 비밀번호를 입력해주세요.</h3>
	<form action="/ex22/member/memDelete" method="post">
         <table>
            <tr>
               <td align="center"><input id="memId" name="memId" placeholder="아이디" class="LogJoinTable"></td>
            </tr>
            <tr>
               <td align="center"><input id="memPw" type="password" name="memPw" placeholder="암호" class="LogJoinTable"></td>
            </tr>
            <tr>
               <td align="center"><input type="submit" value="확인" class="LogJoinTable"></td>
            </tr>  
          	<tr>
         		<td align="center"><input type="button" value="취소" onClick="location.href='/ex22/member/memModifyForm'" class="LogJoinTable"></td>
          	</tr>
         </table>
	</form>
<wrap><%@include file="footer.html"%></wrap> 
</body>
</html>