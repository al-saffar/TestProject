package servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import mapper.SQLmapper;
import classes.User;

/**
 * Servlet implementation class EditUserServlet
 */
@WebServlet("/EditUserServlet")
public class EditUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditUserServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		
		String firstname = ""; firstname = request.getParameter("firstname");
		String lastname = ""; lastname = request.getParameter("lastname");
		String username = ""; username = (String)session.getAttribute("username");
		String password = ""; password = request.getParameter("pw");
		
		if(firstname.isEmpty() || lastname.isEmpty())
		{
			response.sendRedirect("profile.jsp?update_success=false");
		}
		else
		{
			User user = new User(firstname, lastname,username, password);
			
			boolean success = false;
			int id = (int) session.getAttribute("userid");
			success = SQLmapper.updateUser(id, user);
			
			if(success)
			{
				response.sendRedirect("profile.jsp?update_success=true");
			}
			else
			{
				response.sendRedirect("profile.jsp?update_success=false");
			}
		}	
	}
}
