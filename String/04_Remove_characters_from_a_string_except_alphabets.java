/*
Remove Special Characters from String
-------------------------------------
Given a string, remove all characters except letters (A-Z, a-z).
Return "-1" if no alphabet remains.

Approach:
---------
- Use StringBuilder to build result string.
- Loop characters in the string
- Append only if character is between 'a'–'z' or 'A'–'Z'
- If result becomes empty, return "-1"

Time Complexity: O(n)  -> iterate over string once
Space Complexity: O(n) -> StringBuilder stores result
*/

class Solution {
    String removeSpecialCharacter(String s) {
      
      StringBuilder res = new StringBuilder();
      
      for(char ch : s.toCharArray()){
          if((ch >= 'a' && ch <= 'z') || (ch >= 'A' && ch <= 'Z')){
              res.append(ch);
          }
      }
      
      if(res.length() == 0) return "-1";  // required by GFG
      
      return res.toString();
    }
}
