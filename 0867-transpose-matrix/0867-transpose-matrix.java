class Solution {
    public int[][] transpose(int[][] matrix) {
         int m = matrix.length;      // Number of rows
        int n = matrix[0].length;   // Number of columns
        
        // Result will have dimensions n × m (swapped)
        int[][] result = new int[n][m];
        
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                // Swap row and column indices
                result[j][i] = matrix[i][j];
            }
        }
        
        return result;
    }
}