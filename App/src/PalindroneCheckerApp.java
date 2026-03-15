public class PalindroneCheckerApp {

    // Recursive method to check palindrome
    public static boolean isPalindrome(String str, int start, int end) {

        // Base Condition (when pointers cross or equal)
        if (start >= end) {
            return true;
        }

        // If characters don't match
        if (str.charAt(start) != str.charAt(end)) {
            return false;
        }

        // Recursive call (move towards center)
        return isPalindrome(str, start + 1, end - 1);
    }

    public static void main(String[] args) {

        String input = "racecar";

        boolean result = isPalindrome(input, 0, input.length() - 1);

        System.out.println("======================================");
        System.out.println("Palindrome Checker App - UC9");
        System.out.println("======================================");
        System.out.println("Given String: " + input);

        if (result) {
            System.out.println("Result: The given string is a Palindrome.");
        } else {
            System.out.println("Result: The given string is NOT a Palindrome.");
        }

        System.out.println("Program executed successfully.");
    }
}