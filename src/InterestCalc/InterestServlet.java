package InterestCalc;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
@WebServlet(urlPatterns="/InterestServlet",initParams=@WebInitParam(name="rate", value="5"))


public class InterestServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public InterestServlet() {
        super();

    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		
		Float si;
		Float p=Float.parseFloat(request.getParameter("principal"));
		Float rate;
		ServletConfig s= getServletConfig();
		rate=Float.parseFloat(s.getInitParameter("rate"));
		int t= Integer.parseInt(request.getParameter("tenure"));
		si=(p*t*rate)/100;
		
	HttpSession session= request.getSession();
	
	session.setAttribute("name", request.getParameter("name"));
	session.setAttribute("email", request.getParameter("email"));
	session.setAttribute("principal", request.getParameter("principal"));
	session.setAttribute("si",si);
	session.setAttribute("tenure", request.getParameter("tenure"));
	request.setAttribute("si",si);
	RequestDispatcher rd= request.getRequestDispatcher("confirm.jsp");
		rd.forward(request, response);
		
	}


	}


