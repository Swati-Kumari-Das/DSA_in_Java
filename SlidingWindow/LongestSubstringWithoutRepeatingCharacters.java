package SlidingWindow;

import java.util.HashMap;

public class LongestSubstringWithoutRepeatingCharacters {
     public int lengthOfLongestSubstring(String s) {
        int n =s.length();
        int i=0,j=0;
        int maxLen=0;
        HashMap<Character,Integer>map=new HashMap<>();
        while(j<n){
            char ch=s.charAt(j);
            map.put(ch,map.getOrDefault(ch,0)+1);
         
            if(map.size()==(j-i+1)){
                maxLen=Math.max(maxLen,j-i+1);
                j++;
            }
            else if(map.size()<j-i+1){
                while(map.size()<j-i+1){
                    char c=s.charAt(i);
                    map.put(c,map.get(c)-1);
                    if(map.get(c)==0){
                        map.remove(c);
                    }
                    i++;
                }
                j++;
            }
        }
        return maxLen;
    }
}
