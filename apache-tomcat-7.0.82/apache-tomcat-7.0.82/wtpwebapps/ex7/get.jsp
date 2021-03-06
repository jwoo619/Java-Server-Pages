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
    Object obj1 = session.getAttribute("s_name");
    String s_name = (String)obj1;
    out.println(s_name + "<br>");
    
    Object obj2 = session.getAttribute("mynum");
    Integer mynum = (Integer)obj2;
    out.println(mynum + "<br>");
    out.println("=========================<br>");
    
    String sname;
    String svalue;
    Enumeration enumeration = session.getAttributeNames();
    
    while(enumeration.hasMoreElements()){
    	sname = enumeration.nextElement().toString();
    	svalue = session.getAttribute(sname).toString();
    	out.println("sName : " + sname + "<br>");
    	out.println("sValue : " + svalue + "<br>");
    }
    out.println("=========================<br>");
    
    String sessionid = session.getId();
    out.println("Session ID : "+sessionid+"<br>");
    int time = session.getMaxInactiveInterval();
    out.println("Session Max Time : "+time+"<br>");
    out.println("=========================<br>");
    
    session.removeAttribute("s_name");
    Enumeration enumeration1 = session.getAttributeNames();
    while(enumeration1.hasMoreElements()){
    	sname = enumeration1.nextElement().toString();
    	svalue = session.getAttribute(sname).toString();
    	out.println("sName : " + sname + "<br>");
    	out.println("sValue : " + svalue + "<br>");
    }
    out.println("=========================<br>");
    
    session.invalidate();
    if(request.isRequestedSessionIdValid())
    	out.println("Valid");
    else
    	out.println("invalid");
    
  %>
</body>
</html>