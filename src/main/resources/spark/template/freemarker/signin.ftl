<!DOCTYPE html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"></meta>
    <title>${title} | Web Checkers</title>
    <link rel="stylesheet" type="text/css" href="/css/registration.css">
</head>
<body>
<div class="wrapper">
    <div class="container">
        <h1>Welcome to Web checkers Game</h1>
    <#if noExistUser??>




    </#if>
        <form action="/signin" method="post">

            <input type="text" name="PlayerName"  placeholder="Username">
            <h4> Try to enter different Name or <br> You can  <a href='/register'>Sign Up</a> </h4>

            <button type="submit" required id="login-button">Login</button>
        </form>
    </div>


</div>


</body>
</html>