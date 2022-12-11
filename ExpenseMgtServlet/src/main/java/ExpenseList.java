

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 * Servlet implementation class ExpenseList
 */
public class ExpenseList extends HttpServlet {
	private static final long serialVersionUID = 1L;
     
	private ServletConfig config;
	String page = "DataPage.jsp";
	
	public void init(ServletConfig config)

		throws ServletException{

			 this.config=config;

		}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		PrintWriter out = response.getWriter();
		Connection conn = null;
		ResultSet rs;
        
		 response.setContentType("text/html");

		 List<String> dataList = new ArrayList<String>();
		  
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3307/expensemgt", "root", "");//Establishing connection
            System.out.println("Connected With the database successfully");
            
            String sql = "select * from expenses";
            
            Statement s = conn.createStatement();

            s.executeQuery (sql);

            rs = s.getResultSet();

            while (rs.next ()){
            	dataList.add(rs.getString("Category"));
            	dataList.add(rs.getString("CategoryDetails"));
            }
            rs.close ();

       	 	s.close ();
       	 	
        	} catch(Exception e) {
        	  System.out.println("Exception is ;"+e);
        	}
        	request.setAttribute("data",dataList);
        	
        	RequestDispatcher dispatcher = request.getRequestDispatcher(page);

        	  if (dispatcher != null){

        	  dispatcher.forward(request, response);
	}


	}
}
