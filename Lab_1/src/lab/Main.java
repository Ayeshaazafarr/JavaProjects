package lab;

public class Main {

	public static void main(String[] args) {
	String name;
	int age;
	
	name="Ayesha ";
	age=26;
	
	Class_1 c1 = new Class_1();
	c1.displayinfo(name, age);
		c1.displayinfo("ali", 23);
		
	Rectangle r1 = new Rectangle();
	System.out.println("Area of Triangle is : "+r1.calculatearea()+"\n");
	
	calculator c2 = new calculator();
	System.out.println("Addition of two number is : "+c2.add(7, 7));
	System.out.println("Multiplication of two number is : "+c2.multiply(8 , 5)+"\n");
	
	Bank b1 = new Bank();
	System.out.println("balance : "+b1.balance);
	System.out.println("deposite : "+b1.add(539.2)+"\n");
	
	student s1 = new student();
	System.out.println(s1.name);
	s1.checkpass();
}
}
