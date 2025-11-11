/*
 * 🧩 Problem: Frequency of Elements
 * --------------------------------
 * Given an array of positive integers (which may contain duplicates),
 * return the frequency of each distinct element as a list of pairs [element, frequency].
 *
 * Example:
 * Input:  arr = [1, 2, 2, 3, 3, 5]
 * Output: [[1, 1], [2, 2], [3, 2], [5, 1]]
 *
 * Constraints:
 * 1 ≤ arr.length ≤ 10^5
 * 1 ≤ arr[i] ≤ 10^9
 *
 * --------------------------------
 * 💡 Approach:
 * --------------------------------
 * 1. Use a HashMap<Integer, Integer> to count the frequency of each element in O(n) time.
 * 2. Get all distinct elements (keys) from the map.
 * 3. Sort the keys to maintain ascending order in output.
 * 4. Build the result as an ArrayList of ArrayLists → [[element, frequency], ...]
 *
 * --------------------------------
 * ⏱️ Time Complexity:
 *  - Counting frequencies: O(n)
 *  - Sorting keys: O(k log k), where k = number of distinct elements
 *  - Building output list: O(k)
 *  → Overall: O(n + k log k)
 *
 * 💾 Space Complexity:
 *  - HashMap stores k entries: O(k)
 *  - Output list: O(k)
 *  → Total: O(k)
 */

import java.util.*;

public class FrequencyOfElements {

    public static ArrayList<ArrayList<Integer>> countFreq(int[] arr) {
        // Step 1: Count frequencies using HashMap
        HashMap<Integer, Integer> freqMap = new HashMap<>();
        for (int num : arr) {
            freqMap.put(num, freqMap.getOrDefault(num, 0) + 1);
        }

        // Step 2: Get keys and sort them (for sorted output)
        ArrayList<Integer> keys = new ArrayList<>(freqMap.keySet());
        Collections.sort(keys);

        // Step 3: Prepare final result
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        for (int key : keys) {
            ArrayList<Integer> pair = new ArrayList<>();
            pair.add(key);
            pair.add(freqMap.get(key));
            result.add(pair);
        }

        return result;
    }

    // Driver code for testing
    public static void main(String[] args) {
        int[] arr = {1, 2, 2, 3, 3, 5};
        ArrayList<ArrayList<Integer>> output = countFreq(arr);
        System.out.println(output);
    }
}
