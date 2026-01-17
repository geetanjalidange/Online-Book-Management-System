<%@ page import="java.sql.*" %>
<html>
<body>
<h2>Book List</h2>
<%
Class.forName("com.mysql.cj.jdbc.Driver");
Connection con = DriverManager.getConnection(
"jdbc:mysql://localhost:3306/book_db","root","root");
Statement st = con.createStatement();
ResultSet rs = st.executeQuery("SELECT * FROM books");

while(rs.next()){
%>
<p><%= rs.getString("title") %> - <%= rs.getString("author") %></p>
<% } %>
</body>
</html>
