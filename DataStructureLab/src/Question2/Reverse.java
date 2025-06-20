package Question2;
import java.util.ArrayList;
import java.util.Scanner;

public class Reverse {
    ArrayList<Integer> numbers = new ArrayList<>();

    void inputNumbers() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter 5 integers:");
        for (int i = 0; i < 5; i++) {
            numbers.add(sc.nextInt());
        }
    }

    void showList() {
        System.out.println(numbers);
    }

    void reverseList() {
        int n = numbers.size();
        for (int i = 0; i < n / 2; i++) {
            int temp = numbers.get(i);
            numbers.set(i, numbers.get(n - 1 - i));
            numbers.set(n - 1 - i, temp);
        }
    }
}

