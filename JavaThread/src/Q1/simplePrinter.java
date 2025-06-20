package Q1;
import java.time.*;
public class simplePrinter extends Thread {
	public void run() {
	for(int i = 0 ; i<=5 ; i++ ) {
		System.out.println("Hello From Thread");
		try {
			Thread.sleep(1000);
		} catch (Exception e ) {
			System.out.println("error");
		}
	}
	}}
