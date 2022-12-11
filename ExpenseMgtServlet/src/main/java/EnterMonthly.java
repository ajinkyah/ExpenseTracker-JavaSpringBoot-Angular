

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
 * Servlet implementation class EnterMonthly
 */
public class EnterMonthly extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String cat = request.getParameter("cat");
		String catdesc = request.getParameter("catdes");
		int amount = Integer.parseInt(request.getParameter("amount"));
		String city = request.getParameter("city");
		String shop = request.getParameter("shop");
		String date = request.getParameter("date");

	
		RequestDispatcher dispatcher = null;
		
		Connection conn;
        
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3307/expensemgt", "root", "");//Establishing connection
            System.out.println("Connected With the database successfully");
            
            HttpSession hs = request.getSession(false);
            String n=(String)hs.getAttribute("userid");
            int ID = Integer.parseInt(n);
            
            PreparedStatement ps = conn.prepareStatement("insert into expenses (ID, Category, CategoryDetails, Amount, place, shop, Dated) values (?,?,?,?,?,?,?)");
        	
            
            ps.setInt(1, ID);
        	ps.setString(2, cat);
        	ps.setString(3, catdesc);
        	ps.setInt(4, amount);
        	ps.setString(5, city);
        	ps.setString(6, shop);
        	ps.setString(7, date);
        	
        	int rowCnt = ps.executeUpdate();

        	if(rowCnt > 0) {
    			RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
    			rd.forward(request, response);
        	
        	}
        	else {
            	
        		request.setAttribute("status", "failed");
        	}
        }catch(Exception e) {
		
	}
}
}
