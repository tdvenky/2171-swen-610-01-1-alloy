package com.webcheckers.model;

public class Piece {

    public Type getType() {
        return type;
    }

    public Color getColor() {
        return color;
    }

    public void setType(Type type) {
        this.type = type;
    }

    private Type type;
    private Color color;
    public enum Type {
        SINGLE, KING  //king will be created after a coin reaches the opponent ends
    }
    public enum Color {
        RED, WHITE
    }
    Piece(Type type,Color color){
        this.type = type;
        this.color = color;


    }
}

