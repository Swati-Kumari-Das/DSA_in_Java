//Brute Force
//tc:O(n^2)
//sc:O(1)
public class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] res = new int[n];

        for (int i = 0; i < n; i++) {
            int prod = 1;
            for (int j = 0; j < n; j++) {
                if (i != j) {
                    prod *= nums[j];
                }
            }
            res[i] = prod;
        }
        return res;
    }
}

//Prefix & Suffix (Optimal)
//tc:O(n)
//sc:O(1)
class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n=nums.length;
        int[] res=new int[n];

        res[0]=1;
        for(int i=1;i<n;i++){
            res[i]=res[i-1]*nums[i-1];
        }
        int postfix=1;
        for(int j=n-1;j>=0;j--){
            res[j]*=postfix;
            postfix*=nums[j];
        }
        return res;
    }
}  
