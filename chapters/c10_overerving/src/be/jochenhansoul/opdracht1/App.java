package be.jochenhansoul.opdracht1;

import be.jochenhansoul.opdracht1.data.Rectangle;
import be.jochenhansoul.opdracht1.data.Square;

public class App {
    public static void main(String[] args) {
        Rectangle rectangle = new Rectangle(10, 5, 1, 1);
        rectangle.setHeight(7);

        Square square = new Square(4, 10, 10);
        square.setHeight(5);

        System.out.println(square.getWidth());
        System.out.println("amount of rectangles: " + Rectangle.getAmount());
        System.out.println("amount of square: " + Square.getAmount());
    }
}
