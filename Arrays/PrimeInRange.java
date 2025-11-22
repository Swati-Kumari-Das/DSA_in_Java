import java.util.ArrayList;
import java.util.Arrays;

/**
 * Approach:
 * ---------
 * We want to find all prime numbers in the range [M, N].
 * The most efficient way for this is the Sieve of Eratosthenes.
 *
 * Steps:
 * 1. Create a boolean array isPrime[] of size N+1 and mark all as true.
 * 2. Set isPrime[0] and isPrime[1] as false (not primes).
 * 3. For each number i from 2 to sqrt(N):
 *         - If isPrime[i] is true, mark all multiples of i as false.
 * 4. After the sieve is built, iterate from max(M, 2) to N:
 *         - Add the numbers that are still marked true (these are primes).
 *
 * Time Complexity:
 * ----------------
 * Building the sieve:   O(N log log N)
 * Collecting primes:     O(N)
 * Total:                ~O(N log log N)
 *
 * Space Complexity:
 * -----------------
 * Boolean array isPrime[] of size (N + 1):  O(N)
 *
 * This method is efficient for ranges where N is up to 10^7.
 */

public class PrimeRange {

    public static ArrayList<Integer> primeRange(int M, int N) {
        ArrayList<Integer> primes = new ArrayList<>();

        if (N < 2) return primes;

        // Create sieve up to N
        boolean[] isPrime = new boolean[N + 1];
        Arrays.fill(isPrime, true);
        isPrime[0] = false;
        isPrime[1] = false;

        for (int i = 2; i * i <= N; i++) {
            if (isPrime[i]) {
                for (int j = i * i; j <= N; j += i) {
                    isPrime[j] = false;
                }
            }
        }

        // Collect primes in the range [M, N]
        for (int i = Math.max(2, M); i <= N; i++) {
            if (isPrime[i]) primes.add(i);
        }

        return primes;
    }

    // Optional: testing the code
    public static void main(String[] args) {
        int M = 10;
        int N = 50;
        System.out.println("Prime numbers between " + M + " and " + N + ":");
        System.out.println(primeRange(M, N));
    }
}
