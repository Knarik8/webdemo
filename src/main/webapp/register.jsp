<%@ page contentType="text/html;charset=UTF-8" language="java"%>

<html lang="en" dir="ltr">
  <head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title> Registration or Sign Up form in HTML CSS | CodingLab </title>
    <link rel="stylesheet" href="style.css">
   </head>
<body>
  <div class="wrapper">
    <h2>Registration</h2>
    <form action="/webdemo1/register" method="post">
      <div class="input-box">
        <input name="name" type="name" placeholder="Enter your name" required>
      </div>
      <div class="input-box">
        <input name="email" type="text" placeholder="Enter your email" required>
      </div>
      <div class="input-box">
        <input name="password" type="password" placeholder="Create password" required>
      </div>
      <div class="input-box">
        <input name="confirmPassword" type="confirmPassword" placeholder="Confirm password" required>
      </div>
      <div class="policy">
        <input type="checkbox">
        <h3>I accept all terms & condition</h3>
      </div>
      <div class="input-box button">
        <input type="Submit" value="Register">
      </div>
      <div class="text">
        <h3>Already have an account? <a href="#">Login now</a></h3>
      </div>
    </form>
  </div>
</body>
</html>