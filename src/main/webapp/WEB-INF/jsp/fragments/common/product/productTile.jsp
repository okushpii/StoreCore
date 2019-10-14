<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 17.08.2019
  Time: 17:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div class="col-lg-4 col-md-6 mb-4">
    <div class="card h-100">
        <c:url var="productImageUrl" value="/image/${product.imageCode}">
            <c:param name="imageFormat" value="${imageFormat}"/>
        </c:url>
        <a href="#"><img class="card-img-top" src="${productImageUrl}" alt=""></a>
        <div class="card-body">
            <h4 class="card-title">
                <a href="#">${product.name}</a>
            </h4>
            <h5>$${product.price}</h5>
            <p class="card-text">
                ${product.description}
            </p>
        </div>
        <div class="card-footer">
            <small class="text-muted">★ ★ ★ ★ ☆</small>
        </div>
    </div>
</div>
