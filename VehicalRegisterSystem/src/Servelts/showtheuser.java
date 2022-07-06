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
import javax.servlet.http.HttpSession;
import javax.xml.ws.Response;

/**
 * Servlet implementation class showtheuser
 */
@WebServlet("/showtheuser")
public class showtheuser extends HttpServlet{
	private static final long serialVersionUID = 1L;
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session=request.getSession();
		PrintWriter out=response.getWriter();
		String uid=(String) session.getAttribute("uid");
		//System.out.println(uid);
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/vehical?useSSL=false&serverTimezone=GMT%2B8","root","root");
			Statement st=connection.createStatement();
			ResultSet rs=st.executeQuery("select*from vehical where uid='"+uid+"';");
			while(rs.next()) {
				String carmodel=rs.getString("carmodel");
				String registerdate=rs.getString("registerdate");
				out.println("The car model is "+carmodel+"<br></br>");
				out.println("The register date is "+registerdate+"<br></br>");
			}
			if(connection!=null) {
				connection.close();
			}
			if(st!=null) {
				st.close();
			}
			System.out.println(uid);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
/*	public void main() {
		doPost(null, null);
		
	}*/
