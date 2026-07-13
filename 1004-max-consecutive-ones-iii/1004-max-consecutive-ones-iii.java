class Solution {
    public int longestOnes(int[] nums, int k) {
        
        int left = 0;
        int zeros = 0;      // sirf zeros count track karo
        int result = 0;
        
        for (int right = 0; right < nums.length; right++) {
            
            // Naya element 0 hai toh zero count badhao
            if (nums[right] == 0) {
                zeros++;
            }
            
            // Agar zeros zyada ho gaye, shrink karo
            while (zeros > k) {
                if (nums[left] == 0) {
                    zeros--;
                }
                left++;
            }
            
            // Valid window
            result = Math.max(result, right - left + 1);
        }
        
        return result;
    }
}