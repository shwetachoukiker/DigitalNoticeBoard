<html>
    <body>
        <h2>Digital Notice Board</h2>
        <hr>
        <form action="VerifyUser" method="get">
            <pre>
            UserId          <input type="text" name="uid"/>
            Password        <input type="text" name="pw"/>
            UserType        <select name="utype">
                                <option>admin</option>
                                <option>hod</option>
                                <option>student</option>
                            </select>
            SavePassword    <input type="checkbox" name="save" value="yes"/>
                            <input type="submit" value="Login"/>
            </pre>
        </form>
        <hr>
        <a href="registration.jsp">New-Student-Registration</a>
    </body>
</html>
