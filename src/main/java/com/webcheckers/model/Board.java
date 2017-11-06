package com.webcheckers.model;

import java.lang.Iterable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Board implements Iterable {
   public List<Row> row = new ArrayList<Row>();
   // public Row[] row = new Row[8];
    //  Row row;
    public Board(){
        // generate the row of board
        for (int i = 0; i <8 ; i++) {
            row.add( new Row(i));

        }




    }

    @Override
    public Iterator iterator() {
        // Freemaker  can read the row list from html

        return row.iterator();
    }
}

