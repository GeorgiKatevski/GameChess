package chess;

public class King extends Piece {
    public King(int x, int y, boolean isWhite, String image, Board board) {
        super(x, y, isWhite, image, board);
    }


    @Override
    public boolean canMove(int X, int Y) {

        if ((X == getX() + 1 && Y == getY() + 1) || (X == getX() - 1 && Y == getY() - 1) || (X == getX() + 1 && Y == getY() - 1) || (X == getX() - 1 && Y == getY() + 1)
                || (X == getX() && Y == getY() + 1) || (X == getX() && Y == getY() - 1) || (X == getX() + 1 && Y == getY()) || (X == getX() - 1 && Y == getY())) {
            Piece p = getBoard().getPiece(X, Y);
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
            else
                {
                return true;
            }


            //  return true;

        }

return false;
    }
}