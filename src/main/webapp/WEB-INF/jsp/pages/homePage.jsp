<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>

</head>
<body>
<div>
    <h1>Test</h1>
    <ul>
    <c:forEach items="${categories}" var="category">
        <li>
            <p>${category.name}</p>
            <ul>
            <c:forEach items="${category.childCategories}" var="childCategory">
                <li>
                    <p>${childCategory.name}</p>
                </li>
            </c:forEach>
            </ul>
        </li>
    </c:forEach>
    </ul>
</div>
</body>
</html>