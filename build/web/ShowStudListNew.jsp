<%@page  import="java.sql.*,java.util.*" %>

<%!
    String convert(int n){
        String res="";
        switch(n){
            case 1:
                res="One";
            break;
            case 2:
                res="Two";
            break;
            case 3:
                res="Three";
            break;
            case 4:
                res="Four";
            break;
            case 5:
                res="Five";
            break;
            case 6:
                res="Six";
            break;
            case 7:
                res="Seven";
            break;
            case 8:
                res="Eight";
            break;
        }
        return res;
    }
%>
<%
    java.sql.Connection con=com.ssi.Connector.connect();
    String qr="select * from students";
    PreparedStatement ps=con.prepareStatement(qr);
    ResultSet rs=ps.executeQuery();
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
                    <td><%=s1%></td>
                    <td><%=s2%></td>
                    <td><%=s3%></td>
                    <td><%=s4%></td>
                    <td><%=convert(Integer.parseInt(s5))%></td>
                    <td><%=s6%></td>
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
