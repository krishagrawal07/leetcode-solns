class Solution {
    public int maxAbsoluteSum(int[] nums) {
        int maxsum=0,minsum=0,maxending=0,minending=0;
        for(int num:nums){
            maxending=Math.max(0,maxending+num);
            maxsum=Math.max(maxsum,maxending);
            minending=Math.min(0,minending+num);
            minsum=Math.min(minsum,minending);
        }
        return Math.max(maxsum,-minsum);
    }
}