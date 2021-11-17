<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원정보 수정</title>
<link href="${cp}/resources/stylesheet.css" rel="stylesheet">
<%@include file="header.jsp"%>
</head>
<body>
	<c:if test="${res == 'fail'}">
		<script>
			alert("수정하실 정보를 확인하신 후 다시 시도해주세요.")
		</script>
	</c:if>
	<c:if test="${res == 'success'}">
		<script>
			alert("수정이 완료되었습니다. 메인 화면으로 돌아갑니다.")
			location.href="${cp}";
		</script>
	</c:if>	
	<nav>
		<h1> 회원정보 수정 <h1>
	</nav>
	<form action="/ex22/member/memModify" method="post">
		<table>
            <tr>
               <td align="center"><input name="memId" value="${member.memId}" readonly class="LogJoinTable"/></td>
            </tr>
            <tr>
               <td align="center"><input type="password" name="memPw" placeholder="변경 전 암호" class="LogJoinTable"></td>
            </tr>            
            <tr>
               <td align="center"><input type="password" name="memPw_aft" placeholder="변경 후 암호" class="LogJoinTable"></td>
            </tr>
            <tr>
               <td align="center"><input type="text" name="memMail" value="${member.memMail}" class="LogJoinTable"></td>
            </tr>
            <tr>
               <td align="center"><input type="text" name="memPhone1" value="${member.memPhone1}" maxlength="3" size="6" class="LogJoinTable_phone"> - 
               <input type="text" name="memPhone2" value="${member.memPhone1}" maxlength="4" size="11" class="LogJoinTable_phone"> -
               <input type="text" name="memPhone3" value="${member.memPhone1}" maxlength="4" size="11" class="LogJoinTable_phone"></td>
            </tr>
            <tr>
               <td align="center"><input type="submit" value="변경" class="LogJoinTable"></td>
            </tr>
          	<tr>
         		<td align="center"><input type="button" value="취소" onClick="location.href='/ex22'" class="LogJoinTable"></td>
          	</tr>
          	<tr>
         		<td align="center"><input type="button" value="회원 탈퇴" onClick="location.href='/ex22/member/memDeleteForm'" class="LogJoinTable" style="background-color: darkgrey;"></td>
          	</tr>
         </table>
	</form>
<wrap><%@include file="footer.html"%></wrap> 
</body>
</html>