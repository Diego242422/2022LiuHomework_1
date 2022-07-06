package Servelts;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class search
 */
@WebServlet("/search")
public class search extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String uid=request.getParameter("uid");
		PrintWriter out=response.getWriter();
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/vehical?useSSL=false&serverTimezone=GMT%2B8","root","root");
			Statement st=connection.createStatement();
			
			ResultSet r=st.executeQuery("select*from userdetail where uid='"+uid+"';");
			//ResultSet rs=st.executeQuery("select*from vehical where uid='"+uid+"';");
			while(r.next()) {
				String userid=r.getString("uid");
				String uname=r.getString("uname");
				out.println("user id is :"+userid+"<br></br>");
				out.println("user name is"+uname+"<br></br>");
			}
			ResultSet rs=st.executeQuery("select*from vehical where uid='"+uid+"';");
		   while(rs.next()) {
				String carmodel=rs.getString("carmodel");
				String registerdate=rs.getString("registerdate");
				out.println("The vehical model is "+carmodel+"<br></br>");
				out.println("The registerdate is "+registerdate+"<br></br>");
			}
			if(connection!=null) {
				connection.close();
			}
			if(st!=null) {
				st.close();
			}
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
