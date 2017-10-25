package com.webcheckers.model;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Row implements Iterable {

    public List<Space> space = new ArrayList<Space>();
   // public Space space;

    public int getIndex() {
        return index;
    }

    private int index = 0;


    Row(int index){
        this.index = index;
        if (index == 0 || index == 2){
            space.add(new Space(0,false, null));
            space.add(new Space(1,true, new Piece(Piece.Type.SINGLE, Piece.Color.RED)));
            space.add(new Space(2,false, null));
            space.add(new Space(3,true, new Piece(Piece.Type.SINGLE, Piece.Color.RED)));
            space.add(new Space(4,false, null));
            space.add(new Space(5,true, new Piece(Piece.Type.SINGLE, Piece.Color.RED)));
            space.add(new Space(7,false, null));
            space.add(new Space(6,true, new Piece(Piece.Type.SINGLE, Piece.Color.RED)));

        }else if (index == 1){

            space.add(new Space(0,true, new Piece(Piece.Type.SINGLE, Piece.Color.RED)));
            space.add(new Space(1,false, null));

            space.add(new Space(2,true, new Piece(Piece.Type.SINGLE, Piece.Color.RED)));
            space.add(new Space(3,false, null));

            space.add(new Space(4,true, new Piece(Piece.Type.SINGLE, Piece.Color.RED)));
            space.add(new Space(5,false, null));

            space.add(new Space(6,true, new Piece(Piece.Type.SINGLE, Piece.Color.RED)));
            space.add(new Space(7,true, null));

        }else if (index == 3){

            space.add(new Space(0,true, null));
            space.add(new Space(1,false, null));
            space.add(new Space(2,true, null));
            space.add(new Space(3,false, null));
            space.add(new Space(4,true, null));
            space.add(new Space(5,false, null));
            space.add(new Space(7,true, null));
            space.add(new Space(6,false, null));

        }else if (index == 4){
            space.add(new Space(0,false, null));
            space.add(new Space(1,true, null));
            space.add(new Space(2,false, null));
            space.add(new Space(3,true, null));
            space.add(new Space(4,false, null));
            space.add(new Space(5,true, null));
            space.add(new Space(7,false, null));
            space.add(new Space(6,true, null));
        }else if (index == 5 || index == 7){

            space.add(new Space(0,true, new Piece(Piece.Type.SINGLE, Piece.Color.WHITE)));
            space.add(new Space(1,false, null));

            space.add(new Space(2,true, new Piece(Piece.Type.SINGLE, Piece.Color.WHITE)));
            space.add(new Space(3,false, null));

            space.add(new Space(4,true, new Piece(Piece.Type.SINGLE, Piece.Color.WHITE)));
            space.add(new Space(5,false, null));

            space.add(new Space(6,true, new Piece(Piece.Type.SINGLE, Piece.Color.WHITE)));
            space.add(new Space(7,true, null));

        }else if (index == 6){
            space.add(new Space(0,false, null));
            space.add(new Space(1,true, new Piece(Piece.Type.SINGLE, Piece.Color.WHITE)));

            space.add(new Space(2,false, null));
            space.add(new Space(3,true, new Piece(Piece.Type.SINGLE, Piece.Color.WHITE)));

            space.add(new Space(4,false, null));
            space.add(new Space(5,true, new Piece(Piece.Type.SINGLE, Piece.Color.WHITE)));

            space.add(new Space(6,true, null));
            space.add(new Space(7,true, new Piece(Piece.Type.SINGLE, Piece.Color.WHITE)));

        }



    }
    @Override
    public Iterator iterator() {
        System.out.println("ROWWWWWW" );


        return space.iterator();
    }
}
