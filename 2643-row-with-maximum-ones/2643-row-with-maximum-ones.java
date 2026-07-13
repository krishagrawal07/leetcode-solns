class Solution {
    public int[] rowAndMaximumOnes(int[][] mat) {
        int maxRow = 0, maxCount = 0;
        
        for (int i = 0; i < mat.length; i++) {
            int count = 0;
            for (int val : mat[i]) count += val;
            
            if (count > maxCount) {
                maxCount = count;
                maxRow = i;
            }
        }
        return new int[]{maxRow, maxCount};
    }
}