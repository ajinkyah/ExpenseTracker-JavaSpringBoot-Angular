<!DOCTYPE html>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<html>
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <link href="https://fonts.googleapis.com/css2?family=Noto+Sans+JP&display=swap" rel="stylesheet">
  <script src="https://kit.fontawesome.com/e51c99212f.js" crossorigin="anonymous"></script>
  <link rel="stylesheet" href="indexstyle.css">
  <title>Expense Tracker</title>
  <script type="text/javascript"></script>
  <!-- Including the bootstrap CDN -->
    <link rel="stylesheet" href=
"https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">
    <script src=
"https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js">
    </script>
    <script src=
"https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js">
    </script>
    <script src=
"https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js">
    </script>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
</head>

<body>
<%
Class.forName("com.mysql.cj.jdbc.Driver");
Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3307/expensemgt", "root", "");//Establishing connection
System.out.println("Connected With the database successfully");

HttpSession hs = request.getSession(false);
String n=(String)hs.getAttribute("userid");
int ID = Integer.parseInt(n);

PreparedStatement s = conn.prepareStatement("select Category, CategoryDetails, Amount, place, shop, Dated from expenses where ID = ?");
s.setInt(1, ID);
ResultSet rs = s.executeQuery();


%>
  <header>
    <div class="navbar">
      <h1><span><i class="fas fa-piggy-bank logo"></i></span> Manage Money smartly...</h1>
      
      <nav class="navbar navbar-expand-sm bg-transparent">
  
        <ul class="navbar-nav ml-auto">
            <li class="nav-item">
                <a class="nav-link" href="MonthlyExpense.jsp">
                  Check Monthly Expenditure 
                </a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="YearlyExpense.jsp">
                  Check Yearly Expenditure 
                </a>
                </a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="CategoryExpense.jsp">
                  Check CategoryWise Expenditure 
                </a>
            <li class="nav-item">
               <a class="nav-link" href="Logout">
                  Logout 
                </a>
                </a>
            </li>
        </ul>
    </nav>
    </div>
    </header>
    <div class="navbar-image">

  </div>
  <div class="menu-container">
    <form class="add-form" action = "/ExpenseMgtServlet/EnterMonthly" method = "Post">
      <div class="form-row">
        <label for="category">Category:</label>
        <select name = "cat" id = "category" required>
        	<option value="Rent">Rent</option>
  			<option value="Home Maintenance">Home Maintenance</option>
  			<option value="Public transportation">Public transportation</option>
  			<option value="Food">Food</option>
  			<option value="Medications">Medications</option>
  			<option value="Charities">Charities</option>
  			<option value="Tution">Tution fees</option>
  			<option value="Utilities">Utilities</option>
        </select>
      </div> 
      <div class="form-row">
        <label for="description">Category Description:</label>
        <input type="text" id="description" placeholder="Details of your expense" name = "catdes" required>
      </div> 
      <div class="form-row">
        <label for="amount">Amount:</label>
        <input type="number" id="amount" placeholder="Enter amount" name = "amount" required>
      </div>
      <div class="form-row">
        <label for="place">Enter City:</label>
        <input type="text" id="description" placeholder="Enter details of your expense" name = "city" pattern = "[A-Za-z]+" required>
      </div>
      <div class="form-row">
        <label for="shop">Enter Place:</label>
        <input type="text" id="description" placeholder="Enter details of your expense" name = "shop" pattern = "[A-Za-z]+" required>
      </div>
      <div class="form-row">
        <label for="date">Date:</label>
        <input type="date" name = "date" id="date" class="date" required>
      </div>
      
	<button class="submit-btn add-items" type="submit">Submit</button>
  	</form>
  <div class="error-message"></div>
  </div>
  <div class= "d-flex justify-content-center">
  		<div class = "col-md-10">
  		<h3><center>
  		<% PreparedStatement s1 = conn.prepareStatement("select * from users where ID = ?");
  		s1.setInt(1, ID);
		ResultSet rs1 = s1.executeQuery();
		while(rs1.next()){
			String name ="Hi "+ rs1.getString(2);
			out.print(name);
		}
		%>
		Expenses made...</center></h3>
  		<table class = "table">
  		<thead>
  			<tr>
  			<th scope= "col"> Category </th>
  			<th scope= "col"> Category Details</th>
    		<th scope= "col"> Amount </th>
  			<th scope= "col"> City </th>
  			<th scope= "col"> Place </th>
  			<th scope= "col"> Date </th>
  			</tr>
  		</thead>
  		<tbody>
  			<% while(rs.next()){ %>
  			<tr>
  			<td><%= rs.getString("Category") %></td>
  			<td><%= rs.getString("CategoryDetails") %></td>
  			<td><%= rs.getInt("Amount") %></td>
  			<td><%= rs.getString("place") %></td>
  			<td><%= rs.getString("shop") %></td>
  			<td><%= rs.getString("Dated") %></td>
  		<% } %>
  		</tbody>
  		</table>
  		</div>
  </div>
  <script src="indexjs.js"></script> 
</body>
</html>