

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

/**
 * Servlet implementation class Registration
 */

public class Registration extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String uname = request.getParameter("name");
		String upass = request.getParameter("pass");
		
		RequestDispatcher dispatcher = null;
		
		Connection conn;
        
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3307/expensemgt", "root", "");//Establishing connection
            System.out.println("Connected With the database successfully");
            
            PreparedStatement ps = conn.prepareStatement("insert into users (Name, password) values (?,?)");
        	
        	ps.setString(1, uname);
        	ps.setString(2, upass);
        	
        	dispatcher = request.getRequestDispatcher("login.jsp");
        	int rowCnt = ps.executeUpdate();
        	
        	if(rowCnt > 0) {
        		request.setAttribute("status", "success");
        	}
        	else {
        		request.setAttribute("status", "failed");

        	}
        	dispatcher.forward(request, response);
        }catch(Exception e) {
		
	}
}
}
