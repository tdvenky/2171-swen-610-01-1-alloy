/**
 * This module exports the PendingMoveState class constructor.
 * 
 * This component is an concrete implementation of a state
 * for the Game view; this state represents the view state
 * in which the player has requested a move and is waiting
 * for server validation.
 */
define(function(require){
  'use strict';
  
  // imports
  var GameConstants = require('GameConstants');

  /**
   * Constructor function.
   * 
   * @param {GameView} view
   *    The Game view object.
   */
  var PendingMoveState = function(view) {
    // public (internal) methods
    this.getView = function() {
      return view;
    };
  };

  //
  // Public (external) methods
  //
    function getParameterByName(name, url) {
        if (!url) url = window.location.href;
        name = name.replace(/[\[\]]/g, "\\$&");
        var regex = new RegExp("[?&]" + name + "(=([^&#]*)|&|#|$)"),
            results = regex.exec(url);
        if (!results) return null;
        if (!results[2]) return '';
        return decodeURIComponent(results[2].replace(/\+/g, " "));
    }
  /**
   * Get the name of this state.
   */
  PendingMoveState.prototype.getName = function getName() {
    return GameConstants.PENDING_MOVE;
  }
  
  /**
   * Hook when entering this state.
   */
  PendingMoveState.prototype.onEntry = function onEntry() {
    var view = this.getView();
    var move = view.getPendingMove();
    // 1) disable all controls
    view.disableAllControls();
    // 2) disable all Pieces
    view.disableAllMyPieces();
    // 3) ask the server to validate the pending move
    function handleMoveResponse(message, textStatus, jqXHR) {
      view.displayMessage(message);
      if (message.type === 'error') {
        view.resetPendingMove();
        view.setState(view.isTurnActive() ? GameConstants.STABLE_TURN : GameConstants.EMPTY_TURN);
      }
      else {
        view.addPendingMove();
        view.setState(GameConstants.STABLE_TURN);
      }
    }

      var obj = { "move":move, "OpponetPlayer":getParameterByName("OpponetPlayer",window.location.href)};
    jQuery.post('/validateMove', JSON.stringify(obj), handleMoveResponse, 'json');
  }

  // export class constructor
  return PendingMoveState;
  
});
