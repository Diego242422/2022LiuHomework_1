<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Sign in page</title>
</head>
<body>
<% 
if(session!=null){
	if(session.getAttribute("uid")!=null){
	String name=(String)session.getAttribute("uid");
	out.print(name+" Welcome");
	}
	if(session.getAttribute("uid").equals("admin")&&session.getAttribute("pw").equals("admin")){
		response.sendRedirect("Admin.jsp");
	}
	
}%>
<form action="showtheuser" method="post">
<input type="submit" value="show the vehicals"><br></br>
</form>
<form action="Update.jsp" method="post">
<input type="submit" value="update the car"><br></br>
</form>
<form action="delete.jsp" method="post">
<input type="submit" value="delete the car"><br></br>
</form>
<form action="signout" method="post">
<input type="submit" value="Sign Out">
</form>
</body>
</html>