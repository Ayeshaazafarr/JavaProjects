package q1;
import java.util.Scanner; 

public class main {
 public static void main(String[] args) {
     Scanner scanner = new Scanner(System.in);

  
     System.out.print("Enter radius of the circle: ");
     double r = scanner.nextDouble();
     Circle c = new Circle(r);
     System.out.println("Area of Circle: " + c.area());

   
     System.out.print("Enter length of the rectangle: ");
     double l = scanner.nextDouble();
     System.out.print("Enter width of the rectangle: ");
     double w = scanner.nextDouble();
     Rectangle rect = new Rectangle(l, w);
     System.out.println("Area of Rectangle: " + rect.area());

     scanner.close();
 }
}
