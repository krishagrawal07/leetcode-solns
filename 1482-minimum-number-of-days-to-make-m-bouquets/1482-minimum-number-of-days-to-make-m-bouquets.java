class Solution {
    
    // Check if we can make m bouquets of k adjacent flowers by given day
    private boolean canMakeBouquets(int[] bloomDay, int day, int m, int k) {
        int bouquets = 0;   // Bouquets made so far
        int consecutive = 0; // Consecutive bloomed flowers
        
        for (int bloom : bloomDay) {
            if (bloom <= day) {
                // This flower has bloomed by 'day'
                consecutive++;
                
                // If we have k consecutive flowers, make a bouquet
                if (consecutive == k) {
                    bouquets++;
                    consecutive = 0; // Reset for next bouquet
                    
                    // Early termination: if already made enough
                    if (bouquets >= m) {
                        return true;
                    }
                }
            } else {
                // Flower hasn't bloomed, break the consecutive streak
                consecutive = 0;
            }
        }
        
        return bouquets >= m;
    }
    
    public int minDays(int[] bloomDay, int m, int k) {
        int n = bloomDay.length;
        
        // Edge case: impossible to make m bouquets
        // Need m * k flowers total
        if ((long) m * k > n) {
            return -1;
        }
        
        // Find search space bounds
        int minDay = Integer.MAX_VALUE;
        int maxDay = Integer.MIN_VALUE;
        
        for (int day : bloomDay) {
            minDay = Math.min(minDay, day);
            maxDay = Math.max(maxDay, day);
        }
        
        int low = minDay;
        int high = maxDay;
        
        // Binary Search on Answer: FFFFTTTT pattern
        // Find minimum day where canMakeBouquets(day) == true
        while (low < high) {
            int mid = low + (high - low) / 2;
            
            if (canMakeBouquets(bloomDay, mid, m, k)) {
                high = mid;      // Can make bouquets, try earlier day
            } else {
                low = mid + 1;   // Can't make enough, need to wait longer
            }
        }
        
        // Verify the answer (should always be true if we reach here)
        return canMakeBouquets(bloomDay, low, m, k) ? low : -1;
    }
}