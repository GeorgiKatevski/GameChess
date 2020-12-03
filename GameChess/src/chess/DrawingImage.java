package chess;

import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.geom.Rectangle2D;
import java.awt.image.ImageObserver;

class DrawingImage implements DrawingShape {
    public Image image;
    public Rectangle2D rect;

    public DrawingImage(Image image, Rectangle2D rect) {
        this.image = image;
        this.rect = rect;
    }

    public boolean contains(Graphics2D g2, double x, double y) {
        return this.rect.contains(x, y);
    }

    public void adjustPosition(double dx, double dy) {
        this.rect.setRect(this.rect.getX() + dx, this.rect.getY() + dy, this.rect.getWidth(), this.rect.getHeight());
    }

    
    public void draw(Graphics2D g2) {
        Rectangle2D bounds = this.rect.getBounds2D();
        g2.drawImage(this.image, (int)bounds.getMinX(), (int)bounds.getMinY(), (int)bounds.getMaxX(), (int)bounds.getMaxY(), 0, 0, this.image.getWidth((ImageObserver)null), this.image.getHeight((ImageObserver)null), (ImageObserver)null);
    }
}
