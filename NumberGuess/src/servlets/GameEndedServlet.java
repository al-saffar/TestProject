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
 * Servlet implementation class GameEndedServlet
 */
@WebServlet("/GameEndedServlet")
public class GameEndedServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public GameEndedServlet() {
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
		String score = (request.getParameter("hiddenScore"));
		if(request.getParameter("hiddenScore").contains(".")){
			
			score = score.substring(0, score.indexOf("."));
			
		}
		int scoreAsInt = Integer.parseInt(score);
		int attemps = Integer.parseInt(request.getParameter("hiddenField"));
		System.out.println("Forsøg: " + attemps);
		
		// int randomNumb = Integer.parseInt((String)
		// session.getAttribute("randomNumb"));
		int level = Integer.parseInt((String) session.getAttribute("selLevel"));
		System.out.println("level = " + level);

		
		System.out.println("Score = " + score);
		session.setAttribute("score", score);
		session.setAttribute("randomNumb", null);
		int currentScore = scoreAsInt;
		int highScore = (Integer)session.getAttribute("totalHighscore");
		int totalHighscore = highScore += currentScore;
		SQLmapper.updateScore(totalHighscore, (String)session.getAttribute("username"));
		
		response.sendRedirect("play.jsp");

	}
}
