<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:useBean id="student" class="ex9.Student" scope="page"></jsp:useBean>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

  <jsp:setProperty name="student" property="name" value="tello"/>
  <jsp:setProperty name="student" property="age" value="18"/>
  <jsp:setProperty name="student" property="grade" value="3"/>
  <jsp:setProperty name="student" property="num" value="20"/>

  이름 : <jsp:getProperty property="name" name="student"/> <br>
  나이 : <jsp:getProperty property="age" name="student"/> <br>
  학년 : <jsp:getProperty property="grade" name="student"/> <br>
  번호 : <jsp:getProperty property="num" name="student"/> <br>

</body>
</html>