<%@page import="java.util.Enumeration"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
  
  <%
    Enumeration enumertaion = session.getAttributeNames();
    while(enumertaion.hasMoreElements()){
    	String sname = enumertaion.nextElement().toString();
    	String svalue = session.getAttribute(sname).toString();
    	
    	if(svalue.equals("tello"))
    		session.removeAttribute(sname);
    }
  %>
  
  <a href="check.jsp">session check</a>
</body>
</html>