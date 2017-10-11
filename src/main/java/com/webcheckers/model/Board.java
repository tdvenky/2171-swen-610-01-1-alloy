package com.webcheckers.model;

import com.webcheckers.model.Row;

import java.lang.Iterable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Board implements Iterable {
   public List<Row> row = new ArrayList<Row>();
   // public Row[] row = new Row[8];
    //  Row row;
    public Board(){




    }

    @Override
    public Iterator iterator() {
        row.add( new Row(0));
        row.add( new Row(1));
        row.add( new Row(2));
        row.add( new Row(3));
        row.add( new Row(4));
        row.add( new Row(5));
        row.add( new Row(6));
        row.add( new Row(7));

        System.out.println("Board is created:"+ row.size());


        return row.iterator();
    }
}

