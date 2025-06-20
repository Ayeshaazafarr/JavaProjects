package P1Q3;


	import java.util.Scanner;

	public class PowerCalculator {

	 
	    public void calculatePower() {
	        Scanner scanner = new Scanner(System.in);

	        
	        System.out.print("Enter the base number: ");
	        double base = scanner.nextDouble();

	        System.out.print("Enter the exponent: ");
	        double exponent = scanner.nextDouble();

	     
	        double result = Math.pow(base, exponent);

	        System.out.println(base + " raised to the power of " + exponent + " is " + result);

	        scanner.close();
	    }
	}


