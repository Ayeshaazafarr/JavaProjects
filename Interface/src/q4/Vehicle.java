package q4;

interface Vehicle {
 void start();
}

class Car implements Vehicle {
 public void start() {
     System.out.println("Car is starting with a roar!");
 }
}

class Bike implements Vehicle {
 public void start() {
     System.out.println("Bike is starting with a vroom!");
 }
}

class Bus implements Vehicle {
 public void start() {
     System.out.println("Bus is starting with a heavy engine sound!");
 }
}

public class vehicle {
 public static void main(String[] args) {
     Vehicle car = new Car();
     Vehicle bike = new Bike();
     Vehicle bus = new Bus();

     car.start();   // Output: Car is starting with a roar!
     bike.start();  // Output: Bike is starting with a vroom!
     bus.start();   // Output: Bus is starting with a heavy engine sound!
 }
}
