import java.util.Stack;

public class PalindroneCheckerApp {

    public static void main(String[] args) {

        // Original String
        String word = "madam";

        // Create a Stack
        Stack<Character> stack = new Stack<>();

        // Step 1: Push characters into stack
        for (int i = 0; i < word.length(); i++) {
            stack.push(word.charAt(i));
        }

        // Step 2: Pop characters and build reversed string
        String reversed = "";
        while (!stack.isEmpty()) {
            reversed = reversed + stack.pop();
        }

        // Step 3: Compare original and reversed
        System.out.println("Original String: " + word);
        System.out.println("Reversed String (using Stack): " + reversed);

        if (word.equals(reversed)) {
            System.out.println("Result: It is a Palindrome.");
        } else {
            System.out.println("Result: It is NOT a Palindrome.");
        }
    }
}