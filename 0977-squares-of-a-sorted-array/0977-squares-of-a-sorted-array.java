class Solution {
    public int[] sortedSquares(int[] nums) {
        int n = nums.length;
        int[] result = new int[n];
        
        int left = 0;          // Start se
        int right = n - 1;     // End se
        int pos = n - 1;       // Result fill karne ki position (peeche se)
        
        while (left <= right) {
            int leftSquare = nums[left] * nums[left];
            int rightSquare = nums[right] * nums[right];
            
            // Jo bada hai, usko result ke end mein daalo
            if (leftSquare > rightSquare) {
                result[pos] = leftSquare;
                left++;      // Left wala use ho gaya, aage badho
            } else {
                result[pos] = rightSquare;
                right--;     // Right wala use ho gaya, peeche aao
            }
            
            pos--;  // Result ki next position (peeche se aage)
        }
        
        return result;
    }
}