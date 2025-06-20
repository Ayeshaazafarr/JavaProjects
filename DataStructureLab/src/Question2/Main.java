package Question2;

public class Main {
    public static void main(String[] args) {
        Reverse list = new Reverse();

        list.inputNumbers();

        System.out.print("Original list: ");
        list.showList();

        list.reverseList();

        System.out.print("Reversed list: ");
        list.showList();
    }
}

