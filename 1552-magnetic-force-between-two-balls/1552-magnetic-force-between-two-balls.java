import java.util.Arrays;

class Solution {
    
    // Check if we can place 'm' balls with at least 'dist' apart
    private boolean canPlace(int[] position, int m, int dist) {
        int balls = 1;           // Place first ball at first basket
        int lastPos = position[0];
        
        for (int i = 1; i < position.length; i++) {
            if (position[i] - lastPos >= dist) {
                balls++;
                lastPos = position[i];
                
                if (balls >= m) return true;
            }
        }
        return false;
    }
    
    public int maxDistance(int[] position, int m) {
        Arrays.sort(position);
        
        int n = position.length;
        int low = 1;                              // Minimum possible force
        int high = position[n - 1] - position[0]; // Maximum possible force
        int ans = 0;
        
        while (low <= high) {
            int mid = low + (high - low) / 2;
            
            if (canPlace(position, m, mid)) {
                ans = mid;        // mid works, try for larger force
                low = mid + 1;    // Search right half
            } else {
                high = mid - 1;   // mid too large, search left half
            }
        }
        return ans;
    }
}