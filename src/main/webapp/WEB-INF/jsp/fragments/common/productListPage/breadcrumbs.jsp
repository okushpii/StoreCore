<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 18.08.2019
  Time: 13:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<nav aria-label="breadcrumb">
    <ol class="breadcrumb">
        <c:url var="homePageUrl" value="/"/>
        <li class="breadcrumb-item"><a href="${homePageUrl}">Home</a></li>
        <c:forEach var="breadcrumb" items="${breadcrumbs}">
            <c:choose>
                <c:when test="${breadcrumb.last}">
                    <li class="breadcrumb-item active">${breadcrumb.name}</li>
                </c:when>
                <c:otherwise>
                    <li class="breadcrumb-item active"><a href="${breadcrumb.url}">${breadcrumb.name}</a></li>
                </c:otherwise>
            </c:choose>

        </c:forEach>
    </ol>
</nav>