package webcheckers.model;

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

    @Override
    public String toString() {
        return "start : "+start.toString()+" end : "+end.toString();
    }
}
