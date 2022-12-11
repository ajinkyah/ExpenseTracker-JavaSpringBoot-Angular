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

PreparedStatement s = conn.prepareStatement("select date_format(Dated, '%M')as Dated, sum(Amount) as Amount from expenses where ID = ? group by date_format(Dated, '%M')");
s.setInt(1, ID);
ResultSet rs = s.executeQuery();


%>
  <header>
    <div class="navbar">
      <h1><span><i class="fas fa-piggy-bank logo"></i></span> Manage Money smartly...</h1>
      </div>
    </header>
    <div class="navbar-image">
  </div>
  <div class= "d-flex justify-content-center">
  		<div class = "col-md-10">
  		<h3><center>Monthly Expense made...</center></h3>
  		<table class = "table">
  		<thead>
  			<tr>
  			<th scope= "col"> Month </th>
  			<th scope= "col"> Expenditure</th>
  			</tr>
  		</thead>
  		<tbody>
  			<% while(rs.next()){ %>
  			<tr>
  			<td><%= rs.getString("Dated") %></td>
  			<td><%= rs.getInt("Amount") %></td>
  			</tr>
  		<% } %>
  		</tbody>
  		</table>
  		</div>
  </div>
</body>
</html>