<%
    java.sql.Connection con=com.ssi.Connector.connect();
    String qr="select * from students";
    java.sql.PreparedStatement ps=con.prepareStatement(qr);
    java.sql.ResultSet rs=ps.executeQuery();
%>
<html>
    <body>
        <h2>Students List</h2>
        <table border="3" width="3" cellspacing="2" cellpadding="2">
            <thead>
                <tr>
                    <th>Id</th>
                    <th>Password</th>
                    <th>Name</th>
                    <th>Branch</th>
                    <th>Sem</th>
                    <th>Status</th>
                </tr>
            </thead>
            <tbody>
<%
        while(rs.next()){
        String s1=rs.getString(1);
        String s2=rs.getString(2);
        String s3=rs.getString(3);
        String s4=rs.getString(4);
        String s5=rs.getString(5);
        String s6=rs.getString(6);
%>
                <tr>
                    <td><% out.println(s1); %></td>
                    <td><% out.println(s2); %></td>
                    <td><% out.println(s3); %></td>
                    <td><% out.println(s4); %></td>
                    <td><% out.println(s5); %></td>
                    <td><% out.println(s6); %></td>
                </tr>
<%
    }
      con.close();
%>
            </tbody>
            
        </table>
<a href="adminhome.jsp">Home</a> 
    </body>
</html>
