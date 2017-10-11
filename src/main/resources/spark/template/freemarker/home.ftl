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

    <p align="center">Login to Web Checkers</p>
      <#if loginPlayers??>
          <#list loginPlayers as player>
             <p>${player.playerName}</p>
          </#list>
      </#if>


      <section class="container">
        <div class="login">
    <p align="center">Let's play Web Checkers</p>

    <section class="container">
        <div class="home">
            <button>Start Game</button>
          <form method="post" action="./login">
            <p align="center"><input type="text" name="login" value="" placeholder="Username"></p>
            <p align="center"><input type="password" name="password" value="" placeholder="Password"></p>
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
