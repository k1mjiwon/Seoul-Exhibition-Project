<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>비밀번호 재설정</title>
<link href="${cp}/resources/stylesheet.css" rel="stylesheet">
<%@include file="header.jsp"%>
</head>
<body>
	<c:if test="${set == 'fail'}">
		<script>
			alert("비밀번호 재설정에 실패하였습니다.")
		</script>
	</c:if>
	<c:if test="${set == 'success'}">
		<script>
			alert("비밀번호 재설정이 완료되었습니다. 메인 화면으로 돌아갑니다.")
			location.href="${cp}";
		</script>
	</c:if>	
 
	<nav>
		<h1> 비밀번호 재설정 </h1>
	</nav>
		<h3 style="text-align: center";>변경하실 비밀번호를 입력해주세요.</h3>
	<form action="/ex22/member/memSetPass" method="post">
         <table>
            <tr>
               <td align="center"><input id="memId" name="memId" value="${member.memId}" readonly class="LogJoinTable"></td>
            </tr>
           <tr>
               <td align="center"><input type="password" name="memPw" placeholder="비밀번호" class="LogJoinTable"></td>
            </tr>
            <tr>
               <td align="center"><input type="submit" value="확인" class="LogJoinTable"></td>
            </tr>  
          	<tr>
         		<td align="center"><input type="button" value="취소" onClick="location.href='/ex22/member/memFindForm'" class="LogJoinTable"></td>
          	</tr>
         </table>
	</form>
<wrap><%@include file="footer.html"%></wrap> 
</body>
</html>