<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 18.08.2019
  Time: 13:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<main role="main" class="container">

    <%@include file="../common/productListPage/breadcrumbs.jsp" %>
    <div class="row">
        <div class="col-lg-3">
            <%@include file="../common/productListPage/facetsPanel.jsp" %>
        </div>
        <div class="col-lg-9">
            <%@include file="../common/productListPage/productGridOptions.jsp" %>
            <%@include file="../common/productListPage/productGrid.jsp" %>
            <%@include file="../common/productListPage/pagination.jsp" %>
        </div>
    </div>
</main>
