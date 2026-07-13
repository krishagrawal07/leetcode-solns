class Solution {
    public int countNegatives(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int count = 0;
        int row = 0;
        int col = n - 1;
        // Start from top-right corner
        // Since rows and columns are sorted in non-increasing order
        while (row < m && col >= 0) {
            if (grid[row][col] < 0) {
                // All elements below grid[row][col] in this column are also negative
                count += (m - row);
                col--;
            } else {
                row++;
            }
        }
        
        return count;
    }
}