package Part2Q8;

public class Array {
	private int[] numbers;

    public Array() {
        numbers = new int[]{5, 10, 15, 20, 25};
    }

    public void printReverse() {
        System.out.println("Array in reverse order:");
        for (int i = numbers.length - 1; i >= 0; i--) {
            System.out.print(numbers[i] + " ");
        }
        System.out.println();
    }
}
