	

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 * Servlet implementation class Login
 */
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String uname = request.getParameter("username");
		String pass = request.getParameter("password");
		RequestDispatcher dispatcher = null;
		
		Connection conn;
        
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3307/expensemgt", "root", "");//Establishing connection
            System.out.println("Connected With the database successfully");
            
            PreparedStatement ps = conn.prepareStatement("select * from users where Name = ? and password = ?");
        	
        	ps.setString(1, uname);
        	ps.setString(2, pass);
        	ps.executeBatch();
        	ResultSet rs = ps.executeQuery();
        	
          	if (rs.next()) {
          		System.out.println("Hello from Login serevlet");
          		int id = rs.getInt(1);
          		String ID = Integer.toString(id);
          		HttpSession hs = request.getSession();
          		hs.setAttribute("userid",ID);
          		dispatcher = request.getRequestDispatcher("index.jsp");
            	dispatcher.forward(request, response);

        	}
          	else {
        		request.setAttribute("status", "failed");
        		dispatcher = request.getRequestDispatcher("login.jsp");
              	dispatcher.forward(request, response);	

        	}
	}catch(Exception e) {
		e.printStackTrace();
		}
	}

}
