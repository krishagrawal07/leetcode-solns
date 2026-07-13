class Solution {
    public int findMaxLength(int[] nums) {
        Map<Integer,Integer> map=new HashMap<>();
        for(int i=0;i<nums.length;i++){
            if(nums[i]==0) nums[i]=-1;
        }
        int sum=0,maxlength=0;
        map.put(0,-1);//sum 0 at position -1

        for(int i=0;i<nums.length;i++){
            sum+=nums[i];
            if(map.containsKey(sum)){
                int last=map.get(sum);
                maxlength=Math.max(maxlength,i-last);

            }
            else{
                map.put(sum,i);
            }

        }
        return maxlength;
    }
}