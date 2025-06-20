package Question1;
import java.util.ArrayList;

public class Main {

	public static void main(String[] args) {
		ArrayList<Employee> list = new ArrayList<>();
		
		list.add(new Employee(1 , "Shakeela" , 5000));
		list.add(new Employee(2 , "Farzeena" , 6000));
		list.add(new Employee (3 , "Rukhsana" , 7000));
		
		Employee maxEmp = list.get(0);
		for(Employee e : list) {
			if (e.salary >maxEmp.salary ) {
				maxEmp = e ;
				
			}
		}
		System.out.println("Highest Salary" +maxEmp.salary);
	}}
