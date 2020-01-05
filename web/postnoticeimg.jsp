<%@include file="info.jsp" %>
<%
    String id=(String)session.getAttribute("hodid");
     if(id==null){
        response.sendRedirect("index.jsp");
    }
    String dp=(String)session.getAttribute("hoddept");
%>
<html>
    <body>
        <h3>Welcome <%=id%> (<%=dp%>)</h3>
        <h4>Notice Post Form</h4>
        <form action="SaveNoticeImg" method="post" enctype="multipart/form-data" >
            <pre>
            Title   <input type="text" name="title"/>
            Message <textarea name="message" rows="6" cols="40"></textarea>
            Image   <input type="file" name="img"/>
                    <input type="submit" value="Post-Notice"/>
            </pre>
        </form>
        <hr>
        <a href="facultyhome.jsp">Home</a>
    </body>
</html>
