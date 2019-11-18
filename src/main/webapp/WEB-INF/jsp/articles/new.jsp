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
                <input name="title" placeholder="标题"/>
            </p>
            <p>
                <textarea name="content" rows="20" placeholder="正文"></textarea>
            </p>
            <p>
                <button type="submit">提交</button>
            </p>
        </form>
        <a href="/articles">返回</a>
    </body>
</html>