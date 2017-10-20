<!DOCTYPE html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"></meta>
    <title>${title} | Web Checkers</title>
    <link rel="stylesheet" href="/css/registration.css">

</head>
<body>
<form action="/register" method="post">
    <div class="container">
        <label><b>Player Name</b></label>
        <input type="text" placeholder="Enter Your Name" name="PlayerName" required>


        <p>By creating an account you agree to our <a href="#">Terms & Privacy</a>.</p>

        <#if isTaken??>
            <label><b>Player Name is taken, try to enter different name  </b></label>

        </#if>
    <#if NONAME??>
        <label><b>Player Name is not written   </b></label>

    </#if>
        <div class="clearfix">
            <button type="button"  class="cancelbtn">Cancel</button>
            <button type="submit" class="signupbtn">Sign Up</button>
        </div>
        <script></script>
    </div>
</form>
</body>
</html>
