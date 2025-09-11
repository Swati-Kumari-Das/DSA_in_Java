/*
# Longest Substring Without Repeating Characters  

LeetCode Problem Link:
https://leetcode.com/problems/longest-substring-without-repeating-characters/?envType=study-plan-v2&envId=top-interview-150

---

## Problem  
Given a string `s`, find the length of the **longest substring** without repeating characters.  

---

## Brute Force Approach  

Idea:  
- Generate all substrings of `s`.  
- For each substring, check if all characters are unique.  
- Keep track of the maximum length of such substrings.  

Complexity:  
- Time Complexity: O(n³)  
  - Generating substrings → O(n²)  
  - Checking uniqueness → O(n)  
- Space Complexity: O(min(n, charset)) → extra space for a set to track characters.  
*/

import java.util.*;

class BruteForceSolution {
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

/*
---

## Optimized Approach (Sliding Window + HashMap)  

Idea:  
- Use two pointers (`i`, `j`) to define a sliding window.  
- Expand `j` by including characters in a HashMap (to count occurrences).  
- If the window has all unique characters (`map.size() == j - i + 1`), update max length.  
- If there are duplicates (`map.size() < j - i + 1`), shrink the window from the left (`i`) until it becomes valid again.  

Complexity:  
- Time Complexity: O(n) → each character is processed at most twice (once by `j`, once by `i`).  
- Space Complexity: O(min(n, charset)) → HashMap to store counts of characters.  
*/

class SlidingWindowSolution {
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
