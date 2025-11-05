// ReverseString_Approach.java

/*

Reassigning a string in Java creates a new string object in the pool while the reference moves. Immutable strings ensure the old literal remains unchanged. intern() makes multiple strings share the same SCP object.
Approach:
---------
1️⃣ Convert the string to a character array
2️⃣ Use two-pointer technique:
       left pointer at start
       right pointer at end
3️⃣ Swap characters while left < right
4️⃣ Convert array back to string

Why two pointers?
-----------------
Efficient way to reverse without extra stack or recursion.

Time Complexity: O(n)  
- We traverse half of the string, but overall complexity is still linear.

Space Complexity: O(n)
- Because strings in Java are immutable, toCharArray() creates a new char array.
- If reversing in-place in char array input (like LeetCode), it becomes O(1).

Example
-------
Input:  "abcde"
Output: "edcba"
*/

class Solution {
    public static String reverseString(String s) {
      
      char arr[] = s.toCharArray();
      int l = 0;
      int r = arr.length - 1;
      
      while(l < r){
          char temp = arr[l];
          arr[l] = arr[r];
          arr[r] = temp;
          l++;
          r--;
      }
      
      return new String(arr);
    }

    public static void main(String[] args) {
        String str = "Swati";
        System.out.println(reverseString(str)); // Output: itawS
    }
}
