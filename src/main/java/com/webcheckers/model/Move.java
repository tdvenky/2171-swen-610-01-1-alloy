package com.webcheckers.model;

public class Move {

    public Position getStrat() {
        return strat;
    }

    public Position getEnd() {
        return end;
    }

    Position strat;
    Position end;

    Move(Position strat, Position end ){

    }
}
