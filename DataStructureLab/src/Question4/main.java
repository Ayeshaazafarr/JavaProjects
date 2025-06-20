package Question4;

import java.util.Scanner;

public class main {
    public static void main(String[] args) {
        
        PalindromeChecker checker = new PalindromeChecker();


        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a word: ");
        String word = sc.nextLine();

       
        if (checker.isPalindrome(word)) {
            System.out.println(word + " is a palindrome.");
        } else {
            System.out.println(word + " is not a palindrome.");
        }
    }
}
