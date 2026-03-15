import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;
import java.util.Stack;

public class PalindroneCheckerApp {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a string to benchmark: ");
        String userInput = scanner.nextLine();

        PalindromeStrategy stackStrategy = new StackStrategy();
        PalindromeStrategy dequeStrategy = new DequeStrategy();
        PalindromeStrategy twoPointerStrategy = new TwoPointerStrategy();

        System.out.println("\n--- Benchmarking Results ---");
        benchmarkAlgorithm("Two-Pointer Strategy", twoPointerStrategy, userInput);
        benchmarkAlgorithm("Stack Strategy", stackStrategy, userInput);
        benchmarkAlgorithm("Deque Strategy", dequeStrategy, userInput);

        scanner.close();
    }

    private static void benchmarkAlgorithm(String name, PalindromeStrategy strategy, String input) {
        long startTime = System.nanoTime();

        boolean result = strategy.checkPalindrome(input);

        long endTime = System.nanoTime();
        long duration = endTime - startTime;

        System.out.println(name + ":");
        System.out.println("  Result: " + result);
        System.out.println("  Time:   " + duration + " ns\n");
    }
}

interface PalindromeStrategy {
    boolean checkPalindrome(String input);
}

class TwoPointerStrategy implements PalindromeStrategy {
    @Override
    public boolean checkPalindrome(String input) {
        if (input == null) {
            return false;
        }
        String cleanInput = input.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
        int left = 0;
        int right = cleanInput.length() - 1;

        while (left < right) {
            if (cleanInput.charAt(left) != cleanInput.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}

class StackStrategy implements PalindromeStrategy {
    @Override
    public boolean checkPalindrome(String input) {
        if (input == null) {
            return false;
        }
        String cleanInput = input.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
        Stack<Character> stack = new Stack<>();

        for (char c : cleanInput.toCharArray()) {
            stack.push(c);
        }

        StringBuilder reversed = new StringBuilder();
        while (!stack.isEmpty()) {
            reversed.append(stack.pop());
        }

        return cleanInput.equals(reversed.toString());
    }
}

class DequeStrategy implements PalindromeStrategy {
    @Override
    public boolean checkPalindrome(String input) {
        if (input == null) {
            return false;
        }
        String cleanInput = input.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
        Deque<Character> deque = new ArrayDeque<>();

        for (char c : cleanInput.toCharArray()) {
            deque.addLast(c);
        }

        while (deque.size() > 1) {
            if (deque.removeFirst() != deque.removeLast()) {
                return false;
            }
        }

        return true;
    }
}