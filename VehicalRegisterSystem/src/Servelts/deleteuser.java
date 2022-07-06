package Servelts;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class deleteuser
 */
@WebServlet("/deleteuser")
public class deleteuser extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String uid=request.getParameter("uid");
		boolean b=false;
		try {
			b=deleteuser(uid);
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}if(b==true) {
			response.sendRedirect("Admin.jsp");
			System.out.println("Delete Successfully");
		}
	}
	private boolean deleteuser(String uid) throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/vehical?useSSL=false&serverTimezone=GMT%2B8","root","root");
		PreparedStatement preparedstatement=null;
		int result=0;
		preparedstatement=connection.prepareStatement("delete from userdetail where uid=?;");
		preparedstatement.setString(1, uid);
		result=preparedstatement.executeUpdate();
		if(result==0) {
			return false;
		}
		return true;
	}

}
