package chess;

public class Pawn extends Piece {

    public Pawn(int x,int y,boolean isWhite,String image,Board board)
    {
        super(x,y,isWhite,image,board);
    }



    @Override
    public boolean canMove(int X,int Y) {

        if((isWhite()==true && Y==getY()+1 && X==getX()+1) || (isWhite()==true && Y==getY()+1 && X==getX()-1) )
        {
            Piece piece=getBoard().getPiece(X,Y);
            if(piece != null)
            {
                return true;
            }
        }
        if (isWhite()==true && Y == getY() + 1) {
            Piece piece=getBoard().getPiece(X,Y);
            if(piece != null)
            {
                return false;
            }
         else {
             return true;
         }
         }
        if(isBlack()==true && Y==getY()-1 && X==getX())
        {

            Piece piece=getBoard().getPiece(X,Y);
            if( piece != null)
            {
                return false;
            }
            else {
                return true;
            }
            }

        if((isBlack()==true && Y==getY()-1 && X==getX()+1) || (isBlack()==true && Y==getY()-1 && X==getX()-1) )
        {
            Piece piece=getBoard().getPiece(X,Y);
            if(piece != null)
            {
                return true;
            }
            else
            {
                return false;
            }
        }

        return false;
    }


}
