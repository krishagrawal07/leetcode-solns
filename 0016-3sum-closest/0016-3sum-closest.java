class Solution {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int result=0;
        int maxdiff=Integer.MAX_VALUE;
        for (int i=0;i<nums.length-2;i++){
            int j=i+1,k=nums.length-1;
            int diff=0;
            
            while(j<k){
                int total=nums[i]+nums[j]+nums[k];
                diff=Math.abs(total-target);
                if(diff<maxdiff){
                    maxdiff=diff;
                    result=total;
                }
                if(target==total){
                    return total;
                }
                else if(total<target){
                    j++;
                }
                else{
                    k--;
                }
            }
        }
        return result;
    }
}