class Solution {
    
    // ============================================
    // MAIN FUNCTION: Count Subarrays With Fixed Bounds
    // ============================================
    public long countSubarrays(int[] nums, int minK, int maxK) {
        
        long count = 0;  // Total valid subarrays (long - overflow se bachne ke liye)
        
        // ==========================================
        // TRACKING VARIABLES
        // ==========================================
        
        // Last position jahan minK mila (-1 = abhi tak nahi mila)
        int lastMinK = -1;
        
        // Last position jahan maxK mila (-1 = abhi tak nahi mila)
        int lastMaxK = -1;
        
        // Last position jahan invalid element tha
        // Invalid = element < minK ya element > maxK
        // Iske left mein koi valid subarray nahi ban sakta
        int lastInvalid = -1;
        
        // ==========================================
        // ITERATE THROUGH ARRAY
        // ==========================================
        for (int i = 0; i < nums.length; i++) {
            
            int current = nums[i];  // Current element
            
            // -----------------------------------------
            // STEP 1: Check if current element is INVALID
            // -----------------------------------------
            // Agar current < minK ya current > maxK, toh yahan se break hai
            if (current < minK || current > maxK) {
                
                // Iske baad ke subarrays isse pehle wale se nahi jod sakte
                lastInvalid = i;  // Invalid position update karo
                
                // minK aur maxK bhi reset nahi karte - future ke liye useful hain
                // But is index se pehle ke subarrays ab count nahi honge
            }
            
            // -----------------------------------------
            // STEP 2: Update lastMinK if current == minK
            // -----------------------------------------
            if (current == minK) {
                lastMinK = i;  // Last position jahan minK mila
            }
            
            // -----------------------------------------
            // STEP 3: Update lastMaxK if current == maxK
            // -----------------------------------------
            if (current == maxK) {
                lastMaxK = i;  // Last position jahan maxK mila
            }
            
            // -----------------------------------------
            // STEP 4: Calculate valid subarrays ending at i
            // -----------------------------------------
            // Valid subarray ke liye:
            // - minK aur maxK dono present hone chahiye
            // - lastInvalid ke baad se start hona chahiye
            
            // leftBound = max(lastInvalid, ...) nahi, actually:
            // Subarray start position >= lastInvalid + 1 honi chahiye
            // AND subarray mein minK aur maxK dono hone chahiye
            
            // leftmost valid start = max(lastInvalid + 1, ...)
            // But actually: min(lastMinK, lastMaxK) se right mein start karna padega
            // taaki dono (minK aur maxK) include ho
            
            // Valid start positions: [lastInvalid + 1, min(lastMinK, lastMaxK)]
            // Matlab: lastInvalid + 1 se leke min(lastMinK, lastMaxK) tak
            
            int validLeftBound = Math.min(lastMinK, lastMaxK);
            // Yeh rightmost position hai jahan se start karke 
            // dono minK aur maxK include honge
            
            // -----------------------------------------
            // STEP 5: Add valid subarrays to count
            // -----------------------------------------
            if (validLeftBound > lastInvalid) {
                // Kitne valid starting points hain?
                // Start can be: lastInvalid + 1, lastInvalid + 2, ..., validLeftBound
                // Count = validLeftBound - lastInvalid
                
                count += (validLeftBound - lastInvalid);
            }
            // Agar validLeftBound <= lastInvalid, toh koi valid subarray nahi
            // Kyunki ya toh minK/maxK nahi mila, ya invalid ne break kar diya
        }
        
        return count;
    }
}