class Solution {
    
    // Calculate sum of ceiling divisions for given divisor
    private int calculateSum(int[] nums, int divisor) {
        int sum = 0;
        for (int num : nums) {
            // Ceiling division: (num + divisor - 1) / divisor
            sum += (num + divisor - 1) / divisor;
        }
        return sum;
    }
    
    public int smallestDivisor(int[] nums, int threshold) {
        // Find maximum element (upper bound for search space)
        int maxNum = 0;
        for (int num : nums) {
            maxNum = Math.max(maxNum, num);
        }
        
        int low = 1;           // Minimum possible divisor
        int high = maxNum;     // Maximum useful divisor
        
        // Binary Search on Answer: FFFFTTTT pattern
        // Find minimum divisor where calculateSum(divisor) <= threshold
        while (low < high) {
            int mid = low + (high - low) / 2;
            
            if (calculateSum(nums, mid) <= threshold) {
                high = mid;      // Works! Try smaller divisor
            } else {
                low = mid + 1;   // Sum too large, need larger divisor
            }
        }
        
        return low;  // or high (both converge to answer)
    }
}