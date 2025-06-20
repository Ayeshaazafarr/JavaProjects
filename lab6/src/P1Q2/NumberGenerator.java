package P1Q2;

import java.util.Scanner;

public class NumberGenerator {

    
    public void printNumbers() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter 5 numbers:");

        int[] numbers = new int[5];
        
        
        for (int i = 0; i < 5; i++) {
            System.out.print("Number " + (i + 1) + ": ");
            numbers[i] = scanner.nextInt();
        }

        
        System.out.println("Here are the 5 numbers:");
        for (int i = 0; i < 5; i++) {
            System.out.println("Number " + (i + 1) + ": " + numbers[i]);
        }
        
        scanner.close();
    }
}
