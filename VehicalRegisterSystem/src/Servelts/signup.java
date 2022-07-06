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
import org.openqa.selenium.WebElement;
/**
 * Servlet implementation class signup
 */
@WebServlet("/signup")
public class signup extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		boolean b=false;
		String uid=request.getParameter("uid");
		String pw=request.getParameter("pw");
		String uname=request.getParameter("uname");
		String carmodel=request.getParameter("carmodel");
		String registerdate=request.getParameter("registerdate");
		try {
			b=registerdata(uid,pw,uname,carmodel,registerdate);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(b==false) {
			response.sendRedirect("SignUp.jsp");	
		}else {
			response.sendRedirect("Index.jsp");
		}
	}
	private boolean registerdata(String uid, String pw,String uname,String carmodel,String registerdate) throws ClassNotFoundException, SQLException {
		String insert_user_sql="insert into userdetail"+"(uid,pw,uname)values(?,?,?);";
		String insert_vehical_sql="insert into vehical"+"(uid,carmodel,registerdate)values(?,?,?);";
		int result=0;
		int rs=0;
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/vehical?useSSL=false&serverTimezone=GMT%2B8","root","root");
		PreparedStatement preparedstatement=null;
		PreparedStatement preparedstatement2=null;
		preparedstatement2=connection.prepareStatement(insert_vehical_sql);
		preparedstatement=connection.prepareStatement(insert_user_sql);
		connection.setAutoCommit(false);
		preparedstatement.setString(1, uid);
		preparedstatement.setString(2, pw);
		preparedstatement.setString(3, uname);
		preparedstatement2.setString(1, uid);
		preparedstatement2.setString(2, carmodel);
		preparedstatement2.setString(3, registerdate);
		System.out.println(preparedstatement);
		System.out.println(preparedstatement2);
		result=preparedstatement.executeUpdate();
		rs=preparedstatement2.executeUpdate();
		connection.commit();
		if(result==0&&rs==0) {
			return false;
		}else {
			preparedstatement.close();
			preparedstatement2.close();
			connection.close();
		}
		return true;
	}

}
