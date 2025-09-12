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

# 2. Longest Substring Without Repeating Characters  

[LeetCode Problem Link](https://leetcode.com/problems/longest-substring-without-repeating-characters/?envType=study-plan-v2&envId=top-interview-150)

---

## Problem  
Given a string `s`, find the length of the **longest substring** without repeating characters.  

---

## Brute Force Approach  

**Idea:**  
- Generate all substrings of `s`.  
- For each substring, check if all characters are unique.  
- Keep track of the maximum length of such substrings.  

**Complexity:**  
- **Time Complexity:** O(n³)  
  - Generating substrings → O(n²)  
  - Checking uniqueness → O(n)  
- **Space Complexity:** O(min(n, charset)) → because we use a set for uniqueness checking.  

```java
class Solution {
    public int lengthOfLongestSubstring(String s) {
        int n = s.length();
        int maxLen = 0;

        for (int i = 0; i < n; i++) {
            Set<Character> set = new HashSet<>();
            for (int j = i; j < n; j++) {
                char ch = s.charAt(j);
                if (set.contains(ch)) {
                    break; // duplicate found, stop this substring
                }
                set.add(ch);
                maxLen = Math.max(maxLen, j - i + 1);
            }
        }

        return maxLen;
    }
}
```

# Optimized Approach (Sliding Window + HashMap)

**Idea:**
Use two pointers (i, j) to define a sliding window.

Expand j by including characters in a HashMap (to count occurrences).

If the window has all unique characters (map.size() == j - i + 1), update max length.

If there are duplicates (map.size() < j - i + 1), shrink the window from the left (i) until it becomes valid again.

**Complexity:**

**Time Complexity:** O(n) (each character is processed at most twice).
**Space Complexity:**  O(min(n, charset)) (HashMap to store counts of characters).
```java
class Solution {
    public int lengthOfLongestSubstring(String s) {
        int i = 0, j = 0;
        int n = s.length();
        int maxLen = 0;
        HashMap<Character, Integer> map = new HashMap<>();

        while (j < n) {
            char ch = s.charAt(j);
            map.put(ch, map.getOrDefault(ch, 0) + 1);

            if (map.size() == j - i + 1) {
                maxLen = Math.max(maxLen, j - i + 1);
            } else if (map.size() < j - i + 1) {
                char c = s.charAt(i);
                map.put(c, map.get(c) - 1);
                if (map.get(c) == 0) {
                    map.remove(c);
                }
                i++;
            }

            j++;
        }

        return maxLen;
    }
}
```


# 3. Minimum Window Substring

**Problem Link:** [LeetCode - Minimum Window Substring](https://leetcode.com/problems/minimum-window-substring/?envType=study-plan-v2&envId=top-interview-150)

---

## 🟢 Problem Statement
Given two strings `s` and `t` of lengths `m` and `n` respectively, return the **minimum window substring** of `s` such that every character in `t` (including duplicates) is included in the window.  
If no such substring exists, return an empty string `""`.

---

## 🔴 Approach 1: Brute Force
1. Generate all possible substrings of `s`.  
2. For each substring, check if it contains all characters of `t` with required frequency.  
3. If yes, update the minimum length substring.  
4. Return the smallest substring at the end.  

### ⏱ Time Complexity
- O(m³) in the worst case (O(m²) substrings × O(m+n) checking).  

### 📦 Space Complexity
- O(n) for frequency tracking.  

### 💻 Code (Brute Force)
```java
class Solution {
    private boolean isValid(String sub, String t) {
        int[] freq = new int[128];
        for (char c : t.toCharArray()) {
            freq[c]++;
        }
        for (char c : sub.toCharArray()) {
            if (freq[c] > 0) {
                freq[c]--;
            }
        }
        for (int f : freq) {
            if (f > 0) return false;
        }
        return true;
    }

    public String minWindowBrute(String s, String t) {
        int n = s.length();
        String result = "";
        int minLen = Integer.MAX_VALUE;

        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                String sub = s.substring(i, j + 1);
                if (isValid(sub, t) && sub.length() < minLen) {
                    minLen = sub.length();
                    result = sub;
                }
            }
        }
        return result;
    }
}
```
## Approach 2: Optimized Sliding Window
Count frequencies of characters in t using a HashMap.

Use two pointers (i, j) to maintain a sliding window on s.

Expand j and decrease the count of seen characters from the map.

When a character’s frequency reaches zero, reduce uniqueCharCount.

When all characters from t are covered (uniqueCharCount == 0), try shrinking the window from the left (i) to minimize length.

Track the smallest valid window.

Return the substring if found, otherwise return "".

**Time Complexity**
O(m + n) → each character is processed at most twice.

**Space Complexity**
O(n) for storing frequency map of t.

```java

import java.util.*;
class Solution {
    public String minWindow(String s, String t) {
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < t.length(); i++) {
            char ch = t.charAt(i);
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }

        int uniqueCharCount = map.size();
        int si = -1;
        int j = 0, i = 0;
        int minLen = Integer.MAX_VALUE;
        int n = s.length();

        while (j < n) {
            char ch = s.charAt(j);
            if (map.containsKey(ch)) {
                map.put(ch, map.get(ch) - 1);
                if (map.get(ch) == 0) {
                    uniqueCharCount--;
                }
            }

            while (uniqueCharCount == 0) {
                int len = j - i + 1;
                if (len < minLen) {
                    minLen = len;
                    si = i;
                }

                char leftChar = s.charAt(i);
                if (map.containsKey(leftChar)) {
                    map.put(leftChar, map.get(leftChar) + 1);
                    if (map.get(leftChar) > 0) {
                        uniqueCharCount++;
                    }
                }
                i++;
            }
            j++;
        }

        if (si == -1) {
            return "";
        }
        return s.substring(si, si + minLen);
    }
}
```


# 4 Sliding Window Maximum

Given an array `nums` and an integer `k`, find the maximum value in each sliding window of size `k`.

---

## 1. Brute Force Approach

### Idea
- For each window of size `k`, scan all elements and take the maximum.  
- Very slow for large `n`.

### Complexity
- **Time Complexity:** O(n * k)  
- **Space Complexity:** O(1)  

### Code
```java
class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums == null || nums.length == 0) return new int[0];
        int n = nums.length;
        int[] result = new int[n - k + 1];
        
        for (int i = 0; i <= n - k; i++) {
            int maxVal = Integer.MIN_VALUE;
            for (int j = i; j < i + k; j++) {
                maxVal = Math.max(maxVal, nums[j]);
            }
            result[i] = maxVal;
        }
        return result;
    }
}
```
### 2. Heap Based Approach
**Idea**
Use a max heap (priority queue) to keep track of the largest element in the current window.

Insert current element → remove elements outside the window → top of heap is max.

**Complexity**
**Time Complexity**: O(n log k)

**Space Complexity**: O(k)

```java
import java.util.*;

class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums == null || nums.length == 0) return new int[0];
        int n = nums.length;
        int[] result = new int[n - k + 1];
        
        // Max Heap: stores {value, index}
        PriorityQueue<int[]> maxHeap = new PriorityQueue<>((a, b) -> b[0] - a[0]);
        
        for (int i = 0; i < n; i++) {
            maxHeap.offer(new int[]{nums[i], i});
            
            // Remove elements outside the window
            while (maxHeap.peek()[1] <= i - k) {
                maxHeap.poll();
            }
            
            // Record result once window is fully formed
            if (i >= k - 1) {
                result[i - k + 1] = maxHeap.peek()[0];
            }
        }
        return result;
    }
}
```

### 3. Optimized Deque Based Approach
**Idea**
Use a deque to store indices of elements in decreasing order of values.

Front of deque always holds the maximum for the current window.

Remove smaller elements from the back (not useful).

Remove elements outside the current window from the front.

**Complexity**
**Time Complexity: O(n)**

**Space Complexity: O(k)**

```java
import java.util.*;

class Solution {
    public static int[] maxSlidingWindow(int[] nums, int k) {
        if (nums == null || nums.length == 0 || k <= 0) {
            return new int[0];
        }
        int n = nums.length;
        int[] result = new int[n - k + 1];
        Deque<Integer> deque = new LinkedList<>();
        int i = 0, j = 0;
        
        while (j < n) {
            // Step 1: Remove smaller elements from the back
            while (!deque.isEmpty() && nums[deque.peekLast()] < nums[j]) {
                deque.pollLast();
            }
            
            // Step 2: Add current index
            deque.offerLast(j);
            
            // Step 3: Remove out-of-window indices from the front
            if (!deque.isEmpty() && deque.peekFirst() < i) {
                deque.pollFirst();
            }
            
            // Step 4: If window is full, record the max
            if (j - i + 1 == k) {
                result[i] = nums[deque.peekFirst()];
                i++;
            }
            j++;
        }
        return result;
    }
}
```
