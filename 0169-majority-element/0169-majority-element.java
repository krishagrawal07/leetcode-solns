class Solution {
    public int majorityElement(int[] nums) {
        //mooers voting algo -- first find candidate, second verify it

        int candidate =0; //majority element
        int count =0;

        for(int i =0 ; i<nums.length; i++){

            if(count==0){
                candidate = nums[i];
            }

            if(candidate == nums[i]){
                count++;
            }

            else{
                count--;
            }

        }
        return candidate;
    }
}