<!DOCTYPE html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"></meta>
    <meta http-equiv="refresh" content="10">
    <title>${title} | Web Checkers</title>
    <link rel="stylesheet" type="text/css" href="/css/home.css">
    <link href="css/bootstrap.min.css" rel="stylesheet">
    <link rel="stylesheet" href="css/font-awesome.min.css">
    <link href="css/animate.min.css" rel="stylesheet">
    <link href="css/prettyPhoto.css" rel="stylesheet">
    <link href="css/style1.css" rel="stylesheet">
    <link href="css/responsive.css" rel="stylesheet">
</head>
<body>
<div class="navbar">
    <a href="#home">Home</a>
    <a href="#news">News</a>
    <a href="#contact">Contact</a>
</div>

<div class="main">
    <div class="container">
        <div class="skill-wrap clearfix">
            <div class="center wow fadeInDown">
                <h2>Player List </h2>
                <p class="lead">Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut <br> et dolore magna aliqua. Ut enim ad minim veniam</p>
            </div>

            <div class="row">
                <#if playersList??>
                <#list playersList as player>

                        <div class="col-sm-3">
                            <div class="sinlge-skill wow fadeInDown" data-wow-duration="1000ms" data-wow-delay="300ms">
                                <div class="joomla-skill">
                                    <p><em>${player}</em></p>
                                    <p><a href="/game?OpponetPlayer=${player}">click to play</a></p>
                                </div>
                            </div>
                        </div>




                </#list>
                </#if>


            </div>





        </div>

</div>
<#--<#include "footer.ftl">-->
</body>
</html>

