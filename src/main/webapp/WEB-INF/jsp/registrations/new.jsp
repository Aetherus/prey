<%@page pageEncoding="UTF-8" %>
<!doctype html>
<html>
<head>
    <meta charset="UTF-8"/>
    <title>Login</title>
    <script src="https://cdn.bootcss.com/jquery/3.4.1/jquery.min.js"></script>
    <script src="https://cdn.bootcss.com/jquery-cookie/1.4.1/jquery.cookie.min.js"></script>
    <script>
        $(function () {
            $(window.location.hash).show();
        })
    </script>
</head>

<body>
<form action="/registrations" method="post">
    <p>
        <input name="username" placeholder="Username"/><br/>
        <small id="duplicate-username" style="color: red; display: none">Username has already been taken</small>
    </p>
    <p>
        <input type="password" name="password" placeholder="Password"/><br/>
    </p>
    <p>
        <button type="submit">Sign Up</button>
        <a href="/sessions/new">Already have an account</a>
    </p>
</form>
</body>
</html>