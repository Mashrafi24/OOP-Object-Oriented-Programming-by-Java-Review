public class Circle extends Shape {
    private double radius;
    
    public Circle(String name, String color, double radius) {
        super(name, color);
        this.radius = radius;
    }
    
    // Step 3: Create getter method for radius
    public double getRadius() {
        return radius;
    }
    
    @Override
    public double area() {
        // Area of a circle = π * radius * radius
        return Math.PI * radius * radius;
    }
    
    @Override
    public double perimeter() {
        // Perimeter (circumference) of a circle = 2 * π * radius
        return 2 * Math.PI * radius;
    }
    
    @Override
    public String toString() {
        return super.toString() + ", Shape Type: Circle, Radius: " + radius;
    }
}