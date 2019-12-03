<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 18.08.2019
  Time: 13:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<nav class="d-flex flex-row-reverse">
    <div class="nav-item dropdown">
        <a class="nav-link dropdown-toggle" href="#" role="button"
           data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">

            <c:forEach items="${sortingList}" var="sorting">
                <c:if test="${sorting.selected}">
                    ${sorting.name}
                </c:if>
            </c:forEach>
        </a>

        <div class="dropdown-menu" aria-labelledby="navbarDropdown">
            <c:forEach items="${sortingList}" var="sorting">
                <c:url var="findProductsWithSorting" value="products/c/${categoryCode}/">
                    <c:param name="sorting" value="${sorting.code}"/>
                </c:url>
                <c:choose>
                    <c:when test="${sorting.selected}">
                        <a class="dropdown-item active" href="${findProductsWithSorting}">${sorting.name}</a>
                    </c:when>
                    <c:otherwise>
                        <a class="dropdown-item" href="${findProductsWithSorting}">${sorting.name}</a>
                    </c:otherwise>
                </c:choose>
            </c:forEach>
        </div>
    </div>
</nav>
