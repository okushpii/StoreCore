<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 18.08.2019
  Time: 13:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<div class="row">

    <c:forEach items="${productList}" var="product">
        <%@include file="../product/productTile.jsp" %>
    </c:forEach>

</div>
<!-- /.row -->