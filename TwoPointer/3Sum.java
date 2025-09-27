
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
