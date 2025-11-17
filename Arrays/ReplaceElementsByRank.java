// ReplaceWithRank.java
// Problem: Replace each element with its rank in the sorted array
// Time Complexity: O(N log N)
// Space Complexity: O(N)
// Approach: Use a Min Heap to extract elements in sorted order and assign ranks.
//           Duplicates receive the same rank.

import java.util.*;

class Solution {
    static int[] replaceWithRank(int arr[], int N) {

        // Step 1: Create a min-heap storing (value, index)
        PriorityQueue<int[]> minHeap = new PriorityQueue<>(
            (a, b) -> Integer.compare(a[0], b[0])
        );

        for (int i = 0; i < N; i++) {
            minHeap.offer(new int[]{arr[i], i});
        }

        // Step 2: Extract from heap and assign ranks
        int[] result = new int[N];
        int rank = 1;
        int prevValue = Integer.MIN_VALUE;

        while (!minHeap.isEmpty()) {
            int[] current = minHeap.poll();
            int value = current[0];
            int index = current[1];

            // Assign same rank for duplicates
            if (value != prevValue) {
                prevValue = value;
                result[index] = rank;
                rank++;
            } else {
                result[index] = rank - 1; // same rank as previous value
            }
        }

        return result;
    }
}
