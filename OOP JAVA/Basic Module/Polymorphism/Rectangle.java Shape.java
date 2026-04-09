public class Rectangle extends Shape {
    private double length;
    private double width;
    
    public Rectangle(String name, String color, double length, double width) {
        super(name, color);
        this.length = length;
        this.width = width;
    }
    
    public double getLength() {
        return length;
    }
    
    public double getWidth() {
        return width;
    }
    
    @Override
    public double area() {
        // Area of a rectangle = length * width
        return length * width;
    }
    
    @Override
    public double perimeter() {
        // Perimeter of a rectangle = 2 * (length + width)
        return 2 * (length + width);
    }
    
    @Override
    public String toString() {
        return super.toString() + ", Shape Type: Rectangle, Length: " + length + ", Width: " + width;
    }
}