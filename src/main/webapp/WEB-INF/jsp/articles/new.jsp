<%@ page pageEncoding="UTF-8" %>
<!doctype html>
<html>
    <head>
        <meta charset="UTF-8"/>
        <title>New Article</title>
        <script src="https://cdn.bootcss.com/jquery/3.4.1/jquery.min.js"></script>
        <script src="https://cdn.bootcss.com/jquery-cookie/1.4.1/jquery.cookie.min.js"></script>
    </head>

    <body>
        <form action="/articles" method="post">
            <p>
                <input name="title" placeholder="Title"/>
            </p>
            <p>
                <textarea name="content" rows="20" placeholder="Content"></textarea>
            </p>
            <p>
                <button type="submit">Create Article</button>
            </p>
        </form>
        <a href="/articles">Back</a>
    </body>
</html>