<!DOCTYPE html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"></meta>
    <meta http-equiv="refresh" content="10">
    <title>${title} | Web Checkers</title>
    <link rel="stylesheet" type="text/css" href="/css/style.css">
</head>
<body>
<div class="page">
    <div class="navigation">
        <a href="/"><#if playerName??>${playerName}'s<#else>my</#if> home</a>
    <#if playerName??>
        <a href="/signout">Sign Out</a>
    </#if>
        <a href="/signin">Sign In</a>

        <a href="/register">Sign Up</a>
    </div>

    <div class="body">
        <h1 align="center">Welcome to the world of online Checkers</h1>
    </div>

    <section class="container">
        <div class="login">
            <p align="center">Let's play Web Checkers</p>

            <section class="container">
                <table id="allUserNameTable" cellpadding="20px">
                    <tr>
                        <td><form action="./login" method="get">
                            <button type="submit" align="center" id="startButton" style="font-size: larger">Start Game</button>
                        </form></td>
                        <td>
                            <table border="0.5" id="allUserNames">
                            <#if playersList??>
                                <tr>
                                    <th>Logged in players</th>
                                </tr>
                                <tr>

                                    <#list playersList as player>
                                        <#if !(player == playerName )>
                                        <td><a href="/game?OpponetPlayer=${player}">${player}</a></td>
                                        </#if>
                                    </#list>
                                </tr>
                            </#if>
                            </table>
                        </td>
                    </tr>
                </table>
</div>
</body>
</html>