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
    Cookie cookie[] = request.getCookies();
  
    if(cookie != null){
    	for(int i = 0; i < cookie.length; i++){
    		cookie[i].setMaxAge(0);
    		response.addCookie(cookie[i]);
    	}
    }
    
    response.sendRedirect("check.jsp");
  %>
</body>
</html>