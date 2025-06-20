package Q2;

public class CharacterPrinter extends Thread{

public void run() {
	for ( char c = 'A' ; c<='E' ; c++) {
		System.out.println(c);
	
	try {
		Thread.sleep(1000);
	} catch (Exception e) {
		System.out.println("Error");
	}
}
}
}