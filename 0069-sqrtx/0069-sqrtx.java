class Solution {
    public int mySqrt(int x) {
        if (x == 0) return 0;  // Edge case
        
        int left = 1, right = x;
        int firstTrue = -1;  // First index where mid*mid > x
        
        while (left <= right) {
            int mid = left + (right - left) / 2;
            
            // Check if mid*mid > x (overflow-safe using division)
            if (mid > x / mid) {
                firstTrue = mid;
                right = mid - 1;  // Search left for earlier true
            } else {
                left = mid + 1;   // Search right
            }
        }
        
        // If no true found (x <= 1), return x
        // Otherwise return firstTrue - 1 (largest valid square root)
        return (firstTrue == -1) ? x : firstTrue - 1;
    }
}