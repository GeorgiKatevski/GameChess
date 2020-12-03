package chess;

public class Bishop extends Piece{
    public Bishop(int x,int y,boolean isWhite,String image,Board board)
    {
        super(x,y,isWhite,image,board);
    }

    @Override
    public boolean canMove(int X,int Y)
    {
        if(X==getX() && Y!=getY() || X!=getX() && Y==getY() || X==getX()+2 && Y==getY()+1 || X==getX()-2 && Y==getY()-1 || X==getX()-2 && Y==getY()+1
        || X==getX()+2 && Y==getY()-1 || X==getX()+1 && Y==getY()+2 || X==getX()-1 && Y==getY()-2 || X==getX()-1 && Y==getY()+2 || X==getX()+1 && Y==getY()-2)
        {
            return false;
        }

        else
        {
            if((X>getX() && Y>getY()) ) {
                int i = getX();
                int j=getY();
                while (i != X && j!=Y) {
                    i++;
                    j++;
                    Piece p = getBoard().getPiece(i, j);
                    if (p != null) {
                        if (this.isWhite() && p.isWhite()) {
                            return false;
                        } else if (this.isBlack() && p.isBlack()) {
                            return false;
                        } else if (this.isWhite() && p.isBlack()) {
                            return true;
                        } else {
                            return true;
                        }

                    }
                    return true;

                }
            }
            else if((X<getX() && Y<getY()))
            {

                int i=getY();
                int j=getX();
                while(i!=Y && j!=X) {
                    i--;
                    j--;
                    Piece p = getBoard().getPiece(j, i);

                    if (p != null) {
                        if (isWhite() && p.isWhite()) {
                            return false;
                        } else if (this.isBlack() && p.isBlack()) {
                            return false;
                        } else if (this.isWhite() && p.isBlack()) {
                            return true;
                        } else {
                            return true;
                        }
                    }
                }

                return true;

            }
            else if ((X<getX() && Y>getY()))
            {

                int i=getY();
                int j=getX();
                while(i!=Y && j!=X)
                {
                    i++;
                    j--;
                    Piece p=getBoard().getPiece(j,i);
                    if(p!=null)
                    {
                        if (this.isWhite() && p.isWhite()) {
                            return false;
                        } else if (this.isBlack() && p.isBlack()) {
                            return false;
                        } else if (this.isWhite() && p.isBlack()) {
                            return true;
                        } else {
                            return true;
                        }
                    }

                }

                return true;
            }
            else if ((X>getX() && Y<getY()))
            {

                int i=getX();
                int j=getY();
                while(i!=X && j!=Y)
                {
                    i++;
                    j--;
                    Piece p=getBoard().getPiece(i,j);
                    if(p!=null)
                    {
                        if (isWhite() && p.isWhite()) {
                            return false;
                        } else if (this.isBlack() && p.isBlack()) {
                            return false;
                        } else if (this.isWhite() && p.isBlack()) {
                            return true;
                        } else {
                            return true;
                        }
                    }
                }
            }

            return true;



        }



    }

}
