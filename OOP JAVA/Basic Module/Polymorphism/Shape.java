
public class Shape {
    private String name;
    private String color;
    
    public Shape(String name, String color) {
        this.name = name;
        this.color = color;
    }
    
    public String getName() {
        return name;
    }
    
    public String getColor() {
        return color;
    }
    
    public double area() {
        return 0.0;
    }
    
    public double perimeter() {
        return 0.0;
    }
    
    @Override
    public String toString() {
        return "Shape: " + name + ", Color: " + color;
    }
}
