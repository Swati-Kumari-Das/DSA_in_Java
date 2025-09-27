

/*
Problem: Two Sum II - Input Array is Sorted

Approach (Brute Force):
1. Iterate through each element (i).
2. For every i, check all elements after it (j).
3. If numbers[i] + numbers[j] == target, return their 1-based indices.
4. If no such pair is found, return {-1, -1}.

Time Complexity (TC):
- O(n^2), because we check every pair.

Space Complexity (SC):
- O(1), since no extra space is used apart from variables.
*/

class Solution {
    public int[] twoSum(int[] numbers, int target) {
        for (int i = 0; i < numbers.length; i++) {
            for (int j = i + 1; j < numbers.length; j++) {
                if (numbers[i] + numbers[j] == target) {
                    // +1 because indices are 1-based in the problem
                    return new int[]{i + 1, j + 1};
                }
            }
        }
        return new int[]{-1, -1};
    }
}


/*


Approach (Two Pointers):
1. Initialize two pointers:
   - l (left) = 0
   - r (right) = numbers.length - 1
2. While l < r:
   - If numbers[l] + numbers[r] == target → return {l+1, r+1} (1-based indices).
   - If sum < target → move left pointer (l++) to increase the sum.
   - If sum > target → move right pointer (r--) to decrease the sum.
3. If no such pair is found, return {-1, -1}.

Time Complexity (TC):
- O(n), because each element is visited at most once.

Space Complexity (SC):
- O(1), no extra data structures used.
*/

class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int l = 0;
        int r = numbers.length - 1;

        while (l < r) {
            int sum = numbers[l] + numbers[r];

            if (sum == target) {
                return new int[]{l + 1, r + 1}; // 1-based indexing
            } else if (sum < target) {
                l++;
            } else {
                r--;
            }
        }
        return new int[]{-1, -1};
    }
}

