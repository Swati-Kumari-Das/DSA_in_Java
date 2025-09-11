# 1.Minimum Size Subarray Sum  

[LeetCode Problem Link](https://leetcode.com/problems/minimum-size-subarray-sum/description/?envType=study-plan-v2&envId=top-interview-150)

---

## Problem  
Given an array of positive integers `nums` and a positive integer `target`, return the **minimal length** of a subarray whose sum is greater than or equal to `target`. If there is no such subarray, return `0` instead.  

---

## Brute Force Approach  

**Idea:**  
- For every possible starting index `i`, try to extend the subarray to the right (`j`) while maintaining the sum.  
- If the running sum ≥ `target`, update the minimum length.  
- Stop extending further for that `i` since adding more elements only increases the subarray length.  

**Complexity:**  
- **Time Complexity:** O(n²)  
- **Space Complexity:** O(1)  

```java
class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int n = nums.length;
        int minLen = Integer.MAX_VALUE;

        for (int i = 0; i < n; i++) {
            int currSum = 0;
            for (int j = i; j < n; j++) {
                currSum += nums[j];
                if (currSum >= target) {
                    minLen = Math.min(minLen, j - i + 1);
                    break; // stop early for this i
                }
            }
        }

        return (minLen == Integer.MAX_VALUE) ? 0 : minLen;
    }
}
```

## Sliding Window Approach (Optimized)

## Idea:
Use two pointers (i, j) to maintain a window sum.
Expand j by adding elements to the sum.
As soon as the window sum ≥ target, shrink from the left (i) while updating the minimum length.

Complexity:

**Time Complexity: O(n)** 

**Space Complexity: O(1)**

```java
class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int i = 0, j = 0;
        int n = nums.length;
        int currSum = 0;
        int minLen = Integer.MAX_VALUE;

        while (j < n) {
            currSum += nums[j];

            while (currSum >= target) {
                minLen = Math.min(minLen, j - i + 1);
                currSum -= nums[i];
                i++;
            }
            j++;
        }

        return (minLen == Integer.MAX_VALUE) ? 0 : minLen;
    }
}
```
