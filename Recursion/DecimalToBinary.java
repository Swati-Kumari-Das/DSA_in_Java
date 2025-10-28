/*
 * 🧩 Problem: Convert Decimal to Binary (Recursive)
 *
 * 🔹 Approach:
 * Use recursion to divide the number by 2 until it becomes 0.
 * During the unwind phase of recursion, print (n % 2) — this gives binary digits in the correct order.
 *
 * 🔸 Steps:
 * 1️⃣ Base case: If n == 0, stop recursion.
 * 2️⃣ Recursive step: Call toBinary(n / 2).
 * 3️⃣ Print remainder (n % 2) during unwinding.
 *
 * Example:
 * n = 13 → Binary = 1101
 * (13 / 2 = 6) → (6 / 2 = 3) → (3 / 2 = 1) → (1 / 2 = 0)
 *
 * 🕒 Time Complexity: O(log n)
 * 🧠 Space Complexity: O(log n)
 */

public class DecimalToBinary {

    // Recursive function to print binary representation
    public static void toBinary(int n) {
        // Base case
        if (n == 0) {
            return;
        }

        // Recursive call
        toBinary(n / 2);

        // Print remainder
        System.out.print(n % 2);
    }

    // Main function for testing
    public static void main(String[] args) {
        int n = 13;

        System.out.print("Binary of " + n + " = ");
        if (n == 0) {
            System.out.print(0);
        } else {
            toBinary(n);
        }
        System.out.println();
    }
}
