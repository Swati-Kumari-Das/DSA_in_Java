| Sorting Algorithm | Best Case Time | Average Case Time | Worst Case Time | Space Complexity | Stable? | Notes |
|------------------|----------------|-------------------|-----------------|------------------|--------|------|
| **Bubble Sort (Optimized)** | O(n) | O(n²) | O(n²) | O(1) | ✅ Yes | Good when array is nearly sorted |
| **Selection Sort** | O(n²) | O(n²) | O(n²) | O(1) | ❌ No | Performs minimum swaps |
| **Insertion Sort** | O(n) | O(n²) | O(n²) | O(1) | ✅ Yes | Best for small / nearly sorted data |
| **Merge Sort** | O(n log n) | O(n log n) | O(n log n) | O(n) | ✅ Yes | Divide & Conquer, stable |
| **Quick Sort (Random Pivot)** | O(n log n) | O(n log n) | O(n²) | O(log n) | ❌ No | Fastest in practice, in-place |
| **Heap Sort** | O(n log n) | O(n log n) | O(n log n) | O(1) | ❌ No | Always O(n log n), not stable |
| **Counting Sort** | O(n + k) | O(n + k) | O(n + k) | O(k) | ✅ Yes | Works only for limited integer range |
| **Radix Sort** | O(d × (n + k)) | O(d × (n + k)) | O(d × (n + k)) | O(n + k) | ✅ Yes | Works for integers/strings |
| **Bucket Sort** | O(n) | O(n) | O(n²) | O(n) | ✅ Yes | Depends on input distribution |
| **Shell Sort** | O(n log n) | O(n^(3/2)) | O(n²) | O(1) | ❌ No | Improved insertion sort |
