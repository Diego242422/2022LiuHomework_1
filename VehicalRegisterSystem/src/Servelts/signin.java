package Servelts;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.jws.soap.SOAPBinding.Use;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


/**
 * Servlet implementation class signin
 */
@WebServlet("/signin")
public class signin extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		boolean b=false;
		PrintWriter out=response.getWriter();
		String uid=request.getParameter("uid");
		String pw=request.getParameter("pw");
		HttpSession session=request.getSession();
		//if(uid.equals("admin")&&pw.equals("admin")) {
			//System.out.println("okok");
			//request.getRequestDispatcher("Admin.jsp");return;
		//}
		try {
			b=checkLogin(uid,pw);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(b==false) {
			response.sendRedirect("Index.jsp");
		}else {
			session.setAttribute("uid", uid);
			session.setAttribute("pw", pw);
			response.sendRedirect("SignIn.jsp");
		}
	}
	private boolean checkLogin(String uid, String pw) throws SQLException, ClassNotFoundException {
		// TODO Auto-generated method stub
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/vehical?useSSL=false&serverTimezone=GMT%2B8","root","root");
		Statement st=connection.createStatement();
		ResultSet rs=st.executeQuery("select*from userdetail where uid='"+uid+"' and pw='"+pw+"';");
		if(rs.next()) {
			return true;
		}
		return false;
	}

}
