<%@ page pageEncoding="UTF-8" %>
<!doctype html>
<html>
    <head>
        <meta charset="UTF-8"/>
        <title>New Article</title>
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
        <a href="/articles">返回</a>
    </body>
</html>