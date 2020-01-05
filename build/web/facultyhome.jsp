<%
    String id=(String)session.getAttribute("hodid");
%>
<html>
    <body>
        <h3>Welcome <%=id%></h3>
        <hr>
        <pre>
            <a href="noticepost.jsp">Post Notice</a>
            <a href="">Update Notice</a>
            <a href="">Remove Notice</a>
            <a href="">View Queries</a>
            <a href="">Logout</a>
        </pre>
        <hr>
    </body>
</html>
