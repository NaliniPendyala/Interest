package InterestCalc;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
@WebServlet("/InsertServlet")
public class InsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public InsertServlet() {
        super();
        
        }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		try {
			
			Class.forName("org.h2.Driver");
			HttpSession ses= request.getSession();
			 Connection con= DriverManager.getConnection("jdbc:h2:tcp://localhost/~/demo","sa","sa@123");
			PreparedStatement st= con.prepareStatement("insert into loan(name,email,principal,si,tenure,status) values(?,?,?,?,?,?)");
			 
			 st.setString(1, ses.getAttribute("name").toString());
			 st.setString(2, ses.getAttribute("email").toString());
			 st.setString(3, ses.getAttribute("principal").toString());
			 st.setString(4, ses.getAttribute("si").toString());
			 st.setString(5, ses.getAttribute("tenure").toString());
			 st.setString(6, "pending");
			 
			st.executeUpdate();			
		
		
	}catch (Exception e){
		e.printStackTrace();
	}
		
	}


}
