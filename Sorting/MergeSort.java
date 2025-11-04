/*
💡 Approach: Merge Sort (Divide & Conquer)

1. Divide the array into two halves until each part has one element.
2. Recursively sort the left half and right half.
3. Merge the two sorted halves into a final sorted array.

📌 Why it works?
   Merge Sort divides the array and then merges sorted parts,
   ensuring sorted structure at each merge step.

🕒 Time Complexity:
   - Best Case: O(n log n)
   - Average Case: O(n log n)
   - Worst Case: O(n log n) ✔ (Stable performance)

🧠 Space Complexity:
   - O(n) (extra arrays used for merging)

🎯 Key Properties:
   ✅ Stable Sort (preserves order of equal elements)
   ✅ Good for large datasets
   ❌ Needs extra space (not in-place)
*/

public class MergeSort {

    public void mergeSort(int arr[], int l, int r) {
        if (l < r) {
            int mid = l + (r - l) / 2;

            // Sort left half
            mergeSort(arr, l, mid);

            // Sort right half
            mergeSort(arr, mid + 1, r);

            // Merge both sorted halves
            merge(arr, l, mid, r);
        }
    }

    private void merge(int arr[], int l, int mid, int r) {
        int n1 = mid - l + 1;
        int n2 = r - mid;

        int[] left = new int[n1];
        int[] right = new int[n2];

        // Copy elements to left and right arrays
        for (int i = 0; i < n1; i++)
            left[i] = arr[l + i];

        for (int j = 0; j < n2; j++)
            right[j] = arr[mid + 1 + j];

        int i = 0, j = 0, k = l;

        // Merge arrays in sorted order
        while (i < n1 && j < n2) {
            if (left[i] <= right[j]) {
                arr[k] = left[i];
                i++;
            } else {
                arr[k] = right[j];
                j++;
            }
            k++;
        }

        // Copy remaining elements
        while (i < n1) {
            arr[k] = left[i];
            i++;
            k++;
        }

        while (j < n2) {
            arr[k] = right[j];
            j++;
            k++;
        }
    }

    // Driver Code (for testing)
    public static void main(String[] args) {
        int[] arr = {5, 2, 9, 1, 5, 6};

        MergeSort ms = new MergeSort();
        ms.mergeSort(arr, 0, arr.length - 1);

        System.out.print("Sorted Array: ");
        for (int num : arr) {
            System.out.print(num + " ");
        }
    }
}
