<%@ page pageEncoding="UTF-8" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!doctype html>
<html>
    <head>
        <meta charset="UTF-8"/>
        <title>${article.title}</title>
    </head>

    <body>
        <article>
            <h1>${fn:escapeXml(article.title)}</h1>
            <p>${fn:escapeXml(article.content)}</p>
        </article>
        <a href="/articles">Back</a>
    </body>
</html>