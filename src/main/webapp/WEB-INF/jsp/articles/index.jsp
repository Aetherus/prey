<%@ page pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!doctype html>
<html>
    <head>
        <meta charset="UTF-8"/>
        <title>Articles</title>
    </head>

    <body>
        <form action="/articles" method="get">
            <input name="keyword" placeholder="请输入关键字"/>
            <button type="submit">搜索</button>
        </form>

        <a href="/articles/new">新建</a>

        <ul>
            <c:forEach items="${articles}" var="article">
                <li>
                    <a href="/articles/${article.id}">${article.title}</a>
                    <a href="/articles/${article.id}?_method=delete&_csrfToken=${pageContext.session.getAttribute("csrfToken")}">删除</a>
                </li>
            </c:forEach>
        </ul>
    </body>
</html>