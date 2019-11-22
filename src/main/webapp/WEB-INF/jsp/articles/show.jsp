<%@ page pageEncoding="UTF-8" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!doctype html>
<html>
    <head>
        <meta charset="UTF-8"/>
        <title>${article.title}</title>
        <script src="https://cdn.bootcss.com/jquery/3.4.1/jquery.min.js"></script>
        <script src="https://cdn.bootcss.com/jquery-cookie/1.4.1/jquery.cookie.min.js"></script>
    </head>

    <body>
        <article>
            <h1>${fn:escapeXml(article.title)}</h1>
            <p>${fn:escapeXml(article.content)}</p>
        </article>
        <a href="/articles">Back</a>
    </body>
</html>