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
    <title>Register - Logistics System</title>
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
    <div class="toggle" onclick="redirectToLogin()">
        <i class="fa fa-sign-in" style="margin-top: 8px"></i>
        <span class="tooltip">Login</span>
    </div>
    <!-- Registration Form -->
    <div class="form registerForm">
        <h2>Create an account</h2>
        <form id="registrationForm">
            <input type="text" id="name" placeholder="Name">
            <input type="password" id="password" placeholder="Password">
            <input type="email" id="email" placeholder="Email Address">
            <input type="tel" id="phoneNumber" placeholder="Phone Number">
            <button type="button" onclick="registerUser()">Register</button>
        </form>
    </div>

</div>
<script>
    function registerUser() {
        // Retrieve user input data
        const name = document.getElementById('name').value;
        const password = document.getElementById('password').value;
        const email = document.getElementById('email').value;
        const phoneNumber = document.getElementById('phoneNumber').value;

        // Create user object
        const user = {
            name: name,
            password: password,
            email: email,
            phoneNumber: phoneNumber,
            role: 2
        };

        // Send POST request to server
        fetch('${BASE_URL}user/register', {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify(user)
        })
            .then(response => {
                if (response.ok) {
                    // Registration successful
                    console.log('Registration successful');
                    window.location.href="${BASE_URL}web/login";
                } else {
                    // Registration failed
                    console.error('Registration failed');

                }
            })
            .catch(error => {
                console.error('Error:', error);
                // Handle network error
            });
    }
</script>
</body>
</html>
