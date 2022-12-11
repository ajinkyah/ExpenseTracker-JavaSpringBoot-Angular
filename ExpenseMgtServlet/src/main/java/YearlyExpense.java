

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 * Servlet implementation class YearlyExpense
 */
public class YearlyExpense extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PrintWriter out = response.getWriter();
		out.print("<h1>Yearly Expense list</h1>");
		out.print("<table border = '1'><tr><th>Year</th><th>Expenditure</th></tr>");
		
		
		try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3307/expensemgt", "root", "");//Establishing connection
            System.out.println("Connected With the database successfully");
            
            Statement stmt = conn.createStatement();
    		ResultSet rs = stmt.executeQuery("select date_format(Dated, '%Y'), sum(Amount) from expenses group by date_format(Dated, '%Y');\r\n"
    				+ "");
 
            while(rs.next()) {
            	out.print("<tr><td>");
            	out.println(rs.getString(1));
            	out.print("</td>");
            	out.print("<td>");
            	out.print(rs.getString(2));
            	out.print("</td>");
            	out.print("</tr>");
            	
            }
	} catch(Exception e) {
		}
		out.print("</table>");
	}

}
