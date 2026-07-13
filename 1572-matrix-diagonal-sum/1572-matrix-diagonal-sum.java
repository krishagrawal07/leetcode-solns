class Solution {
    public int diagonalSum(int[][] mat) {
        int n = mat.length;
        int sum = 0;
        
        for (int i = 0; i < n; i++) {
            // Primary diagonal: top-left to bottom-right (row == col)
            sum += mat[i][i];
            
            // Secondary diagonal: top-right to bottom-left (row + col == n - 1)
            sum += mat[i][n - 1 - i];
        }
        
        // If n is odd, the center element was counted twice
        // Center is at (n/2, n/2)
        if (n % 2 == 1) {
            sum -= mat[n / 2][n / 2];
        }
        
        return sum;
    }
}