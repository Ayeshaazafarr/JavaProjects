package Q3;
import java.util.ArrayList;

public class main {
    public static void main(String[] args) {

        // Create an ArrayList of Strings
        ArrayList<String> fruits = new ArrayList<>();

        // 1. add(element)
        fruits.add("Apple");
        fruits.add("Banana");
        fruits.add("Mango");

        // 2. add(index, element)
        fruits.add(1, "Orange"); // Insert at index 1

        // 3. get(index)
        System.out.println("Element at index 2: " + fruits.get(2));

        // 4. set(index, element)
        fruits.set(0, "Pineapple"); // Replace "Apple"

        // 5. contains(element)
        System.out.println("Contains Mango? " + fruits.contains("Apple"));

        // 6. indexOf(element)
        System.out.println("Index of Orange: " + fruits.indexOf("Orange"));

        // 7. lastIndexOf(element)
        fruits.add("Mango"); // Add duplicate
        System.out.println("Last index of Mango: " + fruits.lastIndexOf("Mango"));

        // 8. size()
        System.out.println("Size of list: " + fruits.size());

        // 9. isEmpty()
        System.out.println("Is the list empty? " + fruits.isEmpty());

        // 10. remove(index)
        fruits.remove(2); // Remove element at index 2

        // 11. remove(Object)
        fruits.remove("Banana"); // Remove by value

        // 12. toArray()
        Object[] array = fruits.toArray();
        System.out.print("Converted to array: ");
        for (Object item : array) {
            System.out.print(item + " ");
        }
        System.out.println();

        // 13. clone()
        ArrayList<String> clonedList = (ArrayList<String>) fruits.clone();
        System.out.println("Cloned list: " + clonedList);

        // 14. equals()
        System.out.println("Lists equal? " + fruits.equals(clonedList));

        // 15. clear()
        fruits.clear();
        System.out.println("List after clear: " + fruits);

        // 16. isEmpty() again
        System.out.println("Is the list empty now? " + fruits.isEmpty());
    }
}
