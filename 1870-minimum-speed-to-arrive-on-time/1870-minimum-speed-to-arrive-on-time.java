class Solution {
    
    // Check if we can arrive on time at given speed
    // Uses integer arithmetic to avoid floating-point precision issues
    private boolean canArrive(int[] dist, double hour, int speed) {
        double totalTime = 0.0;
        int n = dist.length;
        
        for (int i = 0; i < n; i++) {
            if (i == n - 1) {
                // Last train: exact time, no waiting needed
                totalTime += (double) dist[i] / speed;
            } else {
                // Non-last train: must depart at integer hour
                // Use INTEGER ceiling to avoid floating-point errors!
                // ceil(dist[i] / speed) = (dist[i] + speed - 1) / speed
                totalTime += (dist[i] + speed - 1) / speed;
            }
            
            // Early termination
            if (totalTime > hour) {
                return false;
            }
        }
        
        return totalTime <= hour;
    }
    
    public int minSpeedOnTime(int[] dist, double hour) {
        int n = dist.length;
        
        // Edge case: impossible to arrive
        // Even with infinite speed, first n-1 trains need at least 1 hour each (waiting)
        // Last train needs > 0 time. So minimum possible time > n-1
        if (hour <= n - 1) {
            return -1;
        }
        
        int low = 1;
        int high = 10_000_000;  // 10^7, safe upper bound
        
        // Verify that it's even possible
        if (!canArrive(dist, hour, high)) {
            return -1;
        }
        
        // Binary Search on Answer: FFFFTTTT pattern
        while (low < high) {
            int mid = low + (high - low) / 2;
            
            if (canArrive(dist, hour, mid)) {
                high = mid;      // Works, try slower
            } else {
                low = mid + 1;   // Too slow, need faster
            }
        }
        
        return low;
    }
}