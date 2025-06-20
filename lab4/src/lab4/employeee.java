package lab4;

public class employeee {
	public void calculateSalary () {
		System.out.println("Base Salary: $3000");
	}
	
	public class manager extends employeee {
		@Override
		public void calculateSalary () {
			System.out.println("Manager Salary: $50	00 + Bonus");
		}
		
	public class developer extends employeee{
		@Override
		public void calculateSalary () {
			System.out.println("Developer Salary: $5000 + Project ALLowance");
		}
		
	}
	}
}
