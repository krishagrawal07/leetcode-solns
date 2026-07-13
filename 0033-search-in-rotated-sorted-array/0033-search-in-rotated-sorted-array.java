class Solution {
    public int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        
        while (left <= right) {
            int mid = left + (right - left) / 2;
            
            // Found!
            if (nums[mid] == target) {
                return mid;
            }
            
            // Check karo: koun sa half sorted hai?
            
            // ========== LEFT HALF SORTED ==========
            if (nums[left] <= nums[mid]) {
                // [left ... mid] sorted hai
                
                // Target left sorted half mein hai?
                if (nums[left] <= target && target < nums[mid]) {
                    right = mid - 1;    // Haan, left mein dhoondo
                } else {
                    left = mid + 1;     // Nahi, right mein jao
                }
            }
            
            // ========== RIGHT HALF SORTED ==========
            else {
                // [mid ... right] sorted hai
                
                // Target right sorted half mein hai?
                if (nums[mid] < target && target <= nums[right]) {
                    left = mid + 1;     // Haan, right mein dhoondo
                } else {
                    right = mid - 1;    // Nahi, left mein jao
                }
            }
        }
        
        return -1;  // Nahi mila
    }
}