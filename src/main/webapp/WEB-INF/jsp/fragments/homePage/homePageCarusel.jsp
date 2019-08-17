<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 17.08.2019
  Time: 14:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<div id="carouselExampleIndicators" class="carousel slide my-4" data-ride="carousel">
    <ol class="carousel-indicators">
        <li data-target="#carouselExampleIndicators" data-slide-to="0" class=""></li>
        <li data-target="#carouselExampleIndicators" data-slide-to="1" class=""></li>
        <li data-target="#carouselExampleIndicators" data-slide-to="2" class="active"></li>
    </ol>
    <div class="carousel-inner" role="listbox">
        <div class="carousel-item">
            <img class="d-block img-fluid" src="http://placehold.it/1080x450" alt="First slide">
        </div>
        <div class="carousel-item">
            <img class="d-block img-fluid" src="http://placehold.it/1080x450" alt="First slide">
        </div>
        <div class="carousel-item active">
            <img class="d-block img-fluid" src="http://placehold.it/1080x450" alt="First slide">
        </div>
    </div>
    <a class="carousel-control-prev" href="#carouselExampleIndicators" role="button"
       data-slide="prev">
        <span class="carousel-control-prev-icon" aria-hidden="true"></span>
        <span class="sr-only">Previous</span>
    </a>
    <a class="carousel-control-next" href="#carouselExampleIndicators" role="button"
       data-slide="next">
        <span class="carousel-control-next-icon" aria-hidden="true"></span>
        <span class="sr-only">Next</span>
    </a>
</div>
