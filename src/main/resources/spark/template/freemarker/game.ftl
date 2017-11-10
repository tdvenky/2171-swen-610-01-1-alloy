<!DOCTYPE html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"></meta>
    <title>${title} | Web Checkers</title>
    <link rel="stylesheet" href="/css/style.css">
    <link rel="stylesheet" href="/css/game.css">

    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
    <script>
        window.gameState = {
            'player' : {
                'name' : '${playerName}',
                'color' : '${playerColor}',
                'isMyTurn' : ${isMyTurn?c}
            },
            'opponent' : {
                'name' : '${opponentName}',
                'color' : '${opponentColor}',
                'isMyTurn' : ${(!isMyTurn)?c}
            }
        };
    </script>
</head>
<body>
<div class="page">
    <h1>Web Checkers</h1>

    <div class="navigation">
        <a href="/signout">sign out </a>
    </div>

    <div class="body">
        <form id="gameForm" action="/submitTurn" method="POST">

            <p>
                You are playing a game of checkers with ${opponentName}.
            <#if isMyTurn>
                It's your turn.  Move your piece and click the Submit link.
                If you want to erase your move click the Reset link.
            <#else>
                It's ${opponentName}'s turn.  The page will refresh periodically
                and you will be informed when it is your turn.
            </#if>

                <#if GameID??> game id is ${GameID} </#if>
            </p>

            <div>
                <div id="game-controls">

                    <fieldset id="game-info">
                        <legend>Info</legend>

                    <#if message??>
                        <div id="message" class="${message.type}">${message.text}</div>
                    <#else>
                        <div id="message" class="info" style="display:none">
                            <!-- keep here for Client-side messages -->
                        </div>
                    </#if>

                        <div>
                            <table data-color='RED'>
                                <tr>
                                    <td><img src="../img/single-piece-red.svg" /></td>
                                    <td class="name">Red</td>
                                </tr>
                            </table>
                            <table data-color='WHITE'>
                                <tr>
                                    <td><img src="../img/single-piece-white.svg" /></td>
                                    <td class="name">White</td>
                                </tr>
                            </table>
                        </div>
                    </fieldset>

                    <fieldset id="game-toolbar">
                        <legend>Controls</legend>
                        <div class="toolbar">
                            <a href="#" id="backupLink"
                               title="Remove the last move with your current turn.">
                                Backup one move
                            </a>
                            <a href="#" id="resetLink"
                               title="Remove all moves within your current turn.">
                                Reset turn
                            </a>
                            <a href="#" id="submitLink"
                               title="Commit your current turn to the server.">
                                Submit turn
                            </a>
                            <a href="#" id="resignLink"
                               title="End the game by resigning.">
                                Resign from game
                            </a>
                        </div>
                    </fieldset>

                </div>

                <div class="game-board <#if rotate??>${rotate}</#if> ">
                    <table id="game-board">
                        <tbody>
                        <#list board.iterator() as row>
                        <tr data-row="${row.index}">
                          <#list row.iterator() as space>
                              <td data-cell="${space.cellIdx}"
                                <#if space.isValid() >
                                  class="Space"
                                </#if>>
                                <#if space.piece??>
                                    <div class="Piece <#if rotate??>${rotate}</#if>"
                                         id="piece-${row.index}-${space.cellIdx}"
                                         data-type="${space.piece.type}"
                                         data-color="${space.piece.color}">
                                    </div>
                                </#if>
                              </td>
                          </#list>
                        </tr>
                        </#list>
                        </tbody>
                    </table>
                </div>
            </div>

        </form>
    </div>
</div>

<audio id="audio" src="http://www.soundjay.com/button/beep-07.mp3" autostart="false" ></audio>

<script data-main="js/game/index" src="js/require.js"></script>

</body>
</html>
