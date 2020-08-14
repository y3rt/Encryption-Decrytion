abstract class Shape {

    abstract double getPerimeter();

    abstract double getArea();
}
class Triangle extends Shape {
    protected double a;
    protected double b;
    protected double c;

    public Triangle(double a, double b, double c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    @Override
    double getPerimeter() {
        return a + b + c;
    }

    @Override
    double getArea() {
        double s = getPerimeter() / 2;
        return Math.sqrt(s * ((s - a) * (s - b) * (s - c)));
    }
}

class Rectangle extends Shape {
    protected double a;
    protected double b;

    public Rectangle(double a, double b) {
        this.a = a;
        this.b = b;
    }

    @Override
    double getPerimeter() {
        return a * 2 + b * 2;
    }

    @Override
    double getArea() {
        return a * b;
    }
}

class Circle extends Shape {
    protected double radius;

    public Circle(double radius) {
        this.radius = radius;
    }

    @Override
    double getPerimeter() {
        return 2 * Math.PI * radius;
    }

    @Override
    double getArea() {
        return Math.PI * Math.pow(radius, 2);
    }
}
