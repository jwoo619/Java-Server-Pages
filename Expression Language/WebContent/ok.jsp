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
    String id = request.getParameter("id");
    String pw = request.getParameter("pw");
  %>
  
  아이디 : <%= id %><br>
  패스워드 : <%= pw %><br>
  <hr>
  
  아이디 : ${param.id}<br>
  패스워드 : ${param.pw}<br>
  아이디 : ${param["id"]}<br>
  패스워드 : ${param["pw"]}<br>
  
  <hr>
  
  applicationScope : ${applicationScope.a_name}<br>
  sessionScope : ${sessionScope.s_name}<br>
  pageScope : ${pageScope.p_name}<br>
  requestScope : ${requestScope.r_name}<br>
  
  <hr>
  
  context초기화 파라미더 <br>
  ${initParam.con_name}<br>
  ${initParam.con_id}<br>
  ${initParam.con_pw}<br>
  
</body>
</html>