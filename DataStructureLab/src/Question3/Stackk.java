package Question3;
import java.util.Stack;

public class Stackk {
    Stack<String> books = new Stack<>();

    void pushBooks() {
        books.push("Book 1");
        books.push("Book 2");
        books.push("Book 3");
        books.push("Book 4");
        books.push("Book 5");
    }

    void popBooks() {
        System.out.println("Removed books:");
        System.out.println(books.pop());
        System.out.println(books.pop());
    }

    void showBooks() {
        System.out.println("\nBooks left in the stack:");
        for (String book : books) {
            System.out.println(book);
        }
    }
}
