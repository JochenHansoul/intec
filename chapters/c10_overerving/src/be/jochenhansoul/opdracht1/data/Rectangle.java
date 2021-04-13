package be.jochenhansoul.opdracht1.date;

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

    public int circumference(int height, int width) {
        return 2 * this.height + this.width;
    }

    public int area() {
        return height * width;
    }
}