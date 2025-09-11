
## Minimum SIze Subaaray Sum
link: https://leetcode.com/problems/minimum-size-subarray-sum/description/?envType=study-plan-v2&envId=top-interview-150
TC = O(n)
SC = O(1)

```bash
class Solution {
    public int minSubArrayLen(int target, int[] nums) {
    int i=0,j=0;
    int n=nums.length;
    int currSum=0;
    int minLen=Integer.MAX_VALUE;
    while(j<n){
     currSum+=nums[j];
     while(currSum>=target){
        minLen=Math.min(minLen,j-i+1);
        currSum-=nums[i];
        i++;
     }
     j++;
    } 
    return (minLen==Integer.MAX_VALUE)?0:minLen; 
    }
}

```
