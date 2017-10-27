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
        // generating the space and the peacis on the space
        for (int i = 0; i < 8; i++)
        {
            if (index == 0 && i % 2 == 1 || index == 1 && i % 2 == 0 || index == 2 && i % 2 == 1)
            {
                space.add(new Space(i,true, new Piece(Piece.Type.SINGLE, Color.RED)));


            }

            else if ((index == 3 && i % 2 == 0) || (index == 4 && i % 2 == 1))
            {
                space.add(new Space(i,true, null));

            }

            else if (index == 6 && i % 2 == 1||(index == 7 && i % 2 == 0)||(index == 5 && i % 2 == 0))
            {
                space.add(new Space(i,true, new Piece(Piece.Type.SINGLE, Color.WHITE)));


            }
            else
            {
                space.add(new Space(i,false, null));

            }
        }




    }
    @Override
    public Iterator iterator() {


        return space.iterator();
    }
}
