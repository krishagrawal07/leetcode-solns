class Solution {
    
    // Find the row with maximum element in given column
    private int findMaxInColumn(int[][] mat, int col) {
        int maxRow = 0;
        for (int i = 1; i < mat.length; i++) {
            if (mat[i][col] > mat[maxRow][col]) {
                maxRow = i;
            }
        }
        return maxRow;
    }
    
    public int[] findPeakGrid(int[][] mat) {
        int rows = mat.length;
        int cols = mat[0].length;
        int low = 0, high = cols - 1;
        
        while (low <= high) {
            int mid = low + (high - low) / 2;
            
            // Find the maximum element in the middle column
            int maxRow = findMaxInColumn(mat, mid);
            
            // Get left and right neighbors (treat out-of-bounds as -infinity)
            int left = (mid > 0) ? mat[maxRow][mid - 1] : -1;
            int right = (mid < cols - 1) ? mat[maxRow][mid + 1] : -1;
            
            // Check if current element is a peak
            if (mat[maxRow][mid] > left && mat[maxRow][mid] > right) {
                return new int[]{maxRow, mid};
            }
            // If left neighbor is greater, peak must be in left half
            else if (left > mat[maxRow][mid]) {
                high = mid - 1;
            }
            // Otherwise, peak must be in right half
            else {
                low = mid + 1;
            }
        }
        
        return new int[]{-1, -1}; // Should never reach here
    }
}