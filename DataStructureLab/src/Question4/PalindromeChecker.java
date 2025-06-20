package Question4;
import java.util.Stack;

public class PalindromeChecker {

   
    public boolean isPalindrome(String word) {
        Stack<Character> stack = new Stack<>();

        
        for (int i = 0; i < word.length(); i++) {
            stack.push(word.charAt(i));
        }

       
        String reversed = "";
        while (!stack.isEmpty()) {
            reversed += stack.pop();
        }

      
        return word.equals(reversed);
    }
}

