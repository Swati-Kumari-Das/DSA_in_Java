
// Problem: Koko Eating Bananas (LeetCode 875)
// Approach: Binary Search on Answer
// Explanation:
// 1. The minimum possible eating speed is 1, and the maximum is the size of the largest pile.
// 2. Use binary search to find the smallest valid speed:
//    - For each candidate speed (mid), check if Koko can finish within h hours.
//    - If yes, try smaller speeds (move left).
//    - If no, try larger speeds (move right).
// 3. The check is done using ceil(pile / speed).
//
// Time Complexity: O(n log m)
//   - n = number of piles, m = max pile size.
//   - log m for binary search, O(n) for each check.
// Space Complexity: O(1)

class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int start = 1;
        int end = 0;

        // Find maximum pile size (upper bound for speed)
        for (int pile : piles) {
            end = Math.max(end, pile);
        }

        int ans = -1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (isEatingSpeedValid(piles, mid, h)) {
                ans = mid;       // candidate answer
                end = mid - 1;   // try smaller speed
            } else {
                start = mid + 1; // need faster speed
            }
        }
        return ans;
    }

    // Check if eating speed is valid
    private boolean isEatingSpeedValid(int[] piles, int speed, int h) {
        int hoursSpent = 0;
        for (int pile : piles) {
            hoursSpent += (pile + speed - 1) / speed; // ceil(pile/speed)
            if (hoursSpent > h) {
                return false;
            }
        }
        return true;
    }
}
