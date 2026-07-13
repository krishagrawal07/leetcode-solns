class Solution {
    public boolean circularArrayLoop(int[] nums) {
        int n = nums.length;
        
        for (int i = 0; i < n; i++) {
            // Skip already visited or invalid starting points
            if (nums[i] == 0) continue;
            
            // Slow and fast pointers
            int slow = i;
            int fast = i;
            
            // Direction check: all elements in cycle must have same sign
            // Forward: positive, Backward: negative
            while (true) {
                // Move slow one step
                slow = next(nums, slow);
                // Check if direction changed or same element
                if (!isSameDirection(nums, i, slow)) break;
                
                // Move fast one step
                fast = next(nums, fast);
                // Check direction for fast
                if (!isSameDirection(nums, i, fast)) break;
                
                // Move fast second step
                fast = next(nums, fast);
                // Check direction again
                if (!isSameDirection(nums, i, fast)) break;
                
                // If they meet, we found a cycle
                if (slow == fast) {
                    // Check if cycle length > 1 (not self-loop)
                    if (slow == next(nums, slow)) break; // Self-loop, invalid
                    return true;
                }
            }
            
            // Mark visited elements as 0 to avoid re-checking
            // This is optimization to make it O(n) time
            int val = nums[i];
            int j = i;
            while (nums[j] * val > 0) {
                int nextJ = next(nums, j);
                nums[j] = 0;
                j = nextJ;
            }
        }
        
        return false;
    }
    
    // Calculate next index with wrapping
    private int next(int[] nums, int curr) {
        int n = nums.length;
        // Add n to handle negative numbers, then mod
        int next = ((curr + nums[curr]) % n + n) % n;
        return next;
    }
    
    // Check if two elements have same direction (both positive or both negative)
    private boolean isSameDirection(int[] nums, int i, int j) {
        // nums[i] is original direction from starting point
        // nums[j] should have same sign
        // Also nums[j] should not be 0 (visited)
        return nums[i] * nums[j] > 0;
    }
}