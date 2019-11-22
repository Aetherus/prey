<%@ page pageEncoding="UTF-8" %>
<!doctype html>
<html>
    <head>
        <meta charset="UTF-8"/>
        <title>Login</title>
        <script src="https://cdn.bootcss.com/jquery/3.4.1/jquery.min.js"></script>
        <script>
            $(function () {
                $(window.location.hash).show();
            })
        </script>
    </head>

    <body>
        <div id="registration-success" style="color: green; display: none">Registration succeeded!</div>
        <form action="/sessions" method="post">
            <p>
                <input name="username" placeholder="Username"/><br/>
                <small id="invalid-username" style="color: red; display: none">Invalid username</small>
            </p>
            <p>
                <input type="password" name="password" placeholder="Password"/><br/>
                <small id="invalid-password" style="color: red; display: none">Invalid password</small>
            </p>
            <p>
                <button type="submit">Login</button>
                <a href="/registrations/new">Register new account</a>
            </p>
        </form>
    </body>
</html>