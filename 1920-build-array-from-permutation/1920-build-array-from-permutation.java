class Solution {
    public int[] buildArray(int[] nums) {
        //jese nums[3] 5 tha first ex me and nums[5] 4 so 4--- 3 wali place per ayega
        int[] result = new int[nums.length];
        for(int i =0;i<nums.length;i++){
            result[i] = nums[nums[i]];
        }  
        return result;
    }
}