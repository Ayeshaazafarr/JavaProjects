package q3;

import java.util.Scanner;

interface Operations {
 void add(double a, double b);
 void subtract(double a, double b);
 void multiply(double a, double b);
 void divide(double a, double b);
}

class Calculator implements Operations {
 public void add(double a, double b) {
     System.out.println("Addition: " + (a + b));
 }

 public void subtract(double a, double b) {
     System.out.println("Subtraction: " + (a - b));
 }

 public void multiply(double a, double b) {
     System.out.println("Multiplication: " + (a * b));
 }

 public void divide(double a, double b) {
     if (b != 0) {
         System.out.println("Division: " + (a / b));
     } else {
         System.out.println("Error: Division by zero is not allowed.");
     }
 }
}

public class operations {
 public static void main(String[] args) {
     Scanner scanner = new Scanner(System.in);
     Calculator calc = new Calculator();

     System.out.print("Enter first number: ");
     double num1 = scanner.nextDouble();

     System.out.print("Enter second number: ");
     double num2 = scanner.nextDouble();

     // Performing all operations
     calc.add(num1, num2);
     calc.subtract(num1, num2);
     calc.multiply(num1, num2);
     calc.divide(num1, num2);

     scanner.close();
 }
}
