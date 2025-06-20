package Q1;

public class Vehicle {

	    String brand;

	    void startEngine() {
	        System.out.println("The vehicle engine starts.");
	    }
	}

	// Subclass
	class Car extends Vehicle {
	    void honk() {
	        System.out.println("The car honks");
	    }
	}

