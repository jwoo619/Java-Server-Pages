<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="com.mysql.jdbc.Statement"%>
<%@page import="com.mysql.jdbc.Connection"%>
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
    Connection connection;
    Statement statement;
    ResultSet resultSet;
    
    String name , id , pw , phone1 , phone2 , phone3 , gender;
  %>
  
  <%
      id = (String)session.getAttribute("id");
      
      String query = "select * from member where id = '"+id+"';";
      
      Class.forName("com.mysql.jdbc.Driver");
	  connection = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/member", "root", "1234");
	  statement = (Statement) connection.createStatement();
	  resultSet = statement.executeQuery(query);
		
		while(resultSet.next()){
			name = resultSet.getString("name");
			id = resultSet.getString("id");
			pw = resultSet.getString("pw");
			phone1 = resultSet.getString("phone1");
			phone2 = resultSet.getString("phone2");
			phone3 = resultSet.getString("phone3");
			gender = resultSet.getString("gender");
		}
  %>
  
  <form action="modifyOK" method="post">
      이름 : <input type="text" name="name" size="10" value=<%= name %>><br>
	  아이디 : <%= id %><br>
	  비밀번호 : <input type="password" name="pw" size="10"><br>
	  전화번호 : <select name="phone1">
	  <option value="010" >010</option>
	  <option value="020" >020</option>
	  <option value="030" >030</option>
	  <option value="040" >040</option>
	  <option value="050" >050</option>
	  </select>
	  -<input type="text" name="phone2" size="5" value=<%= phone2 %>> -<input type="text" name="phone3" size="5" value=<%= phone3 %>><br>
	  <%
	    if(gender.equals("man")){
	  %>
	  
	  성별 : <input type="radio" name="gender" value="man" checked="checked">남 &nbsp;
	        <input type="radio" name="gender" value="woman">여<br>
	  <%
	    } 
	    else{
	  %>
	  성별 : <input type="radio" name="gender" value="man" >남 &nbsp;
	        <input type="radio" name="gender" value="woman" checked="checked">여<br>
	  <%
	    }
	   %>
	    <input type="submit" value="정보수정"><input type="reset" value="취소">

  
  </form>
</body>
</html>