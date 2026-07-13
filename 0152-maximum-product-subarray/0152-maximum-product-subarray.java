class Solution {
    public int maxProduct(int[] nums) {
        if(nums.length==0){
            return 0;
        }
       int maxx=nums[0];
       int minn=nums[0];
       int global=nums[0];
       for(int i=1;i<nums.length;i++){
        int current =nums[i];
        if(current<0){
            int temp=maxx;
            maxx=minn;
            minn=temp;
        }
        maxx=Math.max(current,maxx*current);
        minn=Math.min(current,minn*current);
        global=Math.max(global,maxx);
       }
       return global;

    }
}