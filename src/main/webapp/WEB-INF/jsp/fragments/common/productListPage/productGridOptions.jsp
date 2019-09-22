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
            <c:set var="isSortingPlacementDateAsc"
                   value="${sortingField == 'placementDate' && sortingType == 'asc'}"/>
            <c:set var="isSortingPlacementDateDesc"
                   value="${sortingField == 'placementDate' && sortingType == 'desc'}"/>
            <c:set var="isSortingPriceAsc"
                   value="${sortingField == 'price' && sortingType == 'asc'}"/>
            <c:set var="isSortingPriceDesc"
                   value="${sortingField == 'price' && sortingType == 'desc'}"/>

            <c:choose>
                <c:when test="${isSortingPlacementDateAsc}">
                    Date added asc
                </c:when>
                <c:when test="${isSortingPlacementDateDesc}">
                    Date added desc
                </c:when>
                <c:when test="${isSortingPriceAsc}">
                    Price asc
                </c:when>
                <c:when test="${isSortingPriceDesc}">
                    Price desc
                </c:when>
                <c:otherwise>
                    Date added asc
                </c:otherwise>
            </c:choose>
        </a>

        <c:url var="findProductsWithSorting" value="/productList/${categoryId}/"/>
        <div class="dropdown-menu" aria-labelledby="navbarDropdown">

            <c:url var="placementDateAscSortingUrl" value="${findProductsWithSorting}">
                <c:param name="sortingField" value="placementDate"/>
                <c:param name="sortingType" value="asc"/>
            </c:url>

            <c:choose>
                <c:when test="${isSortingPlacementDateAsc}">
                    <a class="dropdown-item active" href="${placementDateAscSortingUrl}">Date added asc</a>
                </c:when>
                <c:otherwise>
                    <a class="dropdown-item" href="${placementDateAscSortingUrl}">Date added asc</a>
                </c:otherwise>
            </c:choose>

            <c:url var="placementDateDescSortingUrl" value="${findProductsWithSorting}">
                <c:param name="sortingField" value="placementDate"/>
                <c:param name="sortingType" value="desc"/>
            </c:url>

            <c:choose>
                <c:when test="${isSortingPlacementDateDesc}">
                    <c:set var="currentSorting" value="Date added desc"/>
                    <a class="dropdown-item active" href="${placementDateDescSortingUrl}">Date added desc</a>
                </c:when>
                <c:otherwise>
                    <a class="dropdown-item" href="${placementDateDescSortingUrl}">Date added desc</a>
                </c:otherwise>
            </c:choose>

            <c:url var="priceAscSortingUrl" value="${findProductsWithSorting}">
                <c:param name="sortingField" value="price"/>
                <c:param name="sortingType" value="asc"/>
            </c:url>

            <c:choose>
                <c:when test="${isSortingPriceAsc}">
                    <a class="dropdown-item active" href="${priceAscSortingUrl}">Price asc</a>
                </c:when>
                <c:otherwise>
                    <a class="dropdown-item" href="${priceAscSortingUrl}">Price asc</a>
                </c:otherwise>
            </c:choose>

            <c:url var="priceDescSortingUrl" value="${findProductsWithSorting}">
                <c:param name="sortingField" value="price"/>
                <c:param name="sortingType" value="desc"/>
            </c:url>

            <c:choose>
                <c:when test="${isSortingPriceDesc}">
                    <a class="dropdown-item active" href="${priceDescSortingUrl}">Price desc</a>
                </c:when>
                <c:otherwise>
                    <a class="dropdown-item" href="${priceDescSortingUrl}">Price desc</a>
                </c:otherwise>
            </c:choose>

        </div>
    </div>
</nav>
