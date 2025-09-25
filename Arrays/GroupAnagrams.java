

/*
Approach:
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
