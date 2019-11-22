<%@ page pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!doctype html>
<html>
    <head>
        <meta charset="UTF-8"/>
        <title>Articles</title>
        <link href="https://cdn.bootcss.com/twitter-bootstrap/4.3.1/css/bootstrap.min.css" rel="stylesheet">
        <script src="https://cdn.bootcss.com/jquery/3.4.1/jquery.min.js"></script>
        <script src="https://cdn.bootcss.com/jquery-cookie/1.4.1/jquery.cookie.min.js"></script>
    </head>

    <body>
        <form action="/articles" method="get">
            <input name="keyword" placeholder="Keyword"/>
            <button type="submit">Search</button>
        </form>

        <code><pre>
select articles.id, articles.title, users.username
from articles
inner join users on articles.user_id = users.id
where articles.title like '%&lt;keyword&gt;%'
        </pre></code>

        <a href="/articles/new">New</a>

        <table class="table table-bordered table-striped">
            <thead>
            <tr>
                <th>Title</th>
                <th>Username</th>
                <th></th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${articles}" var="article">
                <tr>
                    <td><a href="/articles/${article.id}">${article.title}</a></td>
                    <td>${article.username}</td>
                    <td><a href="/articles/${article.id}?_method=delete">Delete</a></td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </body>
</html>