<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
  <%!
    String name , id , pw;
  %>
  
  <%
    name = (String)session.getAttribute("name");
    session.setAttribute("name", name);
  %>
  
  <%= name %>님 회원정보 수정이 정상적으로 처리 되었습니다. <br>
  <a href="logout.jsp">로그아웃</a> &nbsp;&nbsp;<a href="modify.jsp">회원정보 수정</a>
</body>
</html>