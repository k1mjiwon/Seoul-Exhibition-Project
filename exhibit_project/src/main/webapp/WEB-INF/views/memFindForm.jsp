<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>암호를 잊으셨나요?</title>
<link href="${cp}/resources/stylesheet.css" rel="stylesheet">
<%@include file="header.jsp"%>
</head>
<body>
	<c:if test="${res == 'fail'}">
		<script>
			alert("입력하신 정보가 맞지 않습니다.")
		</script>
	</c:if>
	<c:if test="${res == 'no'}">
		<script>
			alert("입력하신 아이디는 존재하지 않습니다.")
		</script>
	</c:if>
	<nav>
		<h1> 비밀번호 찾기 </h1>
	</nav>
		<h3 style="text-align: center";>가입하신 아이디와 이메일을 입력해주세요.</h3>
	<form action="/ex22/member/memFind" method="post">
         <table>
            <tr>
               <td align="center"><input id="memId" name="memId" placeholder="아이디" class="LogJoinTable"></td>
            </tr>
            <tr>
               <td align="center"><input id="memMail" type="text" name="memMail" placeholder="이메일" class="LogJoinTable"></td>
            </tr>
            <tr>
               <td align="center"><input type="submit" value="확인" class="LogJoinTable"></td>
            </tr>  
          	<tr>
         		<td align="center"><input type="button" value="취소" onClick="location.href='/ex22/member/memLoginForm'" class="LogJoinTable"></td>
          	</tr>
         </table>
	</form>
<wrap><%@include file="footer.html"%></wrap> 
</body>
</html>