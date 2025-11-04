/*
💡 Approach: Quick Sort (Divide & Conquer)

1. Pick a pivot (here we pick the last element of the array).
2. Partition the array so that:
   - Elements <= pivot are placed on left
   - Elements > pivot are placed on right
3. Recursively apply QuickSort on left and right subarrays.
4. Base case: When low >= high (array of size 1 or empty).

📌 Key idea:
   Correct pivot position ensures left side contains smaller values 
   and right side contains larger values.

🕒 Time Complexity:
   - Best Case: O(n log n)
   - Average Case: O(n log n)
   - Worst Case: O(n²) (already sorted array / bad pivot selection)

🧠 Space Complexity:
   - O(log n) recursive stack space (average case)
*/

public class QuickSort {
    
    public void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            int p = partition(arr, low, high);
            quickSort(arr, low, p - 1);   // left side
            quickSort(arr, p + 1, high); // right side
        }
    }

    private int partition(int[] arr, int low, int high) {
        int pivot = arr[high];
        int i = low - 1;  // index of smaller element

        for (int j = low; j < high; j++) {
            if (arr[j] <= pivot) {
                i++;

                // swap arr[i] and arr[j]
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }

        // place pivot in its correct sorted position
        int temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;

        return i + 1; // pivot index
    }

    // Driver code for testing
    public static void main(String[] args) {
        int[] arr = {7, 2, 1, 6, 8, 5, 3, 4};
        QuickSort qs = new QuickSort();
        qs.quickSort(arr, 0, arr.length - 1);
        
        System.out.print("Sorted Array: ");
        for (int num : arr) System.out.print(num + " ");
    }
}
