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
    Enumeration enumeration = session.getAttributeNames();
    int i = 0;
    while(enumeration.hasMoreElements()){
    	String sname = enumeration.nextElement().toString();
    	String svalue = session.getAttribute(sname).toString();
    	
    	out.println("name : "+sname+"<br>");
    	out.println("value : "+svalue+"<br>");
    	
    	if(svalue.equals("tello"))
    		i++;
    }
    
    if(i == 0)
    	out.println("해당 세션 삭제완료");
  %>
</body>
</html>