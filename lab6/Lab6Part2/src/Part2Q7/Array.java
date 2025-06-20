package Part2Q7;

public class Array {
	private int[] numbers;

    public Array() {
        numbers = new int[]{45, 22, 89, 13, 67, 34};
    }

    public int findMax() {
        int max = numbers[0];
        for (int num : numbers) {
            if (num > max) {
                max = num;
            }
        }
        return max;
    }
}
