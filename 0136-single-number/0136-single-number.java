class Solution {
    public int singleNumber(int[] nums) {
        int value =0;

        for(int i =0;i<nums.length;i++){

            value = value^nums[i];
        }  //xor same number ke sath 0 return krta he

        return value;

    }
}