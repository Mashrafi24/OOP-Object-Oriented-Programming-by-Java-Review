// File: p1/A.java
package p1;
public class A {
   protected void display() {
       System.out.println("Protected method in A");
   }
}
// File: p2/B.java
package p2;
import p1.A;
public class B extends A {
   public static void main(String[] args) {
       B obj = new B();
       obj.display(); 
   }
}