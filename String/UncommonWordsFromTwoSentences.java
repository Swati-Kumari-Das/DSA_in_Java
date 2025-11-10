// LeetCode 884: Uncommon Words from Two Sentences
// Difficulty: Easy

/*
Approach:
----------
1️⃣ Split both input sentences (s1 and s2) into individual words using split(" ").
2️⃣ Use a HashMap<String, Integer> to count the frequency of each word.
     - Add all words from s1 and s2 into the same map.
     - If a word appears multiple times, increment its count.
3️⃣ A word is "uncommon" if its frequency == 1 (appears only once across both sentences).
4️⃣ Collect all such words into a List and return as a String array.

Example:
---------
Input: s1 = "this apple is sweet", s2 = "this apple is sour"
Map after counting:
{this=2, apple=2, is=2, sweet=1, sour=1}
→ Output: ["sweet", "sour"]

Time Complexity:  O(n + m)
--------------------------
- Where n = number of words in s1, and m = number of words in s2.
- Each word is processed once (for counting + checking).

Space Complexity: O(n + m)
--------------------------
- We store all unique words in a HashMap and a result List.

*/

import java.util.*;

public class UncommonFromSentences {
    public String[] uncommonFromSentences(String s1, String s2) {
       
        // Step 1: Split both sentences
        String[] words1 = s1.split(" ");
        String[] words2 = s2.split(" ");
        
        // Step 2: Use a HashMap to count frequency
        Map<String, Integer> freq = new HashMap<>();
        
        // Count words from s1
        for (String w : words1) {
            freq.put(w, freq.getOrDefault(w, 0) + 1);
        }

        // Count words from s2
        for (String w : words2) {
            freq.put(w, freq.getOrDefault(w, 0) + 1);
        }
        
        // Step 3: Collect words that appear exactly once
        List<String> result = new ArrayList<>();
        for (String word : freq.keySet()) {
            if (freq.get(word) == 1) {
                result.add(word);
            }
        }
        
        // Step 4: Convert list to array
        return result.toArray(new String[0]);
    }

    // Test the solution
    public static void main(String[] args) {
        UncommonFromSentences sol = new UncommonFromSentences();

        String s1 = "this apple is sweet";
        String s2 = "this apple is sour";

        String[] output = sol.uncommonFromSentences(s1, s2);
        System.out.println("Output: " + Arrays.toString(output));
        // Expected Output: [sweet, sour]

        String s3 = "apple apple";
        String s4 = "banana";
        System.out.println("Output: " + Arrays.toString(sol.uncommonFromSentences(s3, s4)));
        // Expected Output: [banana]
    }
}
