package servlets;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.EmployeeDetails;

/**
 * Servlet implementation class Display
 */
@WebServlet("/Display")
public class Display extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Connection con = null;
		PreparedStatement stnt = null;
		ResultSet rs = null;
		List<EmployeeDetails> emplist = new ArrayList<>();
				try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost/mydb", "root", "Ramya@1234");
			stnt = con.prepareStatement("select * from table_name");
			rs = stnt.executeQuery();
			while (rs.next()) {
				EmployeeDetails emp = new EmployeeDetails();
				emp.setName(rs.getString("name"));
				emp.setSalary(rs.getInt("salary"));
				emp.setDesignation(rs.getString("designation"));
				System.out.println(rs.getString("name"));
				emplist.add(emp);
			}
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		finally{
			try {
				con.close();
				stnt.close();
				rs.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		System.out.println(emplist.size());
		RequestDispatcher rds = request.getRequestDispatcher("display.jsp");
		request.setAttribute("empList", emplist);
		rds.forward(request, response);																																																																																																																										
	}

}
