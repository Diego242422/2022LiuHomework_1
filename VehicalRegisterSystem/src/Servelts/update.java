package Servelts;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class update
 */
@WebServlet("/update")
public class update extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session=request.getSession();
		String uid=(String) session.getAttribute("uid");
		String carmodel=request.getParameter("carmodel");
		String registerdate=request.getParameter("registerdate");
		boolean b=false;
		try {
			b=update(uid,carmodel,registerdate);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}if(b==true) {
			response.sendRedirect("SignIn.jsp");
		}else {
			System.out.println("update failed");
		}
	}
	private boolean update(String uid, String carmodel, String registerdate) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		int result=0;
		String insert_vehical_sql="insert into vehical"+"(uid,carmodel,registerdate)values(?,?,?);";
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/vehical?useSSL=false&serverTimezone=GMT%2B8","root","root");
		PreparedStatement preparedstatement=null;
		preparedstatement=connection.prepareStatement(insert_vehical_sql);
		connection.setAutoCommit(false);
		preparedstatement.setString(1, uid);
		preparedstatement.setString(2, carmodel);
		preparedstatement.setString(3, registerdate);
		System.out.println(preparedstatement);
		result=preparedstatement.executeUpdate();
		connection.commit();
		if(result==0) {
			return false;
		}else {
			preparedstatement.close();
			connection.close();
		}
		return true;
	}

}
