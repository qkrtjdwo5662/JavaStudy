package oop1.ex;

public class RectangleMain {
    public static void main(String[] args) {
        Rectangle rectangle = new Rectangle();
        rectangle.width = 6;
        rectangle.height = 8;

        int area = rectangle.calculateArea();
        System.out.println(area);

        int perimeter = rectangle.calculatePerimeter();
        System.out.println(perimeter);

        boolean square = rectangle.isSquare();
        System.out.println(square);
    }
}
