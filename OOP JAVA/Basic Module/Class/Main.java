import java.util.Scanner;


class Circle {
    private double radius;

                          //             constructor
    public Circle(double radius) {
        if (radius < 0) {
            throw new IllegalArgumentException("Radius cannot be negative.");
        }
        this.radius = radius;
    }

                 // method
    public double getArea() {
        return Math.PI * radius * radius;
    }

    
    public double getCircumference() {
        return 2 * Math.PI * radius;
    }

                       // getter for radius
    public double getRadius() {
        return radius;
    }

                    // setter for radius
    public void setRadius(double radius) {
        if (radius < 0) {
            throw new IllegalArgumentException("Radius cannot be negative.");
        }
        this.radius = radius;
    }
}

                   // Main class
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
          
            System.out.print("Enter radius of the circle: ");
            double radius = scanner.nextDouble();

           
            Circle circle = new Circle(radius);

            
            System.out.printf("Radius: %.2f%n", circle.getRadius());
            System.out.printf("Area: %.2f%n", circle.getArea());
            System.out.printf("Circumference: %.2f%n", circle.getCircumference());

        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Invalid input. Please enter a numeric value.");
        } finally {
            scanner.close();
        }
    }
}
