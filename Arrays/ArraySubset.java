// ArraySubset.java
// Problem: Check if array b[] is a subset of array a[].
/*
    ✔ Approach (Using HashMap - Frequency Based)
    --------------------------------------------
    We need to check whether every element of array b[] exists in array a[] 
    with at least the same frequency.

    Steps:
    1. Store the frequency of each element of array a[] in a HashMap.
    2. For each element in b[], check:
         - Element must exist in the map.
         - Frequency should be greater than 0.
    3. If both conditions are satisfied, decrease the frequency.
    4. If any element of b[] is missing or its frequency is insufficient,
       b[] cannot be a subset → return false.
    5. After checking all elements of b[], return true.

    ✔ Time Complexity:
       O(n + m)  
       (n = size of a[], m = size of b[])

    ✔ Space Complexity:
       O(n)
       HashMap stores frequencies of elements from a[].
*/

import java.util.HashMap;

public class ArraySubset {

    public boolean isSubset(int[] a, int[] b) {

        // Step 1: Store frequency of each element of array a
        HashMap<Integer, Integer> freq = new HashMap<>();

        for (int num : a) {
            freq.put(num, freq.getOrDefault(num, 0) + 1);
        }

        // Step 2: Check if elements of b[] exist in a[] in required frequencies
        for (int num : b) {
            if (!freq.containsKey(num) || freq.get(num) == 0) {
                return false;  // element missing or insufficient frequency
            }
            freq.put(num, freq.get(num) - 1);  // reduce frequency
        }

        // All elements found → subset confirmed
        return true;
    }

    // You can add a main() to test the function locally (optional)
    public static void main(String[] args) {
        ArraySubset obj = new ArraySubset();

        int[] a = {11, 7, 1, 13, 21, 3, 7, 3};
        int[] b = {11, 3, 7, 1, 7};

        System.out.println(obj.isSubset(a, b));  // Output: true
    }
}
