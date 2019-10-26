<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 10.10.2019
  Time: 20:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<main role="main" class="container">

    <div class="signup-form">
        <form method="post" action="/register/add">
            <h2>Register</h2>
            <p class="hint-text">Create your account. It's free and only takes a minute.</p>
            <div class="form-group">
                <input type="text" class="form-control" name="firstName" value="${user.firstName}"
                       placeholder="First Name" required="required">
            </div>
            <div class="form-group">
                <input type="text" class="form-control" name="lastName" value="${user.lastName}" placeholder="Last Name"
                       required="required">
            </div>
            <div class="form-group">
                <input type="email" class="form-control" name="email" value="${user.email}" placeholder="Email"
                       required="required">
            </div>
            <div class="form-group">
                <input type="password" class="form-control" name="password" value="${user.password}"
                       placeholder="Password"
                       required="required">
            </div>
            <div class="form-group">
                <label class="checkbox-inline"><input type="checkbox" required="required"> I accept the <a href="#">Terms
                    of Use</a> &amp; <a href="#">Privacy Policy</a></label>
            </div>
            <div class="form-group">
                <button type="submit" class="btn btn-success btn-lg btn-block">Register Now</button>
            </div>
        </form>
        <div class="text-center">Already have an account? <a href="#">Sign in</a></div>
    </div>
</main>
