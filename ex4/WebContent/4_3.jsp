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
    int age;
  %>
  
  <%
    age = Integer.parseInt(request.getParameter("age"));
  	
  	if(age >= 20)
  		response.sendRedirect("4_3_1.jsp?age=" + age);
  	else
  		response.sendRedirect("4_3_2.jsp?age=" + age);
  %>
</body>
</html>