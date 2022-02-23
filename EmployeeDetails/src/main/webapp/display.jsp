<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="java.util.List" %>
    <%@ page import="model.EmployeeDetails" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action ="Display" method=post>
<button>get result</button>
</form>
<table>
<thead>
<tr>
<th>Employee Name</th>
<th>Salary</th>
<th>Designation</th>
</tr>
</thead>
<%
List<EmployeeDetails> emplist=(List<EmployeeDetails>)request.getAttribute("empList");
if(emplist != null)
for(EmployeeDetails empl:emplist) {
%>

<tr>
<td><%=empl.getName() %></td>
<td><%=empl.getSalary() %></td>
<td><%=empl.getDesignation() %></td>
</tr>
<% }  %>
</tbody>
</table>
<a href="Index.jsp">Home</a>
</body>
</html>