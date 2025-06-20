package P1Q1;

import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a number to find its square root: ");
        double number = scanner.nextDouble();

       
        SquareRoot finder = new SquareRoot();

        
        double result = finder.findSquareRoot(number);

        System.out.println("The square root of " + number + " is " + result);

        scanner.close();
    }
}
