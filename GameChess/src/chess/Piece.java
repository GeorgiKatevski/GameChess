package chess;

public class Piece {
    private int x;
    private int y;
    private String image;
    private boolean isWhite;
    private Board board;

    public Piece(int x,int y,boolean isWhite,String image,Board board)
    {
        this.isWhite=isWhite;
        this.board=board;
        setX(x);
        setY(y);
        setImage(image);
    }

    public Board getBoard() {
        return board;
    }

    public boolean isWhite()
    {
         return isWhite;
    }
    public boolean isBlack()
        {
        return !isWhite;
        }
    public int getY() {
        return y;
    }

    public int getX() {
        return x;
    }

    public String getImage() {
        return image;
    }

    public void setY(int y) {
        if (y > 8 || y < 0) {
            this.y = 0;
        } else {
            this.y = y;
        }
    }

    public void setX(int x) {

        if (x > 8 || x < 0) {
            this.x = 0;
        } else {
            this.x = x;
        }
    }
    public void setImage(String image) {

     if(image!=null) {
         this.image = image;
     }
     }
     public boolean canMove(int X,int Y)
     {
        return false;
     }
}
