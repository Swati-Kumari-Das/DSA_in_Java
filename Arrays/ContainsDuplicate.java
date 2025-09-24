
//Brute force

//Time complexity: O(n^2)
//Space complexity: O(1)
public class Solution {
    public boolean hasDuplicate(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] == nums[j]) {
                    return true;
                }
            }
        }
        return false;
    }
}


//HashMap Approach
//tc:O(n)
//sc:O(n)

class Solution {
    public boolean hasDuplicate(int[] nums) {
        
      HashMap<Integer,Integer>map=new HashMap<>();

      for(int num:nums){
        map.put(num,map.getOrDefault(num,0)+1);
      }

      for(int val:map.values()){
        if(val>1){
            return true;
        }
      }
      return false;
    }
}
