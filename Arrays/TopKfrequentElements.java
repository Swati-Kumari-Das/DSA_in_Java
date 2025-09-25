/*
Approach:
1. Count the frequency of each number using a HashMap.
   - Key = number, Value = frequency.
2. Convert the frequency map into a list of pairs [frequency, number].
3. Sort the list in descending order of frequency.
4. Pick the first k numbers from the sorted list and return them.

This is a brute force approach since we sort all unique numbers 
instead of only maintaining the top k.

Complexity:
- Time Complexity: O(n + m log m)
    n = total elements in nums
    m = number of unique elements
    (O(n) for building the map + O(m log m) for sorting) 
- Space Complexity: O(m + k)
    m for frequency map and list, k for the result array
*/

class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        // Step 1: Count frequencies
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        // Step 2: Convert to list of [frequency, number]
        List<int[]> arr = new ArrayList<>();
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            arr.add(new int[]{entry.getValue(), entry.getKey()});
        }

        // Step 3: Sort by frequency (descending)
        arr.sort((a, b) -> b[0] - a[0]);

        // Step 4: Pick top k
        int[] res = new int[k];
        for (int i = 0; i < k; i++) {
            res[i] = arr.get(i)[1];
        }
        return res;
    }
}
