package Servelts;

import java.io.IOException;
import java.io.PrintWriter;
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
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class delete
 */
@WebServlet("/delete")
public class delete extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		boolean b=false;
		PrintWriter out=response.getWriter();
		HttpSession session=request.getSession();
		String uid=(String) session.getAttribute("uid");
		String carmodel=request.getParameter("carmodel");
		try {
			b=delete(uid,carmodel);
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(b==false) {
			out.println("not good");
		}else {
			System.out.println("verry gooood");
			response.sendRedirect("SignIn.jsp");
		}
	}
	private boolean delete(String uid, String carmodel) throws SQLException, ClassNotFoundException {
		// TODO Auto-generated method stub
		Class.forName("com.mysql.cj.jdbc.Driver");
		int result=0;
		Connection connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/vehical?useSSL=false&serverTimezone=GMT%2B8","root","root");
		//Statement st=connection.createStatement();
		PreparedStatement preparedstatement=null;
		preparedstatement=connection.prepareStatement("delete from vehical where uid=? and carmodel=?;");
		preparedstatement.setString(1, uid);
		preparedstatement.setString(2, carmodel);
		result=preparedstatement.executeUpdate();
		if(result==0) {
			return false;
		}
		preparedstatement.close();
		connection.close();
		return true;
	}

}
