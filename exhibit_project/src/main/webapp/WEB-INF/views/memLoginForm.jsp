<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>LOGIN</title>
<link href="${cp}/resources/stylesheet.css" rel="stylesheet">
<%@include file="header.jsp"%>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
</head>
<body>
<script>
$(function(){
	var idCk = RegExp(/^[a-z0-9]{4,12}$/) // a~z, 0~9로 시작하는 4~12자리 아이디
	var pwCk = RegExp(/^[A-Za-z0-9]{4,12}$/) // A~Z, a~z, 0~9로 시작하는 4~12자리 비번

	// 아이디 유효성 검사
	$('#memId').blur(function(){		
		if($('#memId').val() == ""){
			$('#id_check').text('아이디를 입력해주세요.');
			$('#id_check').css('color', 'red');
		} else if(idCk.test($('#memId').val())){
			$('#id_check').text('');
		} else {
			$('#id_check').text('입력하신 아이디의 형식을 확인해주세요.');
			$('#id_check').css('color', 'red');
		}
	});

	// 패스워드 유효성 검사
	$('#memPw').blur(function(){
		if($('#memPw').val() == ""){
			$('#pw_check').text('비밀번호를 입력해주세요.');
			$('#pw_check').css('color', 'red');
		} else if(pwCk.test($('#memPw').val())){
			$('#pw_check').text('');
		} else {
			$('#pw_check').text('입력하신 비밀번호의 형식을 확인해주세요.');
			$('#pw_check').css('color', 'red');
		}
	});
});
</script>

	<c:if test="${res == 'fail'}">
		<script>
			alert("아이디와 비밀번호를 확인하신 후 다시 시도해주세요.")
		</script>
	</c:if>
		<c:if test="${res == 'success'}">
		<script>
			location.href="${cp}";
		</script>
	</c:if>
	<c:if test="${boardmem == 'null'}">
		<script>
			alert("로그인 후 이용해주세요.")
		</script>
	</c:if>
	
	<nav>
		<h1> LOGIN </h1>
	</nav>	
	<form action="/ex22/member/memLogin" method="post">
         <table>
            <tr>
               <td align="center"><input id="memId" name="memId" placeholder="아이디" class="LogJoinTable"></td>
            </tr>
            <tr><td align="center" id="id_check"></td></tr>
            <tr>
               <td align="center"><input id="memPw" type="password" name="memPw" placeholder="암호" class="LogJoinTable"></td>
            </tr>
            <tr><td align="center" id="pw_check"></td></tr>
            <tr>
               <td align="center"><a href="/ex22/member/memFindForm" style="color: grey; font-size: 12px; text-decoration: underline;">
               암호를 잊으셨나요?</a></td>
            </tr>
            <tr>
               <td align="center"><input type="submit" value="로그인" class="LogJoinTable"></td>
            </tr>  
            <tr>
               <td align="center"><input type="button" value="회원가입" onClick="location.href='/ex22/member/memJoinForm'" class="LogJoinTable"></td>
            </tr>
          	<tr>
         		<td align="center"><input type="button" value="취소" onClick="location.href='/ex22'" class="LogJoinTable"></td>
          	</tr>
          	<tr>
               <td align="center"><a href="https://kauth.kakao.com/oauth/authorize?client_id=815adfa14049e217f54d21e1ddc7046b&redirect_uri=http://localhost:8000/auth/kakao/callback&response_type=code">
 			   <img src="${cp}/resources/image/kakao_login_large_wide.png" width="400" height="50"></td>
 			   <!-- 서울 전시 공유 사이트 REST API키:950524ac57e03a9b6c41fa13b30aab37 -->
            </tr>
         </table>
	</form>
<wrap><%@include file="footer.html"%></wrap> 
</body>
</html>