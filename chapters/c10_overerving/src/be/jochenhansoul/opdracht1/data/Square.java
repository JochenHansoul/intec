package be.jochenhansoul.opdracht1.data;

public class Square extends Rectangle {

    public Square() {
        this(1);
    }

    public Square(int size) {
        this(size, 0, 0);
    }

    public Square(int size, int x, int y) {
        super(size, size, x, y);
    }

    @Override
    public void setHeight(int height) {
        setSize(height);
    }

    @Override
    public void setWidth(int width) {
        setSize(width);
    }

    public void setSize(int size) {
        super.setHeight(size);
        super.setWidth(size);
    }

}
