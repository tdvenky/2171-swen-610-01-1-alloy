package com.webcheckers.model;

public class Move {

    public Position getStart() {
        return start;
    }

    public Position getEnd() {
        return end;
    }

    Position start;
    Position end;

    Move(Position strat, Position end ){
     this.start = strat;
     this.end = end;
    }

    public int getMoveMagnitude()
    {

        return (int) Math
                .sqrt(Math.pow(start.getRow() - end.getRow(), 2) + Math.pow(start.getCell() - end.getCell(), 2));
    }

    @Override
    public String toString() {
        return "start : "+start.toString()+" end : "+end.toString();
    }
}
