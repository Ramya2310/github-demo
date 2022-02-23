package servlets;

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

/**
 * Servlet implementation class Update
 */
@WebServlet("/Update")
public class Update extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String employeeName=request.getParameter("employee");
		int salary=Integer.parseInt(request.getParameter("salary"));
		System.out.println(employeeName);
		System.out.println(salary);
		Connection con=null;
		PreparedStatement stnt=null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			 con=DriverManager.getConnection("jdbc:mysql://localhost/mydb","root","Ramya@1234");
			 stnt=con.prepareStatement("update table_name set salary=salary+? where name=?");
			stnt.setString(2, employeeName);
			stnt.setInt(1, salary);
			int rowaffected=stnt.executeUpdate();
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		finally
		{
			try {
				con.close();
				stnt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
}	
	}
		

	


