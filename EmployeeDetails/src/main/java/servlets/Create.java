package servlets;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Create
 */
@WebServlet("/Create")
public class Create extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String employeeName=request.getParameter("employee");
		int salary=Integer.parseInt(request.getParameter("salary"));
		String designation=request.getParameter("designation");
		System.out.println(employeeName);
		System.out.println(salary);
		System.out.println(designation);
		Connection con=null;
		PreparedStatement stnt=null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			 con=DriverManager.getConnection("jdbc:mysql://localhost/mydb","root","Ramya@1234");
			 stnt=con.prepareStatement("insert into table_name(name,salary,designation)values(?,?,?)");
			stnt.setString(1, employeeName);
			stnt.setInt(2, salary);
			stnt.setString(3, designation);
			int rowaffected=stnt.executeUpdate();
			RequestDispatcher rd =request.getRequestDispatcher("create.jsp");
			rd.forward(request, response);
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
