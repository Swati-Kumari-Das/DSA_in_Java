// 💡 Approach:
// The goal is to count the frequency of each distinct element in the array.
// We use a HashMap to efficiently count occurrences of every element.
//
// Steps:
// 1️⃣ Traverse the array once and store frequency of each element in a HashMap.
// 2️⃣ (Optional) Sort the keys if output requires sorted order.
// 3️⃣ Store each element-frequency pair in an ArrayList<ArrayList<Integer>> for output.
//
// ✅ Using HashMap gives average O(1) insertion and lookup time.
// ✅ Overall complexity: O(n) for counting + O(k log k) for sorting distinct elements.

import java.util.*;

class Solution {
    public ArrayList<ArrayList<Integer>> countFreq(int[] arr) {
        // Step 1: Count frequency using HashMap (O(n))
        HashMap<Integer, Integer> freqMap = new HashMap<>();
        for (int num : arr) {
            freqMap.put(num, freqMap.getOrDefault(num, 0) + 1);
        }

        // Step 2: Get distinct keys and sort them (O(k log k))
        ArrayList<Integer> keys = new ArrayList<>(freqMap.keySet());
        Collections.sort(keys);

        // Step 3: Prepare result as list of [element, frequency]
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        for (int key : keys) {
            ArrayList<Integer> pair = new ArrayList<>();
            pair.add(key);
            pair.add(freqMap.get(key));
            result.add(pair);
        }

        return result;
    }
}

/*
🧠 Example:
Input: [1, 2, 2, 3, 1]
Output: [[1, 2], [2, 2], [3, 1]]

⏱️ Time Complexity: O(n + k log k)
   - O(n) for building HashMap
   - O(k log k) for sorting distinct elements (k = number of unique elements)

💾 Space Complexity: O(k)
   - For storing frequencies of distinct elements
*/
