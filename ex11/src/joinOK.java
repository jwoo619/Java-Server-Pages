

import java.io.IOException;
import java.sql.DriverManager;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Driver;
import com.mysql.jdbc.Statement;



/**
 * Servlet implementation class joinOK
 */
@WebServlet("/joinOK")
public class joinOK extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private Connection connection;
	private Statement statement;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public joinOK() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doGet");
		actionDo(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doPost");
		actionDo(request, response);
	}
	
	private void actionDo(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("EUC-KR");
		
		String name = request.getParameter("name");
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		String phone1 = request.getParameter("phone1");
		String phone2 = request.getParameter("phone2");
		String phone3 = request.getParameter("phone3");
		String gender = request.getParameter("gender");
		
		String query = "insert into member values ('"+name+"','"+id+"','"+pw+"','"+phone1+"','"+phone2+"','"+phone3+"','"+gender+"');";
		
	    try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/member", "root", "1234");
			statement = (Statement) connection.createStatement();
			int i = statement.executeUpdate(query);
			
			if (i == 1){
				System.out.println("success");
				response.sendRedirect("joinResult.jsp");
			}
			else{
				System.out.println("fail");
				response.sendRedirect("join.html");
			}
			
		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			try{
			if(statement != null) statement.close();
			if(connection != null) connection.close();
			}catch(Exception e){}
		}		
				
				
	}

}
