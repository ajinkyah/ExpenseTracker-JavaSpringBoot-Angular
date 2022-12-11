<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>Data Page</title>
</head>
<body> 
<table border="1" width="303">
<tr>
<td width="119"><b>Category</b></td>
<td width="168"><b>CategoryDetails</b></td>
</tr>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.Iterator"%> 
 
<%@Iterator itr;%>
<%@ List data= (List)request.getAttribute("data");
for (itr=data.iterator(); itr.hasNext(); )
{
%>
<tr>
<td width="119"><%@=itr.next()%></td>
<td width="168"><%@=itr.next()%></td>
</tr>
<%@}%>
</table>
</body>
</html>