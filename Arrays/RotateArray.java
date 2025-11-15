// RotateArray.java
// Problem: Rotate an array by d elements in counter-clockwise direction.

/*
    ✔ Approach (Reversal Algorithm)
    --------------------------------
    To rotate an array by d positions to the left (counter-clockwise), we use
    the efficient reversal technique:

        Step 1: Reverse the first d elements
        Step 2: Reverse the remaining n - d elements
        Step 3: Reverse the entire array

    Example:
        arr = [1, 2, 3, 4, 5], d = 2
        
        Step 1: reverse(0, 1) → [2, 1, 3, 4, 5]
        Step 2: reverse(2, 4) → [2, 1, 5, 4, 3]
        Step 3: reverse(0, 4) → [3, 4, 5, 1, 2]

    ✔ Why this works?
        Reversing parts and then reversing the whole reorders elements exactly as a rotation.

    ✔ Time Complexity: O(n)
        Entire array is reversed 3 times.

    ✔ Space Complexity: O(1)
        No extra space used.
*/

public class RotateArray {

    // Function to rotate an array by d elements counter-clockwise
    public static void rotateArr(int[] arr, int d) {
        int n = arr.length;

        // If d > n, reduce it
        if (d > n) {
            d = d % n;
        }

        // Step 1: Reverse first d elements
        reverse(arr, 0, d - 1);

        // Step 2: Reverse the remaining elements
        reverse(arr, d, n - 1);

        // Step 3: Reverse the entire array
        reverse(arr, 0, n - 1);
    }

    // Helper function to reverse array from index i to j
    private static void reverse(int[] arr, int i, int j) {
        while (i < j) {
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
            i++;
            j--;
        }
    }

    // Optional: main() for local testing
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};
        int d = 2;

        rotateArr(arr, d);

        // Expected Output: [3, 4, 5, 1, 2]
        System.out.print("Rotated Array: ");
        for (int x : arr) {
            System.out.print(x + " ");
        }
    }
}
