<%@page pageEncoding="UTF-8" %>
<!doctype html>
<html>
    <head>
        <meta charset="UTF-8"/>
        <title>${article.title}</title>
    </head>

    <body>
        <article>
            <h1>${article.title}</h1>
            <p>${article.content}</p>
        </article>
        <a href="/articles">返回</a>
    </body>
</html>