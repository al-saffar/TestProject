package servlets;

import java.io.IOException;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class StartGameServlet
 */
@WebServlet("/StartGameServlet")
public class StartGameServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public StartGameServlet() {

		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		HttpSession session = request.getSession();
		
		String level = request.getParameter("level");
		Random rand = new Random();
		int ranNum = rand.nextInt((Integer.parseInt(level) - 1) + 1) + 1;
		
		System.out.println("level: " + level);
		System.out.println("randomNumber: " + ranNum);

		session.setAttribute("randomNumb", ranNum);
		session.setAttribute("selLevel", level);
		System.out.println("TEST!!! "+session.getAttribute("randomNumb"));
		
		
		response.sendRedirect("play.jsp");

	}

}
