public class PalindroneCheckerApp {

    public static void main(String[] args) {

        // Original String
        String original = "level";

        // Variable to store reversed string
        String reversed = "";

        // Reverse the string using for loop
        for (int i = original.length() - 1; i >= 0; i--) {
            reversed = reversed + original.charAt(i);
        }

        // Display original and reversed strings
        System.out.println("Original String: " + original);
        System.out.println("Reversed String: " + reversed);

        // Compare using equals() method
        if (original.equals(reversed)) {
            System.out.println("Result: The given string is a Palindrome.");
        } else {
            System.out.println("Result: The given string is NOT a Palindrome.");
        }

        System.out.println("Program executed successfully.");
    }
}