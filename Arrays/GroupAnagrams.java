

/*

Brute Force Approach:
- Use a HashMap to group words by their anagram signature.
- For each word, sort its characters and use the sorted string as the key.
- Add the original word to the list mapped by that key.
- Finally, return all the grouped lists.

Time Complexity: O(n * k log k)  // n = number of words, k = max word length
Space Complexity: O(n * k)
*/

class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String,List<String>>res=new HashMap<>();
        for(String s:strs){
            char[] charArray=s.toCharArray();
            Arrays.sort(charArray);
            String SortedS=new String(charArray);
            res.putIfAbsent(SortedS,new ArrayList<>());
            res.get(SortedS).add(s);
        }
        return new ArrayList<>(res.values());
    }
}

/*
Hash Table Approach:
- Use a HashMap to group words by their character frequency signature.
- For each word:
    1. Count the frequency of each character (array of size 26).
    2. Convert this frequency array into a string key (unique for each anagram group).
    3. Store the word in the map under that key.
- Finally, return all the grouped lists from the map values.

Why this works:
- Anagrams always produce the same character frequency array.
- Using frequency as key avoids sorting, making it more efficient.

Complexity:
- Time Complexity: O(m * n)
    where m = length of each word, n = number of words
    (we traverse each word once and count its characters).
- Space Complexity:
    O(m) → for frequency array per word
    O(m * n) → for storing the output list
*/

class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String,List<String>>res=new HashMap<>();
        for(String s:strs){
            int count[]=new int[26];
            for(char c:s.toCharArray()){
                count[c-'a']++;
            }
            String key=Arrays.toString(count);
            res.putIfAbsent(key,new ArrayList<>());
            res.get(key).add(s);
        }
        return new ArrayList<>(res.values());
    }
}
