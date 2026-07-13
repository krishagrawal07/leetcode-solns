class Solution {
    public int[] findDiagonalOrder(int[][] mat) {
        int n = mat.length;       // rows
        int m = mat[0].length;    // columns
        int row = 0, col = 0;
        int idx = 0;
        int[] ans = new int[n * m];
        boolean up = true;
        
        while (row < n && col < m) {
            if (up) {
                // Going UP-RIGHT
                while (row > 0 && col < m - 1) {
                    ans[idx++] = mat[row][col];
                    row--;
                    col++;
                }
                ans[idx++] = mat[row][col];  // Last element of this diagonal
                
                // Decide next starting point
                if (col == m - 1) {
                    row++;      // Right edge → go down
                } else {
                    col++;      // Top edge → go right
                }
            } else {
                // Going DOWN-LEFT
                while (row < n - 1 && col > 0) {
                    ans[idx++] = mat[row][col];
                    row++;
                    col--;
                }
                ans[idx++] = mat[row][col];  // Last element of this diagonal
                
                // Decide next starting point
                if (row == n - 1) {
                    col++;      // Bottom edge → go right
                } else {
                    row++;      // Left edge → go down
                }
            }
            up = !up;  // Toggle direction
        }
        
        return ans;
    }
}