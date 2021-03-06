

import java.io.IOException;
import java.sql.DriverManager;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;

/**
 * Servlet implementation class loginOK
 */
@WebServlet("/loginOK")
public class loginOK extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private Connection connection;
	private Statement statement;
	private ResultSet resultSet;
	
	private String query , id , pw , name , phone1 , phone2 , phone3 , gender; 
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public loginOK() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doget");
		actionDo(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("dopostlll");
		actionDo(request, response);
	}
	private void actionDo(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		id = request.getParameter("id");
		pw = request.getParameter("pw");

		query = "select * from member where id ='"+id+"' and pw = '"+pw+"';";
		
		try {
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
			
			if(name != null){
				HttpSession httpSession = request.getSession();
				httpSession.setAttribute("name", name);
				httpSession.setAttribute("id", id);
				httpSession.setAttribute("pw", pw);
				response.sendRedirect("loginResult.jsp");
			}
			else
				response.sendRedirect("login.html");
			
		} catch (Exception e) {
			// TODO: handle exception
		}finally {
			try {
				if(statement != null) statement.close();
				if(connection != null) connection.close();
				if(resultSet != null) resultSet.close();
			} catch (Exception e2) {
				// TODO: handle exception
			}
		}
	}

}
