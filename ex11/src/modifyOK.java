

import java.io.IOException;
import java.sql.DriverManager;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.websocket.Session;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;
import com.sun.xml.internal.ws.api.pipe.Tube;

/**
 * Servlet implementation class modifyOK
 */
@WebServlet("/modifyOK")
public class modifyOK extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private Connection connection;
	private Statement statement;
	
	private String pw;
	
	HttpSession httpSession;
	
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public modifyOK() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doget");
		doaction(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("dopost");
		doaction(request, response);
	}
	
	private void doaction(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("EUC-KR");
		httpSession = request.getSession();
		
		String name = request.getParameter("name");
		String id =  (String)httpSession.getAttribute("id");
		pw = request.getParameter("pw");
		String phone1 = request.getParameter("phone1");
		String phone2 = request.getParameter("phone2");
		String phone3 = request.getParameter("phone3");
		String gender = request.getParameter("gender");

		if(pwconfirm()){
			String query = "update member set name = '" + name +"', phone1= '"+ phone1 +"', phone2= '"+ phone2 +"', phone3= '"+ phone3 +"', gender= '"+gender+"'"+" where id = '" + id +"';";
			
		    try {
				Class.forName("com.mysql.jdbc.Driver");
				connection = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/member", "root", "1234");
				statement = (Statement) connection.createStatement();
				int i = statement.executeUpdate(query);
				
				if (i == 1){
					httpSession.setAttribute("name", name);
					System.out.println("success");
					response.sendRedirect("modifyResult.jsp");
				}
				else{
					System.out.println("fail123");
					response.sendRedirect("modify.jsp");
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
		else{
			System.out.println("fail");
			response.sendRedirect("modify.jsp");
		}
				
				
	}

	private boolean pwconfirm() {
		
		boolean ch;
		String spw = (String)httpSession.getAttribute("pw");

		if(spw.equals(pw))
			ch = true;
		else
			ch = false;

		return ch;
	}


}
