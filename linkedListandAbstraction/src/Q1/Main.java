package Q1;
import java.util.LinkedList;
public class Main {

	public static void main(String[] args) {
		LinkedList<String> node = new LinkedList<String>();
		
		for (int i = 1 ; i<=9 ; i++) {
			node.add(String.valueOf(i));
		}
		node.addFirst("0");
		node.addLast("10");
		node.removeFirst();
		node.removeLast();
		System.out.println(node);
	}
}