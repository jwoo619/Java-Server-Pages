/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/7.0.82
 * Generated at: 2018-01-16 17:28:25 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.sql.DriverManager;
import java.sql.ResultSet;
import com.mysql.jdbc.Statement;
import com.mysql.jdbc.Connection;

public final class modify_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {


    Connection connection;
    Statement statement;
    ResultSet resultSet;
    
    String name , id , pw , phone1 , phone2 , phone3 , gender;
  
  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  private volatile javax.el.ExpressionFactory _el_expressionfactory;
  private volatile org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public javax.el.ExpressionFactory _jsp_getExpressionFactory() {
    if (_el_expressionfactory == null) {
      synchronized (this) {
        if (_el_expressionfactory == null) {
          _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
        }
      }
    }
    return _el_expressionfactory;
  }

  public org.apache.tomcat.InstanceManager _jsp_getInstanceManager() {
    if (_jsp_instancemanager == null) {
      synchronized (this) {
        if (_jsp_instancemanager == null) {
          _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
        }
      }
    }
    return _jsp_instancemanager;
  }

  public void _jspInit() {
  }

  public void _jspDestroy() {
  }

  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
        throws java.io.IOException, javax.servlet.ServletException {

    final javax.servlet.jsp.PageContext pageContext;
    javax.servlet.http.HttpSession session = null;
    final javax.servlet.ServletContext application;
    final javax.servlet.ServletConfig config;
    javax.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    javax.servlet.jsp.JspWriter _jspx_out = null;
    javax.servlet.jsp.PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html; charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\" \"http://www.w3.org/TR/html4/loose.dtd\">\n");
      out.write("<html>\n");
      out.write("<head>\n");
      out.write("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("<title>Insert title here</title>\n");
      out.write("</head>\n");
      out.write("<body>\n");
      out.write("  ");
      out.write("\n");
      out.write("  \n");
      out.write("  ");

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
  
      out.write("\n");
      out.write("  \n");
      out.write("  <form action=\"modifyOK\" method=\"post\">\n");
      out.write("      이름 : <input type=\"text\" name=\"name\" size=\"10\" value=");
      out.print( name );
      out.write("><br>\n");
      out.write("\t  아이디 : ");
      out.print( id );
      out.write("<br>\n");
      out.write("\t  비밀번호 : <input type=\"password\" name=\"pw\" size=\"10\"><br>\n");
      out.write("\t  전화번호 : <select name=\"phone1\">\n");
      out.write("\t  <option value=\"010\" >010</option>\n");
      out.write("\t  <option value=\"020\" >020</option>\n");
      out.write("\t  <option value=\"030\" >030</option>\n");
      out.write("\t  <option value=\"040\" >040</option>\n");
      out.write("\t  <option value=\"050\" >050</option>\n");
      out.write("\t  </select>\n");
      out.write("\t  -<input type=\"text\" name=\"phone2\" size=\"5\" value=");
      out.print( phone2 );
      out.write("> -<input type=\"text\" name=\"phone3\" size=\"5\" value=");
      out.print( phone3 );
      out.write("><br>\n");
      out.write("\t  ");

	    if(gender.equals("man")){
	  
      out.write("\n");
      out.write("\t  \n");
      out.write("\t  성별 : <input type=\"radio\" name=\"gender\" value=\"man\" checked=\"checked\">남 &nbsp;\n");
      out.write("\t        <input type=\"radio\" name=\"gender\" value=\"woman\">여<br>\n");
      out.write("\t  ");

	    } 
	    else{
	  
      out.write("\n");
      out.write("\t  성별 : <input type=\"radio\" name=\"gender\" value=\"man\" >남 &nbsp;\n");
      out.write("\t        <input type=\"radio\" name=\"gender\" value=\"woman\" checked=\"checked\">여<br>\n");
      out.write("\t  ");

	    }
	   
      out.write("\n");
      out.write("\t    <input type=\"submit\" value=\"정보수정\"><input type=\"reset\" value=\"취소\">\n");
      out.write("\n");
      out.write("  \n");
      out.write("  </form>\n");
      out.write("</body>\n");
      out.write("</html>");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof javax.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try {
            if (response.isCommitted()) {
              out.flush();
            } else {
              out.clearBuffer();
            }
          } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
