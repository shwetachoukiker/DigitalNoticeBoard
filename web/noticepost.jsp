<%
    String id=(String)session.getAttribute("hodid");
%>
<html>
    <body>
        <h3>Welcome <%=id%></h3>
        <h4>Notice Post Form</h4>
        <form action="SaveNotice" method="get" >
            <pre>
            Title   <input type="text" name="title"/>
            Message <textarea id="message" rows="8" cols="40"></textarea>
                    <input type="submit" value="Post-Notice"/>
            </pre>
        </form>
        <hr>
        <a href="facultyhome.jsp">Home</a>
    </body>
</html>
