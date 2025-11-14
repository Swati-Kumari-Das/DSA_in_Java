// Problem: Sort first half in ascending and second half in descending
// Time Complexity: O(n log n)
// Space Complexity: O(1) auxiliary (ignoring output list)
// Approach:
// 1. Divide array into two halves
// 2. Sort first half in ascending order
// 3. Sort second half in ascending and reverse it to get descending
// 4. Return result as ArrayList

import java.util.*;
public class CustomSort {
    public static ArrayList<Integer> customSort(int[] arr) {
        int n = arr.length;
        int mid = n / 2;
        // Sort first half (ascending)
        Arrays.sort(arr, 0, mid);
        // Sort second half (ascending)
        Arrays.sort(arr, mid, n);
        // Reverse second half to make it descending
        int left = mid, right = n - 1;
        while (left < right) {
            int temp = arr[left];
            arr[left] = arr[right];
            arr[right] = temp;
            left++;
            right--;
        }
        // Convert to ArrayList and return
        ArrayList<Integer> ans = new ArrayList<>(n);
        for (int val : arr) {
            ans.add(val);
        }
        return ans;
    }
    // Optional main() for testing
    public static void main(String[] args) {
        int[] arr = {5, 4, 6, 2, 3, 8, 9, 7};
        System.out.println(customSort(arr));
    }
}
