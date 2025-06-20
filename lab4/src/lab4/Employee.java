package lab4;

public class Employee {
	
	public double calculateBonus (int baseSalary) {
		return baseSalary*0.05;
	}

	public double calculateBonus (double baseSalary , int rating) {
		
		double bonus =0.0;
		if (rating == 5) {
			bonus = 0.02 ;	
		} else if(rating == 4) {
			bonus = 0.15;
		} else if (rating ==3) {
			bonus = 0.10 ;
		} else if (rating ==2) {
			bonus = 0.05 ;
		} else {
			System.out.println("SORRY APKO NO BONUS ");
			return 0.0;
		}
	}
}
