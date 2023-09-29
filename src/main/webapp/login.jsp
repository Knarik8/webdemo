<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<html>
<head>
    <title>Login Form</title>

</head>
<body>
    <form action="/webdemo1/login" method="post">
        <input name="username" type="text" placeholder="Username"><br/><br/>
        <input name="password" type="password" placeholder="Password"><br/><br/>
        <input type="submit" value="Login">

    </form>
</body>
</html>

<html lang="en" dir="ltr">
  <head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title> Sign Up form</title>
    <link rel="stylesheet" href="style.css">
   </head>
<body>
  <div class="wrapper">
    <h2>Sign Up</h2>
    <form action="/webdemo1/login" method="post">
      <div class="input-box">
        <input name="email" type="text" placeholder="Enter your email" required>
      </div>
      <div class="input-box">
        <input name="password" type="password" placeholder="Enter your password" required>
      </div>
      <div class="input-box button">
        <input type="Submit" value="Sign Up">
      </div>
      <div class="text">
        <h3>Does not have an account? <a href="#">Register now</a></h3>
      </div>
    </form>
  </div>
</body>
</html>