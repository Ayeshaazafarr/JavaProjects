package Q4;

public class Rectangle extends Shape {
    double width, height;

    public Rectangle(double w, double h) {
        width = w;
        height = h;
    }

    public double getArea() {
        return width * height;
    }
}
