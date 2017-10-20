<!DOCTYPE html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"></meta>
    <title>${title} | Web Checkers</title>
    <link rel="stylesheet" href="/css/registration.css">

</head>
<body>
<form action="/signin" method="post">
    <div class="container">
        <label><b>Player Name</b></label>
        <input type="text" placeholder="Enter Your Name" name="PlayerName" required>

            <#if noExistUser??>

                <label><b> not exist, try to enter anther name or register  <a href="/register">Sign Up</a>    </b></label>

            </#if>
        <div class="clearfix">
            <button type="button"  class="cancelbtn">Cancel</button>
            <button type="submit" class="signupbtn">Sign In</button>
        </div>
        <script></script>
    </div>
</form>
</body>
</html>
