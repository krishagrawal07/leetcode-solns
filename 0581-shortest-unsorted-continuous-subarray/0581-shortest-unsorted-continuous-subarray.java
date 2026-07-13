class Solution {
    public int findUnsortedSubarray(int[] nums) {
        int n=nums.length;
        int left=0,right=n-1;
        while(left<n-1 && nums[left]<=nums[left+1]){
            left++;
        }
        if (left==n-1){
            return 0;
        }
        while(right>0 && nums[right]>=nums[right-1]){
            right--;
        }
        int minval=Integer.MAX_VALUE;
        int maxval = Integer.MIN_VALUE;
        for(int i=left;i<=right;i++){
            minval=Math.min(minval,nums[i]);
            maxval=Math.max(maxval,nums[i]);
        }
        while(left>0 && nums[left-1]>minval){
                left--;
        }
        while(right<n-1 && nums[right+1]<maxval){
            right++;
        }
        return right-left+1;
    }
}