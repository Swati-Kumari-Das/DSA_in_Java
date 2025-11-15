// RelativeSort.java
// Problem: Sort array a1[] according to the order defined in array a2[].

/*
    ✔ Approach (Using HashMap + Sorting)
    ------------------------------------
    We first store the frequency of every element of a1[] in a HashMap.
    Then we traverse a2[], and for each element:
       - If it exists in the frequency map, we add it to a1[] based on its count.
       - Remove it from the map so it doesn’t appear again.

    After processing all elements of a2[], the remaining elements in the map are
    those that were not present in a2[]. These elements must appear at the end in
    sorted (ascending) order. So we:
       - Extract remaining keys
       - Sort them
       - Add them to a1[] based on their frequencies

    ✔ Time Complexity:
        O(n + m + k log k)
        where,
        n = size of a1[],
        m = size of a2[],
        k = number of distinct elements not in a2[].

    ✔ Space Complexity:
        O(n) 
        Frequency map stores counts of elements in a1[].
*/

import java.util.*;

public class RelativeSort {

    static void relativeSort(int[] a1, int[] a2) {

        // Step 1: Frequency map of a1[]
        HashMap<Integer, Integer> freq = new HashMap<>();
        for (int num : a1) {
            freq.put(num, freq.getOrDefault(num, 0) + 1);
        }

        int index = 0;

        // Step 2: Place elements of a2[] first, respecting their order and frequency
        for (int num : a2) {
            if (freq.containsKey(num)) {
                int count = freq.get(num);
                while (count-- > 0) {
                    a1[index++] = num;
                }
                freq.remove(num);
            }
        }

        // Step 3: Append remaining elements of a1[] in sorted order
        List<Integer> remaining = new ArrayList<>(freq.keySet());
        Collections.sort(remaining);

        for (int num : remaining) {
            int count = freq.get(num);
            while (count-- > 0) {
                a1[index++] = num;
            }
        }
    }

    // Optional: main() function for local testing
    public static void main(String[] args) {
        int[] a1 = {4, 1, 3, 3, 2};
        int[] a2 = {3, 1};

        relativeSort(a1, a2);

        System.out.println(Arrays.toString(a1));   // Output: [3, 3, 1, 2, 4]
    }
}
