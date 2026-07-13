class Solution {
    public int[] searchRange(int[] nums, int target) {
        int first = lowerBound(nums, target);
        
        // Check karo target actually exists
        if (first == nums.length || nums[first] != target) {
            return new int[]{-1, -1};
        }
        
        int last = upperBound(nums, target) - 1;
        
        return new int[]{first, last};
    }
    
    // ========== LOWER BOUND ==========
    // Pehla index jahan nums[i] >= target
    private int lowerBound(int[] nums, int target) {
        int left = 0, right = nums.length;
        
        while (left < right) {
            int mid = left + (right - left) / 2;
            
            if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        
        return left;
    }
    
    // ========== UPPER BOUND ==========
    // Pehla index jahan nums[i] > target
    private int upperBound(int[] nums, int target) {
        int left = 0, right = nums.length;
        
        while (left < right) {
            int mid = left + (right - left) / 2;
            
            if (nums[mid] <= target) {    // ← Yahan "<=" (Lower se yahi farq!)
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        
        return left;
    }
}