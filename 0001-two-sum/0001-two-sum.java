class Solution {
    public int[] twoSum(int[] nums, int target) {
        // Map: number → index
        Map<Integer, Integer> map = new HashMap<>();
        
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];  // Jo number chahiye
            
            // Kya complement pehle mila tha?
            if (map.containsKey(complement)) {
                return new int[]{map.get(complement), i};
            }
            
            // Current number ko map mein daalo
            map.put(nums[i], i);
        }
        
        return new int[]{};  // Kabhi nahi aayega (guaranteed solution hai)
    }
}