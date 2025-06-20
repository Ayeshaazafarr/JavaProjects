package methodOverloading;

public class calcul {
	public int add (int a , int b ) {
		int res = 0 ;
		res = a+b;
		System.out.println("The answer is" + res);
		return res ; 
	}

	public int add ( int a , int b , int c ) {
		int res = 0 ; 
		res = a+b+c;
				System.out.println("The answer is " + res);
				return res ;
	}
}
