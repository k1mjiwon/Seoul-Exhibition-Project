<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JOIN</title>
<link href="${cp}/resources/stylesheet.css" rel="stylesheet">
<%@include file="header.jsp"%>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
</head>
<body>
<script>	
$(function(){
	var idCk = RegExp(/^[a-z0-9]{4,12}$/) // a~z, 0~9로 시작하는 4~12자리 아이디
	var pwCk = RegExp(/^[A-Za-z0-9]{4,12}$/) // A~Z, a~z, 0~9로 시작하는 4~12자리 비번
	var mailCk = RegExp(/^[A-Za-z0-9\-\.]+\@[A-Za-z0-9\-\.]+(\.[A-Za-z0-9]{2,3}){1,2}/ig)
		// 특수문자 -, _ 가능하며 중앙에 @ 필수 그리고 . 뒤에 2~3글자 필요
	var phone1Ck = RegExp(/^01([0|1|6|7|8|9])/) // 01?(세글자)
	var phone2Ck = RegExp(/^[0-9]{3,4}/)
	var phone3Ck = RegExp(/^[0-9]{4}/)
	
	// 아이디 유효성 검사
	$('#memId').blur(function(){		
		if($('#memId').val() == ""){
			console.log('false');
			$('#id_check').text('아이디를 입력해주세요.');
			$('#id_check').css('color', 'red');
		} else if(!idCk.test($('#memId').val())){
			console.log('false');
			$('#id_check').text('아이디는 4~12자리의 문자 혹은 숫자로 입력해주세요.');
			$('#id_check').css('color', 'red');
		} else {
			console.log('true');
			$('#id_check').text('');
		}
	});

	// 패스워드 유효성 검사
	$('#memPw').blur(function(){
		if($('#memPw').val() == ""){
			console.log('false');
			$('#pw_check').text('비밀번호를 입력해주세요.');
			$('#pw_check').css('color', 'red');
		} else if(!pwCk.test($('#memPw').val())){
			console.log('false');
			$('#pw_check').text('비밀번호는 4~12자리의 문자 혹은 숫자로 입력해주세요.');
			$('#pw_check').css('color', 'red');
		} else {
			console.log('true');
			$('#pw_check').text('');
		}
	});

	// 메일 유효성 검사
	$('#memMail').blur(function(){
		if($('#memMail').val() == ""){
			console.log('false');
			$('#mail_check').text('이메일을 입력해주세요.');
			$('#mail_check').css('color', 'red');
		} else if(!mailCk.test($('#memMail').val())){
			console.log('false');
			$('#mail_check').text('이메일 형식을 확인해주세요.');
			$('#mail_check').css('color', 'red');
		} else {
			console.log('true');
			$('#mail_check').text('');
		}
	});

	// 휴대번호 유효성 검사
	$('#memPhone1').blur(function(){
		if($('#memPhone1').val() == ""){
			console.log('false');
			$('#phone_check').text('휴대폰 번호를 입력해주세요.');
			$('#phone_check').css('color', 'red');
		} else if(!phone1Ck.test($('#memPhone1').val())){
			console.log('false');
			$('#phone_check').text('휴대폰 번호를 확인해주세요.');
			$('#phone_check').css('color', 'red');
		} else {
			console.log('true');
			$('#phone_check').text('');
		}
	});
	$('#memPhone2').blur(function(){
		if($('#memPhone2').val() == ""){
			console.log('false');
			$('#phone_check').text('휴대폰 번호를 입력해주세요.');
			$('#phone_check').css('color', 'red');
		} else if(!phone2Ck.test($('#memPhone2').val())){
			console.log('false');
			$('#phone_check').text('휴대폰 번호를 확인해주세요.');
			$('#phone_check').css('color', 'red');
		} else {
			console.log('true');
			$('#phone_check').text('');
		}
	});
	$('#memPhone3').blur(function(){
		if($('#memPhone3').val() == ""){
			console.log('false');
			$('#phone_check').text('휴대폰 번호를 입력해주세요.');
			$('#phone_check').css('color', 'red');
		} else if(!phone3Ck.test($('#memPhone3').val())){
			console.log('false');
			$('#phone_check').text('휴대폰 번호를 확인해주세요.');
			$('#phone_check').css('color', 'red');
		} else {
			console.log('true');
			$('#phone_check').text('');
		}
	});
	
	// 가입 가능 여부
	function JoinCheck(){
		var idVal = $('#memId').val();
		var pwVal = $('#memPw').val();
		var mailVal = $('#memMail').val();
		var phone1Val = $('#memPhone1').val();
		var phone2Val = $('#memPhone2').val();
		var phone3Val = $('#memPhone3').val();
		
	    if(idVal == null || idVal == '' || !idCk.test(idVal)){
	        return false;
	    } else if(pwVal == null || pwVal == '' || !pwCk.test(pwVal)){
	        return false;
	    } else if(mailVal == null || mailVal == '' || !mailCk.test(mailVal)){
	        return false;
	    } else if(phone1Val == null || phone1Val == '' || !phone1Ck.test(phone1Val)){
	        return false;
	    } else if(phone2Val == null || phone2Val == '' || !phone2Ck.test(phone2Val)){
	        return false;
	    } else if(phone3Val == null || phone3Val == '' || !phone3Ck.test(phone3Val)){
	        return false;
	    }
	    return true;
	};
});


</script>

	<c:if test="${res == 'fail'}">
		<script>
			alert("입력하신 정보를 확인하신 후 다시 시도해주세요.")
		</script>
	</c:if>
	<c:if test="${res == 'duplicate'}">
		<script>
			alert("이미 존재하는 아이디입니다. 다른 아이디를 사용해주세요.")
		</script>
	</c:if>	
	<c:if test="${res == 'success'}">
		<script>
			alert("회원가입을 축하드립니다! 로그인 화면으로 이동합니다.")
			location.href="memLoginForm";
		</script>
	</c:if>

	<nav>
		<h1> JOIN US <h1>
	</nav>
	<form action="/ex22/member/memJoin" method="post" onsubmit="return JoinCheck()"> <!-- onsubmit="return check_form()" -->
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
               <td align="center"><input id="memMail" type="text" name="memMail" placeholder="이메일" class="LogJoinTable"></td>
            </tr>
            <tr><td align="center" id="mail_check"></td></tr>
            <tr>
               <td align="center"><input id= "memPhone1" type="text" name="memPhone1" placeholder="전화번호		ex)010" maxlength="3" size="17" class="LogJoinTable_phone"> - 
               <input id= "memPhone2" type="text" name="memPhone2" placeholder="0000" maxlength="4" size="6" class="LogJoinTable_phone"> -
               <input id= "memPhone3" type="text" name="memPhone3" placeholder="0000" maxlength="4" size="6" class="LogJoinTable_phone"></td>
            </tr>
            <tr><td align="center" id="phone_check"></td></tr>
            <tr>
               <td align="center"><input type="submit" value="회원가입" class="LogJoinTable"></td>
            </tr>
          	<tr>
         		<td align="center"><input type="button" value="취소" onClick="location.href='/ex22'" class="LogJoinTable"></td>
          	</tr>
         </table>
	</form>
<%@include file="footer.html"%> 
</body>
</html>