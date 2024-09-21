<%--
  Created by IntelliJ IDEA.
  User: acer
  Date: 5/16/2024
  Time: 5:43 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login - Logistics System</title>
    <link rel="stylesheet"
          href="https://fonts.googleapis.com/css?family=Roboto:400,100,300,500,700,900|RobotoDraft:400,100,300,500,700,900"/>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.3.0/css/font-awesome.min.css">
    <link rel="stylesheet" href="${assets}/css/style.css">
</head>
<body>

<div class="pen-title">
    <h1>Logistics System</h1>
</div>

<!-- Form Module -->
<div class="module form-module">
    <div class="toggle" onclick="redirectToRegistration()">
        <i class="fa fa-user-plus" style="margin-top: 8px"></i>
        <span class="tooltip">Sign Up</span>
    </div>
    <!-- Login Form -->
    <div class="form loginForm visible">
        <h2>Login to your account</h2>
        <form action="j_security_check" method="post">
            <input type="text" placeholder="Username" name="j_username">
            <input type="password" placeholder="Password" name="j_password">
            <button type="submit">Login</button>
        </form>

    </div>
    <!-- Forgot Password Link -->
    <div class="cta">
        <a href="">Forgot your password?</a>
    </div>
</div>
<script>
    function redirectToRegistration() {
        window.location.href = "${BASE_URL}register";
    }
    function redirectToDashboard() {
        window.location.href = "${BASE_URL}dashboard";
    }
</script>
</body>
</html>
