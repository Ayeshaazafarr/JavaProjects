package Part2Q9;

public class Array {
	private int[] numbers;

    public Array() {
        numbers = new int[]{12, 7, 9, 24, 18, 33, 40, 11, 6, 21};
    }

    public void printEvenNumbers() {
        System.out.println("Even numbers in the array:");
        for (int num : numbers) {
            if (num % 2 == 0) {
                System.out.print(num + " ");
            }
        }
        System.out.println();
    }
}