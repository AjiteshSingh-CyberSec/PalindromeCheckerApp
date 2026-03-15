public class PalindroneCheckerApp {

    public static void main(String[] args) {

        String input = "A man a plan a canal Panama";

        // Step 1: Normalize string
        // Convert to lowercase and remove all non-alphanumeric characters
        String normalized = input.toLowerCase().replaceAll("[^a-z0-9]", "");

        boolean isPalindrome = true;

        int start = 0;
        int end = normalized.length() - 1;

        // Step 2: Apply palindrome logic
        while (start < end) {
            if (normalized.charAt(start) != normalized.charAt(end)) {
                isPalindrome = false;
                break;
            }
            start++;
            end--;
        }

        // Display Result
        System.out.println("======================================");
        System.out.println("Palindrome Checker App - UC10");
        System.out.println("======================================");
        System.out.println("Original String: " + input);
        System.out.println("Normalized String: " + normalized);

        if (isPalindrome) {
            System.out.println("Result: The given string is a Palindrome.");
        } else {
            System.out.println("Result: The given string is NOT a Palindrome.");
        }

        System.out.println("Program executed successfully.");
    }
}