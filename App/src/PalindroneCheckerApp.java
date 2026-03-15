import java.util.Scanner;

public class PalindroneCheckerApp {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a string to check: ");
        String userInput = scanner.nextLine();

        PalindromeService service = new PalindromeService();
        boolean isPalindrome = service.checkPalindrome(userInput);

        if (isPalindrome) {
            System.out.println("The string is a palindrome.");
        } else {
            System.out.println("The string is not a palindrome.");
        }

        scanner.close();
    }
}

class PalindromeService {

    public boolean checkPalindrome(String input) {
        if (input == null) {
            return false;
        }

        String cleanInput = input.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
        char[] charArray = cleanInput.toCharArray();

        int left = 0;
        int right = charArray.length - 1;

        while (left < right) {
            if (charArray[left] != charArray[right]) {
                return false;
            }
            left++;
            right--;
        }

        return true;
    }
}