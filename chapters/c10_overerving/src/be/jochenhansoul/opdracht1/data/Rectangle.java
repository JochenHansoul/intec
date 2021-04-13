package be.jochenhansoul.opdracht1.data;

public class Rectangle {
    private int height;
    private int width;
    private int x;
    private int y;
    // public/private/protected/- static abstract final void/datatype methodName(parameters) throws Exception

    public Rectangle(int height, int width, int x, int y) {
        this.height = height;
        this.width = width;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getHeight() {
        return height;
    }

    public int getWidth() {
        return width;
    }

    public int getX() {
        return x;    }

    public int getY() {
        return y;
    }

    public int circumference() {
        return 2 * (this.height + this.width);
    }

    public int area() {
        return height * width;
    }
}