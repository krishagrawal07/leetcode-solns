class Solution {
    public int findKthPositive(int[] arr, int k) {
        int left = 0;
        int right = arr.length;   // ← Note: n (Lower Bound style)
        
        while (left < right) {
            int mid = left + (right - left) / 2;
            int missingTillMid = arr[mid] - (mid + 1);
            
            if (missingTillMid < k) {
                // Mid tak missing < k, answer right mein
                left = mid + 1;
            } else {
                // Mid tak missing >= k, answer yahan ya left mein
                right = mid;
            }
        }
        
        // left = woh index jahan pehli baar missing >= k
        // Ya arr.length agar kabhi nahi hua
        
        // Answer formula: left + k
        // Kyun? 
        // left index pe missing >= k
        // (left-1) index pe missing < k
        // So k-th missing = arr ke left elements + k more = left + k
        
        return left + k;
    }
}