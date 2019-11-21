<%@ page pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!doctype html>
<html>
    <head>
        <meta charset="UTF-8"/>
        <title>Articles</title>
    </head>

    <body>
        <form action="/articles" method="get">
            <input name="keyword" placeholder="Keyword"/>
            <button type="submit">Search</button>
        </form>

        <a href="/articles/new">New</a>

        <ul>
            <c:forEach items="${articles}" var="article">
                <li>
                    <a href="/articles/${article.id}">${fn:escapeXml(article.title)}</a>
                    <a href="/articles/${article.id}?_method=delete">Delete</a>
                </li>
            </c:forEach>
        </ul>
    </body>
</html>