import java.util.*;

/**
 * Problem: Sort array elements by frequency.
 *
 * Approach:
 * 1. Count the frequency of each element using a HashMap.
 * 2. Store each element and its frequency inside a Pair object.
 * 3. Sort the list of pairs:
 *      - Higher frequency comes first.
 *      - If same frequency, smaller element comes first.
 * 4. Print each element according to its frequency.
 *
 * Time Complexity:  O(N log N)
 * Space Complexity: O(N)
 */

class Pair {
    int first;      // element
    int second;     // frequency

    Pair(int first, int second) {
        this.first = first;
        this.second = second;
    }
}

public class SortElementsByFrequency {

    static void sortElementsByFreq(int arr[], int n) {

        // Step 1: Build frequency map
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
        }

        // Step 2: Convert to list of Pair
        ArrayList<Pair> list = new ArrayList<>();
        for (int x : map.keySet()) {
            list.add(new Pair(x, map.get(x)));
        }

        // Step 3: Sort pairs
        Collections.sort(list, (a, b) -> {
            if (a.second == b.second)
                return a.first - b.first;      // smaller value first
            return b.second - a.second;        // higher frequency first
        });

        // Step 4: Print result
        for (Pair p : list) {
            for (int i = 0; i < p.second; i++) {
                System.out.print(p.first + " ");
            }
        }
        System.out.println();
    }

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();
        while (T-- > 0) {

            int N = sc.nextInt();
            int arr[] = new int[N];

            for (int i = 0; i < N; i++) {
                arr[i] = sc.nextInt();
            }

            sortElementsByFreq(arr, N);
        }

        sc.close();
    }
}
