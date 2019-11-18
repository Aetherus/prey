<%@page pageEncoding="UTF-8" %>
<!doctype html>
<html>
    <head>
        <meta charset="UTF-8"/>
        <title>Login</title>
    </head>

    <body>
        <form action="/sessions" method="post">
            <p>
                <input name="username" placeholder="用户名"/>
            </p>
            <p>
                <input type="password" name="password" placeholder="密码"/>
            </p>
            <p>
                <button type="submit">登录</button>
            </p>
        </form>
    </body>
</html>