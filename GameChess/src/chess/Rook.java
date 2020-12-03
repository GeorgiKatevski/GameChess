package chess;

public class Rook extends Piece {

    public Rook(int x,int y,boolean isWhite,String image,Board board)
    {
        super(x,y,isWhite,image,board);
    }

    @Override

    public boolean canMove(int X ,int Y)
    {
        if(X!=getX() && Y!=getY())
        {
            return false;
        }
        else
        {
            if((X>getX() && Y==getY()) ) {
                int i = getX();
                while (i != X) {
                    i++;
                    Piece p = getBoard().getPiece(i, Y);
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
            else if((X==getX() && Y>getY()))
                {

                    int i=getY();
                    while(i!=Y) {
                        i++;
                        Piece p = getBoard().getPiece(X, i);

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
             else if ((X==getX() && Y<getY()))
            {

                int i=getY();
                while(i!=Y)
                {
                    i--;
                    Piece p=getBoard().getPiece(X,i);
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

                return true;
            }
             else if ((X<getX() && Y==getY()))
            {

                int i=getX();
                while(i!=X)
                {
                    i--;
                    Piece p=getBoard().getPiece(i,Y);
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


