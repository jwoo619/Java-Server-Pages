
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import=" java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <%!
      Connection connection;
      PreparedStatement preparedStatement;
      ResultSet resultSet;
      
      String driver = "com.mysql.jdbc.Driver";
      String url = "jdbc:mysql://localhost:3306/test";
      String uid = "root";
      String upw = "1234";
    %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

  <%
    try{
    	
    	Class.forName(driver);
    	connection = DriverManager.getConnection(url, uid, upw);
    	int n;
    	String query = "insert into test (id,pw,name,phone) values (?,?,?,?);";
    	preparedStatement = connection.prepareStatement(query);
    	
    	preparedStatement.setString(1, "aaa");
    	preparedStatement.setString(2, "1111");
    	preparedStatement.setString(3, "가");
    	preparedStatement.setString(4, "010-1111-1111");
    	n = preparedStatement.executeUpdate();
    	
    	preparedStatement.setString(1, "bbb");
    	preparedStatement.setString(2, "2222");
    	preparedStatement.setString(3, "나");
    	preparedStatement.setString(4, "010-2222-2222");
    	n = preparedStatement.executeUpdate();
    	
    	preparedStatement.setString(1, "ccc");
    	preparedStatement.setString(2, "3333");
    	preparedStatement.setString(3, "다");
    	preparedStatement.setString(4, "010-3333-3333");
    	n = preparedStatement.executeUpdate();
    	
    	preparedStatement.setString(1, "ddd");
    	preparedStatement.setString(2, "4444");
    	preparedStatement.setString(3, "마");
    	preparedStatement.setString(4, "010-4444-4444");
    	n = preparedStatement.executeUpdate();
    	
        if(n == 1)
        	out.println("success");
        else
        	out.println("fail");
        
    }catch(Exception e){
    	
    	}finally{
    		try{
    			if(resultSet != null) resultSet.close();
    			if(connection != null) connection.close();
    			if(preparedStatement != null) preparedStatement.close();

    		}catch(Exception e){}
    	}
   
  %>


</body>
</html>