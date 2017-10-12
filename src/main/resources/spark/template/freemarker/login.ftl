<!DOCTYPE html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"></meta>
    <link rel="stylesheet" type="text/css" href="/css/style.css">
</head>
<body>
  <div class="page">

  <div class="body">
        <h1 align="center">Welcome to the world of online Checkers</h1>
      </div>

    <p align="center">Login to Web Checkers</p>

    <section class="container">
        <div class="login">
          <form method="post" action="./validateUsername">

            <p align="center"><input type="text" name="login" value=" <#if playNmae??>${playNmae}</#if>" placeholder="Username"></p>
            <p align="center">
            <#if loginPlayers??>
                <select name="opponentList">
                    <option value="opponent">Select an opponent</option>
                          <#list loginPlayers as player>
                              <option value=${player.playerName}>${player.playerName}</option>
                          </#list>

                </select>
            </#if>
            </p>
          <#if errorMessage??>
              <p align ="center"> ${errorMessage}</p>
          </#if>
            <p align="center" class="submit"><input type="submit" name="commit" value="Login"></p>
          </form>
        </div>
      </section>
  </div>
</body>
</html>