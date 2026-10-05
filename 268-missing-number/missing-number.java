class Solution {
    public int missingNumber(int[] nums) {
       int sum=0;
       int n=nums.length;
       int actualsum=n*(n+1)/2;
       for(int i:nums){
        sum+=i;

       }
       return actualsum-sum;
    }

}