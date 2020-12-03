package chess;

import java.awt.*;
import java.awt.event.*;
import java.awt.geom.*;
import java.awt.image.*;
import java.io.*;
import java.util.*;
import javax.imageio.*;
import javax.swing.*;

public class Board extends JComponent {


    public ArrayList<Piece> whitePieces;
    public ArrayList<Piece> blackPieces;

    public ArrayList<DrawingShape> staticShapes;
    public ArrayList<DrawingImage> pieceGraphics;

    private final int rows = 8;

    private final int cols = 8;

    private Integer[][] BoardGrid;

    public void initGrid() {
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                BoardGrid[i][j] = 0;
            }
        }

        whitePieces.add(new King(4, 0, true, "zwF4Lyn.png", this));
        whitePieces.add(new Queen(3, 0, true, "Carica.png", this));
        whitePieces.add(new Bishop(2, 0, true, "Oficer.png", this));
        whitePieces.add(new Bishop(5, 0, true, "Oficer.png", this));
        whitePieces.add(new Knight(1, 0, true, "Kon2.png", this));
        whitePieces.add(new Knight(6, 0, true, "Kon2.png", this));
        whitePieces.add(new Rook(0, 0, true, "bishop3.png", this));
        whitePieces.add(new Rook(7, 0, true, "bishop3.png", this));
        whitePieces.add(new Pawn(0, 1, true, "peshka.png", this));
        whitePieces.add(new Pawn(1, 1, true, "peshka.png", this));
        whitePieces.add(new Pawn(2, 1, true, "peshka.png", this));
        whitePieces.add(new Pawn(3, 1, true, "peshka.png", this));
        whitePieces.add(new Pawn(4, 1, true, "peshka.png", this));
        whitePieces.add(new Pawn(5, 1, true, "peshka.png", this));
        whitePieces.add(new Pawn(6, 1, true, "peshka.png", this));
        whitePieces.add(new Pawn(7, 1, true, "peshka.png", this));

        blackPieces.add(new King(3, 7, false, "car.png", this));
        blackPieces.add(new Queen(4, 7, false, "carica.png", this));
        blackPieces.add(new Bishop(2, 7, false, "zwF4Lyn.png", this));
        blackPieces.add(new Bishop(5, 7, false, "zwF4Lyn.png", this));
        blackPieces.add(new Knight(1, 7, false, "kon.png", this));
        blackPieces.add(new Knight(6, 7, false, "kon.png", this));
        blackPieces.add(new Rook(0, 7, false, "Bishop.png", this));
        blackPieces.add(new Rook(7, 7, false, "Bishop.png", this));
        blackPieces.add(new Pawn(0, 6, false, "peshka.png", this));
        blackPieces.add(new Pawn(1, 6, false, "peshka.png", this));
        blackPieces.add(new Pawn(2, 6, false, "peshka.png", this));
        blackPieces.add(new Pawn(3, 6, false, "peshka.png", this));
        blackPieces.add(new Pawn(4, 6, false, "peshka.png", this));
        blackPieces.add(new Pawn(5, 6, false, "peshka.png", this));
        blackPieces.add(new Pawn(6, 6, false, "peshka.png", this));
        blackPieces.add(new Pawn(7, 6, false, "peshka.png", this));

    }
    public Piece getPiece(int x, int y) {
        for (Piece p : whitePieces)
        {
            if (p.getX() == x && p.getY() == y)
            {
                return p;
            }
        }
        for (Piece p : blackPieces)
        {
            if (p.getX() == x && p.getY() == y)
            {
                return p;
            }
        }
        return null;
    }


    private int turnCounter=0;
    private MouseAdapter mouseAdapter = new MouseAdapter() {

        @Override
        public void mouseClicked(MouseEvent e) {


        }

        @Override
        public void mousePressed(MouseEvent e) {
            int d_X = e.getX();
            int d_Y = e.getY();
            int Clicked_Row = d_Y / 67;
            int Clicked_Column = d_X / 67;
            boolean is_whites_turn = true;
            if (turnCounter%2 == 1)
            {
                is_whites_turn = false;
            }

            Piece clicked_piece = getPiece(Clicked_Column, Clicked_Row);

            if (Active_Piece == null && clicked_piece != null &&
                    ((is_whites_turn && clicked_piece.isWhite()) || (!is_whites_turn && clicked_piece.isBlack())))
            {
                Active_Piece = clicked_piece;
            }
            else if (Active_Piece != null && Active_Piece.getX() == Clicked_Column && Active_Piece.getY() == Clicked_Row)
            {
                Active_Piece = null;
            }
            else if (Active_Piece != null && Active_Piece.canMove(Clicked_Column, Clicked_Row)
                    && ((is_whites_turn && Active_Piece.isWhite()) || (!is_whites_turn && Active_Piece.isBlack())))
            {
                // if piece is there, remove it so we can be there
                if (clicked_piece != null)
                {
                    if (clicked_piece.isWhite())
                    {
                        whitePieces.remove(clicked_piece);
                    }
                    else
                    {
                        blackPieces.remove(clicked_piece);
                    }
                }
                // do move
                Active_Piece.setX(Clicked_Column);
                Active_Piece.setY(Clicked_Row);

                // if piece is a pawn set has_moved to true
                if (Active_Piece.getClass().equals(Pawn.class))
                {
                    Pawn castedPawn = (Pawn)(Active_Piece);
                    //    castedPawn.setHasMoved(true);
                }


                Active_Piece = null;
                turnCounter++;
            }

            drawBoard();
        }

        @Override
        public void mouseDragged(MouseEvent e) {
        }

        @Override
        public void mouseReleased(MouseEvent e) {
        }

        @Override
        public void mouseWheelMoved(MouseWheelEvent e)
        {
        }


    };
    public Board() {
        BoardGrid = new Integer[rows][cols];
        staticShapes = new ArrayList();
        pieceGraphics = new ArrayList();

        blackPieces = new ArrayList();

        whitePieces = new ArrayList();


         initGrid();
        this.setBackground(new Color(37, 13, 84));
        this.setPreferredSize(new Dimension(520, 520));
        this.setMinimumSize(new Dimension(100, 100));
        this.setMaximumSize(new Dimension(1000, 1000));

         this.addMouseListener(mouseAdapter);
        this.addComponentListener(componentAdapter);
        this.addKeyListener(keyAdapter);


        this.setVisible(true);
        this.requestFocus();


        drawBoard();

    }

    private static Image NULL_IMAGE = new BufferedImage(10, 10, BufferedImage.TYPE_INT_ARGB);

    private Image loadImage(String imageFile) {
        try {
            return ImageIO.read(new File(imageFile));
        } catch (IOException e) {
            return NULL_IMAGE;
        }
    }
    public Piece Active_Piece;
    public void drawBoard() {
        pieceGraphics.clear();
        staticShapes.clear();

        Image board = loadImage("src" + File.separator + "chess/BoardChess.jpg");
        staticShapes.add(new DrawingImage(board, new Rectangle2D.Double(0, 0, board.getWidth(null), board.getHeight(null))));



      //  initGrid();
        for (int i = 0; i < whitePieces.size(); i++) {
            int COL = whitePieces.get(i).getX();
            int ROW = whitePieces.get(i).getY();
            Image piece = loadImage("src" + File.separator + "chess/Images" + File.separator + "White" + File.separator + whitePieces.get(i).getImage());
            pieceGraphics.add(new DrawingImage(piece, new Rectangle2D.Double(67 * COL, 67 * ROW, piece.getWidth(null), piece.getHeight(null))));
        }

        for (int i = 0; i < blackPieces.size(); i++) {
            int COL = blackPieces.get(i).getX();
            int ROW = blackPieces.get(i).getY();
            Image piece = loadImage("src" + File.separator + "chess/Images" + File.separator + "Black" + File.separator + blackPieces.get(i).getImage());
            pieceGraphics.add(new DrawingImage(piece, new Rectangle2D.Double(67 * COL, 67 * ROW, piece.getWidth(null), piece.getHeight(null))));
        }

        this.repaint();
    }


    private void adjustShapePositions(double dx, double dy) {

        staticShapes.get(0).adjustPosition(dx, dy);
        this.repaint();

    }

    @Override
    protected void paintComponent(Graphics g) {

        super.paintComponent(g);

        Graphics2D g2 = (Graphics2D) g;
        drawBackground(g2);
        drawShapes(g2);
    }

    private void drawBackground(Graphics2D g2) {
        g2.setColor(getBackground());
        g2.fillRect(0, 0, getWidth(), getHeight());
    }


    private void drawShapes(Graphics2D g2) {
        for (DrawingShape shape : staticShapes) {
            shape.draw(g2);
        }
       for (DrawingShape shape : pieceGraphics) {
            shape.draw(g2);
        }
    }

    private ComponentAdapter componentAdapter = new ComponentAdapter() {

        @Override
        public void componentHidden(ComponentEvent e) {

        }

        @Override
        public void componentMoved(ComponentEvent e) {

        }

        @Override
        public void componentResized(ComponentEvent e) {

        }

        @Override
        public void componentShown(ComponentEvent e) {

        }
    };

    private KeyAdapter keyAdapter = new KeyAdapter() {

        @Override
        public void keyPressed(KeyEvent e) {

        }

        @Override
        public void keyReleased(KeyEvent e) {

        }

        @Override
        public void keyTyped(KeyEvent e) {

        }


    };

















}
