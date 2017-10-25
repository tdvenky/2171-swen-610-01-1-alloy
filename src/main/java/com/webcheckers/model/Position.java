package com.webcheckers.model;

public class Position {

    public int getRow() {
        return row;
    }

    public int getCell() {
        return cell;
    }

    private int row;
    private int cell;

    Position(int row,int cell ){
        this.row = row;
        this.cell = cell;
    }

    @Override
    public String toString() {
        return  "row "+row+"  -----"+" cell  "+cell;
    }
}
