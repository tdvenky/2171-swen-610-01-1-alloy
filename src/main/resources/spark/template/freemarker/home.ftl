<!DOCTYPE html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"></meta>
    <meta http-equiv="refresh" content="10">
    <title><#if title?? >${title} </#if>| Web Checkers</title>
    <link rel="stylesheet" type="text/css" href="/css/home.css">
    <link href="css/style1.css" rel="stylesheet">
    <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.3/umd/popper.min.js" integrity="sha384-vFJXuSJphROIrBnz7yo7oB41mKfc8JzQZiCq4NCceLEaO4IHwicKwpJf9c9IpFgh" crossorigin="anonymous"></script>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta.2/css/bootstrap.min.css" integrity="sha384-PsH8R72JQ3SOdhVi3uxftmaW6Vc51MKb0q5P2rRUpPvrszuE4W1povHYgTpBfshb" crossorigin="anonymous">

</head>
<body>
<div class="navbar">
    <a href="/">Home</a>
    <a href="/signout">sign out </a>

</div>

<div class="main">
    <div class="container">
            <div class="center wow fadeInDown">
                <h3>you login with : <#if playerName?? >${playerName}</#if></h3>
                <h2>Available Player to play with: </h2>
                <div class="card-deck">

                <#if playersList??>
                <#list playersList as player>
                    <#if (player?lower_case  != playerName?lower_case ) >
                    <div class="card" style="width: 10rem; ">

                        <div class="card-block">
                                <h3 class="card-title" style="text-align: center;">  ${player} </h3>

                            <a href="/game?OpponetPlayer=${player}" class="btn btn-primary"> play with me !!</a>
                        </div>
                    </div>

                    </#if>


                </#list>
                </#if>

            </div>
            </div>

      <#--this is the second section for ppl who win -->
            <div class="skill-wrap clearfix">
                <div class="center wow fadeInDown">
                    <h2> Played Games: </h2>
                </div>

                <div class="card-deck">
             <#if playedGames??>
                 <#list playedGames as games>
                 <div class="card" style="width: 10rem; ">

                     <div class="card-block">
                        <h3 class="card-title" style="text-align: center;">  Win </h3>
                        <p class="card-text">${games}.</p>

                    </div>
                 </div>
                </#list>
                </#if >
                </div>

</div>
    </div></div>


</body>
</html>

