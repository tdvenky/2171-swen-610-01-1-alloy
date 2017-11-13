package com.webcheckers.model;

import java.lang.Iterable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Board implements Iterable {
   public List<Row> rows = new ArrayList<Row>();



    int removedRedPiece = 0;
    int removedWhitePiece = 0;

    //  Row rows;
    public Board(){
        // generate the rows of board
        for (int i = 0; i <8 ; i++) {
            rows.add( new Row(i));

        }




    }

    @Override
    public Iterator iterator() {
        // Freemaker  can read the rows list from html

        return rows.iterator();
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }


        if (!(obj instanceof Board)) {
            return false;
        }
        obj = (Board) obj;

        return this.rows == ((Board) obj).rows;

    }
    public int getRemovedRedPiece() {
        return removedRedPiece;
    }

    public int getRemovedWhitePiece() {
        return removedWhitePiece;
    }
}

