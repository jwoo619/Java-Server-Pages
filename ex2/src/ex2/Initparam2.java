package ex2;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Initparam2
 */
//@WebServlet("/init")
@WebServlet(urlPatterns={"/init2"},initParams={@WebInitParam(name="id",value="jwoo619"),@WebInitParam(name="pw",value="1234")})
public class Initparam2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Initparam2() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		response.setContentType("text/html; charset=EUC-KR");
		PrintWriter writer = response.getWriter();
		
		String id = getInitParameter("id");
		String pw = getInitParameter("pw");
		
		String rid = getServletContext().getInitParameter("id");
		String rpw = getServletContext().getInitParameter("pw");
		
		writer.println("<html><head></head><body>");
		writer.println("ID : " + id + "<br>");
		writer.println("PW : " + pw + "<br>");
		writer.println("admin ID : " + rid + "<br>");
		writer.println("admin PW : " + rpw + "<br>");
		writer.println("</body></html>");
		
		writer.close();
		System.out.println(id + pw);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
