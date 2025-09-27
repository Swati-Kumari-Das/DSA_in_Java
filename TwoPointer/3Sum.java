
/*
Problem: 3Sum

Approach (Brute Force with HashSet):
1. Sort the array to help keep triplets in a consistent order.
2. Use three nested loops (i, j, k) to try all possible triplets.
3. If nums[i] + nums[j] + nums[k] == 0, create a triplet and add it to a HashSet.
   - Using a HashSet ensures uniqueness (no duplicate triplets).
4. Convert the HashSet into a List and return as the result.

Time Complexity (TC):
- Sorting: O(n log n)
- Triple nested loops: O(n³)
- HashSet insertion: O(1) (amortized) per triplet
=> Overall: O(n³)

Space Complexity (SC):
- Sorting: O(1) (in-place)
- HashSet: O(n²) in the worst case (storing many unique triplets)
=> Overall: O(n²)

Note: This is a brute force approach. The optimized solution uses sorting + two pointers
and runs in O(n²) time with O(1) extra space (excluding output).
*/

import java.util.*;

class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Set<List<Integer>> res = new HashSet<>();
        Arrays.sort(nums); // Step 1: Sort the array

        // Step 2: Triple nested loop to try all triplets
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                for (int k = j + 1; k < nums.length; k++) {
                    if (nums[i] + nums[j] + nums[k] == 0) {
                        List<Integer> ans = Arrays.asList(nums[i], nums[j], nums[k]);
                        res.add(ans); // HashSet ensures uniqueness
                    }
                }
            }
        }

        // Step 3: Convert set to list and return
        return new ArrayList<>(res);
    }
}


// Approach: Sort + Two Pointers

/*
Approach:
1. Sort the array.
2. Fix one element (n1) in each iteration.
3. Use the two-pointer technique (like Two Sum) to find pairs (n2, n3)
   such that n1 + n2 + n3 = 0.
4. Skip duplicate elements to avoid duplicate triplets.
5. Collect all unique triplets.

Time Complexity:
- Sorting takes O(n log n).
- Outer loop runs O(n).
- Two-pointer search per element runs O(n).
- Total: O(n^2).

Space Complexity:
- O(1) extra (ignoring output list).
*/

import java.util.*;

class Solution {
    List<List<Integer>> res = new ArrayList<>();

    // Helper method: two sum with two pointers
    void twoSum(int[] nums, int target, int i, int j) {
        while (i < j) {
            if (nums[i] + nums[j] > target) {
                j--;
            } else if (nums[i] + nums[j] < target) {
                i++;
            } else {
                // Skip duplicates for left pointer
                while (i < j && nums[i] == nums[i + 1]) i++;
                // Skip duplicates for right pointer
                while (i < j && nums[j] == nums[j - 1]) j--;

                // Found valid triplet
                List<Integer> triplet = Arrays.asList(-target, nums[i], nums[j]);
                res.add(triplet);

                i++;
                j--;
            }
        }
    }

    public List<List<Integer>> threeSum(int[] nums) {
        int n = nums.length;
        if (n < 3) return res;

        Arrays.sort(nums);

        // Fix one element at a time
        for (int i = 0; i < n - 2; i++) {
            // Skip duplicates for fixed element
            if (i > 0 && nums[i] == nums[i - 1]) continue;

            int n1 = nums[i];
            int target = -n1;

            // Find pairs (n2, n3) such that n2 + n3 = -n1
            twoSum(nums, target, i + 1, n - 1);
        }

        return res;
    }
}

