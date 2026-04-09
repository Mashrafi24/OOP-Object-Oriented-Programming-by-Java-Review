
package p1;
public class Vehicle {
    protected int speed;
}


package p2;
import p1.Vehicle;
public class Bike extends Vehicle {
    void showSpeed() {
        speed = 100; 
        System.out.println(speed);
    }
}


package p2;
import p1.Vehicle;
public class Test {
    public static void main(String[] args) {
        Bike b = new Bike();
        b.showSpeed(); // prints 100

        Vehicle v = new Vehicle();
        
}