/*
 * Problem: Adding Array Elements
 * Difficulty: Easy
 *
 * Description:
 * ------------
 * You are given an array Arr[] of size N and an integer K.
 * In each operation:
 *      - Remove the two smallest elements.
 *      - Insert their sum back into the array.
 * Continue these operations until all elements become >= K.
 *
 * Return the number of operations required.
 * If it's not possible, return -1.
 *
 * Example:
 * Input:  Arr = [1, 10, 12, 9, 2, 3], K = 6
 * Output: 2
 *
 *
 * Approach:
 * ---------
 * - Use a min-heap (PriorityQueue) to efficiently extract the smallest elements.
 * - Insert all array elements into the heap.
 * - While the smallest element is < K:
 *        - If size < 2 → we cannot combine further → return -1.
 *        - Remove the two smallest numbers.
 *        - Insert their sum into the heap.
 *        - Increment operation count.
 *
 * - Once all elements are >= K → return operations.
 *
 *
 * Time Complexity: O(N log N)
 * ---------------------------
 * - Building the heap takes O(N)
 * - Each operation takes O(log N) for removal + insertion
 *
 *
 * Space Complexity: O(N)
 * ----------------------
 * - PriorityQueue stores all elements
 */

import java.util.PriorityQueue;

public class AddingArrayElements {

    public int minOperations(int[] arr, int n, int k) {

        PriorityQueue<Integer> pq = new PriorityQueue<>();

        // Insert all elements
        for (int num : arr) {
            pq.add(num);
        }

        int operations = 0;

        // Continue until smallest element ≥ K
        while (!pq.isEmpty() && pq.peek() < k) {

            // If less than 2 elements remain, cannot proceed
            if (pq.size() < 2) {
                return -1;
            }

            int first = pq.poll();
            int second = pq.poll();

            int sum = first + second;
            pq.add(sum);

            operations++;
        }

        return operations;
    }

    // Optional test
    public static void main(String[] args) {
        AddingArrayElements obj = new AddingArrayElements();
        int[] arr = {1, 10, 12, 9, 2, 3};
        System.out.println(obj.minOperations(arr, arr.length, 6)); // Output: 2
    }
}
