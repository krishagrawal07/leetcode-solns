class Solution {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        //while isliye kyuki loop ke bhar nai ana baar baaaar check kerna he
        if(k<=1){
            return 0;
        }
        int count=0;
        int left=0;
        int prod=1;
        for(int right=0;right<nums.length;right++){
            prod*=nums[right];
            while(prod>=k){
                prod/=nums[left]; //piche wala htane ke liye
                left++;
            }
            count += right-left+1;
        }
        return count;
    }
}