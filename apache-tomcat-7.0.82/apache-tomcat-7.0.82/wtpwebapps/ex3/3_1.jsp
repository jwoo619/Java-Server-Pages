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
   int i = 0;
   public String func(){
	   return "This is Function";
   }
%>

<% 
   out.println(func()+"<br><br>");
 
   func();
   while(true){
	   i++;
	   out.println("2 * " + i + " = " + 2*i + "<br>");
%>
  ---------------------------<br>
<%
	   if(i == 9) break;
   }
%>
<br>
i = <%= i %> <br>
func = <%= func() %> <br>
<%@ include file="3_2.jsp" %>
<%-- 주 --%>
</body>
</html>