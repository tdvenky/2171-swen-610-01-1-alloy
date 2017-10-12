<!DOCTYPE html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"></meta>
    <title>${title} | Web Checkers</title>
    <link rel="stylesheet" type="text/css" href="/css/style.css">
</head>
<body>
<div class="page">

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
                            <#if loginPlayers??>
                                <tr>
                                    <th>Logged in players</th>
                                </tr>
                                <tr>

                                    <#list loginPlayers as player>
                                        <td>${player.playerName}</td>
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