package chess;

import java.awt.Graphics2D;

interface DrawingShape {
    boolean contains(Graphics2D var1, double var2, double var4);

    void adjustPosition(double var1, double var3);

    void draw(Graphics2D var1);
}