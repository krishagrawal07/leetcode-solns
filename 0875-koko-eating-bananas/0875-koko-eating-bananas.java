class Solution {
    
    // Check if Koko can finish all bananas at speed k within h hours
    private boolean canFinish(int[] piles, int k, int h) {
        int hours = 0;
        for (int pile : piles) {
            // Ceiling division: (pile + k - 1) / k
            hours += (pile + k - 1) / k;
            
            // Early termination: if hours already exceed h
            if (hours > h) return false;
        }
        return hours <= h;
    }
    
    public int minEatingSpeed(int[] piles, int h) {
        // Find max pile (upper bound for search space)
        int maxPile = 0;
        for (int pile : piles) {
            maxPile = Math.max(maxPile, pile);
        }
        
        int low = 1;           // Minimum possible speed
        int high = maxPile;    // Maximum useful speed
        
        // Binary Search on Answer: FFFFTTTT pattern
        // Find minimum k where canFinish(k) == true
        while (low < high) {
            int mid = low + (high - low) / 2;
            
            if (canFinish(piles, mid, h)) {
                high = mid;      // Can finish, try slower speed
            } else {
                low = mid + 1;   // Can't finish, need faster speed
            }
        }
        
        return low;  // or high (both converge)
    }
}