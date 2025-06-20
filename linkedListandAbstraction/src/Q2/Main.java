package Q2;

import java.util.LinkedList;

public class Main {

	public static void main(String[] args) {
LinkedList<String> node = new LinkedList<String>();
		
		for (int i = 1 ; i<=9 ; i++) {
			node.add(String.valueOf(i));
		}
		;
		node.removeFirst();
		node.removeLast();
		node.remove(5);
		System.out.println(node);

	}

}
