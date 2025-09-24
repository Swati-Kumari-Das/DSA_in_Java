//Brute Approach 
//tc:O(n^2)
//sc:O(n)
public class Solution {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }

        char[] sSort = s.toCharArray();
        char[] tSort = t.toCharArray();
        Arrays.sort(sSort);
        Arrays.sort(tSort);
        return Arrays.equals(sSort, tSort);
    }
}

//Hash Table (Using Array)
//tc:O(n)
//sc:O(1)
class Solution {
    public boolean isAnagram(String s, String t) {
     if(s.length()!=t.length()){
        return false;
     }
     int count[]=new int[26];

     for(int i=0;i<s.length();i++){
        char ch=s.charAt(i);
        count[ch-'a']++;
         count[t.charAt(i)-'a']--;
     }
   

     for(int val:count){
        if(val!=0){
            return false;
        }
     }
     return true;
    }
}

