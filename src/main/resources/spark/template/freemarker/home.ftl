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
</div>

<div class="main">
    <div class="container">
        <div class="skill-wrap clearfix">
            <div class="center wow fadeInDown">
                <h3>you login with : <#if playerName?? >${playerName}</#if></h3>
                <h2>Available Player to play with: </h2>
            </div>

            <div class="row">
                <#if playersList??>
                <#list playersList as player>
                    <#if (player != playerName) >
                        <div class="col-sm-3">
                            <div class="sinlge-skill wow fadeInDown" data-wow-duration="1000ms" data-wow-delay="300ms">
                                <div class="joomla-skill">
                                    <p><em>${player}</em></p>
                                    <p><a href="/game?OpponetPlayer=${player}">click to play</a></p>

                                </div>
                            </div>
                        </div>
                    </#if>


                </#list>
                </#if>


            </div>





        </div>

</div>
<#--<#include "footer.ftl">-->
</body>
</html>

