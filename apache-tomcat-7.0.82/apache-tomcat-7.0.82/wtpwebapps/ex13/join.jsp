<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script language="JavaScript" src="members.js"></script>
</head>
<body>
  <form action="joinok.jsp" method="post" name="reg_frm">
    아이디 : <input type="text" size="20" name="id"> <br>
    비밀번호 : <input type="password" size="20" name="pw"> <br>
    비밀번호 확인 : <input type="password" size="20" name="pw_check"> <br>
    이름 : <input type="text" size="20" name="name"> <br>
    메일 : <input type="text" size="20" name="mail"> <br>
    주소 : <input type="text" size="50" name="address"> <br>
    <input type="button" value="회원가입" onclick="infoConfirm();">&nbsp;&nbsp;<input type="reset" value="취소" onclick="javascript:window.location='login.jsp'">
  </form>
</body>
</html>