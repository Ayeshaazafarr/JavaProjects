package Part2Q6;

public class Array {
    private int[] numbers;

    public Array() {
        numbers = new int[]{10, 20, 30, 40, 50};
    }

    public int calculateSum() {
        int sum = 0;
        for (int num : numbers) {
            sum += num;
        }
        return sum;
    }
}
