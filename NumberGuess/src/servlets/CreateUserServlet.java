package servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.jasper.tagplugins.jstl.core.Out;

import mapper.SQLmapper;
import classes.User;
import database.DatabaseCon;

/**
 * Servlet implementation class CreateUserServlet
 */
@WebServlet("/CreateUserServlet")
public class CreateUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public CreateUserServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		HttpSession session = request.getSession();
		
		String firstname = request.getParameter("firstname");
		String lastname = request.getParameter("lastname");
		String username = request.getParameter("username");
		String pw = request.getParameter("pw");
		
		
		User user = new User();
		if(!SQLmapper.isThisUsernameTaken(username) && user.setFirstname(firstname) && user.setLastname(lastname) && user.setUsername(username)&&user.setPassword(pw))
		{
			user.setFirstname(firstname);
			user.setLastname(lastname);
			user.setUsername(username);
			user.setPassword(pw);
			
			System.out.println(user.getFirstname().toString());
			System.out.println(user.getLastname().toString());
			
			SQLmapper.saveUser(user);
			
			response.sendRedirect("index.jsp?success=true");
		}
		else
		{
			if(SQLmapper.isThisUsernameTaken(username))
			{
				response.sendRedirect("index.jsp?success=false&err=user&f="+firstname+"&l="+lastname+"&u="+username+"");
			}
			else
			{
				response.sendRedirect("index.jsp?success=false&err=length&f="+firstname+"&l="+lastname+"&u="+username+"");
			}
		}
	}

}
