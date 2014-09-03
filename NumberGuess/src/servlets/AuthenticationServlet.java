package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;

import classes.UserCheck;

/**
 * Servlet implementation class AuthenticationServlets
 */
@WebServlet("/AuthenticationServlets")
public class AuthenticationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AuthenticationServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
    public PrintWriter out;
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            response.setContentType("text/html");
            out = response.getWriter();
            
            UserCheck users = new UserCheck();
            String loginName = request.getParameter("LoginName");
            String loginPassword = request.getParameter("LoginPassword");

            //String enCryptLogin = AesEncrypter.encrypt(loginPassword);


          //  if (users.userExists(loginName, enCryptLogin)) {
                
                HttpSession session = request.getSession();
               
           
                
                session.setAttribute("loggedIn", loginName);
               
               
               
                String type = SQLMapper.getType((String) session.getAttribute("loggedIn"));
                
                session.setAttribute("type", type);
                System.out.println("LOGINNAME:" + loginName + " PASS: " + loginPassword + " TYPE: " + type);
                if ("Student".equals(type)) {
                    response.sendRedirect("mainpage.jsp");
                }
                if ("Manager".equals(type)) {
                    response.sendRedirect("adminpage.jsp");
                }
                if ("RMC".equals(type)) {
                    response.sendRedirect("rmcPage.jsp");
                }



            } else {
                response.sendRedirect("index.jsp");
            }
        } catch (Exception ex) {
            Logger.getLogger(AuthenticationServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
