package webcheckers.model;

public class Space {

    public int getCellIdx() {
        return cellIdx;
    }

    public boolean isValid() {
        return isValid;
    }

    public Piece getPiece() {
        return piece;
    }

     private int cellIdx;

     private   boolean isValid = true;

     private Piece piece;
  //  public List<Space> space = new ArrayList<Space>();


    Space(int cellIdx,boolean isValid,  Piece piece){

        this.cellIdx = cellIdx;
        this.isValid = isValid;
        this.piece = piece;

    }



}
