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
    <#if isTaken??>
        <label><b>Player Name is taken, try to enter different name  </b></label>

    </#if>
    <#if NONAME??>
        <label><b>Player Name is not written   </b></label>

    </#if>
        <form action="/register" method="post">

            <input type="text" required name="PlayerName"  placeholder="Username">
            <button type="submit" id="login-button">Sign Up</button>
        </form>
    </div>


</div>


</body>
</html>