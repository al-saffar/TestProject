package servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import mapper.SQLmapper;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username = request.getParameter("username");
		String pass = request.getParameter("password");
		
		HttpSession session = request.getSession();
		
		if(username.length() < 1 || pass.length() < 1)
		{
			response.sendRedirect("index.jsp?success=false&err=login-length");
		}
		else
		{
			int id = -1;
			id = SQLmapper.loginAndGetID(username, pass);
			
			if(id < 0)
			{
				response.sendRedirect("index.jsp?success=false&err=login-user");
			}
			else
			{
				session.setAttribute("userid", id);
				session.setAttribute("username", SQLmapper.getUsername(id));
				response.sendRedirect("profile.jsp");
			}
		}
	}

}
