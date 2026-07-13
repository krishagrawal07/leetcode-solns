class Solution {
    public int[] smallerNumbersThanCurrent(int[] nums) {
        int n=nums.length;
        int buckets[] = new int[101];

        //get frequency of each element
        for(int num:nums){
            buckets[num]++;

        }
        //count smaller number than each element
        for(int i=1;i<buckets.length;i++){
            buckets[i]+=buckets[i-1];
        }
        //populate the result
        int[] result=new int[n];
        for(int i=0;i<n;i++){
            if(nums[i]==0){
                result[i]=0;

            }
            else{
                result[i]=buckets[nums[i]-1];
            }
        }
        return result;
    }
}