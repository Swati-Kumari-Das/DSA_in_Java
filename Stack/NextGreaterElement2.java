/**
 * Problem: Next Greater Element II (Circular Array)
 * 
 * Given a circular array, for each element find the next greater element.
 * The next greater element of a number x is the first greater number
 * to its right in the array (considering circularity).
 * If it doesn't exist, return -1.
 *
 * Example:
 * Input: nums = [1, 2, 1]
 * Output: [2, -1, 2]
 *
 * Approach:
 * - Traverse the array twice (simulate circularity using i % n).
 * - Use a monotonic decreasing stack to keep track of possible next greater elements.
 * - For each element:
 *      → Pop all smaller or equal elements from stack.
 *      → If stack is empty → result is -1, else stack top is the answer.
 * - Push current element for future comparisons.
 *
 * Time Complexity: O(n)  (each element pushed & popped at most once)
 * Space Complexity: O(n) (stack + result array)
 */

import java.util.Stack;

public class NextGreaterElementII {

    public int[] nextGreaterElements(int[] nums) {
        int n = nums.length;
        int[] res = new int[n];
        Stack<Integer> stack = new Stack<>();

        // Traverse array twice to handle circular nature
        for (int i = 2 * n - 1; i >= 0; i--) {
            int current = nums[i % n];

            // Maintain decreasing order stack
            while (!stack.isEmpty() && stack.peek() <= current) {
                stack.pop();
            }

            // Fill result only during first pass
            if (i < n) {
                res[i] = stack.isEmpty() ? -1 : stack.peek();
            }

            // Push current element
            stack.push(current);
        }

        return res;
    }

    // Driver code for local testing
    public static void main(String[] args) {
        NextGreaterElementII solution = new NextGreaterElementII();
        int[] nums = {1, 2, 1};
        int[] result = solution.nextGreaterElements(nums);

        System.out.print("Next Greater Elements: ");
        for (int num : result) {
            System.out.print(num + " ");
        }
    }
}
