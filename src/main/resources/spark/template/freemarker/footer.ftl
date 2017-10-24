<!DOCTYPE html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"></meta>
</head>
<body>
<footer id="site-footer" class="site-footer">
    <!-- social networks -->
    <div class="contact">
        <ul class="socials">
            <li><a class="circ-btn" href="http://facebook.com/highhay"><i class="icon ion-social-facebook"></i></a></li>
            <li><a class="circ-btn" href="http://twitter.com/miradontsoa"><i class="icon ion-social-twitter"></i></a></li>
        </ul>
    </div>

    <!-- Notes -->
    <div class="note">
        <p>Website by Highhay contact@highhay.com</p>
        <p>© Copyright <a href="http://highhay.com"><span class="marked">MiVFX</span></a> 2017</p>
    </div>

    <!-- subscription form -->
    <div class="subscription">
        <h3 class="title">Subscribe to<br> Newsletter</h3>
        <!-- Begin Ajax subscription form  subscription-form -->
        <form id="subscription-form" class="form send_email_form" method="post" action="ajaxserver/serverfile.php">
            <p class="feedback gone form-success-visible">Thank you for your subscription. We will inform you.</p>
            <input id="reg-email" class="input form-success-invisible" name="email" type="email" required="" placeholder="your@email.address" data-validation-type="email">
            <button id="submit-email" class="btn circ-btn form-success-invisible" name="submit_email">
                <span class="ion-checkmark"></span>
            </button>
        </form>

    </div>



</footer>

</body>
</html>
