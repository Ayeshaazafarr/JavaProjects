package P1Q5;
import java.util.Scanner;

public class LargestNumberFinder {
	

	   
	    public void findLargestNumber() {
	        Scanner scanner = new Scanner(System.in);

	      
	        System.out.print("Enter the first integer: ");
	        int num1 = scanner.nextInt();

	        System.out.print("Enter the second integer: ");
	        int num2 = scanner.nextInt();

	        System.out.print("Enter the third integer: ");
	        int num3 = scanner.nextInt();

	    
	        int largest = Math.max(num1, Math.max(num2, num3));

	        
	        System.out.println("The largest number is: " + largest);

	        scanner.close();
	    }
	}


