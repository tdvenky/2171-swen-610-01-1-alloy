package com.webcheckers.model;

public class Piece {

    public Type getType() {
        return type;
    }

    public Color getColor() {
        return color;
    }

    private Type type;
    private Color color;
    public enum Type {
        SINGLE, KING
    }
    public enum Color {
        RED, WHITE
    }
    Piece(Type type,Color color){
        this.type = type;
        this.color = color;


    }
}

